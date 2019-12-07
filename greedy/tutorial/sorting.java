package weblab;

import java.util.*;

class Solution {

  /**
   * Return the id(s) of the tasks with the median value for their efficiency, where efficiency = value/time.
   * @param tasks Array of tasks, in no particular order.
   * @return The id(s) of the median task(s) based on efficiency. If you have an odd number of tasks, return the ids of the two median
   * tasks with a space between. eg if the median is 4,5. "(id of 4th task) (id of 5th task)"
   */
  public static String solve(Task[] tasks) {
    Arrays.sort(tasks);
    int med = tasks.length/2;
    if(tasks.length % 2 == 0){
      return tasks[med-1].id + " " + tasks[med].id;
    }
    return "" + tasks[med-1].id;
  }
}

class Task implements Comparable<Task>{

  int id;

  double time;

  double value;

  Task(double time, double value, int id) {
    this.time = time;
    this.value = value;
    this.id = id;
  }
  
  @Override
  public int compareTo(Task other){
    if(this.value/this.time == other.value/other.time){
      return Integer.compare(this.id, other.id);
    }else{
      return Double.compare(this.value/this.time, other.value/other.time);
    }
  }
}

// package weblab;
// 
// import java.util.*;
// 
// class Solution {
// 
//   /**
//    * Return the id(s) of the tasks with the median value for their efficiency, where efficiency = value/time.
//    * @param tasks Array of tasks, in no particular order.
//    * @return The id(s) of the median task(s) based on efficiency. If you have an odd number of tasks, return the ids of the two median
//    * tasks with a space between. eg if the median is 4,5. "(id of 4th task) (id of 5th task)"
//    */
//   public static String solve(Task[] tasks) {
//    Arrays.sort(tasks);
//    
//    int m = tasks.length/2;
//    
//    if(tasks.length % 2 != 0){
//      return "" + tasks[m].id;
//    }else{
//      return "" + tasks[m-1].id + " " + tasks[m].id;
//    }
//    
//   }
// }
// 
// class Task implements Comparable<Task>{
// 
//   int id;
// 
//   double time;
// 
//   double value;
// 
//   Task(double time, double value, int id) {
//     this.time = time;
//     this.value = value;
//     this.id = id;
//   }
//   
//   @Override
//   public int compareTo(Task other){
//     if((this.value/this.time - other.value/other.time) == 0){
//       return new Integer(this.id).compareTo(other.id);
//     }
//     
//     return new Double(this.value/this.time).compareTo(other.value/other.time);
//   }
// }
// 
