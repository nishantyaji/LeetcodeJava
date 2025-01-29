package com.leetcode;

import java.util.HashSet;
import java.util.Set;

// Problem 684
public class RedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {
        Set<Integer> visited = new HashSet<>();
        int mx = -1;
        for(int [] edge: edges) {
            mx = Math.max(mx, Math.max(edge[0], edge[1]));
        }
        DSU dsu = new DSU(mx + 1);
        int [] res = new int[2];
        for(int [] edge: edges) {
            if(visited.contains(edge[0]) && visited.contains(edge[1]) && dsu.find(edge[0]) == dsu.find(edge[1])) {
                res[0] = edge[0];
                res[1] = edge[1];
            } else {
                visited.add(edge[0]);
                visited.add(edge[1]);
                dsu.union(edge[0], edge[1]);
            }
        }
        return res;
    }

    public static class DSU{
        private int[] parent;
        private int[] size;
        private int len;

        public DSU(int len){
            this.len = len;
            parent = new int[len];
            size = new int[len];
            for(int i = 0; i < len; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int i) {
            if(parent[i] != i){
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }

        public void union(int i, int j) {
            int iPar = find(i);
            int jPar = find(j);
            if(iPar == jPar){
                return;
            }

            int iSize = size[i];
            int jSize = size[j];
            if(iSize < jSize) {
                parent[iPar] = jPar;
                size[jPar] += size[iPar];
            } else{
                parent[jPar] = iPar;
                size[iPar] += size[jPar];
            }
        }
    }
}
