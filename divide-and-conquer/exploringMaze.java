package weblab;

class Solution {

  /**
   * Recursively searches for the element.
   * Returns true if element can be found, else false.
   *
   * @param tree
   *     - tree that you need to look in.
   * @param element
   *     - the element that you are looking for.
   * @return true if found, else false.
   */
  public boolean search(BinaryTree tree, int element) {
    if(tree == null){
      return false;
    }
    if(tree.getKey() == element){
      return true;
    }else{
      // more accurate tree.hasLeft && search(tree.getLeft(), element) || tree.hasRight() && search(tree.getRight(), element);
      return tree.hasLeft() && search(tree.getLeft(), element) || tree.hasRight() && search(tree.getRight(), element);
    }
  }
}



















// package weblab;
// 
// class Solution {
// 
//   /**
//    * Recursively searches for the element.
//    * Returns true if element can be found, else false.
//    *
//    * @param tree
//    *     - tree that you need to look in.
//    * @param element
//    *     - the element that you are looking for.
//    * @return true if found, else false.
//    */
//   public boolean search(BinaryTree tree, int element) {
//     if(tree == null){
//       return false;
//     }
//     if(tree.getKey() == element){
//       return true;
//     }else{
//       // more accurate tree.hasLeft && search(tree.getLeft(), element) || tree.hasRight() && search(tree.getRight(), element);
//       return search(tree.getLeft(), element) || search(tree.getRight(), element);
//     }
//   }
// }
// 
