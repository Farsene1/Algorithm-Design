package weblab;

class Solution {

  /**
   * Finds the x coordinate with the smallest distance between two linear equations, by recursively evaluating the median of the range and that integer + 1.
   * Depending on the value, a new evaluation is made with a smaller range to find the x coordinate with the smallest distance.
   * @param e1 the first equation to evaluate
   * @param e2 the second equation to evaluate
   * @param low the lower boundary of the range
   * @param high the upper boundary of the range
   * @return the x coordinate with the minimum difference between e1 and e2
   */
  public static long findMin(Equation e1, Equation e2, long low, long high) {
    if(low == high){
      return low;
    }
    
    long mid = (low + high)/2;
    
    if(diff(e1, e2, mid) < diff(e1, e2, mid+1)){
      return findMin(e1, e2, low, mid);
    }else{
      return findMin(e1, e2, mid+1, high);
    }
    
  }
  
  public static long diff(Equation e1, Equation e2, long k){
    return Math.abs(e1.evaluate(k) - e2.evaluate(k));
  }
  
  
}

























// package weblab;
// 
// class Solution {
// 
//   /**
//    * Finds the x coordinate with the smallest distance between two linear equations, by recursively evaluating the median of the range and that integer + 1.
//    * Depending on the value, a new evaluation is made with a smaller range to find the x coordinate with the smallest distance.
//    * @param e1 the first equation to evaluate
//    * @param e2 the second equation to evaluate
//    * @param low the lower boundary of the range
//    * @param high the upper boundary of the range
//    * @return the x coordinate with the minimum difference between e1 and e2
//    */
//   public static long findMin(Equation e1, Equation e2, long low, long high) {
//     long med  = (low + high)/2;
//         if(low == high){
//             return low;
//         }
//         if(high - low == 1){
//             long dist1 = Math.abs(diff(e1, e2, low));
//             long dist2 = Math.abs(diff(e1, e2, high));
//             if(dist1 < dist2){
//                 return low;
//             }else{
//                 return high;
//             }
//         }
//         
//         // the difference between 2 quadratic equations is still a quadratic equation
//         // so we just check only half of it
//         if(Math.abs(diff(e1, e2, med)) < Math.abs(diff(e1, e2, med+1))){
//           return findMin(e1, e2, low, med);
//         }else{
//           return findMin(e1, e2, med+1, high);
//         }
// 
//         // long  left = findMin(e1, e2, low, med);
//         // long right = findMin(e1, e2, med+1, high);
// 
//         // if(Math.abs(diff(e1, e2, left)) < Math.abs(diff(e1, e2, right))){
//         //     return left;
//         // }else{
//         //     return right;
//         // }
//   }
//   
//   public static long diff(Equation e1, Equation e2, long ind){
//     return e1.evaluate(ind) - e2.evaluate(ind);
//   }
// }
// 
