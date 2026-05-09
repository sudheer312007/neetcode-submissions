class Solution {
    public int trap(int[] height) {
        int ans = 0;
        int leftMax = 0;
        int rightMax = 0;
        int l = 0;
        int r = height.length - 1;
        while(l<=r){
            if (height[l] < height[r]) {
                ans += Math.max(leftMax - height[l], 0);
                leftMax = Math.max(leftMax, height[l]);
                l++;
            } else {
                ans += Math.max(rightMax - height[r], 0);
                rightMax = Math.max(rightMax, height[r]);
                r--;
            }
        }
        return ans;

    }
}
