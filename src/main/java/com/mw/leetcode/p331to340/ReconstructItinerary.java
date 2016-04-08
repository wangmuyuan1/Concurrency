package com.mw.leetcode.p331to340;

import com.mw.ProjectUtil;

import java.util.*;

public class ReconstructItinerary {

    public List<String> findItinerary111(String[][] tickets) {
        Map<String, PriorityQueue<String>> targets = new HashMap<>(); // each ticket and the last dest it can go.
        // The reason to use PriorityQueue is to keep the lexci order
        for (String[] ticket : tickets)
            targets.computeIfAbsent(ticket[0], k -> new PriorityQueue()).add(ticket[1]);
        List<String> route = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        while (!stack.empty()) {
            while (targets.containsKey(stack.peek()) && !targets.get(stack.peek()).isEmpty())
                stack.push(targets.get(stack.peek()).poll());
            route.add(0, stack.pop());
        }
        return route;
    }

    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> ticketMap = new HashMap<>();
        for (String[] ticket : tickets)
        {
            ticketMap.computeIfAbsent(ticket[0], e -> new PriorityQueue<>()).add(ticket[1]);
        }

        List<String> route = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        stack.push("JFK"); // Starting point.
        while (!stack.isEmpty())
        {
            while (ticketMap.containsKey(stack.peek()) && !ticketMap.get(stack.peek()).isEmpty())
                stack.push(ticketMap.get(stack.peek()).poll()); // the smaller dest first?
            route.add(0, stack.pop());
        }

        return route;
    }

    public static void main(String args[])
    {
        String[][] tickets1 = new String[4][2];
        // [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
        tickets1[0][0] = "MUC";
        tickets1[0][1] = "LHR";

        tickets1[1][0] = "JFK";
        tickets1[1][1] = "MUC";

        tickets1[2][0] = "SFO";
        tickets1[2][1] = "SJC";

        tickets1[3][0] = "LHR";
        tickets1[3][1] = "SFO";

        ReconstructItinerary app = new ReconstructItinerary();
        //ProjectUtil.printList(app.findItinerary(tickets1));
        System.out.println();

        String[][] tickets2 = new String[5][2];
        //[["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
        tickets2[0][0] = "JFK";
        tickets2[0][1] = "SFO";

        tickets2[1][0] = "JFK";
        tickets2[1][1] = "ATL";

        tickets2[2][0] = "SFO";
        tickets2[2][1] = "ATL";

        tickets2[3][0] = "ATL";
        tickets2[3][1] = "JFK";

        tickets2[4][0] = "ATL";
        tickets2[4][1] = "SFO";

        ProjectUtil.printList(app.findItinerary(tickets2));
    }
}
