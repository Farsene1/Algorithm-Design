package weblab;

import java.io.*;
import java.util.Arrays;

class Solution {

  static int countInversions(int[] array) {
    return sortAndCount(array);
  }
  
  static int sortAndCount(int[] array){
    if(array.length <= 1){
      return 0;
    }
    
    int mid = array.length/2;
    
    int[] A = Arrays.copyOfRange(array, 0, mid);
    int[] B = Arrays.copyOfRange(array, mid, array.length);
    
    int RA = sortAndCount(A);
    int RB = sortAndCount(B);
    
    int R = mergeAndCount(array, A, B);
    
    return RA + RB + R;
  }
  
  static int mergeAndCount(int[] array, int[] A, int[] B){
    int i = 0, j = 0, k = 0, count = 0;
    
    while(i < A.length && j < B.length){
      if(A[i] <= B[j]){
        array[k++] = A[i++];
      }else if(A[i] > B[j]){
        array[k++] = B[j++];
        count += A.length - i;
      }
    }
    
    while(i < A.length){
      array[k++] = A[i++];
    }
    
    while(j < B.length){
      array[k++] = B[j++];
    }
    
    return count;
  }
}

