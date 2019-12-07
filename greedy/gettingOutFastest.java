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
    /*
     * We already parse the input for you and should not need to make changes to this part of the code.
     * You are free to change this input format however.
     */
    int n = sc.nextInt();
    int m = sc.nextInt();
    int s = sc.nextInt();
    int t = sc.nextInt();
    ArrayList<HashMap<Integer, Integer>> nodes = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      nodes.add(new HashMap<>());
    }
    for (int i = 0; i < m; i++) {
      int u = sc.nextInt();
      int v = sc.nextInt();
      int cost = sc.nextInt();
      nodes.get(u).put(v, cost);
    }
    // TODO
    sc.close();
    ArrayList<Node> graph = new ArrayList<>();
    PriorityQueue<Node> pq = new PriorityQueue<>();
    
    graph.add(new Node());
    
    for(int i = 1; i <= n ; i++){
      Node node = new Node(i, Integer.MAX_VALUE);
      if(node.index == s){
        node.dist = 0;
      }
      graph.add(node);
    }
    
    pq.add(graph.get(s));
    
    while(!pq.isEmpty()){
      Node curr = pq.poll();
      
      for(Integer neigh_ind : nodes.get(curr.index).keySet()){
        Node neigh = graph.get(neigh_ind);
        
        if(curr.dist + nodes.get(curr.index).get(neigh_ind) + nodes.get(curr.index).keySet().size() < neigh.dist){
          neigh.dist =  curr.dist + nodes.get(curr.index).get(neigh_ind) + nodes.get(curr.index).keySet().size();
          pq.add(neigh);
        }
      }
    }
    if(graph.get(t).dist != Integer.MAX_VALUE){
      return "" + graph.get(t).dist;
    }
    
    return "-1";

  }
}

class Node implements Comparable<Node>{
  int index;
  int dist;
  boolean marked = false;
  
  public Node(){
    
  }
  
  public Node(int index, int dist){
    this.index = index;
    this.dist = dist;
  }
  
