import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        int[] sumArray = new int[size];
        int sum = 0;

        for (int i = 0; i < sumArray.length; i++) {
            sumArray[i] = scanner.nextInt();
            sum += sumArray[i];
        }

        System.out.println(sum);
    }
}