package weblab;

class Solution {

  /**
   * Takes an array and sorts it in an ascending order.
   *
   * @param arr
   *     - the array that needs to be sorted.
   */
  public void sort(int[] arr) {
    // for(int i = 0 ; i < arr.length ; i ++){
    //   System.out.print(arr[i] + " ");
    // }
    // System.out.println();
    mergeSort(arr, 0, arr.length-1);
    // for(int i = 0 ; i < arr.length ; i ++){
    //   System.out.print(arr[i] + " ");
    // }
  }
  
  public void mergeSort(int[] arr, int i, int j){
    if(j - i < 2){
      
    }else{
      int start = i;
      int mid = (i+j)/2;
      int end = j;
    
      mergeSort(arr, start, mid);
      mergeSort(arr, mid+1, end);
      
      merge(arr, start, mid, end);
    }
  }
  
  public void merge(int[] arr, int start, int mid, int end){

    // applying insertion sort
    for(int i = mid; i <= end ; i++){
      int temp = arr[i];
      int j = i - 1;
      while(j >= start && arr[j] > temp){
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j+1] = temp;
    }
  }
}

