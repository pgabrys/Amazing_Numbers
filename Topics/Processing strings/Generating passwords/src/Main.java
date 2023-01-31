import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        int realD = d - (a + b + c);

        String password = PasswordGenerator.passwordA(a)
                + PasswordGenerator.passwordB(b)
                + PasswordGenerator.passwordC(c)
                + PasswordGenerator.passwordD(realD);

        System.out.println(password);
    }
}

class PasswordGenerator {

    static String passwordA(int a) {
        String passwordA = "";

        if (a > 0) {
            for (int i = 1; i <= a; i++) {
                passwordA += i % 2 == 0 ? "A" : "B";
            }
        }
        return passwordA;
    }

    static String passwordB(int b) {
        String passwordB = "";

        if (b > 0) {
            for (int i = 1; i <= b; i++) {
                passwordB += i % 2 == 0 ? "a" : "b";
            }
        }
        return passwordB;
    }

    static String passwordC(int c) {
        String passwordC = "";

        if (c > 0) {
            for (int i = 1; i <= c; i++) {
                passwordC += i % 2 == 0 ? "1" : "2";
            }
        }
        return passwordC;
    }

    static String passwordD(int realD) {
        String passwordD = "";

        if (realD > 0) {
            for (int i = 1; i <= realD; i++) {
                passwordD += i % 2 == 0 ? "B" : "A";
            }
        }

        return passwordD;
    }
}