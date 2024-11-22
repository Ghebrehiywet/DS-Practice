package tree;

import javafx.util.Pair;

import java.util.*;

public class VerticalTaversal {
    static List<Integer> verticalOrder(Node root) {
        // add your code here
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<Pair<Node, Integer>> queue = new LinkedList<>();
        queue.put(root, 0);
        int min = 0, max = 0;
        List<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair<Node, Integer> pair = queue.poll();
                int index = pair.getValue();
                Node node = pair.getKey();

                map.put(index, map.getOrDefault(index, new ArrayList<Integer>()).add(node.val));


                if (node.left != null) {
                    queue.put(node.left, index - 1);
                } else if (node.right != null) {
                    queue.put(node.left, index + 1);
                }
            }
        }
        return result;
    }

    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
}

