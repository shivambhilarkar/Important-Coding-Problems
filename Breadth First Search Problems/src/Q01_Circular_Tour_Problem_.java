import java.util.ArrayDeque;
import java.util.Scanner;

//Leetcode circular tour problem...
public class Q01_Circular_Tour_Problem_ {
      public static int circular_tour_(int[][] arr, int n){
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            int nextPump = 0;
            int prevPump = 0;
            int visited_station = 0;
            int petrol = 0;

            while(queue.size() != n){
                  while(petrol >= 0 && queue.size() != n){
                        queue.add(nextPump);
                        petrol += (arr[nextPump][0]  -  arr[nextPump][1]);
                        nextPump = (nextPump + 1) % n;
                  }
                  while(petrol < 0 && queue.size() > 0){
                        prevPump = queue.remove();
                        petrol -= (arr[prevPump][0] -  arr[prevPump][1]);
                  }
                  visited_station += 1;
                  if(visited_station == n){
                        return -1;
                  }
            }
            if(petrol >= 0){
                  return queue.remove(); //first petrol pump;
            }else{
                  return -1;
            }
      }
      public static void main(String[] args){
            Scanner scan = new Scanner(System.in);
            int[][] arr = {{}};
      }
}
