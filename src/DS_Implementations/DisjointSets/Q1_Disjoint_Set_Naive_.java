package DS_Implementations.DisjointSets;

import java.util.Scanner;

public class Q1_Disjoint_Set_Naive_ {
      public static class disjoint_set_naive{
            private int[] parent;
            private int size;


            disjoint_set_naive(int size){
                  parent = new int[size];
                  this.size = size;
                  for(int i = 0; i < size; i++){
                        parent[i] = i; //same parent of same node
                  }

            }

            //find methode to find parent of current element
            public int find(int num){
                  if(parent[num] == num){
                        return num;
                  }
                  return find(parent[num]);
            }

            //to group to numbers into same group or same set
            public void union(int num1 , int num2){
                  num1 = find(num1);
                  num2 = find(num2);
                  if(num1 != num2){
                        parent[num1] = num2;
                        size -= 1; //to group are union together so total size is decrease by one
                  }
            }

            //to get total size of sets inside DisjointSet
            public int size(){
                  return size;
            }


      }


      public static void main(String[] args){
            Scanner scan = new Scanner (System.in);

            disjoint_set_naive ds = new disjoint_set_naive (5);

            ds.union(0 , 2);
            ds.union(0 , 4);
            ds.union(1 , 3);

            System.out.println("Groups : "  + ds.size());

      }

}
