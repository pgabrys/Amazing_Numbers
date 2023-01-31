import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputDate = scanner.nextLine();
        String[] inputArray = inputDate.split("-");

        System.out.println(inputArray[1] + "/" + inputArray[2] + "/" + inputArray[0]);

    }
}