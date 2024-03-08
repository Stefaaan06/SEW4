package Java4a1.EK;

public class ArraySortTest {
    public static void main(String[] args) {
        int[] arraySelectionSort = {64, 25, 12, 22, 11};
        int[] arrayBubbleSort = {64, 34, 25, 12, 22, 11, 90};
        int[] arrayBubbleSortOpt = {64, 34, 25, 12, 22, 11, 90};
        int[] insertionSort = {64, 34, 25, 12, 22, 11, 90};


        System.out.println("Original Array für SelectionSort: ");
        printArray(arraySelectionSort);
        ArraySort.selectionSort(arraySelectionSort);
        System.out.println("Nach SelectionSort: ");
        printArray(arraySelectionSort);

            System.out.println("\nOriginal Array für BubbleSort: ");
        printArray(arrayBubbleSort);
        ArraySort.bubbleSort(arrayBubbleSort);
        System.out.println("Nach BubbleSort: ");
        printArray(arrayBubbleSort);

        System.out.println("\nOriginal Array für BubbleSortOpt: ");
        printArray(arrayBubbleSortOpt);
        ArraySort.bubbleSortOpt(arrayBubbleSortOpt);
        System.out.println("Nach BubbleSortOpt: ");
        printArray(arrayBubbleSortOpt);

        System.out.println("\nOriginal Array für Insert Sort: ");
        printArray(insertionSort);
        ArraySort.bubbleSortOpt(insertionSort);
        System.out.println("Nach Insertion sort: ");
        printArray(insertionSort);
    }

    private static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}