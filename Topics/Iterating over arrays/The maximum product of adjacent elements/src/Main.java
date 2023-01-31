import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a, b = 0;
        int size = scanner.nextInt();
        int[] array = new int[size];

        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }

        for (int i = 1; i < array.length; i++) {
            a = array[i] * array[i - 1];
            if (a > b) {
                b = a;
            }
        }

        System.out.println(b);
    }
}