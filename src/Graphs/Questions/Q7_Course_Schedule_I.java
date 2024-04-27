package Graphs.Questions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/course-schedule/description/
public class Q7_Course_Schedule_I {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //create graph
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] course : prerequisites) {
            adj.get(course[0]).add(course[1]);
        }

        //count inDegree
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (Integer nbr : adj.get(i)) {
                inDegree[nbr] += 1;
            }
        }

        //BFS - using inDegree
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int[] toposort = new int[numCourses];
        int index = 0;
        int count = 0;
        while (queue.isEmpty() == false) {
            Integer node = queue.poll();
            toposort[index] = node;
            index += 1;
            count += 1;

            for (Integer nbr : adj.get(node)) {
                inDegree[nbr] -= 1;
                if (inDegree[nbr] == 0) {
                    queue.add(nbr);
                }
            }
        }
        //if we visited all elements the
        if (count == numCourses) {
            //can take all courses
            return true;
        } else {
            //else graph has cycle
            return false;
        }
    }
}
