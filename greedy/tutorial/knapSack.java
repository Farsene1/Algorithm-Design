package weblab;

import java.util.*;

class Solution {

  /**
   * Return the minimum number of items we need to get to the weight we want to get to.
   * @param n the number of item categories
   * @param w the weight we want to achieve with as few items as possible.
   * @param num the number of items in each category c_1 through c_n stored in num[1] through num[n] (NOTE: you should ignore num[0]!)
   * @param weight the weight of items in each category c_1 through c_n stored in weight[1] through weight[n] (NOTE: you should ignore weight[0]!)
   * @return minimum number of items needed to get to the required weight
   */
  public static int run(int n, int w, int[] num, int[] weight) {
    return new Solution().solve(n, w, num, weight);
  }

  public int solve(int n, int w, int[] num, int[] weight) {
    Category[] categories = new Category[n];
    for (int i = 0; i < n; i++) {
      categories[i] = new Category(num[i + 1], weight[i + 1]);
    }
    Arrays.sort(categories);
    int answer = 0;
    int i = 0;
    while (w >= 0 && i < n) {
      int numWeWouldLikeOfThisItem = Math.min(w / categories[i].weight, categories[i].num);
      answer += numWeWouldLikeOfThisItem;
      w -= numWeWouldLikeOfThisItem * categories[i].weight;
      i++;
    }
    return answer;
  }

  class Category implements Comparable<Category> {

    int num;

    int weight;

    public Category(int num, int weight) {
      this.num = num;
      this.weight = weight;
    }

    @Override
    public int compareTo(Category category) {
      return Integer.compare(category.weight, this.weight);
    }
  }
}
