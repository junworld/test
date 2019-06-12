package suanfa.tree;

public class BinarySearchTree {

    /**
     * 动态创建二叉树
     * @param treeRoot
     * @param value
     */
    public static void createTree(TreeRoot treeRoot, int value) {
        //如果树根为空(第一次访问)，将第一个值作为根节点
        if (treeRoot.getTreeRoot() == null) {
            TreeNode node = new TreeNode(value);
            treeRoot.setTreeRoot(node);
        } else {
            TreeNode temp   = treeRoot.getTreeRoot();
            while (temp!=null) {
                //当前值大于根值，往右边走
                if (value > temp.getValue()) {
                    //右边没有树根，那就直接插入
                    if (temp.getRightTreeNode() == null) {
                        temp.setRightTreeNode(new TreeNode(value));
                        return;
                    } else {
                        //如果右边有树根，到右边的树根去
                        temp = temp.getRightTreeNode();
                    }
                //左没有树根，那就直接插入
                } else {
                    if (temp.getLeftTreeNode() == null) {
                        temp.setLeftTreeNode(new TreeNode(value));
                        return;
                    } else {
                        //如果左有树根，到左边的树根去
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

    /**
     * 后续遍历？？
     * @param rootTreeNode
     */
    public static void endTraverseBTree(TreeNode rootTreeNode){
        if (rootTreeNode != null) {
            endTraverseBTree(rootTreeNode.getLeftTreeNode());
            System.out.println(rootTreeNode.getValue());
            if (rootTreeNode.getRightTreeNode() != null) {
                System.out.println(rootTreeNode.getRightTreeNode().getValue());
            }
            //endTraverseBTree(rootTreeNode.getRightTreeNode());
        }
    }

    public static int getHeight(TreeNode treeNode){
        if (treeNode == null) {
            return 0;
        } else {
            int left = getHeight(treeNode.getLeftTreeNode());
            int right = getHeight(treeNode.getRightTreeNode());
            int max = left;
            if (right > left) {
                max = right;
            }
            return max + 1;
        }
    }

    /**
     * 查询二叉树节点数
     * @param root
     * @return
     */
    public static int getNodeNumRec(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getNodeNumRec(root.getLeftTreeNode());
        int right = getNodeNumRec(root.getRightTreeNode());
        return left+right+1;
    }

    public static void main(String[] args) {
        //int[] arrays = {2, 3, 1, 4, 5};
        //int[] arrays = {10, 9, 20, 15, 35};
        int[] arrays = {10, 35, 15, 9, 20};
        TreeRoot root = new TreeRoot();
        for (int i = 0; i < arrays.length; i++) {
            createTree(root,arrays[i]);
        }
        /*
            二叉树排
            先序(根->左->右),中序(左->根->右),后序(左->右->根)
            如果访问有孩子的节点，先处理孩子的，随后返回
        */
        //先序(根->左->右),中序(左->根->右),后序(左->右->根) 如果访问有孩子的节点，先处理孩子的，随后返回
        preTraverseBTree(root.getTreeRoot());
        System.out.println("======================");
        //中序(左->根->右) 如果访问有孩子的节点，先处理孩子的，随后返回
        inTraverseBTree(root.getTreeRoot());
        System.out.println("======================");
        //后序(左->右->根) 如果访问有孩子的节点，先处理孩子的，随后返回
        //endTraverseBTree(root.getTreeRoot());

        System.out.println(getHeight(root.getTreeRoot()));
        System.out.println(getNodeNumRec(root.getTreeRoot()));
    }

}

/*
        10
        9
        20
        15
        35
        ======================
        9
        10
        15
        20
        35
        ======================
        9
        15
        20
        35
        10
*/

