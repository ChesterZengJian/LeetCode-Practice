package main.java.com.chester.common;

public class FormatPrint {
    public static void print(int[] params) {
        for (int i = 0; i < params.length; i++) {
            if (i == params.length - 1) {
                System.out.print(params[i]);
                return;
            }

            System.out.print(params[i] + ", ");
        }
    }
}
