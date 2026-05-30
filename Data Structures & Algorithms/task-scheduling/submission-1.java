class Solution {
 class Node {
        int count;
        int lastProcessedTime;
        char task;

        Node(char c) {
            count = 0;
            lastProcessedTime = -1;
            this.task = c;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Node> map = new HashMap<>();

        for (char task : tasks) {
            map.putIfAbsent(task, new Node(task));
            map.get(task).count++;
        }


        Comparator<Node> comp = Comparator.comparingInt((Node a) -> a.count).reversed();

        PriorityQueue<Node> pq = new PriorityQueue<>(comp);

        Queue<Node> coolDownQ = new LinkedList<>();
        for (Map.Entry<Character, Node> characterNodeEntry : map.entrySet()) {
            pq.offer(characterNodeEntry.getValue());
        }


        int timeline = 1;
        while (!pq.isEmpty() || !coolDownQ.isEmpty()) {
            if(pq.isEmpty()){
                Node coolDown = coolDownQ.peek();
                while (timeline - coolDown.lastProcessedTime <= n) {
                    timeline++;
                }
            }

            Node cooldown = coolDownQ.peek();
            if (cooldown != null && timeline - cooldown.lastProcessedTime > n) {
                coolDownQ.poll();
                pq.offer(cooldown);
            }

            Node temp = pq.poll();
            temp.lastProcessedTime = timeline;
            temp.count--;
            if(temp.count != 0){
                coolDownQ.offer(temp);
            }
            timeline++;
        }


        return timeline - 1;
    }
}
