class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0;i< nums.length;i++){
            if(i!=0 && nums[i] == nums[i-1] ){
                continue;
            }
            if(nums[i] > 0){
                break;
            }
            int target = -nums[i];
            List<List<Integer>> subAns = twoSum(nums, i+1 , nums.length-1, target);

            for (List<Integer> subAn : subAns) {
                subAn.add(nums[i]);
                ans.add(subAn);
            }
        }
        return ans;
    }

    public List<List<Integer>> twoSum(int[] numbers, int lpr, int rpr, int target) {
        List<List<Integer>> subsAns = new ArrayList<>();
        while(lpr<rpr){
            int curSum = numbers[lpr] + numbers[rpr];
            if( curSum == target){
                subsAns.add(new ArrayList<>(List.of(numbers[lpr], numbers[rpr])));
                lpr++;
                rpr--;
                while(lpr < numbers.length-1 && numbers[lpr] == numbers[lpr-1]){
                lpr++;
            }

            }else if(curSum > target) {
                rpr--;
            }else{
                lpr++;
            }
            
        }
        return subsAns;
    }
}
