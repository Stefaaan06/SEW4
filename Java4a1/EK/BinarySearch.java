package Java4a1.EK;

public class BinarySearch {
    public static void main(String[] args) {

        int[] array = {1, 2, 5, 125, 12, 6, 7, 8, 9, 10};

        System.out.print(binarySearch(array, 5));
    }

    public static int binarySearch(int[] array, int key) {

        int left = 0;
        int right = array.length - 1;

        while (left <= right) {

            int middle = left + (right - left) / 2;

            if (array[middle] == key) {
                return middle;
            }

            if (array[middle] < key) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return -1;
    }
}
