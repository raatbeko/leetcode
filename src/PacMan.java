import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class PacMan extends JFrame {
    public PacMan() {
        add(new GamePanel());
        setTitle("Pac-Man");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new PacMan();
    }
}

class GamePanel extends JPanel implements ActionListener, KeyListener {
    private static final int TILE_SIZE = 20;
    private static final int GRID_WIDTH = 15;
    private static final int GRID_HEIGHT = 15;
    private Timer timer;
    private int pacmanX = 1, pacmanY = 1; // Начальная позиция Pac-Man
    private int ghostX = 13, ghostY = 13; // Начальная позиция привидения
    private boolean gameOver = false;
    private boolean moveRequested = false; // Флаг для одиночного движения
    private int pacmanDirX = 0, pacmanDirY = 0; // Направление Pac-Man
    private int ghostMoveCounter = 0; // Счетчик для замедления привидения
    private int stuckCounter = 0; // Счётчик зацикливаний
    private int lastGhostX = ghostX, lastGhostY = ghostY; // Последняя позиция привидения

    // Лабиринт: 0 - пусто, 1 - стена, 2 - точка
    private int[][] maze = {
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,2,2,2,2,2,2,1,2,2,2,2,2,2,1},
            {1,2,1,1,2,1,2,1,2,1,2,1,1,2,1},
            {1,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
            {1,2,1,1,2,1,2,1,2,1,2,1,1,2,1},
            {1,2,2,2,2,2,2,1,2,2,2,2,2,2,1},
            {1,1,1,1,2,1,1,1,1,1,2,1,1,1,1},
            {1,2,2,2,2,2,2,1,2,2,2,2,2,2,1},
            {1,1,1,1,2,1,1,1,1,1,2,1,1,1,1},
            {1,2,2,2,2,2,2,1,2,2,2,2,2,2,1},
            {1,2,1,1,2,1,2,1,2,1,2,1,1,2,1},
            {1,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
            {1,2,1,1,2,1,2,1,2,1,2,1,1,2,1},
            {1,2,2,2,2,2,2,1,2,2,2,2,2,2,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
    };

    public GamePanel() {
        setFocusable(true);
        addKeyListener(this);
        timer = new Timer(100, this); // Обновление каждые 100 мс
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawMaze(g);
        drawPacMan(g);
        drawGhost(g);

        if (gameOver) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 20));
            g.drawString("Game Over!", 120, 200);
        }
    }

    private void drawMaze(Graphics g) {
        for (int y = 0; y < GRID_HEIGHT; y++) {
            for (int x = 0; x < GRID_WIDTH; x++) {
                if (maze[y][x] == 1) {
                    g.setColor(Color.BLUE);
                    g.fillRect(x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
                } else if (maze[y][x] == 2) {
                    g.setColor(Color.YELLOW);
                    g.fillOval(x * TILE_SIZE + 8, y * TILE_SIZE + 8, 4, 4);
                }
            }
        }
    }

    private void drawPacMan(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillOval(pacmanX * TILE_SIZE, pacmanY * TILE_SIZE, TILE_SIZE, TILE_SIZE);
    }

    private void drawGhost(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(ghostX * TILE_SIZE, ghostY * TILE_SIZE, TILE_SIZE, TILE_SIZE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            if (moveRequested) {
                updatePacMan();
                moveRequested = false; // Сбрасываем флаг после движения
            }
            updateGhost();
            checkCollisions();
            repaint();
        }
    }

    private void updatePacMan() {
        int newX = pacmanX + pacmanDirX;
        int newY = pacmanY + pacmanDirY;
        if (newX >= 0 && newX < GRID_WIDTH && newY >= 0 && newY < GRID_HEIGHT && maze[newY][newX] != 1) {
            pacmanX = newX;
            pacmanY = newY;
            if (maze[newY][newX] == 2) {
                maze[newY][newX] = 0; // Съедаем точку
            }
        }
    }

    private void updateGhost() {
        ghostMoveCounter++;
        if (ghostMoveCounter % 2 != 0) return; // Привидение движется раз в 2 цикла

        // Возможные направления: влево, вправо, вверх, вниз
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        ArrayList<int[]> validDirections = new ArrayList<>();
        ArrayList<Double> distances = new ArrayList<>();

        // Проверяем все направления, исключая стены и границы
        for (int[] dir : directions) {
            int newX = ghostX + dir[0];
            int newY = ghostY + dir[1];
            if (newX >= 0 && newX < GRID_WIDTH && newY >= 0 && newY < GRID_HEIGHT && maze[newY][newX] != 1) {
                validDirections.add(new int[]{newX, newY});
                double distance = Math.sqrt(Math.pow(newX - pacmanX, 2) + Math.pow(newY - pacmanY, 2));
                distances.add(distance);
            }
        }

        // Если есть допустимые направления
        if (!validDirections.isEmpty()) {
            // Проверяем, застряло ли привидение (дергается между двумя клетками)
            if (ghostX == lastGhostX && ghostY == lastGhostY) {
                stuckCounter++;
            } else {
                stuckCounter = 0; // Сбрасываем, если привидение продвинулось
            }
            lastGhostX = ghostX;
            lastGhostY = ghostY;

            int bestIndex = 0;
            // Если застряли (stuckCounter >= 4), с вероятностью 50% выбираем случайное направление
            if (stuckCounter >= 4 && Math.random() < 0.5) {
                bestIndex = (int)(Math.random() * validDirections.size());
            } else {
                // Иначе выбираем ближайшее к Pac-Man
                double minDistance = Double.MAX_VALUE;
                for (int i = 0; i < distances.size(); i++) {
                    double distance = distances.get(i);
                    if (distance < minDistance || (distance == minDistance && Math.random() < 0.5)) {
                        minDistance = distance;
                        bestIndex = i;
                    }
                }
            }

            // Обновляем позицию привидения
            ghostX = validDirections.get(bestIndex)[0];
            ghostY = validDirections.get(bestIndex)[1];
        }
    }

    private void checkCollisions() {
        if (pacmanX == ghostX && pacmanY == ghostY) {
            gameOver = true;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (moveRequested) return; // Игнорируем, если уже есть запрос на движение
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            pacmanDirX = -1;
            pacmanDirY = 0;
            moveRequested = true;
        } else if (key == KeyEvent.VK_RIGHT) {
            pacmanDirX = 1;
            pacmanDirY = 0;
            moveRequested = true;
        } else if (key == KeyEvent.VK_UP) {
            pacmanDirX = 0;
            pacmanDirY = -1;
            moveRequested = true;
        } else if (key == KeyEvent.VK_DOWN) {
            pacmanDirX = 0;
            pacmanDirY = 1;
            moveRequested = true;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
}