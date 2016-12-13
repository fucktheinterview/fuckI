// standard unionFind V to build the array, loop through E, each call will cost constant considering using weighted and compression

// so eventually it is gonna be O(V + E*1) = O(E + V)

public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges == null || n < 1) return false;
        
        UnionFind uf = new UnionFind(n);
        
        for(int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            if(uf.isConnected(a, b)) return false;
            uf.union(a, b);
        }
        
        return uf.getCount() == 1;
    }
    
}

class UnionFind {
    int[] ids, sizes;
    int count;
    
    public UnionFind(int n) {
        ids = new int[n];
        sizes = new int[n];
        count = n;
        for(int i = 0; i < n; i++) {
            ids[i] = i;
        }
    }
    
    public int getCount() {
        return count;
    }
    
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
    
    public int find(int x) {
        while(x != ids[x]) {
            ids[x] = ids[ids[x]];
            x = ids[x];
        }
        return x;
    }
    
    public void union(int p, int q) {
        int idP = find(p);
        int idQ = find(q);
        if(idP == idQ) return;
        if(sizes[idP] < sizes[idQ]) {
            sizes[idQ] += sizes[idP];
            ids[idP] = idQ;
        } else {
            sizes[idP] += sizes[idQ];
            ids[idQ] = idP;
        }
        count--;
    }
}
