## 跳跃游戏III

[1306. 跳跃游戏 III](https://leetcode-cn.com/problems/jump-game-iii/)

#### 思路：递归(dfs)

DFS:从起点开始，递归(dfs)，使用一个boolean数组用来标记已经访问过的节点；

如果有任何一条路径遇到了0就返回true；

否则，如果节点的下标越界，或者是该节点已经被访问过，则返回false；

代码非常简单，是一道考验dfs基本功的题目

#### 代码

```java
class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        return canReach(arr,start,visited);
    }

    private static boolean canReach(int[] arr,int start,boolean[] visited){
        if(start < 0 || start >= arr.length || visited[start]){
            return false;
        }
        if(arr[start] == 0){
            return true;
        }
        visited[start] = true;
        return canReach(arr,start - arr[start],visited) 
            || canReach(arr,start + arr[start],visited);
    }
}
```



