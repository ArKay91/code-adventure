package LC.Contest_266;

import java.util.*;

public class MaximumPathGraphQuality {
    
    private int maxSum;

    public static void main(String[] args) {

    }

    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        maxSum = 0;

        int n = values.length;
        int[] count = new int[n];
        Set<Pair<Integer, Integer>> neighbours = null;
        Map<Integer, Set<Pair<Integer, Integer>>> graph = new HashMap<>();

        for(int[] edge : edges) {
            neighbours = graph.getOrDefault(edge[0], new HashSet<>());
            neighbours.add(new Pair<>(edge[1], edge[2]));
            graph.put(edge[0], neighbours);
            neighbours = graph.getOrDefault(edge[1], new HashSet<>());
            neighbours.add(new Pair<>(edge[0], edge[2]));
            graph.put(edge[2], neighbours);
        }
        count[0]++;
        dfs(graph, count, values, maxTime, 0, 0, values[0]);

        return maxSum;
    }

    private void dfs(Map<Integer, Set<Pair<Integer, Integer>>> graph, 
                            int[] count, int[] values, int maxTime, int node, int time, int cost) {
        int nextNode = 0, nextTime = 0, nextCost = 0;
        if(node == 0) {
            maxSum = Math.max(maxSum, cost);
        }
        if(graph.containsKey(node)) {
            for(Pair<Integer, Integer> neighbour : graph.get(node)) {
                nextNode = neighbour.getKey();
                nextTime = (time + neighbour.getValue());
                if(count[nextNode] == 4) {
                    continue;
                }
                if(nextTime > maxTime) {
                    continue;
                }
                count[nextNode]++;
                if(count[nextNode] == 1) {
                    nextCost = cost + values[nextNode];
                } else {
                    nextCost = cost;
                }
                dfs(graph, count, values, maxTime, nextNode, nextTime, nextCost);
                count[nextNode]--;
            }
        }
    }

}
