class Solution {
    public int[] spiralOrder(int[][] matrix) {
        
        if(matrix.length == 0 || matrix[0].length == 0){
            return new int[0];
        }
        int startX = 0;
        int startY = 0;
        int endX = matrix.length - 1;
        int endY = matrix[0].length - 1;

        List<Integer> res = new ArrayList<>();

        while(startX <= endX && startY <= endY){
            printOuter(matrix,res,startX++,startY++,endX--,endY--);
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    private void printOuter(int[][] matrix,List<Integer> res,int startX,int startY,int endX,int endY){
        int x = startX;
        int y = startY;

        if(startX == endX){
            while(y <= endY){
                res.add(matrix[x][y++]);
            }
            return;
        }else if(startY == endY){
            while(x <= endX){
                res.add(matrix[x++][y]);
            }
            return;
        }else{
            while(y < endY){
                res.add(matrix[x][y++]);
            }
            while(x < endX){
                res.add(matrix[x++][y]);
            }
            while(y > startY){
                res.add(matrix[x][y--]);
            }
            while(x > startX){
                res.add(matrix[x--][y]);
            }
            return;
        }
    }
}