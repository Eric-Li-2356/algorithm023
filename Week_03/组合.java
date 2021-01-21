/**
* 法1：回溯1(每个位置判断取舍)+剪枝
*/
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || k > n) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        backtrack(n, k, 1, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int n, int k, int idx, List<Integer> subRes, List<List<Integer>> res) {
        if (k == 0) {
            res.add(new ArrayList<>(subRes));
            return;
        }
        if (idx > n + 1 - k) {
            return;
        }

        backtrack(n, k, idx + 1, subRes, res);
        subRes.add(idx);
        backtrack(n, k - 1, idx + 1, subRes, res);
        subRes.remove(subRes.size() - 1);
    }
}

/**
* 法2：回溯2(每个位置循环取idx-n中某个)+剪枝
*/
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || k > n) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        backtrack(n, k, 1, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int n, int k, int idx, List<Integer> subRes, List<List<Integer>> res) {
        if (k == 0) {
            res.add(new ArrayList<>(subRes));
            return;
        }

        for (int i = idx; i <= n + 1 - k; i++) {
            subRes.add(i);
            backtrack(n, k - 1, i + 1, subRes, res);
            subRes.remove(subRes.size() - 1);
        }
    }
}