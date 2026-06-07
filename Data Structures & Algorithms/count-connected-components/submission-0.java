class Solution {
    public int countComponents(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {

            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);

        }


        boolean[] visited = new boolean[V];
        int provinces = 0;
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                provinces++;
                countConnectedHelper(i, visited, adj);
            }
        }
        return provinces;
    }

    private void countConnectedHelper(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = true;

        for (Integer i : adj.get(node)) {
            if (!visited[i]) {
                countConnectedHelper(i, visited, adj);
            }
        }
    }
}
