class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int lpr = 0;
        int rpr = numbers.length-1;

        while(lpr<rpr){
            if(numbers[lpr] + numbers[rpr] == target){
                return new int[] {++lpr, ++rpr};
            }else if(numbers[lpr] + numbers[rpr] > target) {
                rpr--;
            }else{
                lpr++;
            }
        }
        return new int[] {};
    }
}
