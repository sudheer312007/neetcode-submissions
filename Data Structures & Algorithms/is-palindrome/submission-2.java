class Solution {
    public boolean isPalindrome(String s) {
        
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        int lpr =0;
        int rpr = s.length()-1;
        while(lpr<rpr){
            if(Character.toLowerCase(s.charAt(lpr)) == Character.toLowerCase(s.charAt(rpr))){
                lpr++;
                rpr--;
            
            }
            else{
                return false;
            }
        }
        return true;
    }
}
