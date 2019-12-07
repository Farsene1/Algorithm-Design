import java.util.*;

class Solution {

  public static double solve(int n, double[] list) {
    mergeSort(list);
    int len = list.length;
    if(len % 2 == 1){
      return list[len/2];
    }else{
      return (list[len/2-1] + list[len/2])/2;
    }
  }
  
  public static void quickSort(double[] elements) {
    if(elements.length > 0){
      quickSort(elements, 0, elements.length-1);
    }
  }

  public static void quickSort(double[] elements, int low, int high) {
    if(high > low){
    int indexPivot = partition(elements, low, high);
    quickSort(elements, low, indexPivot - 1);

    quickSort(elements,indexPivot, high);
    } 

    }

  public static int partition(double[] elements, int low, int high) {
    int left = low,
    right = high -1;
    double pivot = elements[high];

    while(left <= right){
      while(left <= right && elements[left] <= pivot){
        left++;
      }
      while(left <= right && elements[right] >= pivot){
        right--;
      }
      if(left <= right){
        swap(elements, left, right);
        left++;
        right--;
      }
    }

    swap(elements, left, high);

    return left;
  }

  public static void swap(double[] elements, int a, int b) {
    double temp = elements[a];
    elements[a] = elements[b];
    elements[b] = temp;
  }
  
  public static void mergeSort(double[] list){
    
    //IF 0 or 1 elements left -> already SORTED
    if(list.length < 2){
      return;
    }
    
    //SPLITTING THE LIST IN 2 LISTS
    double[] s1 = Arrays.copyOfRange(list, 0, list.length/2); 
    double[] s2 = Arrays.copyOfRange(list, list.length/2, list.length);
    
    //RECURSIVELY CALLING MERGE SORT
    mergeSort(s1);
    mergeSort(s2);
    
    int k = 0;
    int i = 0, j = 0;
    
    //MERGE PART
    while(i < s1.length && j < s2.length){
        if(s1[i] < s2[j]){
          list[k++] = s1[i++];
        }else{
          list[k++] = s2[j++];
        }
    }
    
    while(i < s1.length){
      list[k++] = s1[i++];
    }
    
    while(j < s2.length){
      list[k++] = s2[j++];
    }
  }
  
}
