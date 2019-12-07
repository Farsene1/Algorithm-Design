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
    int m = sc.nextInt();
    int B = sc.nextInt();
    
    ArrayList<Edge> edges = new ArrayList<>();
    UnionFind uf = new UnionFind(n);
    
    for(int i = 1; i<=m ; i++){
      int a = sc.nextInt();
      int b = sc.nextInt();
      int cost = sc.nextInt();
      edges.add(new Edge(a, b, cost));
    }
    
    Collections.sort(edges);
    
    int total = 0;
    int could = 0;
    
    for(Edge e : edges){
      if(uf.union(e.a, e.b)){
        total += e.cost;
        if(total <= B){
          could++;
        }
      }
    }
    
    sc.close();
    return total + " " + could;
  }
}

class UnionFind {

  private int[] parent;

  private int[] rank;

  // Union Find structure implemented with two arrays for Union by Rank
  public UnionFind(int size) {
    parent = new int[size];
    rank = new int[size];
    for (int i = 0; i < size; i++) parent[i] = i;
  }

  /**
   * Merge two subtrees if they have a different parent, input is array indices
   * @param i a node in the first subtree
   * @param j a node in the second subtree
   * @return true iff i and j had different parents.
   */
  boolean union(int i, int j) {
    int x = find(i);
    int y = find(j);
    
    if(x == y){
      return false;
    }else{
      if(rank[x] > rank[y]){
        parent[y] = x;
      }else{
        parent[x] = y;
        if(rank[x] == rank[y]){
          rank[y]++;
        }
      }
      
      return true;
    }
  }

  /**
   * NB: this function should also do path compression
   * @param i index of a node
   * @return the root of the subtree containg i.
   */
  int find(int i) {
    int p = parent[i];
    if(p != i){
      p = find(p);
    }
    return p;
  }

  // Return the rank of the trees
  public int[] getRank() {
    return rank;
  }

  // Return the parent of the trees
  public int[] getParent() {
    return parent;
  }
}

class Edge implements Comparable<Edge>{
  int a;
  int b;
  int cost;
  
  public Edge(int a, int b, int cost){
    this.a = a;
    this.b = b;
    this.cost = cost;
  }
  
  @Override
  public int compareTo(Edge other){
    return Integer.compare(this.cost, other.cost);
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
//     
//     int n = sc.nextInt();
//     int m = sc.nextInt(); 
//     int budget = sc.nextInt();
//     System.out.println("n is " + n + " m is " + m + " budget is " + budget);
//     
//     ArrayList<Edge> edges = new ArrayList<Edge>();
//     UnionFind uf = new UnionFind(n);
// 
//     for (int i = 1; i <= m; i++) {
//       int u = sc.nextInt();
//       int v = sc.nextInt();
//       int cost = sc.nextInt();
//       edges.add(new Edge(u, v, cost));
//       System.out.println(u + " " + v + " " + cost);
//     }
//     
//     Collections.sort(edges);
//     
//     int totalCost = 0;
//     int budgetCons = 0;
//     for(int i = 0 ; i < m ; i ++){
//       Edge e = edges.get(i);
//       // System.out.println("- " + e.cost + " -");
//       if(uf.find(e.u) != uf.find(e.v)){
//         uf.union(e.u, e.v);
//         System.out.println("adding edge between " + e.u + " and " + e.v + " with cost " + e.cost );
//         totalCost += e.cost;
//         if(totalCost <= budget){
//           budgetCons++;
//         }
//       }
//     }
//     
//     System.out.println(totalCost + " " + budgetCons);
//     sc.close();
//     
//     return totalCost + " " + budgetCons;
//   }
// }
// 
// class Edge implements Comparable<Edge>{
//   int u;
//   int v;
//   int cost;
//   
//   public Edge(int u, int v, int cost){
//     this.u = u;
//     this.v = v;
//     this.cost = cost;
//   }
//   
//   @Override
//   public int compareTo(Edge other){
//     return this.cost - other.cost;
//   }
// }
// 
// class UnionFind {
// 
//   private int[] parent;
// 
//   private int[] rank;
// 
//   // Union Find structure implemented with two arrays for Union by Rank
//   public UnionFind(int size) {
//     parent = new int[size];
//     rank = new int[size];
//     for (int i = 0; i < size; i++) parent[i] = i;
//   }
// 
//   /**
//    * Merge two subtrees if they have a different parent, input is array indices
//    * @param i a node in the first subtree
//    * @param j a node in the second subtree
//    * @return true iff i and j had different parents.
//    */
//   boolean union(int i, int j) {
//     //find the roots of both trees;
//     int root_i = find(i);
//     int root_j = find(j);
//     
//     if(root_i == root_j){
//       //nothing to merge, they are already in the same subtree;
//       return false;
//     }
//     
//     //if they are different, we can merge;
//     if(rank[root_i] > rank[root_j]){
//       parent[root_j] = root_i;
//     }else{
//       parent[root_i] = root_j;
//       // if(rank[root_i] == rank[root_j]){
//       //   rank[root_j] ++;
//       // }
//     }
//     
//     
//     return true;
//   }
// 
//   /**
//    * NB: this function should also do path compression
//    * @param i index of a node
//    * @return the root of the subtree containg i.
//    */
//   int find(int i) {
//     int res = parent[i];
//     if(res != i){
//       res = find(res);
//     }
//     return res;
//   }
// 
//   // Return the rank of the trees
//   public int[] getRank() {
//     return rank;
//   }
// 
//   // Return the parent of the trees
//   public int[] getParent() {
//     return parent;
//   }
// }
// 
