package weblab;

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

// package weblab;
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
//       if(rank[root_i] == rank[root_j]){
//         rank[root_j] ++;
//       }
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
