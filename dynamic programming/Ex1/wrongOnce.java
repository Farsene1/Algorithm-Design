package weblab;

class Solution {

  /*
	 * Note that entry node[0] should be avoided, as nodes are labelled node[1] through node[n].
	 */
  public static int weight(int n, int[] nodes) {
    int[] mem = new int[n + 1];
    mem[0] = 0;
    mem[1] = nodes[1];
    for (int i = 2; i <= n; i++) {
      // TODO

    }
    return mem[n];
  }
}

