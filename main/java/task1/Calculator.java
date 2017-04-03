package task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Dina_Abdykasheva on 4/3/2017.
 */
public class Calculator {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader((System.in)));
        System.out.println();
        System.out.println("Enter first number");
        int a = Integer.parseInt(r.readLine());

        System.out.println("Enter operation");
        String operation = r.readLine();

        System.out.println("Enter second number");
        int b = Integer.parseInt(r.readLine());

        if (operation.equals("+"))
            System.out.println("Result: " + (a+b));
        if (operation.equals("-"))
            System.out.println("Result: " + (a-b));
        if (operation.equals("*"))
            System.out.println("Result: " + (a*b));
        if (operation.equals("/"))
            System.out.println("Result: " + (a/b));
    }
}
