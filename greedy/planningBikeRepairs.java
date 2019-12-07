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
    
    if(n <= 0){
      return "0";
    }
    
    ArrayList<Job> jobs = new ArrayList<>();
    
    for(int i = 1 ; i <= n ; i ++){
      int s = sc.nextInt();
      int d = sc.nextInt();
      jobs.add(new Job(s, s+d));
    }
    
    Collections.sort(jobs);
    
    int result = 1;
    
    for(int i = 0 ; i < jobs.size() ; i ++){
      int k = 1;
      Job curr = jobs.get(i);
      for(int j = 0 ; j < i ; j ++){
        Job before = jobs.get(j);
        if(before.finish > curr.start){
          k++;
        }
      }
      result = Math.max(result, k);
    }
    
    sc.close();
    return "" +result;
  }
}

class Job implements Comparable<Job>{
  int start;
  int finish;
  
  public Job(int start, int finish){
    this.start = start;
    this.finish = finish;
  }
  
  @Override
  public int compareTo(Job other){
    return Integer.compare(this.start, other.start);
  }
}



























// package weblab;
// 
// import java.io.*;
// import java.util.*;
// //I ADDED THIS HERE
// import javafx.util.*;
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
//     
//     int n = sc.nextInt();
//     
//     if(n <= 0){
//       return "0";
//     }
//     
//     ArrayList<Pair<Integer, Integer>> list = new ArrayList<Pair<Integer, Integer>>();
//     
//     for(int i = 1 ; i <= n ; i++){
//       int s = sc.nextInt();
//       int f = sc.nextInt();
//       list.add(new Pair<Integer,Integer>(s, s+f));
//     }
//     
//     Collections.sort(list, PairComparator);
// 
//     int maxWorkers = 1;
//   
//     for(int i = 0 ; i < n ; i ++){
//       Pair<Integer, Integer> currentPair = list.get(i);
//       int k = 1;
//       for(int j = 0 ; j < i ; j ++){
//         Pair<Integer, Integer> before = list.get(j);
//         if(before.getValue() > currentPair.getKey()){
//           k++;
//         }
//       }
//       if(k > maxWorkers){
//         maxWorkers = k;
//       }
//     }
//     
//     sc.close();
//     return "" + maxWorkers;
//   }
//   
//   public static Comparator<Pair<Integer, Integer>> PairComparator = new Comparator<Pair<Integer, Integer>>() {
// 
// 	public int compare(Pair<Integer, Integer> s1, Pair<Integer, Integer> s2) {
// 	   //ascending order
// 	   return s1.getKey().compareTo(s2.getKey());
// 
// 	   //descending order
// 	   //return StudentName2.compareTo(StudentName1);
//     }};
// }
// 
