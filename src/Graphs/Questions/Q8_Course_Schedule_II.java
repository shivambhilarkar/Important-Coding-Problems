package Graphs.Questions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Q8_Course_Schedule_II {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // create graph
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] course : prerequisites) {
            adj.get(course[0]).add(course[1]);
        }

        // count inDegree
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (Integer nbr : adj.get(i)) {
                inDegree[nbr] += 1;
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // BFS - using inDegree
        int[] toposort = new int[numCourses];
        int index = toposort.length - 1;
        int count = 0;

        while (queue.isEmpty() == false) {
            Integer node = queue.poll();
            toposort[index] = node;
            index -= 1;
            count += 1;

            for (Integer nbr : adj.get(node)) {
                inDegree[nbr] -= 1;
                if (inDegree[nbr] == 0) {
                    queue.add(nbr);
                }
            }
        }


        //visited all nodes
        if (count == numCourses) {
            return toposort;
        } else {
            return new int[0];
        }


    }


}
