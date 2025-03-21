class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, Integer> inDegree = new HashMap<>();
        Map<String, List<String>> graph = new HashMap<>();
        Set<String> available = new HashSet<>(Arrays.asList(supplies));
        
        for (int i = 0; i < recipes.length; i++) {
            inDegree.put(recipes[i], ingredients.get(i).size());
            for (String ing : ingredients.get(i)) {
                graph.computeIfAbsent(ing, k -> new ArrayList<>()).add(recipes[i]);
            }
        }
        
        Queue<String> queue = new LinkedList<>(available);
        List<String> result = new ArrayList<>();
        
        while (!queue.isEmpty()) {
            String item = queue.poll();
            if (inDegree.containsKey(item)) {
                result.add(item);
            }
            
            if (!graph.containsKey(item)) continue;
            for (String next : graph.get(item)) {
                inDegree.put(next, inDegree.get(next) - 1);
                if (inDegree.get(next) == 0) {
                    queue.offer(next);
                }
            }
        }
        
        return result;
    }
}