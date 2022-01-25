import java.util.PriorityQueue;
import java.util.Scanner;

//find the minimum cost of joining all the ropes.
public class Q01_Join_Ropes_Problem_ {
      public static void join_Ropes(int[] arr){
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for(int num : arr){
                  queue.add(num);
            }
            int total = 0;
            while(queue.size() > 1){
                  int first = queue.remove();
                  int second = queue.remove();
                  queue.add(first + second);
                  total += (first+second);
            }
            System.out.println("Minimum Cost to Join Ropes : "+total);
      }
      public static void main(String[] args){
            Scanner scan = new Scanner(System.in);
            int[] arr = {2,1,7,4,2};
            join_Ropes (arr);
      }
}
