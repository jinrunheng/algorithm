## 剑指 Offer 29. 顺时针打印矩阵

[剑指 Offer 29. 顺时针打印矩阵](https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/)

#### 解题思路：递归

示例：

矩阵为：

```
1 ,2 ,3 ,4 ,5
6 ,7 ,8 ,9 ,10
11,12,13,14,15
16,17,18,19,20
21,22,23,24,25
```

思路：一圈一圈打印，然后递归按圈打印这个算法

设定两个点，为矩阵最左上角和最右下角的顶点：

左上角：`startX`,`startY`

右下角：`endX`,`endY`

按圈打印的算法为：`printOuter(int[][] matrix,int startX,int startY,int endX,int endY)`

在我们打印外圈以后，只需要将左上角的点和右下角的点同时向内“缩”，对应的操作为`startX++;startY++,endX--,endY--`

在`startX <= endX && startY <= endY` 的条件下递归，直至不满足条件为止，矩阵中所有的元素都可以被打印。



打印最外圈这个算法实际上非常简单；拿示例来说明：首先打印出`1 ~ 4`,然后是`5 ~ 20`,接着为`25 ~ 22`,最后打印`21 ~ 6`

设定打印路线的坐标为`matrix[x][y]`,最开始`x = startX;y = startY`;对应的打印外圈的线路即：

- `while(y < endY) print(matrix[x][y++])`
- `while(x < endX) print(matrix[x++][y])`
- `while(y > startY) print(matrix[x][y--])`
- `while(x > startX) print(matrix[x--][y])`

另外，我们也需要考虑到最后打印的矩阵变成了棒状的情况：

如果最后矩阵变成了横向的棒状时，一定是从左向右打印：

```java
if(startX == endX){
    while(y <= endY){
        res.add(matrix[x][y++]);
    }
    return;
}
```

如果最后矩阵变成了竖向的棒状时，一定是从上向下打印：

```java
if(startY == endY){
    while(x <= endX){
        res.add(matrix[x++][y]);
    }
    return;
}
```

详见代码

#### 代码

*Java*

```java
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
```

