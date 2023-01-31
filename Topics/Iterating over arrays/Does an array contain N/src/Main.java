import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean check = false;
        int size = scanner.nextInt();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        int numToCheck = scanner.nextInt();

        for (int i = 0; i < array.length; i++) {
            if (array[i] == numToCheck) {
                check = true;
            }
        }

        System.out.println(check);




    }
}