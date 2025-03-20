class Solution {

    static int par[];
    static int rank[];
    static int weight[];

    static int find(int a){
        if(par[a]==a) return a;
        else return par[a] = find(par[a]);
    }

    static void union(int a, int b, int wt){
        a = find(a);
        b = find(b);
        if(rank[a]<rank[b]){
            par[a] = b;
            rank[b]++;

        }else{
            par[b] = a;
            rank[a]++;
        }

        int x = weight[a] & weight[b] & wt;
        weight[a] = x;
        weight[b] = x;
    }
    public int[] minimumCost(int n, int[][] edges, int[][] q) {
        par = new int[n];
        rank = new int[n];
        weight = new int[n];

        for(int i=0; i<n; i++) par[i] = i;
        Arrays.fill(weight,131071); // 131071=(2^17-1);

        for(int i=0; i<edges.length; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            int wt = edges[i][2];
                union(a,b,wt);
        }
        int size = q.length;
        int ans[] = new int[size];

        for(int i=0; i<size; i++){
            int a = q[i][0];
            int b = q[i][1];
            if(a==b) ans[i] = 0;
            else if(find(a)!=find(b)) ans[i] = -1;
            else{
                ans[i] = weight[find(a)];
            }
        }
        return ans;
    }
}