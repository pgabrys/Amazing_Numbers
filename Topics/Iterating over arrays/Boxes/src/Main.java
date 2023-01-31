import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] box1 = new int[3];
        int[] box2 = new int[3];
        int a = 0;
        int b = 0;

        for (int i = 0; i < 3; i++) {
            box1[i] = scanner.nextInt();
        }
        for (int i = 0; i < 3; i++) {
            box2[i] = scanner.nextInt();
        }

        Arrays.sort(box1);
        Arrays.sort(box2);

        for (int i = 0; i < 3; i++) {
            if (box1[i] > box2[i]) {
                a++;
            } else if (box1[i] < box2[i]) {
                b++;
            }
        }

        if (a == 3) {
            System.out.println("Box 1 > Box 2");
        } else if (b == 3) {
            System.out.println("Box 1 < Box 2");
        } else {
             System.out.println("Incompatible");
        }

    }
}