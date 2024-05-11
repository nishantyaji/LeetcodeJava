package com.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class NextGreaterElement3 {
    public static void main(String[] args) {
        NextGreaterElement3 n = new NextGreaterElement3();
        System.out.println(n.nextGreaterElement(230241));
        System.out.println(n.nextGreaterElement(12));
        System.out.println(n.nextGreaterElement(6784987));
        System.out.println(n.nextGreaterElement(23277773));
        System.out.println(n.nextGreaterElement(2756));
        System.out.println(n.nextGreaterElement(6789));
    }

    public int nextGreaterElement(int n) {
        if (n <= 11 || n > Math.pow(2, 31) - 1) {
            return -1;
        }
        int q = n, r;
        int numDigits = ((int) Math.log10(n - 1)) + 1;
        int[] digits = new int[numDigits];
        int runningIdx = numDigits - 1;
        do {
            r = q % 10;
            q = q / 10;
            digits[runningIdx--] = r;
        } while (q > 0);
        for (int i = digits.length - 2; i >= 0; i--) {
            for (int j = digits.length - 1; j >= i + 1; j--) {
                if (digits[i] < digits[j]) {
                    int temp = digits[i];
                    digits[i] = digits[j];
                    digits[j] = temp;
                    List<Integer> digitsList = Arrays.stream(digits).boxed().collect(Collectors.toList());
                    return intValue(digitsList, i);
                }
            }
        }
        return -1;
    }

    private int intValue(List<Integer> digits, int end) {
        long result = 0;
        List<Integer> resultList = digits.subList(0, end + 1);
        List<Integer> remainingList = digits.subList(end + 1, digits.size());
        Collections.sort(remainingList);
        resultList.addAll(remainingList);
        for (int digit : resultList) {
            result = 10 * result + digit;
        }
        if(result > Math.pow(2, 31)-1) {
            return -1;
        }
        return (int) result;
    }
}
