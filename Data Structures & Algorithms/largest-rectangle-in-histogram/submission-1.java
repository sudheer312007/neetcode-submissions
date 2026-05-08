class Solution {
    class Node{
        int height;
        int idx;

        public Node (int height, int idx){
            this.height = height;
            this.idx = idx;
        }

    }

    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int[] areas = new int[heights.length];
        
        Stack<Node> stack = new Stack();

        for(int i = heights.length-1; i>=0 ; i--){
            while(!stack.isEmpty() && heights[i] <= stack.peek().height  ){
                stack.pop();
            }
            if(stack.isEmpty()){
                areas[i] = heights.length - 1;
            }else{
                areas[i] = stack.peek().idx - 1;
            }
            stack.push(new Node(heights[i],i));
        }

          while(!stack.isEmpty()){
            stack.pop();
        }
        
        for(int i=0; i <= heights.length-1 ; i++){
            while(!stack.isEmpty() && heights[i] <= stack.peek().height  ){
                stack.pop();
            }
            if(stack.isEmpty()){
                areas[i] = (areas[i] +1 ) * heights[i] ;
            }else{
                areas[i] = (areas[i] - stack.peek().idx) * heights[i] ;
            }
            maxArea = Math.max(maxArea, areas[i]);
            stack.push(new Node(heights[i],i));


        }

        return maxArea;

    }
}
