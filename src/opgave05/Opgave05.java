package opgave05;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    private static boolean[][] rulesMatrix = new boolean[100][100];

    public static void main(String[] args) {
        int[] line1 = {75, 47, 61, 53, 29};
        int[] line2 = {97, 61, 53, 29, 13};
        int[] line3 = {75,29,13};
        int[] line4 = {75,97,47,61,53};
        int[] line5 = {61,13,29};
        int[] line6 = {97,13,75,29,47};
        loadrules();
        System.out.println(isBefore(47, 53));
        System.out.println(isBefore(53, 47));

        System.out.println(checkLine(line1));
    }

    private static boolean checkLine(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (!isBefore(numbers[i], numbers[i + 1])) {
                return true;
            }
        }
        return false;
    }

    private static boolean isBefore(int before, int after) {
        return rulesMatrix[before][after];
    }

    private static void loadrules() {
        for (int outer = 0; outer < rulesMatrix.length; outer++) {
            for (int inner = 0; inner < rulesMatrix[outer].length; inner++) {
                rulesMatrix[outer][inner] = false;
            }
        }
        File rulesFile = new File("resources/opgave05/rules.txt");
        try (Scanner scanner = new Scanner(rulesFile)) {
            scanner.useDelimiter("(\\||\r\n)");
            while (scanner.hasNext()) {
                int before = scanner.nextInt();
                int after = scanner.nextInt();
                rulesMatrix[before][after] = true;
            }
        } catch (FileNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
