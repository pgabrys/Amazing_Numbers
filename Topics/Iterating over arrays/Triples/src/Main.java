import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        int[] array = new int[size];
        int counter = 0;
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        for (int i = 0; i < size - 2; i++) {
            if (array[i + 1] == array[i] + 1 && array[i + 2] == array[i] + 2) {
                counter++;
            }
        }
        System.out.println(counter);
    }
}