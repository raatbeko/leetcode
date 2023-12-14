package algorithms.medium;

public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int maxArea = 0;
        while (start != end) {
            int area = end - start;
            int heightStart = height[start];
            int heightEnd = height[end];
            if (heightStart >= heightEnd) {
                if ((heightEnd * area) > maxArea) {
                    maxArea = heightEnd * area;
                }
                end--;
            } else {
                if ((heightStart * area) > maxArea) {
                    maxArea = heightStart * area;
                }
                start++;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 1}));
    }

}
