class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        boolean[] vis = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                int[] res = dfs(i, vis, adj, 0, 0);
                int nodes = res[0], edgesCount = res[1] / 2; // Each edge is counted twice
                if (edgesCount == nodes * (nodes - 1) / 2) count++;
            }
        }
        return count;
    }

    private int[] dfs(int node, boolean[] vis, List<List<Integer>> adj, int nodes, int edges) {
        vis[node] = true;
        nodes++;
        for (int neighbor : adj.get(node)) {
            edges++;
            if (!vis[neighbor]) {
                int[] res = dfs(neighbor, vis, adj, nodes, edges);
                nodes = res[0];
                edges = res[1];
            }
        }
        return new int[]{nodes, edges};
    }
}
