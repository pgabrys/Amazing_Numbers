import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        int[] array = new int[size];
        int sum = 0;

        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        int n = scanner.nextInt();

        for (int i = 0; i < size; i++){
            if(array[i] > n) {
                sum += array[i];
            }
        }
        System.out.println(sum);

    }
}