class Solution {
    class Node {
        boolean[] foundInRow;
        boolean[] foundInCol;
        boolean[] foundInQuadrant;

        public Node() {
            this.foundInRow = new boolean[9];
            this.foundInCol = new boolean[9];
            this.foundInQuadrant = new boolean[9];
        }
    }

    public boolean isValidSudoku(char[][] board) {
        Node[] arr = new Node[10];

        for(int i=0;i< 10;i++){
            arr[i] = new Node();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if(c != '.'){
                    Node temp = arr[c - '1' + 1];
                    int quadrant = ((i/3)*3) + (j/3) ;
                    if(temp.foundInRow[i] || temp.foundInCol[j] || temp.foundInQuadrant[quadrant]){
                        return false;
                    }

                    temp.foundInRow[i] = true;
                    temp.foundInCol[j] = true;
                    temp.foundInQuadrant[quadrant] = true;

                }


            }
        }
        return true;
    }
}
