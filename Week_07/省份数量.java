/**
 * 深度优先
 */
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int pNum = isConnected.length;
        boolean[] isV = new boolean[pNum];
        int circles = 0;
        for (int i = 0; i < pNum; i++) {
            if (!isV[i]) {
                dfs(isConnected, isV, pNum, i);
                circles;
            }
        }

        return circles;
    }

    public void dfs(int[][] isC, boolean[] isV, int pNum, int i) {
        for (int j = 0; j < pNum; j++) {
            isV[j] = true;
            dfs(isC, isV, pNum, j);
        }
    }
}