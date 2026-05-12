class Solution {
    public boolean checkInclusion(String s1, String s2) {
    
        
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = s1.toCharArray();

        for (char c : arr) {
            map.putIfAbsent(c, 0);
            map.put(c, map.get(c) + 1);
        }

        char[] chars = s2.toCharArray();
        int count = map.size();
        int i = 0, j = 0;
        while (j < chars.length) {
            if (map.containsKey(chars[j])) {
                int c = map.get(chars[j]);
                c--;
                if (c == 0) {
                    count--;
                }
                map.put(chars[j], c);
            }

            if (j - i + 1 == s1.length()) {
                if (count == 0) {
                    return true;
                }
                if (map.containsKey(chars[i])) {
                    int c = map.get(chars[i]);
                    c++;
                    if (c == 1) {
                        count++;
                    }
                    map.put(chars[i], c);
                }

                i++;
            }

            j++;

        }
        return false;

    }
}
