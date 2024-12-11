package opgave04;

import opgave04.utils.RandomGenerator;
import opgave04.utils.StopWatch;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] sampleSize = {10_000, 100_000, 1_000_000, 10_000_000};

        for (int size : sampleSize) {
            int[] array = RandomGenerator.generateRandomArray(size);
            StopWatch.start();
            Arrays.sort(array);
            bubbleSort(array);
            insertionSort(array);
            StopWatch.stop();
            System.out.println("Sorterede array med " + size + " elementer: " + StopWatch.durationMilliSeconds() + " millisekunder.");
        }
    }

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }
}
