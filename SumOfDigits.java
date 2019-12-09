package com.rex.fix;

/**
 * Developer: Richard M. Obiye
 * Date: 27-Nov-19
 * Time: 9:20 AM
 * IDE: IntelliJ IDEA
 *
 *
 * We traverse through all numbers. For every number, we find the sum of digits. We stop when we find the n-th number with sum of digits as 10.
 */
public class SumOfDigits {
  public static void main(String ags[]) {
    //poor performance
    System.out.println(getNthNumber(15));
    //Good performance
    System.out.println(findNth(15));
  }

  private static int getNthNumber(int n) {
    int count = 0;
    int val = 0;
    for (int i = 0; i <= 99999999; i++) {
      if (getSum(i) == 10) {
        count++;
      }
      if (count == n) {
        val = i;
        break;
      }
    }
    return val;
  }

  private static int getSum(int x) {
    String s = String.valueOf(x);
    int len = s.length();
    int sum = 0;
    for (int i = 0; i < len; i++) {
      sum += Integer.parseInt(String.valueOf(s.charAt(i)));
    }
    return sum;
  }

  private static int findNth(int n) {
    int count = 0;
    for (int curr = 1; ; curr++) {
      // Find sum of digits in current no.
      int sum = 0;
      for (int x = curr; x > 0; x = x / 10) {
        sum = sum + x % 10;
      }

      // If sum is 10, we increment count
      if (sum == 10) {
        count++;
      }

      // If count becomes n, we return current
      // number.
      if (count == n) {
        return curr;
      }
    }
  }

}
