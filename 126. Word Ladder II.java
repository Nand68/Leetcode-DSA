class Solution {
     public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return result; // No solution if endWord isn't in the wordList
        
        // Queue for BFS and map to track paths
        Queue<List<String>> queue = new LinkedList<>();
        queue.offer(Arrays.asList(beginWord));
        
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        
        boolean found = false;
        while (!queue.isEmpty() && !found) {
            int size = queue.size();
            Set<String> localVisited = new HashSet<>();
            
            for (int i = 0; i < size; i++) {
                List<String> path = queue.poll();
                String word = path.get(path.size() - 1);
                
                // Try all possible single-character transformations
                for (String neighbor : getNeighbors(word, dict)) {
                    if (neighbor.equals(endWord)) {
                        found = true;
                        List<String> newPath = new ArrayList<>(path);
                        newPath.add(neighbor);
                        result.add(newPath);
                    }
                    if (!visited.contains(neighbor)) {
                        List<String> newPath = new ArrayList<>(path);
                        newPath.add(neighbor);
                        queue.offer(newPath);
                        localVisited.add(neighbor);
                    }
                }
            }
            visited.addAll(localVisited);
        }
        return result;
    }
    
    // Helper function to get neighbors by changing one character at a time
    private List<String> getNeighbors(String word, Set<String> dict) {
        List<String> neighbors = new ArrayList<>();
        char[] wordArray = word.toCharArray();
        for (int i = 0; i < wordArray.length; i++) {
            char originalChar = wordArray[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == originalChar) continue;
                wordArray[i] = c;
                String newWord = new String(wordArray);
                if (dict.contains(newWord)) {
                    neighbors.add(newWord);
                }
            }
            wordArray[i] = originalChar; // Restore original character
        }
        return neighbors;
    }
}

 
