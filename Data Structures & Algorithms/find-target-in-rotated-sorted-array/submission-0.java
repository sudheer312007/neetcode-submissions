class Solution {
    public int search(int[] nums, int target) {

    int idx = findMinIndex(nums);

    System.out.println(idx);

    if(idx!=0){
        if(target >= nums[idx] && target <= nums[nums.length-1]){
            return searchBin(nums, target, idx, nums.length-1);
        }else{
            return searchBin(nums, target, 0,idx);
        }
    }else{
        return searchBin(nums, target, 0, nums.length-1);
    }

    }

    public int findMinIndex(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        int ans = Integer.MAX_VALUE;
        int idx = 0;

        while(start <= end){
            int mid = start + (end-start)/2;

            if(nums[start] < nums[end]){
                if(nums[start] < ans){
                    ans = nums[start];
                    idx = start;
                }
                ans = Math.min(ans, nums[start]);
            }
             if(nums[mid] < ans){
                    ans = nums[mid];
                    idx = mid;
                }
            if( nums[start] <= nums[mid]){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }

        return idx;
        
    }

    public int searchBin(int[] nums, int target, int i, int j) {
        

        while(i <= j){
            int m = i+(j-i)/2;

            if(nums[m] == target){
                return m;
            }else if (nums[m] > target){
                j=m-1;
            }else{
                i = m+1;
            }
        }

        return -1;

    }
}
