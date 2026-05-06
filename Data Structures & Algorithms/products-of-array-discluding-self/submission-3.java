class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] leftProducts = new int[nums.length];
        int[] rightProducts = new int[nums.length];
        leftProducts[0]=1;
        rightProducts[nums.length-1]=1;
        for(int i=1 ; i<nums.length ; i++){
            leftProducts[i] = leftProducts[i-1] * nums[i-1];
            rightProducts[nums.length-1-i] = rightProducts[nums.length-i] * nums[nums.length-i];
        }

        
        for(int i=0 ; i<nums.length ; i++){
           leftProducts[i] = leftProducts[i] * rightProducts[i];
        }

        return leftProducts;
    }
}  
