import java.util.Arrays;

public class CountGoodNodes1448 {
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);

    }
    // call this recursively storing the currentMax and adding only
    // consider the node with value greater than or equal to the current Maximum

    public int dfs(TreeNode node, int currentMax) {
        int good=0;
        if(node.val>=currentMax) {
            good++;
        }
        if(node.left!=null) {
            good=good+dfs(node.left, Math.max(currentMax, node.val));
        }
        if(node.right!=null) {
            good=good+dfs(node.right, Math.max(currentMax, node.val));
        }

        return good;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(1);
        root.right = new TreeNode(4);

        root.left.left = new TreeNode(3);

        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);

        CountGoodNodes1448 obj = new CountGoodNodes1448();
        System.out.println("Answer:"+obj.goodNodes(root));
    }
}

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }

