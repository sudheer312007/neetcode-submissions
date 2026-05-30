class Solution {
   public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(a -> (int) a).reversed());

        for (int stone : stones) {
            pq.offer(stone);
        }

        while (!pq.isEmpty()) {
            int stone1 = pq.poll();
            if (pq.isEmpty()) {
                return stone1;
            }
            int stone2 = pq.poll();

            int newStone = Math.abs(stone2-stone1);
            if(newStone > 0){
                pq.offer(newStone);
            }
        }

        return 0;
    }
}