  @Override
  public int compareTo(Node other){
    return Integer.compare(this.dist, other.dist);
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
//     /*
//       * We already parse the input for you and should not need to make changes to this part of the code.
//       * You are free to change this input format however.
//       */
//     int n = sc.nextInt();
//     int m = sc.nextInt();
//     int s = sc.nextInt();
//     int t = sc.nextInt();
//     
//     ArrayList<HashMap<Integer, Integer>> nodes = new ArrayList<>();
//     for (int i = 0; i <= n; i++) {
//       nodes.add(new HashMap<>());
//     }
//     for (int i = 0; i < m; i++) {
//       int u = sc.nextInt();
//       int v = sc.nextInt();
//       int cost = sc.nextInt();
//       nodes.get(u).put(v, cost);
//     }
//     sc.close();
//     
//     // TODO - IMPLEMENTATION HERE
//     
//    if(s == t){
//      return "0";
//    }
//     
//     PriorityQueue<Node> pq = new PriorityQueue<Node>();
//     
//     ArrayList<Node> list = new ArrayList<Node>();
//     list.add(new Node(0));
//     
//     for(int i = 0 ; i <= n ; i ++){
//       if(i!=0){
//          Node x = new Node(i);
//          if(i == s){
//            x.dist = 0;
//          }
//          //pq.add(x);
//          list.add(x);
//       }
//     }
//     
//     Node source = list.get(s);
//     source.dist = 0;
//     pq.add(source);
//     
//     
//     while(!pq.isEmpty()){
//       Node next = pq.remove();
//       int v = next.index;
//       
//       // THIS INCREASES THE SPECTESTS BY 1
//       // if(next.marked){
//       //   continue;
//       // }
//       next.marked = true;
//      
//       HashMap<Integer, Integer> map = nodes.get(v);
//       
//       // key basically represents a neighbour
//       for(Integer key : map.keySet()){
//         Node temp = list.get(key);
//         //this increases the score too
//         // if(temp.marked){
//         //   continue;
//         // }
//         int alt = next.dist + map.get(key) + map.size();
//         if(alt < temp.dist){
//           //pq.remove(temp);
//           temp.dist = alt;
//           pq.add(temp);
//         }
//       }
//     }
//     
// 
//     if(list.get(t).dist == Integer.MAX_VALUE){
//       return "-1";
//     }
//     
//     String result =  " " + list.get(t).dist;
//     
//     
//     return result;
//   }
// }
// 
// class Node implements Comparable<Node>{
//     int index;
//     int dist = Integer.MAX_VALUE;
//     boolean marked = false;
//     
//     public Node(int index){
//       this.index = index;
//     }
//     
//     @Override
//     public int compareTo(Node other){
//       return Integer.compare(this.dist, other.dist);
//     }
//   }
// 
// 
// // package weblab;
// // 
// // import java.io.*;
// // import java.util.*;
// // 
// // class Solution {
// // 
// //   //CAN I ADD THIS HERE?
// //   int[] dist;
// // 
// //   // Implement the solve method to return the answer to the problem posed by the inputstream.
// //   public static String run(InputStream in) {
// //     return new Solution().solve(in);
// //   }
// // 
// //   public String solve(InputStream in) {
// //     Scanner sc = new Scanner(in);
// //     /*
// //       * We already parse the input for you and should not need to make changes to this part of the code.
// //       * You are free to change this input format however.
// //       */
// //     int n = sc.nextInt();
// //     int m = sc.nextInt();
// //     int s = sc.nextInt();
// //     int t = sc.nextInt();
// //     
// //     ArrayList<HashMap<Integer, Integer>> nodes = new ArrayList<>();
// //     for (int i = 0; i <= n; i++) {
// //       nodes.add(new HashMap<>());
// //     }
// //     for (int i = 0; i < m; i++) {
// //       int u = sc.nextInt();
// //       int v = sc.nextInt();
// //       int cost = sc.nextInt();
// //       nodes.get(u).put(v, cost);
// //     }
// //     sc.close();
// //     
// //     // TODO - IMPLEMENTATION HERE
// //     
// //     if(s == t){
// //       return "0";
// //     }
// //     
// //     dist = new int[n+1];
// //     //PriorityQueue<Integer> pq = new PriorityQueue<Integer>(n, new min_comparator());
// //     
// //     ArrayList<Integer> list = new ArrayList<Integer>();
// //     
// //     for(int i = 0 ; i <= n ; i ++){
// //       // INITIALIZING THE dist array with infinity
// //       // if(i != s && i != 0){
// //       //   // pq.add(i);
// //       //   dist[i] = Integer.MAX_VALUE;
// //       // }
// //       dist[i] = Integer.MAX_VALUE;
// //       if(i!=0){
// //         list.add(i);
// //       }
// //     }
// //     dist[s] = 0;
// //     
// //     // for(int i = 0 ; i <= n ; i ++){
// //     //   System.out.println(dist[i]);
// //     // }
// //     
// //     while(!list.isEmpty()){
// //       // int v = pq.remove();
// //       // System.out.println("CHECK ");
// //       int v = getMin(list, dist);
// //       // System.out.println("CHECK " + v);
// //       list.remove(new Integer(v));
// //       
// //       HashMap<Integer, Integer> map = nodes.get(v);
// //       
// //       // key basically represents a neighbour
// //       for(Integer key : map.keySet()){
// //         int alt = dist[v] + map.get(key) + map.size();
// //         if(alt < dist[key]){
// //           dist[key] = alt ;
// //         }
// //       }
// //     }
// //     
// //     // for(int i = 0 ; i <= n ; i ++){
// //     //   System.out.println("DISTANCE FROM 1 to " + i + " is " + dist[i]);
// //     // }
// //     if(dist[t] == Integer.MAX_VALUE){
// //       return "-1";
// //     }
// //     
// //     String result =  " " + dist[t];
// //     
// //     
// //     return result;
// //   }
// //   
// //   // THE PROBLEM MIGHT BE HERE
// //   public static Integer getMin(ArrayList<Integer> list, int[] dist){
// //     int min_dist = Integer.MAX_VALUE;
// //     int index = -1;
// //     
// //     for(Integer element : list){
// //       if(dist[element] <= min_dist){
// //         min_dist = dist[element];
// //         index = element;
// //       }
// //     }
// //     return index;
// //   }
// //   
// //   //comparator for min_queue
// //   class min_comparator implements Comparator<Integer> { 
// //     public int compare(Integer e1, Integer e2) 
// //     { 
// //       return (new Integer(dist[e1])).compareTo(new Integer(dist[e2])); 
// //     } 
// // } 
// // }
// // 
