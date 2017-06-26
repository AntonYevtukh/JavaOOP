package homework.lection01.repeating.task01;

import java.util.Scanner;

public class Palindrome {

    static Scanner scanner = new Scanner(System.in);
    static int[] nums;

    public static void main(String[] args) {
        readAll();
        System.out.println(getPalindrome());
    }

    static void readAll() {
        System.out.print("<<Enter the count of numbers: \n>>");
        nums = new int[readNumber()];
        for (int i = 0; i < nums.length; i++) {
            System.out.print("<<Enter a number #" + (i + 1) + ": \n>>");
            nums[i] = readNumber();
        }
    }

    static int readNumber() {
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.print("<<Invalid input! Please, try again\n>>");
        }
        return scanner.nextInt();
    }

    static boolean isPalindrome(int num) {
        String strNum = Integer.toString(num);
        for (int i = 0; i < strNum.length() / 2; i++)
            if (strNum.charAt(i) != strNum.charAt(strNum.length() - 1 - i))
                return false;
        return true;
    }

    static String getPalindrome() {
        String result = "No palindrome found";
        for(int i : nums) {
            if (isPalindrome(i) && result.equals("No palindrome found"))
                result = Integer.toString(i);
            else if (isPalindrome(i))
                return Integer.toString(i);
        }
        return result;
    }
}
