package Recursive;

import java.util.Arrays;
import java.util.LinkedList;

public class ShortestReach {
    int EDGE_DISTANCE = 1;
    private Node[] nodes;

    public int[] shortestReach(int startId) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(startId);
        int[] distances = new int[nodes.length];
        Arrays.fill(distances, -1);
        distances[startId] = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : nodes[node].neighbors) {
                if (distances[neighbor] == -1) {
                    distances[neighbor] = distances[node] + EDGE_DISTANCE;
                    queue.add(neighbor);
                }
            }
        }
        return distances;
    }

    class Node {
        public int[] neighbors;
    }
}
