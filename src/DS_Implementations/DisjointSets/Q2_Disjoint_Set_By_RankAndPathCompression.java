package DS_Implementations.DisjointSets;

import java.util.Scanner;

public class Q2_Disjoint_Set_By_RankAndPathCompression {
      public static class DisjointSet_2{
            private int[] Rank;
            private int[] Parent;
            int size;
            DisjointSet_2(int size){
                  Rank = new int[size];
                  Parent = new int[size];
                  for(int i = 0; i < size; i++){
                        Rank[i] = 0;    //single element i.e zero rank for curr
                        Parent[i] = i; //same parent
                  }
                  this.size = size;
            }

            //Path compression
            public int find(int num){
                  if(Parent[num] == num){
                        return num;
                  }
                  return Parent[num] = find(Parent[num]);
            }

            //Union By Rank
            public void union(int num1, int num2){
                  num1 = find(num1);
                  num2 = find(num2);

                  if(Rank[num1] < Rank[num2]){
                        Parent[num1] = num2;
                  }else{
                        Parent[num2] = num1;
                  }
                  size -= 1;
            }

            //to get size of sets
            public int size(){
                  return size;
            }

      }



      public static void main(String[] args){
            Scanner scan = new Scanner (System.in);



            DisjointSet_2 ds = new DisjointSet_2 (5);

            ds.union (0,2);
            ds.union (0,4);
            ds.union (1,3);

            System.out.println("Groups : " +   ds.size ());

      }

}
