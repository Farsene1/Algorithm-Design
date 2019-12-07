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
    
    int n = sc.nextInt(), m = sc.nextInt(), s=sc.nextInt(), t = sc.nextInt();
    
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
    
    String result = find(nodes, nodes.get(s), nodes.get(t));
    
    sc.close();
    return result;
    
  }
  
  public static String find(ArrayList<Node> nodes, Node from, Node to){
    Queue<Node> q = new LinkedList<>();
    q.add(from);
    from.marked = true;
    
    while(!q.isEmpty()){
      Node next = q.poll();
      if(next == to){
        return "yes";
      }
      
      for(Node out : next.outgoingEdges){
        if(!out.marked){
          out.marked = true;
          q.offer(out);
        }
      }
    }
    
    if(to.marked == true){
      return "yes";
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
//     Scanner scanner = new Scanner(in);
//     int n, m, s, t;
//     
//     n = scanner.nextInt();
//     m = scanner.nextInt();
//     s = scanner.nextInt();
//     t = scanner.nextInt();
//     
//     ArrayList<Node> nodes = new ArrayList<Node>(n+1);
//     for(int i = 0 ; i <= n ; i++){
//       nodes.add(new Node());
//     }
//     
//     for (int i = 0; i < m; i++) {
//       int from = scanner.nextInt();
//       int to = scanner.nextInt();
//       int cost = scanner.nextInt();
//       nodes.get(from).outgoingEdges.add(nodes.get(to));
//     }
//     
//     scanner.close();
// 
//     String result = "no";
//     find(nodes, nodes.get(s), nodes.get(t));
//     if(nodes.get(t).marked == true){
//       result = "yes";
//     }
//     //REPLACE
//     return result;
//   }
//   
//   public void find(ArrayList<Node> nodes, Node start, Node exit){
//     start.marked = true;
//     
//     for(Node out : start.outgoingEdges){
//       if(out == exit){
//         exit.marked = true;
//         return;
//       }
//       if(out.marked == false){
//         find(nodes, out, exit);
//       }
//     }
//   }
// }
// 
