package main.implementation.medium;

import main.implementation.practice.GraphTraversal;

import java.util.*;

public class CourseSchedule {
  Map<Integer, List<Integer>> theNodes = new HashMap<>();

  public static void main(String[] args) {
    CourseSchedule courseSchedule = new CourseSchedule();
    //int[][] preres = {{1,0},{0,1}};
    int[][] preres = {{0,1}};
    //int[][] preres = {{1,0}};
    //int[][] preres = {{0, 10}, {3, 18}, {5, 5}, {6, 11}, {11, 14}, {13, 1}, {15, 1}, {17, 4}};
    //int[][] preres = {{1, 4}, {2, 4}, {3, 1}, {3, 2}};
    System.out.println("Result : " + courseSchedule.canFinish(20, preres));
  }

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    //to keep track of how many courses we can finish
    //eg: count =2 at the end tells us we can finish 2 courses
    int count = 0;

    //array for incoming edges for each node
    //how many courses are there in total, we have that many array boxes we need
    int[] incoming_edges = new int[numCourses];

    Stack<Integer> stack = new Stack<Integer>();

    //iterate over the input 2d array(row by row) and add courses which has prequisites
    for (int i = 0; i < prerequisites.length; i++) {
      //ith row 0th element represents the course.
      incoming_edges[prerequisites[i][0]]++;
    }

    //add all the courses which has no prerequisite(value 0 in the incoming_edges array)
    for (int j = 0; j < incoming_edges.length; j++) {
      if (incoming_edges[j] == 0) {
        //it has no prerequisite
        stack.push(j);
      }
    }
    List<Integer> result = new ArrayList<>();
    while (!stack.isEmpty()) {
      int prereq = stack.pop();
      result.add(prereq);
      count++;

      for (int k = 0; k < prerequisites.length; k++) {
        //if it is the pre req for any course
        if (prerequisites[k][1] == prereq) {
          //then i can complete that course as i have completed its pre req
          incoming_edges[prerequisites[k][0]]--;
          //if i have no pre req then i can push it to stack
          if (incoming_edges[prerequisites[k][0]] == 0) {
            stack.push(prerequisites[k][0]);
          }
        }
      }
    }
    for(Integer i : result) {
      System.out.print(i + "  ");
    }
    return count == numCourses;
  }
}
