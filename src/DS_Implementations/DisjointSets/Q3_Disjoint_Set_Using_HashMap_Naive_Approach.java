package DS_Implementations.DisjointSets;

import java.util.HashMap;
import java.util.Scanner;

public class Q3_Disjoint_Set_Using_HashMap_Naive_Approach {
      public static class DisjointSet_3{
            private HashMap<Integer,Integer> Parent;
            private int size;

            DisjointSet_3(int size){
                  Parent = new HashMap<>();
                  for(int i = 0; i < size; i++){
                        Parent.put( i , i); //same element & same parent
                  }
                  this.size = size;
            }

            //to find parent of current element
            public int find(int num){
                  if(Parent.get(num) == num){
                        return num;
                  }
                  return find(Parent.get(num));
            }

            //to union parent of two element
            public void union(int num1, int num2){
                  num1 = Parent.get(num1);
                  num2 = Parent.get(num2);

                  if(num1 == num2){
                        return;
                  }else{
                        Parent.put(num1, num2);
                        size -= 1;
                  }
            }

            //to get size of set's inside DisjoinSet
            public int size(){
                  return size;
            }

      }


      public static void main(String[] args){
            Scanner scan = new Scanner (System.in);

            DisjointSet_3 ds = new DisjointSet_3 (5);

            ds.union(0 , 2);
            ds.union(0 , 4);
            ds.union(1 , 3);

            System.out.println("Groups : "+ ds.size());


      }
}
