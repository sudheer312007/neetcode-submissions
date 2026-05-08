class Solution {
    class Node {
        int temp;
        int idx;

        public Node(int temp, int idx){
            this.temp = temp;
            this.idx = idx;

        }
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Node> stack = new Stack();
        List<Integer> ans = new ArrayList();

        for(int i =temperatures.length-1; i >=0 ;i--){
            while(!stack.isEmpty() && stack.peek().temp <= temperatures[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans.add(0);
            }else{
                ans.add(stack.peek().idx - i);
            }
            stack.push(new Node(temperatures[i],i));
        }

        Collections.reverse(ans);
        return ans.stream().mapToInt(Integer::intValue).toArray();


    }
}
