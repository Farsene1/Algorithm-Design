package weblab;

import java.io.*;
import java.util.*;

class Solution {

  public static /**
   * @param n number of researchers
   * @param m number of processes
   * @param start start times of jobs 1 through n. NB: you should ignore start[0]
   * @param duration duration of jobs 1 through n. NB: you should ignore duration[0]
   * @return the number of unlocks that can be saved.
   */
  int solve(int n, int m, int[] start, int[] duration) {
    ArrayList<Session> sessions = new ArrayList<>();
    for(int i = 1 ; i <= n ; i++){
      sessions.add(new Session(start[i], duration[i]));
    }
    
    PriorityQueue<Machine> pq = new PriorityQueue<>();
    
    Collections.sort(sessions);
    
    int result = 0;
    
    for(Session s : sessions){
      while(!pq.isEmpty()){
        if(pq.peek().available > s.start){
          break;
        }
        
        Machine machine = pq.poll();
        
        if(machine.locked >= s.start){
          result++;
          break;
        }
      }
      pq.add(new Machine(s.start + s.duration, s.start + s.duration + m));
    }
    
    return result;
    
  }
}

class Session implements Comparable<Session>{
  int start;
  int duration;
  
  public Session(int start, int duration){
    this.start = start;
    this.duration = duration;
  }
  
  @Override
  public int compareTo(Session other){
    return Integer.compare(this.start, other.start);
  }
}

class Machine implements Comparable<Machine>{
  int available;
  int locked;
  
  public Machine(int available, int locked){
    this.available = available;
    this.locked = locked;
  }
  
  @Override
  public int compareTo(Machine other){
    return Integer.compare(this.available, other.available);
  }
}



























// package weblab;
// 
// import java.io.*;
// import java.util.*;
// 
// class Solution {
// 
//   public static /**
//    * @param n number of researchers
//    * @param m number of processes
//    * @param start start times of jobs 1 through n. NB: you should ignore start[0]
//    * @param duration duration of jobs 1 through n. NB: you should ignore duration[0]
//    * @return the number of unlocks that can be saved.
//    */
//   int solve(int n, int m, int[] start, int[] duration) {
//     ArrayList<Session> sessions = new ArrayList<Session>();
//     for(int i = 1 ; i<= n ; i++){
//       sessions.add(new Session(start[i], duration[i]));
//     }
//     
//     Collections.sort(sessions);
//     PriorityQueue<Machine> machines = new PriorityQueue<Machine>();
//     int result = 0;
//     
//     for(Session s : sessions){
//       while(!machines.isEmpty()){
//         if(machines.peek().available > s.start){
//           break;
//         }
//         
//         Machine next = machines.poll();
//         if(next.locked >= s.start){
//           result++;
//           break;
//         }
//       }
//       machines.add(new Machine(s.start + s.duration, s.start + s.duration + m));
//     }
//     return result;
//   }
// }
// 
// class Session implements Comparable<Session>{
//   int start;
//   int duration;
//   
//   public Session(int start, int duration){
//     this.start = start;
//     this.duration = duration;
//   }
//   
//   @Override
//   public int compareTo(Session other){
//     return this.start - other.start;
//   }
// }
// 
// class Machine implements Comparable<Machine> {
// 
//   public int available;
// 
//   public int locked;
// 
//   public Machine(int available, int locked) {
//     this.available = available;
//     this.locked = locked;
//   }
// 
//   @Override
//   public int compareTo(Machine otherMachine) {
//     return Integer.compare(locked, otherMachine.locked);
//   }
// }
