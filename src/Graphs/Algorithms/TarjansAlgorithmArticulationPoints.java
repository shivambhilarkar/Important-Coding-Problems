//package Graphs.Algorithms;
//
//import java.util.List;
//
//public class TarjansAlgorithmArticulationPoints {
//
//
//    class TarjansAlgorithm{
//
//        boolean[] visited;
//        int[] arrivalTime;
//        int[] lowestArrivalTime;
//
//        int time = 0;
//        int nodes;
//        List<List<Integer>> adj;
//
//        TarjansAlgorithm(List adj, int v){
//            this.nodes = v;
//            this.adj = adj;
//            this.visited = new boolean[v];
//            this.arrivalTime = new int[v];
//            this.lowestArrivalTime = new int[v];
//        }
//
//        public void findArticulationPoints(){
//            for(int i = 0; i < nodes; i++){
//                if(visited[i] == false){
//                    dfs( graph, -1);
//                }
//            }
//        }
//
//        private void dfs( List<List<Integer>> adj, int node){
//            visited[node] = true; // marks as visited
//            arrivalTime[node] = lowestArrivalTime[node] = ++time;
//
//            for(int nbr : adj.get(node)){
//                if(visited[nbr] == false){
//                }else{
//
//                }
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//
//    }
//}
