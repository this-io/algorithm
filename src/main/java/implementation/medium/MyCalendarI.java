package implementation.medium;

import java.util.*;

public class MyCalendarI {
    TreeMap<Integer, Integer> calender;
    public MyCalendarI() {
        calender = new TreeMap<>();
    }

    public static void main(String[] args) {
        //String[] command = {"MyCalendar", "book", "book", "book"};
        //Integer[][] time = {{}, {10, 20}, {15, 25}, {20, 30}};
        //String[] command = {"MyCalendar","book","book","book","book","book"};
        //Integer[][] time = {{},{37,50},{33,50},{4,17},{35,48},{8,25}};
        String[] command = {"MyCalendar", "book", "book", "book", "book", "book", "book", "book", "book", "book", "book"};
        Integer[][] time = {{}, {47, 50}, {33, 41}, {39, 45}, {33, 42}, {25, 32}, {26, 35}, {19, 25}, {3, 8}, {8, 13}, {18, 27}};

        List<Boolean> result = new ArrayList<>();
        MyCalendarI c = new MyCalendarI();
        result.add(null);
        for (int i = 0; i < command.length; i++) {
            if (command[i].equalsIgnoreCase("book")) {
                boolean ans = c.book(time[i][0], time[i][1]);
                result.add(ans);
            }
        }
        //Boolean[] exp = {null,true,false,true,false,false};
        Boolean[] exp = {null, true, true, false, false, true, false, true, true, true, false};
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + "    " + exp[i]);
            for (Integer k : time[i]) {
                System.out.print("    " + k + "  ");
            }
            System.out.println();
        }
    }

    public boolean book(int start, int end) {
        Integer prev = calender.floorKey(start), next = calender.ceilingKey(start);

        if ((prev == null || calender.get(prev) <= start) && (next == null || end <= next)) {
            calender.put(start, end);
            return true;
        }
        return false;
    }

}
