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
        int[] ans = new int[temperatures.length];

        for(int i =temperatures.length-1; i >=0 ;i--){
            while(!stack.isEmpty() && stack.peek().temp <= temperatures[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans[i] = 0;
            }else{
                ans[i] = stack.peek().idx - i;
            }
            stack.push(new Node(temperatures[i],i));
        }

        return ans;


    }
}
