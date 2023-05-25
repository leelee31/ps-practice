import java.util.*;

class Node {
    public int val;
    public int depth;
    public List<Node> neighbor = new ArrayList<>();
    public Node (int val) {
        this.val = val;
    }
    public void print () {
        System.out.println(val + "'s neighbor: ");
        neighbor.stream().forEach((n) -> System.out.println(n.val));
        System.out.println();
    }
}

class Solution {
    public int solution(int n, int[][] edge) {
        Node root = null;
        Map<Integer, Node> nodes = new HashMap<>();
        
        for (int i=0; i<edge.length; i++) {
            Node node1 = nodes.getOrDefault(edge[i][0], new Node(edge[i][0]));
            Node node2 = nodes.getOrDefault(edge[i][1], new Node(edge[i][1]));
            node1.neighbor.add(node2);
            node2.neighbor.add(node1);
            nodes.put(edge[i][0], node1);
            nodes.put(edge[i][1], node2);
            if (root == null && edge[i][0] == 1) {
                root = node1;
            }
            if (root == null && edge[i][1] == 1) {
                root = node2;
            }
        }
        
        return findFarthestCount(root);
    }
    
    public int findFarthestCount(Node root) {
        int count = 0;
        int maxDepth = 0;
        Set<Node> visited = new HashSet<>();
        
        Queue<Node> q = new LinkedList<>();
        root.depth++;
        q.add(root);
        visited.add(root);
        
        while (!q.isEmpty()) {
            Node temp = q.poll();
            for (Node n : temp.neighbor) {
                if (visited.contains(n)) continue;
                n.depth = temp.depth + 1;
                q.add(n);
                visited.add(n);
                if (maxDepth == n.depth) {
                    count++;
                } else if (maxDepth < n.depth) {
                    maxDepth = n.depth;
                    count = 1;
                }
            }
        }
        
        return count;
    }
}