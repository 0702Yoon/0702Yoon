package bClass;

import java.io.IOException;

public class get {
    static final int CarrigeReturn =0x0d;

    private int readOperator() throws IOException {
        int code= System.in.read();
        System.in.read();
        System.in.read();
        return code;
    }

    private int readInt() throws IOException {
        int number = 0;
        int code = System.in.read();
        while (code >= '0' && code <= '9') {
            number = number * 10 + (code - '0');
            code = System.in.read();
        }
        if (code == CarrigeReturn) {
            code = System.in.read();
            return number;
        } else {
            throw new IOException();
        }
    }

    private int add() throws IOException {
        int number1 = readInt();
        int number2 = readInt();
        int sum = number1 + number2;
        return sum;
    }

    private int subtract() throws IOException {
        int number1 = readInt();
        int number2 = readInt();
        int difference = number1 - number2;
        return difference;
    }

    private int multiply() throws IOException {
        int number1 = readInt();
        int number2 = readInt();
        int product = number1 * number2;
        return product;
    }

    private int divide() throws IOException {
        int number1 = readInt();
        int number2 = readInt();
        if (number2 == 0) {
            throw new ArithmeticException("Division by zero");
        }
        int quotient = number1 / number2;
        return quotient;
    }

    public void run() {
        try {
            int result = 0;
            int code = readOperator();
            switch (code) {
                case '*':
                    result = multiply();
                    break;
                case '/':
                    result = divide();
                    break;
                case '+':
                    result = add();
                    break;
                case '-':
                    result = subtract();
                    break;
                default:
                    System.out.println("Invalid operator");
                    return;
            }
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ArithmeticException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {
    	get chat = new get();
    	while(true) {
    		chat.run();
    		System.out.println("Exit?='y'or return?='n'");
    		int ch = System.in.read();
    		if(ch == 'y') {
    			break;
    		}
    		System.in.read(); // 0d
    		System.in.read(); // 0a
    	}
    }
}