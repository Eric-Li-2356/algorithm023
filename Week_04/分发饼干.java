class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int lenG = g.length, lenC = s.length;
        int cnt = 0;
        for (int i = 0, j = 0; i < lenG && j < lenC; i++, j++) {
            while (j < lenC && g[i] > s[j]) {
                j++;
            }
            if (j < lenC) {
                cnt++;
            }
        }

        return cnt;
    }
}