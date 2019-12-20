package weblab;

import java.io.*;
import java.util.*;

class Solution {

  /**
   * Returns the n'th Fibonacci number
   */
  public static int fibonacci(int n) {
    // The array in which you must implement your memoization.
    int[] fibonacci = new int[n + 1];
    // TODO fibonacci[0] = ...; // Implement the base cases here


    // TODO fibonacci[1] = ...;


    // After that, iterate through all fibonacci numbers from index 2 up to n.
    for (int i = 2; i <= n; i++) {
      // TODO fibonacci[i] = ...;

    }
    // Returning the obtained fibonacci value at index n.
    return fibonacci[n];
  }
}

