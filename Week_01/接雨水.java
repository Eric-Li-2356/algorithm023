/**
 * 栈方法
 */
class Solution {
    public int trap(int[] height) {
        int ans = 0;
        int cur = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        while (cur < height.length) {
            while (!stack.isEmpty() && height[cur] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int dis = cur - stack.peek() - 1;
                int bounded_height = Math.min(height[cur], height[stack.peek()]) - height[top];
                ans += dis * bounded_height;
            }
            stack.push(cur++);
        }
        return ans;
    }
}

/**
 * 双指针法
 */
class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int ans = 0;
        int lMax = 0;
        int rMax = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                if (height[l] >= lMax) {
                    lMax = height[l];
                } else {
                    ans += (lMax - height[l]);
                }
                l++;
            } else {
                if (height[r] >= rMax) {
                    rMax = height[r];
                } else {
                    ans += (rMax - height[r]);
                }
                r--;
            }
        }
        return ans;
    }
}