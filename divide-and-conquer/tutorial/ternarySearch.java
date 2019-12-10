package weblab;

class Solution {

  /**
   * Finds the x coordinate with the highest value of an array with a unimodal function, by recursively evaluating the values at one-third and two-thirds of the range.
   * Depending on which is higher, a new evaluation is made with a smaller range to find the x coordinate with the highest value.
   * @param altitude the array with the unimodal function
   * @return the x coordinate with the highest value
   */
  public static int findPictureTime(double[] altitude) {
    return findPictureTime(altitude, 0, altitude.length - 1);
  }

  /**
   * Finds the x coordinate with the highest value of an array with a unimodal function, by recursively evaluating the values at one-third and two-thirds of the range.
   * Depending on which is higher, a new evaluation is made with a smaller range to find the x coordinate with the highest value.
   * @param altitude the array with the unimodal function
   * @param a lower bound on the x coordinate
   * @param an upper bound on the x coordinate
   * @return the x coordinate with the highest value
   */
  public static int findPictureTime(double[] altitude, int low, int high) {
    if(low == high){
      return low;
    }else if(high - low == 1){
      if(altitude[high] >= altitude[low]){
        return high;
      }else{
        return low;
      }
    }else if(high - low == 2){
      return maxOfThree(altitude, low, low+1, high);
    }
    
    // I HAD A MISTAKE WHEN GETTING THE THIRD VALUE; using (low + high)/3
    int oneThird = (2*low + high)/3;
    int twoThirds = (low+2*high)/3;
    
    int first = findPictureTime(altitude, low, oneThird);
    int sec = findPictureTime(altitude, oneThird+1, twoThirds);
    int third = findPictureTime(altitude, twoThirds+1, high);
    // WHY USING ONLY 2 thirds and not every third
    // // If the value at m1 is higher than the value at m2, the highest point must be between low and m2
    // if (altitude[m1] > altitude[m2]) {
    //   return findPictureTime(altitude, low, m2);
    // } else // Else, the highest point must be between m1 and high
    // {
    //   return findPictureTime(altitude, m1, high);
    // }
    
    int largest = maxOfThree(altitude, first, sec, third);
    
    return largest;
  }
  
  public static int maxOfThree(double[] altitude, int e1, int e2, int e3){
    if(altitude[e1] >= altitude[e2] && altitude[e1] >= altitude[e3]){
      return e1;
    }else if( altitude[e2] >= altitude[e1] && altitude[e2] >= altitude[e3]){
      return e2;
    }else if(altitude[e3] >= altitude[e1] && altitude[e3]>= altitude[e2]){
      return e3;
    }
    
    return Integer.MIN_VALUE;
  }
}

