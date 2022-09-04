package main.implementation.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CourseScheduleII {
  public static void main(String[] args) {
    CourseScheduleII courseScheduleII = new CourseScheduleII();
    //int[][] preres = {{1,0},{0,1}};
    //int[][] preres = {{0,1}};
    //int[][] preres = {{1,0}};
    //int[][] preres = {{0, 10}, {3, 18}, {5, 5}, {6, 11}, {11, 14}, {13, 1}, {15, 1}, {17, 4}};
    //int[][] preres = {{1, 4}, {2, 4}, {3, 1}, {3, 2}};
    int numCourses = 4;
    int[][] preres = {{1,0},{2,0},{3,1},{3,2}};
    courseScheduleII.findOrder(numCourses, preres);
  }

  public int[] findOrder(int numCourses, int[][] prerequisites) {
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
    if (count != numCourses) {
      return new int[0];
    } else {
      int[] result1 = new int[numCourses];
      for(int i=0; i<result.size(); i++) {
        System.out.print(result.get(i) + "  ");
        result1[i] = result.get(i);
      }
      return result1;
    }
  }
}
