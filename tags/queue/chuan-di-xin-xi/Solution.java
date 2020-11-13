class Solution {
    static class MyNode {
        int val;
        int level;

        MyNode(int val, int level) {
            this.val = val;
            this.level = level;
        }
    }

    public int numWays(int n, int[][] relation, int k) {
        Queue<MyNode> queue = new LinkedList<>();
        int res = 0;
        queue.offer(new MyNode(0, 0));
        while (!queue.isEmpty()) {

            MyNode node = queue.poll();
            if (node.level <= k) {
                for (int i = 0; i < relation.length; i++) {
                    if (node.level == k && node.val == n - 1) {
                        res++;
                        break;
                    }
                    if (node.val == relation[i][0]) {
                        queue.offer(new MyNode(relation[i][1], node.level + 1));
                    }
                }
            } else {
                break;
            }
        }
        return res;
    }
}