import java.util.*;

class Solution {
    // Updated signature to match the driver's call: findOrder(String[] words)
    public String findOrder(String[] words) {
        int n = words.length;
        
        // 1. Initialize Adjacency List and Indegree map
        Map<Character, Set<Character>> adj = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        
        // Identify all unique characters present in the dictionary
        for (String word : words) {
            for (char c : word.toCharArray()) {
                indegree.putIfAbsent(c, 0);
                adj.putIfAbsent(c, new HashSet<>());
            }
        }

        // 2. Build the graph by comparing adjacent words
        for (int i = 0; i < n - 1; i++) {
            String w1 = words[i];
            String w2 = words[i+1];
            
            // Contradiction check: if w2 is a prefix of w1 (e.g., "apple", "app")
            if (w1.length() > w2.length() && w1.startsWith(w2)) return "";
            
            int len = Math.min(w1.length(), w2.length());
            for (int j = 0; j < len; j++) {
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);
                if (c1 != c2) {
                    if (!adj.get(c1).contains(c2)) {
                        adj.get(c1).add(c2);
                        indegree.put(c2, indegree.get(c2) + 1);
                    }
                    break; // Only the first differing character defines the order
                }
            }
        }

        // 3. Kahn's Algorithm (BFS for Topological Sort)
        Queue<Character> queue = new LinkedList<>();
        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                queue.add(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char curr = queue.poll();
            sb.append(curr);
            
            if (adj.containsKey(curr)) {
                for (char neighbor : adj.get(curr)) {
                    indegree.put(neighbor, indegree.get(neighbor) - 1);
                    if (indegree.get(neighbor) == 0) {
                        queue.add(neighbor);
                    }
                }
            }
        }

        // 4. Cycle Detection: If sorted string doesn't contain all unique characters
        if (sb.length() < indegree.size()) return "";

        return sb.toString();
    }
}