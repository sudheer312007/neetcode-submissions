class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> map = new<Integer, Integer> HashMap();
        for(int i=0; i< nums.length; i++){
            Integer fromMap = map.get(nums[i]);
            if(fromMap == null ){
                map.put(nums[i],1 );
            }else{
                return true;
            }
        }
        return false;
    }
}