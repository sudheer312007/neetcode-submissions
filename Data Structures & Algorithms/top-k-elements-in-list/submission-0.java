class Solution {
    public  int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for(int num:nums){
            map.putIfAbsent(num, 0);
            int temp = map.get(num) + 1;
            map.put(num,temp );
        }

        PriorityQueue<Integer> que = new PriorityQueue(
                Comparator.comparingInt(a->map.get(a))
        );
        for(int key :map.keySet()){
            que.offer(key);
            if(que.size()>k){
                que.poll();
            }
        }
        for(int i=0;i<k;i++){
            ans[i] = que.poll();
        }
        return ans;
    }
}
