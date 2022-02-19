/*
 * @lc app=leetcode.cn id=990 lang=java
 *
 * [990] 等式方程的可满足性
 */

// @lc code=start
class Solution {
    public boolean equationsPossible(String[] equations) {
        UnionFind unionFind = new UnionFind(26);

        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                unionFind.union(equation.charAt(0) - 'a', equation.charAt(3) - 'a');
            }
        }

        for (String equation : equations) {
            if (equation.charAt(1) == '!' && unionFind.connect(equation.charAt(0) - 'a', equation.charAt(3) - 'a')) {
                return false;
            }
        }

        return true;
    }
}

public class UnionFind {
    private int count;
    private int[] parent;
    private int[] size;

    public UnionFind(int count) {
        this.count = count;
        parent = new int[count];
        size = new int[count];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ) {
            return;
        }

        // 平衡树节点，小树合并到大树中，O(logN)
        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
        count--;
    }

    public boolean connect(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }

    public int getCount() {
        return count;
    }

    private int find(int node) {
        while (parent[node] != node) {
            // 将父节点 合并到 父父节点，压缩路径
            parent[node] = parent[parent[node]];
            node = parent[node];
        }

        return node;
    }
}
// @lc code=end
