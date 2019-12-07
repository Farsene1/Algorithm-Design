package weblab;

import java.io.*;
import java.util.*;

class Node {

  List<Node> outgoingEdges;

  boolean marked;

  public Node() {
    this.outgoingEdges = new ArrayList<>();
    this.marked = false;
  }
}

class Solution {

  // Implement the solve method to return the answer to the problem posed by the inputstream.
  public static String run(InputStream in) {
    return new Solution().solve(in);
  }

  public String solve(InputStream in) {
    Scanner sc = new Scanner(in);
    
    int n = sc.nextInt(), m = sc.nextInt(), s=sc.nextInt();
    
    ArrayList<Node> nodes = new ArrayList<>();
    nodes.add(new Node());
    for(int i = 1; i <= n ; i++){
      nodes.add(new Node());
    }
    
    for(int i = 1 ; i<= m ; i++){
      int u = sc.nextInt();
      int v = sc.nextInt();
      sc.nextInt();
      nodes.get(u).outgoingEdges.add(nodes.get(v));
    }
    
    String result = find(nodes, nodes.get(s));
    
    sc.close();
    return result;
    
  }
  
  public static String find(ArrayList<Node> nodes, Node from){
    Queue<Node> q = new LinkedList<>();
    q.add(from);
    from.marked = true;
    
    while(!q.isEmpty()){
      Node next = q.poll();
      next.marked = true;
      
      for(Node out : next.outgoingEdges){
        if(!out.marked){
          q.offer(out);
        }else{
          return "yes";
        }
      }
    }
    
    return "no";
  }
}

// package weblab;
// 
// import java.io.*;
// import java.util.*;
// 
// class Node {
// 
//   List<Node> outgoingEdges;
// 
//   boolean marked;
// 
//   public Node() {
//     this.outgoingEdges = new ArrayList<>();
//     this.marked = false;
//   }
// }
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
//     int n, m, central_station;
//     
//     n = sc.nextInt();
//     m = sc.nextInt();
//     central_station = sc.nextInt();
//     
//     ArrayList<Node> nodes = new ArrayList<Node>(n+1);
//     for(int i = 0 ; i < n+1 ; i ++){
//       nodes.add(new Node());
//     }
//     
//     for (int i = 0; i < m; i++) {
//       int from = sc.nextInt();
//       int to = sc.nextInt();
//       int cost = sc.nextInt();
//       nodes.get(from).outgoingEdges.add(nodes.get(to));
//     }
//     
//     String result = findCycleBFS(nodes, nodes.get(central_station));
//     
//     sc.close();
//     return result;
//   }
//   
//   // with BFS I GET 13/13
//   public String findCycleBFS(ArrayList<Node> nodes, Node start){
//     Queue<Node> queue = new LinkedList<Node>();
//     queue.add(start);
//     String result = "no";
//     
//     while(!queue.isEmpty()){
//       Node current = queue.poll();
//       current.marked = true;
//       for(Node n : current.outgoingEdges){
//         if(n.marked == true){
//           return "yes";
//         }else{
//           queue.offer(n);
//         }
//       }
//     }
//     return result;
//   }
//   
//   // with DFS I GET 11/13
//   public String findCycleDFS(ArrayList<Node> nodes, Node start){
//     start.marked = true;
//     String result = "no";
//     
//     for(Node out : start.outgoingEdges){
//       if(out.marked == true){
//         result = "yes";
//       }else{
//         result = findCycleDFS(nodes, out);
//       }
//     }
//     
//     return result;
//   }
// }
// // 
