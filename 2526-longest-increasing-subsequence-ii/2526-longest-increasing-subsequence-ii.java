class SegmentTree {
    int[] st;
    int size;
    int n; //arraySize

    public SegmentTree(int n) {
        this.n = n;
        this.size = 4 * n + 1;

        st = new int[size];
        Arrays.fill(st, 0);
    }

    private void update(int node, int beg, int end, int i, int value) {
        if(beg > end) return;

        if(beg == end) {
            if(beg == i) { // do we need this ?
                st[node] = Math.max(st[node], value); //IMP
            }
            return;
        }

        int mid = (beg + end) / 2;
        
        if(i <= mid) update(2 * node, beg, mid, i, value);
        else update(2 * node + 1, mid + 1, end, i, value);

        st[node] = Math.max(st[2 * node], st[2 * node + 1]);
    }

    public void update(int i, int value) {
        update(1, 0, n - 1, i, value);
    }
    
    private boolean isNoOverlap(int a, int b, int c, int d) {
        return b < c || d < a;
    }

    private boolean isFullOverlap(int beg, int end, int i, int j) {
        return i <= beg && end <= j;
    }

    private int query(int node, int beg, int end, int i, int j) {
        if(beg > end) return 0;

        if(isNoOverlap(beg, end, i, j)) return 0;

        if(isFullOverlap(beg, end, i, j)) return st[node];

        int mid = (beg + end) / 2;

        int left = query(2 * node, beg, mid, i, j);
        int right = query(2 * node + 1, mid + 1, end, i, j);

        return Math.max(left, right);
    }

    public int query(int i, int j) {
        return query(1, 0, n - 1, i, j);
    }
}


class Solution {
    public int lengthOfLIS(int[] a, int k) {
        int n = a.length;
        int[] dp = new int[n]; //this is just for understanding

        int N = (int)1e5 + 1;
        SegmentTree segmentTree = new SegmentTree(N);

        dp[0] = 1;
        segmentTree.update(a[0], dp[0]); //IMP : (i, value)

        for(int i = 1; i < n; i++) {
            int l = Math.max(0, a[i] - k);
            int r = Math.max(0, a[i] - 1);

            dp[i] = segmentTree.query(l, r) + 1;

            segmentTree.update(a[i], dp[i]);
        }

        int ans = 0; for(int i = 0; i < n; i++) ans = Math.max(ans, dp[i]);

        return ans;
    }
}