class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];

        ans[0]=1;
    
        for(int i=1 ; i<nums.length ; i++){
            ans[i] = ans[i-1] * nums[i-1];
        }
        int rightProduct = 1 ;
        for(int i=0 ; i<nums.length ; i++){
            ans[nums.length-i-1] = ans[nums.length-i-1] * rightProduct;
            rightProduct = rightProduct * nums[nums.length-i-1] ;
        }
        
    

        return ans;
    }
}  
