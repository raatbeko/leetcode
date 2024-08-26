package algorithms.base.quickSort;

public class Quicksort  {
    private int[] numbers;
    private int number;

    public void sort(int[] values) {
        // check for empty or null array
        if (values ==null || values.length==0){
            return;
        }
        this.numbers = values;
        number = values.length;
        quicksort(0, number - 1);
    }

    private void quicksort(int low, int high) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        int pivot = numbers[low + (high-low)/2];

        // Разделите на два списка
        while (i <= j) {
            // Если текущее значение из левого списка меньше опорного элемента,
            // то получите следующий элемент из левого списка.
            while (numbers[i] < pivot) {
                i++;
            }
            // Если текущее значение из правого списка больше опорного элемента,
            // о получите следующий элемент из правого списка.
            while (numbers[j] > pivot) {
                j--;
            }

            // Если мы нашли значение в левом списке,
            // которое больше опорного элемента,
            // и если мы нашли значение в правом списке,
            // которое меньше опорного элемента, то мы обмениваем значения.
            // Как только мы закончили, мы можем увеличить i и j.
            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j)
            quicksort(low, j);
        if (i < high)
            quicksort(i, high);
    }

    private void exchange(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
