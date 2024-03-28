package DS_Implementations.DisjointSets;

import java.util.Scanner;

public class Disjoint_sets_navie_approach {

      public static class Disjoint_set{
            static int[] parent;

//            constructor
            Disjoint_set(int size){
                  parent = new int[size];
                  for(int i = 0; i < size; i++){
                        parent[i] = i ;
                  }
            }

//            to find parent of current number
            public static int find(int num){
                  if(parent[num] == num){
                        return num;
                  }
                  return find(parent[num]);
            }

//            this is used to union both parents
            public static void union(int first , int second){
                  int parent1 = find(first);
                  int parent2 = find(second);

                  parent[parent1] = parent2;
            }

            public static void display(){
                  for(int num = 0; num < parent.length; num++){
                        System.out.println(num +" -> "+ find(num));
                  }
                  System.out.println();
            }
      }

      public static void main(String[] args){
            Scanner scan = new Scanner(System.in);

            Disjoint_set ds = new Disjoint_set (5);
            ds.union(4,3);
            ds.union(1,2);
            ds.union(0,1);

            ds.display();
      }
}
