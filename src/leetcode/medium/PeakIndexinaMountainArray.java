package leetcode.medium;

public class PeakIndexinaMountainArray {

    public static int peakIndexInMountainArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[i + 1]) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(peakIndexInMountainArray(new int[]{0,2,1,0}));
    }
}
