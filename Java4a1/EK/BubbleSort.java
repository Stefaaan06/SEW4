package Java4a1.EK;

public class BubbleSort{
    public static void main(String[] args) {
        int[] array = {5,6,34,34,1,234,56,1,46,12,43521,34,2134,321,41324};
        bubbleSort(array);
        System.out.println("Sorted array: \n \n \n");
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
    }

    public static void bubbleSort(int[] array) {
        boolean swapped;

        for (int i = 0; i < array.length; i++) {

            System.out.println("\n\nDurchlauf " + i + "\n");
            swapped = false;

            for (int j = 1; j < array.length - i; j++) {

                System.out.println("Vergleiche " + array[j - 1] + " und " + array[j]);

                if (array[j - 1] > array[j]) {

                    System.out.println("Tausche " + array[j - 1] + " und " + array[j]);

                    // Tausche Elemente, wenn sie in falscher Reihenfolge sind
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                    swapped = true;

                }
            }
            if (!swapped) {
                System.out.println("Kein Tausch nötig, Array ist sortiert");
                break;
            }
        }
    }
}
