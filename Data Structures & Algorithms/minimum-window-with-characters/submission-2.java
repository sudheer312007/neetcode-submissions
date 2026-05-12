class Solution {
    public String minWindow(String s, String t) {
        int minWindow = Integer.MAX_VALUE;
        String minString = "";

        int i = 0;
        int j = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.putIfAbsent(c, 0);
            map.put(c, map.get(c) + 1);
        }
        int count = map.size();

        char[] chars = s.toCharArray();
        while (j < s.length()) {
            if (map.containsKey(chars[j])) {
                int c = map.get(chars[j]);
                if (c == 1) {
                    count--;
                }
                map.put(chars[j], c - 1);
            }
            if (count == 0) {
                while (count == 0 ) {
                    
                    if (j - i + 1 < minWindow) {
                        minWindow = j - i + 1;
                        minString = s.substring(i, j + 1);
                    }

                    if (map.containsKey(chars[i])) {
                        int c = map.get(chars[i]);
                        if (c == 0) {
                            count++;
                        }
                        map.put(chars[i], c + 1);
                    }
                    i++;
                }
            }

            j++;
        }

        return minString;
    }
}
