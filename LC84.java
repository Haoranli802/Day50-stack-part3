class Solution {
    /**
    find the first height that is less than the current height on the left and on the
    right, in the way we can find the width, then times the width to the current height
    and get the largest rectangle.
     */
    public int largestRectangleArea(int[] heights) {
        if(heights.length == 0) return 0;
        if(heights.length == 1) return heights[0];
        int[] newHeights = new int[heights.length + 2];
        for(int i = 0; i < heights.length; i++){
            newHeights[i + 1] = heights[i];
        }
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        int res = 0;
        for(int i = 1; i < newHeights.length; i++){
            while(newHeights[i] < newHeights[stack.peek()]){
                int mid = stack.pop();
                int left = stack.peek();
                int width = i - left - 1;
                int height = newHeights[mid];
                res = Math.max(res, width * height);
            }
            stack.push(i);
        }
        return res;
    }
}
