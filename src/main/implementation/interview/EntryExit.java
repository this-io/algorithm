package main.implementation.interview;

import java.sql.SQLOutput;
import java.util.*;
/*
		We are working on a security system for a badged-access room in our company's building.
		Given an ordered list of employees who used their badge to enter or exit the room, write a
		function that returns two collections:

		1. All employees who didn't use their badge while exiting the room - they recorded an enter
		without a matching exit. (All employees are required to leave the room before the log ends.)

		2. All employees who didn't use their badge while entering the room - they recorded an exit
		without a matching enter. (The room is empty when the log begins.)
		Each collection should contain no duplicates, regardless of how many times a given
		employee matches the criteria for belonging to it.

		badge_records_1 = [
		  ["Martha",   "exit"],
		  ["Paul",     "enter"],
		  ["Martha",   "enter"],
		  ["Martha",   "exit"],
		  ["Jennifer", "enter"],
		  ["Paul",     "enter"],
		  ["Curtis",   "exit"],
		  ["Curtis",   "enter"],
		  ["Paul",     "exit"],
		  ["Martha",   "enter"],
		  ["Martha",   "exit"],
		  ["Jennifer", "exit"],
		  ["Paul",     "enter"],
		  ["Paul",     "enter"],
		  ["Martha",   "exit"],
		]
		Expected output: ["Curtis", "Paul"], ["Martha", "Curtis"]


		Additional test cases:
		badge_records_2 = [
		  ["Paul", "enter"],
		  ["Paul", "enter"],
		  ["Paul", "exit"],
		]
		Expected output: ["Paul"], []


		badge_records_3 = [
		  ["Paul", "enter"],
		  ["Paul", "exit"],
		  ["Paul", "exit"],
		]
		Expected output: [], ["Paul"]
		badge_records_4 = [
		  ["Paul", "enter"],
		  ["Paul", "exit"],
		  ["Paul", "exit"],
		  ["Paul", "enter"],
		  ["Martha", "enter"],
		  ["Martha", "exit"],
		]
		Expected output: ["Paul"], ["Paul"]
		badge_records_5 = [
		  ["Paul", "enter"],
		  ["Paul", "exit"],
		]
		Expected output: [], []
		badge_records_6 = [
		  ["Paul", "enter"],
		  ["Paul", "enter"],
		  ["Paul", "exit"],
		  ["Paul", "exit"],
		]
		Expected output: ["Paul"], ["Paul"]
		badge_records_7 = [
		  ["Paul", "enter"],
		  ["Paul", "exit"],
		  ["Paul", "exit"],
		  ["Paul", "enter"],
		]
		Expected output: ["Paul"], ["Paul"]
		n: length of the badge records array
*/

public class EntryExit {
	public static void main(String[] args) {
		EntryExit entryExit = new EntryExit();
		System.out.println("=======1st==========");
		String badgeRecords1[][] = new String[][] {
				{"Martha",   "exit"},
				{"Paul",     "enter"},
				{"Martha",   "enter"},
				{"Martha",   "exit"},
				{"Jennifer", "enter"},
				{"Paul",     "enter"},
				{"Curtis",   "exit"},
				{"Curtis",   "enter"},
				{"Paul",     "exit"},
				{"Martha",   "enter"},
				{"Martha",   "exit"},
				{"Jennifer", "exit"},
				{"Paul",     "enter"},
				{"Paul",     "enter"},
				{"Martha",   "exit"},
		};
		System.out.println("Expected output: [Curtis, Paul], [Martha, Curtis]");
		entryExit.algorithm(badgeRecords1);

		System.out.println("=======2nd==========");
		String[][] badge_records_2 = new String[][]{
				{"Paul", "enter"},
				{"Paul", "enter"},
				{"Paul", "exit"},
		};
		System.out.println("Expected output: [\"Paul\"], []");
		entryExit.algorithm(badge_records_2);

		System.out.println("=======3rd==========");
		String[][] badge3 = new String[][]{
				{"Paul", "enter"},
				{"Paul", "exit"},
				{"Paul", "exit"},
		};
		System.out.println("Expected output: [], [\"Paul\"]");
		entryExit.algorithm(badge3);

		System.out.println("=======4th==========");
		String[][] badge4 = new String[][]{
				{"Paul", "enter"},
				{"Paul", "exit"},
				{"Paul", "exit"},
				{"Paul", "enter"},
				{"Martha", "enter"},
				{"Martha", "exit"}
		};
		System.out.println("Expected output: [\"Paul\"], [\"Paul\"]");
		entryExit.algorithm(badge4);

		System.out.println("=======5th==========");
		String[][]badge_records_5 = new String[][]{
				{"Paul", "enter"},
				{"Paul", "exit"},
		};
		System.out.println("Expected output: {}, {}");
		entryExit.algorithm(badge_records_5);

		System.out.println("=======6th==========");
		String[][] badge_records_6 = {
				{"Paul", "enter"},
				{"Paul", "enter"},
				{"Paul", "exit"},
				{"Paul", "exit"},
		};
		System.out.println("Expected output: {'Paul'}, {'Paul'}");
		entryExit.algorithm(badge_records_6);

		System.out.println("=======7th==========");
		String[][] badge_records_7 = {
				{"Paul", "enter"},
				{"Paul", "exit"},
				{"Paul", "exit"},
				{"Paul", "enter"},
		};
		System.out.println("Expected output: {'Paul'}, {'Paul'}");
		entryExit.algorithm(badge_records_7);
	}

	private void algorithm(String[][] badgeRecord) {
		Map<String, Integer> entry = new HashMap<>();
		Set<String> enterIssue = new HashSet<>();
		Set<String> exitIssue = new HashSet<>();

		for(int i=0; i<badgeRecord.length; i++) {
			if("enter".equalsIgnoreCase(badgeRecord[i][1])) {
				if(entry.containsKey(badgeRecord[i][0])) {
					enterIssue.add(badgeRecord[i][0]);
				} else {
					entry.put(badgeRecord[i][0], 1);
				}
			} else {
				if(entry.containsKey(badgeRecord[i][0])) {
					entry.remove(badgeRecord[i][0]);
				} else {
					exitIssue.add(badgeRecord[i][0]);
				}
			}
		}

		for(String name : entry.keySet()) {
			if(!enterIssue.contains(name)) {
				enterIssue.add(name);
			}
		}

 		System.out.println(enterIssue);
		System.out.println(exitIssue);
	}
}
