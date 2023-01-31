import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        int[] array = new int[size];
        int[] array2 = new int[size];
        int kurwa = size - 1;

        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }


       System.arraycopy(array,0, array2, 1, kurwa);
       array2[0] = array[kurwa];

        for (int i = 0; i < array2.length; i++) {
            System.out.print(array2[i] + " ");
        }
    }
}