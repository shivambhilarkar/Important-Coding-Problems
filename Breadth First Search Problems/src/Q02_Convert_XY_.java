import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Q02_Convert_XY_{
      public static int convert_steps(int src , int dest){
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            int[] arr = new int[100];
            int index = 0;
            int steps = 0;

            queue.add(src);
            while(queue.isEmpty() == false){
                  int value = queue.remove();
                  arr[index++] = value;

                  if(value == dest){
                        for(int i = 0; i < index; i++){
                              System.out.print(arr[i] + "->");
                        }
                        return steps;
                  }
                  steps++;
                  if(value < dest){
                        queue.add(2 * value);
                  }else{
                        queue.add(value - 1);
                  }
            }

            return -1;
      }

      public static void main(String[] args){
            Scanner scan = new Scanner(System.in);
            convert_steps(2 , 7);
      }

}
