class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] ans = new int[k][2];

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt((int[] a) -> a[0] * a[0] + a[1] * a[1]).reversed() );

        for (int[] point : points) {
            pq.offer(point);
            
            if(pq.size() > k){
                pq.poll();
            }
        }
        
        int i=0;
        while(!pq.isEmpty()){
            ans[i] = pq.poll();
            i++;
        }
        
        return ans;
    }
}
