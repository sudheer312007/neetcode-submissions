class KthLargest {
 PriorityQueue<Integer> heap;
    int size;

    public KthLargest(int k, int[] nums) {
        this.heap = new PriorityQueue<>(k);
        this.size = k;
        for (Integer i : nums) {
            add(i);
        }
    }

    public int add(int val) {
        if (heap.size() < size) {
            heap.offer(val);
        }else{
            int min = heap.peek();
            if(min < val){
                heap.poll();
                heap.offer(val);
            }
        }
        return heap.peek();
    }
}
