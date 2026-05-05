class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap();
        for(String str:strs){
            int[] keyArr = new int[26];
            for(char c : str.toCharArray()){
                keyArr[c - 'a'] ++;
            }
            String mapKey = Arrays.toString(keyArr);
            map.putIfAbsent(mapKey, new ArrayList<>());
            map.get(mapKey).add(str);
        }

        return new ArrayList<>(map.values());



    }
}
