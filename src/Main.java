import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter expression to evaluate:");
        String expr = scanner.nextLine();
        expr = expr.trim();

        try {Main.calc(expr);}
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void calc(String input) throws Exception {
        int num1 = 0, num2 = 0;
        boolean roman = false;
        int out = 0;
        String[] toEval = input.split(" ");
        if (toEval.length != 3) {
            throw new Exception("not Roman answer");
        }
        HashMap<String, Integer> romanToArabik = new HashMap<>();
        romanToArabik.put("I", 1);
        romanToArabik.put("IV", 4);
        romanToArabik.put("V", 5);
        romanToArabik.put("VI", 6);
        romanToArabik.put("VII", 7);
        romanToArabik.put("VIII", 8);
        romanToArabik.put("IX", 9);
        romanToArabik.put("X", 10);
        if (romanToArabik.containsKey(toEval[0]) && romanToArabik.containsKey(toEval[0]) ){
            num1 = romanToArabik.get(toEval[0]);
            num2 = romanToArabik.get(toEval[2]);
            roman = true;
        } else try {
            num1 = Integer.valueOf(toEval[0]);
            num2 = Integer.valueOf(toEval[2]);
        } catch (NumberFormatException e){
            throw new Exception("wrong number format");
//            System.out.println("wrong format");
//            return;
        }
        switch (toEval[1]){
            case ("*"):
                out = num1*num2;
                break;
            case ("+"):
                out = num1 + num2;
                break;
            case ("/"):
//
                out = num1 / num2;
                break;
            case ("-"):
                out = num1 - num2;
                break;
            default:
                throw new Exception("wrong expression format");

        }
        if (roman){
            if (out <= 0){
                throw new Exception("not Roman answer");
            }
            System.out.println(intToRoman(out));
            return;
        }
        System.out.println(out);

    }
    public static String intToRoman(int input){
        String s = "";
        while (input >= 100) {
            s += "C";
            input -= 100;
        }
        while (input >= 90) {
            s += "XC";
            input -= 90;
        }
        while (input >= 50) {
            s += "L";
            input -= 50;
        }
        while (input >= 40) {
            s += "XL";
            input -= 40;
        }
        while (input >= 10) {
            s += "X";
            input -= 10;
        }
        while (input >= 9) {
            s += "IX";
            input -= 9;
        }
        while (input >= 5) {
            s += "V";
            input -= 5;
        }
        while (input >= 4) {
            s += "IV";
            input -= 4;
        }
        while (input >= 1) {
            s += "I";
            input -= 1;
        }
        return s;
    }

}