package weblab;


class Solution {

  public static /**
   * @param n the number of packages
   * @param weights the weights of all packages 1 through n. Note that weights[0] should be ignored!
   * @param maxWeight the maximum weight a truck can carry
   * @return the minimal number of trucks required to ship the packages _in the given order_.
   */
  int minAmountOfTrucks(int n, int[] weights, int maxWeight) {
    if(n == 0){
      return 0;
    }
    int result = 1;
    int w = 0;
    for(int i = 1 ; i<= n ; i++){
      if(w + weights[i] > maxWeight){
        result++;
        w = weights[i];
      }else{
        w = w + weights[i];
      }
    }
    return result;
  }
}

// package weblab;
// 
// 
// class Solution {
// 
//   public static /**
//     * @param n the number of packages
//     * @param weights the weights of all packages 1 through n. Note that weights[0] should be ignored!
//     * @param maxWeight the maximum weight a truck can carry
//     * @return the minimal number of trucks required to ship the packages _in the given order_.
//     */
//   int minAmountOfTrucks(int n, int[] weights, int maxWeight) {
//     int k = 1;
//     int sum = 0;
//     
//     if(n == 0){
//       return 0;
//     }
//     
//     for(int i = 1 ; i <= n ; i ++){
//       if(sum + weights[i] <= maxWeight){
//         sum = sum + weights[i];
//       }else{
//         sum = weights[i];
//         k++;
//       }
//     }
//     
//     return k;
//     
//   }
// }
// 
