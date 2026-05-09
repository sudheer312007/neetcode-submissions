class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int lpr = 0;
        int rpr = numbers.length-1;

        while(lpr<rpr){
            int curSum = numbers[lpr] + numbers[rpr];
            if( curSum == target){
                return new int[] {++lpr, ++rpr};
            }else if(curSum > target) {
                rpr--;
            }else{
                lpr++;
            }
        }
        return new int[0];
    }
}
