import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Calculator {
    
public static void main(String[] args) {
    Calculator calculator = new Calculator();
    Logging logging = new Logging("calc_log.txt");
    
    System.out.println("Калькулятор для вычисления комплексных чисел");
    
    String[] operations = {"+", "-", "*", "/"};
    try (Scanner scanner = new Scanner(System.in)) {
        int choice;
        do {
        System.out.println("Выберите число обозночающее действие:");
        for (int i = 0; i < operations.length; i++) {
        System.out.println((i + 1) + ") " + operations[i]);
        }
        System.out.println("0) Выход");
        
        choice = scanner.nextInt();
        if (choice > 0 && choice <= operations.length) {
        String operation = operations[choice - 1];
        calculator.Operation(operation);
        } else if (choice != 0) {
        System.out.println("Ошибка");
        }
        } while (choice != 0);
    }
    logging.clear();
    }
    public void log(String message) {
        try {
            FileWriter writer = new FileWriter("calc_log.txt", true);
            writer.write(message + " ");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private ComplexNumber readComplexNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Действительная часть=");
        double real = scanner.nextDouble();
        System.out.print("Комплексная часть=");
        double imaginary = scanner.nextDouble();
        return new ComplexNumber(real, imaginary);
        }
        public void Operation(String operation) {
            ComplexNumber firstNumber = readComplexNumber();
            ComplexNumber secondNumber = readComplexNumber();
            ComplexNumber result = null;
            String logMessage = "";
            switch (operation) {
            case "+":
            result = firstNumber.add(secondNumber);
            logMessage = firstNumber + "+" + secondNumber + "=" + result;
            break;
            case "-":
            result = firstNumber.subtract(secondNumber);
            logMessage = firstNumber + "-" + secondNumber + "=" + result;
            break;
            case "*":
            result = firstNumber.multiply(secondNumber);
            logMessage = firstNumber + "*" + secondNumber + "=" + result;
            break;
            case "/":
            result = firstNumber.divide(secondNumber);
            logMessage = firstNumber + "/" + secondNumber + "=" + result;
            break;
            }
            System.out.println("Результат вычисления=" + result);
            log(logMessage);
            } 
}
