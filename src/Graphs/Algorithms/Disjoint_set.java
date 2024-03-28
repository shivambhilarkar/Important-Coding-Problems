package Graphs.Algorithms;

public class Disjoint_set {
      static int[] Parent;
      static int[] Rank;

      Disjoint_set(int size){
            Parent = new int[size];
            Rank = new int[size];
            for(int i = 0; i < size; i++){
                  Parent[i] = i;
                  Rank[i] = 0;
            }
      }

      public static int find(int num){
            if(Parent[num] == num){
                  return num;
            }
            return Parent[num] = find(Parent[num]); //path compression
      }

      public static void union(int first , int second){
            int parent1 = find(first);
            int parent2 = find(second);
//                Union by Rank --->
            if(Rank[parent1] < Rank[parent2]){
                  Parent[parent1] = parent2;
            }else if(Rank[parent1] > Rank[parent2]){
                  Parent[parent2] = parent1;
            }else{
                  Parent[parent1] = parent2;
                  Rank[parent2] += 1;
            }
      }
      public static void display(){
            for(int i = 0; i < Parent.length; i++){
                  System.out.println(i +" -> " + find(i));
            }
            System.out.println();
      }
}
