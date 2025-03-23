import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String[] year12 = {"зеленый", "красный", "желтый", "белый", "голубой"};
        String[] year = {"крысы", "коровы", "тигра", "зайца", "дракона", "змеи", "лошади", "овцы", "обезьяны", "курицы", "собаки", "свиньи"};
        int start = 1984;
        Scanner myObj = new Scanner(System.in);

        int n = myObj.nextInt();
        while (n < 1984) {
            System.out.println("Веденный число должен быть равен или больше 1984 года!");
            n = myObj.nextInt();
        }

        int i = n - start;
        int positionOn12 = getPositionOn12(i);
        System.out.println(year12[positionOn12]);
        System.out.println(year[i % 12]);
    }

    private static int getPositionOn12(int i) {
        int n = 12;
        int count = 0;
        while (i > n) {
            i -= n;
            count++;
        }
        return count;
    }
}