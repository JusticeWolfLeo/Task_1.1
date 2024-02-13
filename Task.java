import java.util.InputMismatchException;
import java.util.Scanner;

public class Task {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxNumber = 0;
        int maxSum = 0;

        while (true) {
            System.out.print("Введите целое число (для завершения введите 0): ");
            int number = 0;

            try {
                number = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Ошибка. Введите целое число.");
                scanner.next(); // Чтобы избежать бесконечного цикла
                continue;
            }

            if (number == 0) {
                break;
            }

            int currentSum = calculateSumOfDigits(number);

            if (currentSum > maxSum) {
                maxNumber = number;
                maxSum = currentSum;
            }
        }

        System.out.println("Число с максимальной суммой цифр: " + maxNumber);
        System.out.println("Максимальная сумма цифр: " + maxSum);

        scanner.close();
    }

    public static int calculateSumOfDigits(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
