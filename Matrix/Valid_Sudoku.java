//Problem - VAlid Sudoku with 3 conditions the number shld not be present in that row,colm,and 3*3 box
//hashset is used where it contains only unique set of elements we will check if the elemnt is present in any row,colm or amtg if yes then return false else return true
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for(int row=0;row<9;row++){
            for(int col=0;col<9;col++){
                char current = board[row][col];
                if(current != '.'){
                    String inRow = current + "in row" + row;
                    String inCol = current +"in col"+col;
                    String inBox = current + "in box"+(row/3)+"-"+(col/3);
                    if(!seen.add(inRow) || !seen.add(inCol)|| !seen.add(inBox)){
                        return false;

                    }

                }
            }
        }
        return true;
    }
}