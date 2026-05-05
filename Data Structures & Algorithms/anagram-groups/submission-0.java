class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap();
        for(String str:strs){
            int[] keyArr = new int[26];
            for(int i=0;i<str.length();i++){
                keyArr[str.charAt(i) - 'a'] ++;
            }
            String mapKey = Arrays.toString(keyArr);
            if(map.containsKey(mapKey)) {
                List<String> anaList = map.get(mapKey);
                anaList.add(str);
            }else{
                List<String> anaList = new ArrayList();
                anaList.add(str);
                map.put(mapKey, anaList);
            }
        }

        return new ArrayList<>(map.values());



    }
}
