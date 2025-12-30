package leetcode.easy;

public class CanPlaceFlowers {

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        boolean step = false;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1 && step) {
                n++;
            }

            if (flowerbed[i] == 1) {
                step = true;
                continue;
            }
            if (flowerbed[i] == 0 && step) {
                step = false;
                continue;
            }

            if (flowerbed[i] == 0) {
                flowerbed[i] = 1;
                n--;
                step = true;
            }
        }
        return n <= 0;
    }

    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 0, 0, 1}, 2));
    }
}
