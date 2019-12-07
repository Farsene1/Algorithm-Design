package weblab;

import java.util.*;

class Solution {

  public static /**
   * @param n the number of jobs
   * @param m the number of processors
   * @param deadlines the deadlines of the jobs 1 through n. NB: you should ignore deadlines[0]
   * @return the minimised maximum lateness.
   */
  int solve(int n, int m, int[] deadlines) {
    ArrayList<Job> jobs = new ArrayList<>();
    for(int i = 1 ; i <= n ; i++){
      jobs.add(new Job(deadlines[i]));
    }
    
    Collections.sort(jobs);
    int[] processors = new int[m+1];
    
    int max_lateness = Integer.MIN_VALUE;
    
    int curr = 1;
    for(Job job : jobs){
      processors[curr] ++;
      
      max_lateness = Math.max(max_lateness, processors[curr] - job.deadline);
      
      curr++;
      if(curr > m){
        curr = 1;
      }
    }
    
    return max_lateness;
  }
}

class Job implements Comparable<Job>{
  int deadline;
  
  public Job(int deadline){
    this.deadline = deadline;
  }
  
  @Override
  public int compareTo(Job other){
    return Integer.compare(this.deadline, other.deadline);
  }
}

// package weblab;
// 
// import java.util.*;
// 
// class Solution {
// 
//   public static /**
//    * @param n the number of jobs
//    * @param m the number of processors
//    * @param deadlines the deadlines of the jobs 1 through n. NB: you should ignore deadlines[0]
//    * @return the minimised maximum lateness.
//    */
//   int solve(int n, int m, int[] deadlines) {
//     Job[] jobs = new Job[n];
//     for(int i = 1 ; i <= n ; i ++){
//       jobs[i-1] = new Job(deadlines[i]);
//     }
//     Arrays.sort(jobs);
//     
//     int[] times = new int[m+1];
//     Arrays.fill(times, 0);
//     
//     int result = 0;
//     
//     int p = 1;
//     for(int i = 0 ; i < n ; i ++){
//       times[p] = times[p] + 1;
//       
//       if(times[p] - jobs[i].deadline > result){
//         result = times[p] - jobs[i].deadline;
//       }
//       
//       if(p < m){
//         p++;
//       }else{
//         p = 1;
//       }
//       
//     }
//     
//     return result;
//   }
// }
// 
// class Job implements Comparable<Job>{
//   int deadline;
//   
//   public Job(int deadline){
//     this.deadline = deadline;
//   }
//   
//   @Override
//   public int compareTo(Job other){
//     return this.deadline - other.deadline;
//   }
// }
// 
