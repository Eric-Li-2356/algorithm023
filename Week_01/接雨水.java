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