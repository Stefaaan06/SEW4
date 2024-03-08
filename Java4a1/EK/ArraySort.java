package Java4a1.EK;

public class ArraySort {

    // insertionSort
    public static void insertionSort(int[] array) {

        for (int i = 1; i < array.length; i++) {

            int current = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > current) {

                array[j + 1] = array[j];
                j--;

            }

            array[j + 1] = current;

        }

    }

    // SelectionSort
    public static void selectionSort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            // Suche das kleinste Element im Rest des Arrays
            int minIndex = i;

            for (int j = i + 1; j < array.length; j++) {

                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }

            }

            // Tausche das kleinste gefundene Element mit dem Element an Position i
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }

    }

    // Nicht optimierter BubbleSort
    public static void bubbleSort(int[] array) {

        for (int i = 0; i < array.length; i++) {

            for (int j = 1; j < array.length - i; j++) {

                if (array[j - 1] > array[j]) {

                    // Tausche Elemente, wenn sie in falscher Reihenfolge sind
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;

                }

            }

        }

    }

    // Optimierter BubbleSort
    public static void bubbleSortOpt(int[] array) {
        boolean swapped;

        for (int i = 0; i < array.length; i++) {

            swapped = false;
            for (int j = 1; j < array.length - i; j++) {

                if (array[j - 1] > array[j]) {
                    // Tausche Elemente, wenn sie in falscher Reihenfolge sind
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                    swapped = true;
                }

            }

            if (!swapped) {
                // Keine Vertauschungen mehr, Array ist sortiert
                break;
            }

        }

    }
}
