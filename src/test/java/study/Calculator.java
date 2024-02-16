package study;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String value = sc.nextLine();
        String[] values = value.split(" ");

        Calculator calculator = new Calculator();

        Integer result = 0;

        for (int i = 0; i < values.length; i += 2) {
            if (i == 0) {
                result = Integer.parseInt(values[i]);
                continue;
            }
            result = calculator.calculate(result.toString(), values[i], values[i - 1]);
        }

        System.out.println(result);

    }
    public int addtion(int a, int b) {
        return a + b;
    }

    public int subtraction(int a, int b) {
        return a - b;
    }

    public int division(int a, int b) {
        return a / b;
    }

    public int multiplication(int a, int b) {
        return a * b;
    }

    public int calculate(String a, String b, String command) {
        int parsedIntA = Integer.parseInt(a);
        int parsedIntB = Integer.parseInt(b);

        if (command.equals("+")) {
            return addtion(parsedIntA, parsedIntB);
        }
        if (command.equals("-")) {
            return subtraction(parsedIntA, parsedIntB);
        }
        if (command.equals("*")) {
            return multiplication(parsedIntA, parsedIntB);
        }
        if (command.equals("/")) {
            return division(parsedIntA, parsedIntB);
        }
        return 0;
    }

}
