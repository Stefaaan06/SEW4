package Java4a1.EK;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.function.Consumer;

public class ArrayPerformanceTest {

    public static void main(String[] args) {
        int arraySize = 10000; // Beispielgröße, für echte Tests größer wählen
        int[] array = new int[arraySize];

        // Füllen des Arrays mit zufälligen Werten
        for (int i = 0; i < arraySize; i++) {
            array[i] = (int) (Math.random() * arraySize);
        }

        // Test und Zeitmessung für jeden Sortieralgorithmus
        measureSortPerformance(Arrays.copyOf(array, arraySize), "InsertionSort", ArraySort::insertionSort);
        measureSortPerformance(Arrays.copyOf(array, arraySize), "SelectionSort", ArraySort::selectionSort);
        measureSortPerformance(Arrays.copyOf(array, arraySize), "BubbleSort", ArraySort::bubbleSort);
        measureSortPerformance(Arrays.copyOf(array, arraySize), "Optimized BubbleSort", ArraySort::bubbleSortOpt);
    }

    private static void measureSortPerformance(int[] arrayCopy, String methodName, Consumer<int[]> sortMethod) {
        LocalTime start = LocalTime.now();
        sortMethod.accept(arrayCopy);
        LocalTime end = LocalTime.now();

        long duration = ChronoUnit.MILLIS.between(start, end);
        System.out.println(methodName + " dauerte: " + duration + " ms");
    }
}
