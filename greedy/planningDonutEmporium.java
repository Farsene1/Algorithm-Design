package weblab;

import java.io.*;
import java.util.*;

class Solution {

  // Implement the solve method to return the answer to the problem posed by the inputstream.
  public static String run(InputStream in) {
    return new Solution().solve(in);
  }

  public String solve(InputStream in) {
    Scanner sc = new Scanner(in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    List<House> houses = new ArrayList<>(n);
    for (int i = 0; i < n; i++) {
      houses.add(new House(i, sc.nextInt(), sc.nextInt()));
    }
    int m = n * (n - 1) / 2;
    List<Distance> distances = new ArrayList<>(m);
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        distances.add(new Distance(houses.get(i), houses.get(j)));
      }
    }
    UnionFind unionFind = new UnionFind(houses);
    // TODO

    Collections.sort(distances, Comparator.comparingLong(d -> d.distance));
    
    int edges = 0;
    for(int i = 0 ; i< distances.size(); i++){
      if(edges == n-k){
        break;
      }
      
      Distance d = distances.get(i);
      
      if(unionFind.join(d.a, d.b)){
        edges++;
      }
    }
    
    String result = "";
    for(List<House> cluster : unionFind.clusters()){
      double x=0, y=0;
      for(House h : cluster){
        x += h.x;
        y += h.y;
      }
      x = x/cluster.size();
      y = y/cluster.size();
      
      result = result + x + " " + y + "\n";
    }
    
    sc.close();
    return result;
  }
}






// package weblab;
// 
// import java.io.*;
// import java.util.*;
// 
// class Solution {
// 
//   // Implement the solve method to return the answer to the problem posed by the inputstream.
//   public static String run(InputStream in) {
//     return new Solution().solve(in);
//   }
// 
//   public String solve(InputStream in) {
//     Scanner sc = new Scanner(in);
//     int n = sc.nextInt();
//     int k = sc.nextInt();
//     List<House> houses = new ArrayList<>(n);
//     for (int i = 0; i < n; i++) {
//       houses.add(new House(i, sc.nextInt(), sc.nextInt()));
//     }
//     int m = n * (n - 1) / 2;
//     List<Distance> distances = new ArrayList<>(m);
//     for (int i = 0; i < n; i++) {
//       for (int j = i + 1; j < n; j++) {
//         distances.add(new Distance(houses.get(i), houses.get(j)));
//       }
//     }
//     UnionFind unionFind = new UnionFind(houses);
//     // TODO
// 
//   }
// }
// 
// // package weblab;
// // 
// // import java.io.*;
// // import java.util.*;
// // 
// // class Solution {
// // 
// //   // Implement the solve method to return the answer to the problem posed by the inputstream.
// //   public static String run(InputStream in) {
// //     return new Solution().solve(in);
// //   }
// // 
// //   public String solve(InputStream in) {
// //     Scanner sc = new Scanner(in);
// //     
// //     int n = sc.nextInt();
// //     int k = sc.nextInt();
// //     
// //     List<House> houses = new ArrayList<>(n);
// //     for (int i = 0; i < n; i++) {
// //       houses.add(new House(i, sc.nextInt(), sc.nextInt()));
// //     }
// //     
// //     int m = n * (n - 1) / 2;
// //     
// //     List<Distance> distances = new ArrayList<>(m);
// //     
// //     for (int i = 0; i < n; i++) {
// //       for (int j = i + 1; j < n; j++) {
// //         distances.add(new Distance(houses.get(i), houses.get(j)));
// //       }
// //     }
// //     UnionFind unionFind = new UnionFind(houses);
// //     // TODO
// //     sc.close();
// //     Collections.sort(distances, Comparator.comparingLong(d -> d.distance));
// //     
// //     int nr = 0 ;
// //     
// //     for(int i = 0 ; i < distances.size() ; i ++){
// //       
// //       Distance dist = distances.get(i);
// //       House a = dist.a;
// //       House b = dist.b;
// //       
// //       // WHY DON'T I PASS SPECTESTS WHEN I INVERSE THE NEXT TWO IF STATEMENTS
// //       if(nr == n-k){
// //         break;
// //       }
// //       
// //       if(unionFind.find(a) != unionFind.find(b)){
// //         unionFind.join(a, b);
// //         nr++;
// //       }
// //       // UNTIL HERE
// //       
// //     }
// //     
// //     StringBuilder result = new StringBuilder();
// //     
// //     for(List<House> cluster : unionFind.clusters()){
// //       double cx = 0;
// //       double cy = 0;
// //       
// //       for(House huis : cluster){
// //         cx += huis.x;
// //         cy += huis.y;
// //       }
// //       
// //       cx /= cluster.size();
// //       cy /= cluster.size();
// //       
// //       // result = result + cx + " " + cy  + "\n";
// //       result.append(cx).append(' ').append(cy).append('\n');
// //     }
// //     
// //     
// //     return result.toString();
// //   }
// // }
// // 
// // 
