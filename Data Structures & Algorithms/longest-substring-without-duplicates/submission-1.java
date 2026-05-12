class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;
        char[] arr = s.toCharArray();
        while (j < arr.length) {

            if (set.contains(arr[j])) {
                while (arr[i] != arr[j] ) {
                    set.remove(arr[i]);
                    i++;
                }
                set.remove(arr[i]);
                i++;
            }
            set.add(arr[j]);
            j++;

            maxLength = Math.max(maxLength,set.size());

        }

        return maxLength;
    }
}
