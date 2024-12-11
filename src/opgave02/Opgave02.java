package opgave02;

public class Main {
    public static void main(String[] args) {
        String[] names = {"Erna", "Elly", "Laurits", "Bertha", "Christian",
                "August", "Marius", "John", "Tove", "Poul", "Torkild"};

        printArray(names);
        bubbleSort(names);
        printArray(names);
    }


    private static void bubbleSort(String[] names) {
        for (int i = 0; i < names.length - 1; i++) {
            for (int j = 0; j < names.length - i - 1; j++) {
                if (names[j].compareTo(names[j + 1]) > 0) {
                    String temp = names[j];
                    names[j] = names[j + 1];
                    names[j + 1] = temp;
                }
            }
        }
    }

    private static void printArray(String[] names) {
        System.out.printf("[" + String.join(", ", names) + "]\n");
    }
}
