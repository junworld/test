package suanfa.tree;

public class BinarySearchTree {

    /**
     * 动态创建二叉树
     * @param treeRoot
     * @param value
     */
    public static void createTree(TreeRoot treeRoot, int value) {
        if (treeRoot.getTreeRoot() == null) {
            TreeNode node = new TreeNode(value);
            treeRoot.setTreeRoot(node);
        } else {
            TreeNode temp   = treeRoot.getTreeRoot();
            while (temp!=null) {
                //右子树
                if (value > temp.getValue()) {
                    if (temp.getRightTreeNode() == null) {
                        temp.setRightTreeNode(new TreeNode(value));
                        return;
                    } else {
                        temp = temp.getRightTreeNode();
                    }
                //左子树
                } else {
                    if (temp.getLeftTreeNode() == null) {
                        temp.setLeftTreeNode(new TreeNode(value));
                        return;
                    } else {
                        temp = temp.getLeftTreeNode();
                    }
                }
            }
        }
    }

    /**
     * 先序遍历
     * 遍历顺序 根->左->右
     * @param treeRoot 根节点
     */

    public static void preTraverseBTree(TreeNode treeRoot){
        if (treeRoot != null) {
            //打印当前节点
            System.out.println(treeRoot.getValue());
            //存在左孩子 打印左孩子节点，一直有一直打印
            preTraverseBTree(treeRoot.getLeftTreeNode());
            //存在右孩子，打印右孩子，一直有一直打印
            preTraverseBTree(treeRoot.getRightTreeNode());
        }
    }

    /**
     * 中序遍历
     * 遍历顺序 左->根->右
     * @param rootTreeNode 根节点
     */
    public static void inTraverseBTree(TreeNode rootTreeNode){
        if (rootTreeNode != null) {
            inTraverseBTree(rootTreeNode.getLeftTreeNode());
            System.out.println(rootTreeNode.getValue());
            inTraverseBTree(rootTreeNode.getRightTreeNode());
        }
    }

    public static void main(String[] args) {
        int[] arrays = {2, 3, 1, 4, 5};
        TreeRoot root = new TreeRoot();
        for (int i = 0; i < arrays.length; i++) {
            createTree(root,arrays[i]);
        }
        preTraverseBTree(root.getTreeRoot());
    }

}


