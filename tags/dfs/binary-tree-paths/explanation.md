## 二叉树的所有路径

[257. 二叉树的所有路径](https://leetcode-cn.com/problems/binary-tree-paths/)

#### 解题思路：dfs

本题目是一道典型的深度优先搜索遍历二叉树类型题，在遍历二叉树时，我们需要考虑的是当前节点以及它的孩子节点：

- 如果当前节点**不是叶子节点**，则在当前的路径末尾添加该节点，并继续递归遍历该节点的每一个孩子节点。
- 如果当前节点**是叶子节点**，则在当前路径末尾添加该节点后我们就得到了一条从根节点到叶子节点的路径，将该路径加入到答案即可。

#### 代码

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res  = new ArrayList<>();
        dfs(root,res,"");
        return res;
    }

    private static void dfs(TreeNode node,List<String> list,String path){
        if(node != null){
            // 叶子节点
            if(node.left == null && node.right == null){
                path += node.val;
                list.add(path);
            }else {
                path += node.val;
                path += "->";
                dfs(node.left,list,path);
                dfs(node.right,list,path);
            }
        }
    }
}
```

