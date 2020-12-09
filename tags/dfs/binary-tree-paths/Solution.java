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