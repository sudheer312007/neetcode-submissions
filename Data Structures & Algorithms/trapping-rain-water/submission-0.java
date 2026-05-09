class Solution {
    public int trap(int[] height) {
        int[] maxFillable = new int[height.length];
        int ans = 0;
        int leftMax = 0;
        for(int i = 0;i< height.length; i++){
            maxFillable[i] = leftMax;
            leftMax = Math.max(leftMax, height[i]);
        }
        int rightMax = 0;
        for(int i= height.length-1 ; i>=0 ;i--){
            maxFillable[i] = Math.min(rightMax, maxFillable[i]);
            rightMax = Math.max(rightMax, height[i]);
        }

        for(int i=0;i< height.length;i++){
            ans += Math.max(maxFillable[i] - height[i], 0);
        }

        return ans;
        
    }
}
