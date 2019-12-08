package weblab;

import java.util.*;

class Solution {

  /**
   * Takes a list of points and returns the distance between the closest pair.
   * This is done with divide and conquer.
   *
   * @param points
   *     - list of points that need to be considered.
   * @return smallest pair-wise distance between points.
   */
  public static double closestPair(List<Point> points) {
    //sorting according to x and to y at the beginning;
    List<Point> px = new ArrayList<>(points);
    Util.sortByX(px);
    List<Point> py = new ArrayList<>(points);
    Util.sortByY(py);
    
    return closestPair(px, py);
  }
  
  public static double closestPair(List<Point> px, List<Point> py){
    if(px.size() <= 3){
      return Util.bruteForce(px);
    }
    
    int mid = px.size()/2;
    
    //LEFT SIDE
    List<Point> lx = new ArrayList<>(px.subList(0, mid));
    List<Point> ly = new ArrayList<>(py.subList(0, mid));
    //RIGHT SIDE
    List<Point> rx = new ArrayList<>(px.subList(mid, px.size()));
    List<Point> ry = new ArrayList<>(py.subList(mid, px.size()));
  
    double d1 = closestPair(lx, ly);
    double d2 = closestPair(rx, ry);
    
    //SMALLEST DISTANCE FROM BOTH SIDES
    double d = Math.min(d1, d2);
    
    //FIND THE SMALLEST DISTANCE WITH POINTS FROM BOTH SIDES
    
    List<Point> S = new ArrayList<>();
    
    for(Point p : py){
      if(p.x - mid < d){
        S.add(p);
      }
    }
    
    for(int i = 0 ; i < S.size() ; i++){
      Point curr = S.get(i);
      for(int j = i+1 ; j <= i+11 && j < S.size(); j ++){
        Point temp = S.get(j);
        double dist = Util.distance(curr, temp);
        if(dist < d){
          d = dist;
        }
      } 
    }
    
    return d;
  }
}








// package weblab;
// 
// import java.util.*;
// 
// class Solution {
// 
//   /**
//    * Takes a list of points and returns the distance between the closest pair.
//    * This is done with divide and conquer.
//    *
//    * @param points
//    *     - list of points that need to be considered.
//    * @return smallest pair-wise distance between points.
//    */
//   public static double closestPair(List<Point> points) {
//         List<Point> Px = new ArrayList<Point>(points);
//         Util.sortByX(Px);
//         List<Point> Py = new ArrayList<Point>(points);
//         Util.sortByY(Py);
// 
//         return closestPair(Px, Py);
//     }
// 
//      public static double closestPair(List<Point> Px, List<Point> Py){
//         if(Px.size() <= 3){
//             return Util.bruteForce(Px);
//         }
// 
//         List<Point> Qx, Qy = new ArrayList<Point>(), Rx, Ry = new ArrayList<Point>();
//         int med = (Px.size())/2;
// 
//         Qx  = new ArrayList<Point>(Px.subList(0, med));
//         Rx = new ArrayList<Point>(Px.subList(med, Px.size()));
// 
//         for (Point point: Py) {
//             if (point.x < Px.get(med).x)   {
//                 Qy.add(point);
//             } else {
//                 Ry.add(point);
//             }
//         }
// 
// 
//         double lambdaLeft = closestPair(Qx, Qy);
//         double lambdaRight = closestPair(Rx, Ry);
//         double dist = Math.min(lambdaLeft, lambdaRight);
// 
//         List<Point> Sy = new ArrayList<Point>();
// 
//         Point leftMost = Qx.get(Qx.size()-1);
// 
//         // constructing points in the narrow band;
//         for (Point point : Py) {
//             if (Math.abs(leftMost.x - point.x) < dist) {
//                 Sy.add(point);
//             }
//         }
// 
//         // looping the narrow band
//         for(int i = 0 ; i < Sy.size() ; i++){
//             Point curr = Sy.get(i);
//             for(int j = i + 1; j < j + 12 && j < Sy.size(); j ++){
//                 Point next = Sy.get(j);
//                 if(Util.distance(curr, next) < dist){
//                     dist = Util.distance(curr, next);
//                 }
//             }
//         }
// 
// 
//         return dist;
//     }
// }
// 
