package opgave01;

public class Opgave01 {
    public static void main(String[] args) {
        int[] numre = {8,9,1,29,3,6,2,7,11,60,23,69};
        selectionSort(numre);
        for(int i : numre){
            System.out.println(i);
        }
    }

    private static void selectionSort(int[] numre) {
        for (int i = 0; i < numre.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < numre.length; j++) {
                if (numre[j] < numre[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = numre[minIndex];
            numre[minIndex] = numre[i];
            numre[i] = temp;
        }
    }
}
