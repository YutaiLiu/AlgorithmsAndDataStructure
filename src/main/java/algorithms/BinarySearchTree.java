package algorithms;

public class BinarySearchTree {

    class Node {
        int key;
        String value;
        Node left, right;

        public Node(int key, String value) {
            this.key = key;
            this.value = value;
        }

        public Node min() {
            if (left == null) {
                return this;
            } else {
                return left.min();
            }
        }
    }

    Node root;

    public BinarySearchTree() {
        root = null;
    }

    public String find(int key) {
        Node node = find(root, key);
        return node == null ? null : node.value;
    }

    private Node find(Node node, int key) {
        if (node == null || node.key == key) {
            return node;
        } else if (node.key > key) {
            return find(node.left, key);
        } else {
            return find(node.right, key);
        }
    }

    // Insert
    public void insert(int key, String value) {
        root = insertItem(root, key, value);
    }

    public Node insertItem(Node node, int key, String value) {
        if (node == null) {
            node = new Node(key, value);
            return node;
        } else if (node.key > key) {
            node.left = insertItem(node.left, key, value);
        } else {
            node.right = insertItem(node.right, key, value);
        }

        return node;
    }

    // Delete: Three cases
    // 1. No child
    // 2. One child
    // 3. Two children

    // First two are simple. Third is more complex.

    // Case 1: No child - simply remove from tree by nulling it.
    //
    // Case 2: One child - copy the child to the node to be deleted and delete the child

    // Case 3: Two children - re-gig the tree to turn into a Case 1 or a Case 2

    // For third case we first need to
    // 1. Find the right side min
    // 2. Copy it to the node we want to delete (creating a duplicate)
    // 3. Then delete the min value way down on the branch we just copied
    //
    // This works because you can represent a binary tree in more than one way.
    // Here we are taking advantage of that fact to make our more complicated
    // 3rd case delete more simple by transforming it into case 1.

    // Step 1: Create a minvalue function
    public int findMinKey() {
        return findMin(root).key;
    }

    public Node findMin(Node node) {
        Node min = node.min();
        return min;
    }

    public void delete(int key) {
        root = delete(root, key);
    }

    public Node delete(Node node, int key) {
        if (node == null) {
            return null;
        } else if (node.key > key) {
            node.left = delete(node.left, key);
        } else if (node.key < key) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null && node.right == null) {
                return null;
            } else if (node.left != null) {
                node = node.left;
            } else if (node.right != null) {
                node = node.right;
            } else {
                Node minNode = findMin(node.right);
                node.key = minNode.key;
                node.value = minNode.value;
                node.right = delete(node.right, node.key);
            }
        }

        return node;
    }

    // Print
    public void printInOrderTraversal() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.println(node.key);
            inOrderTraversal(node.right);
        }
    }

    public void printPreOrderTraversal() {
        preOrderTraversal(root);
    }

    private void preOrderTraversal(Node node) {
        if (node != null) {
            System.out.println(node.key); // root
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    public void printPostOrderTraversal() {
        postOrderTraversal(root);
    }

    private void postOrderTraversal(Node node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.println(node.key);
        }
    }

    public void prettyPrint() {
        // Hard coded print out of binary tree depth = 3

        int rootLeftKey = root.left == null ? 0 : root.left.key;
        int rootRightKey = root.right == null ? 0 : root.right.key;

        int rootLeftLeftKey = 0;
        int rootLeftRightKey = 0;

        if (root.left != null) {
            rootLeftLeftKey = root.left.left == null ? 0 : root.left.left.key;
            rootLeftRightKey = root.left.right == null ? 0 : root.left.right.key;
        }

        int rootRightLeftKey = 0;
        int rootRightRightKey = 0;

        if (root.right != null) {
            rootRightLeftKey = root.right.left == null ? 0 : root.right.left.key;
            rootRightRightKey = root.right.right == null ? 0 : root.right.right.key;
        }

        System.out.println("     " + root.key);
        System.out.println("   /  \\");
        System.out.println("  " + rootLeftKey + "    " + rootRightKey);
        System.out.println(" / \\  / \\");
        System.out.println(rootLeftLeftKey + "  " + rootLeftRightKey + " " + rootRightLeftKey + "   " + rootRightRightKey);
    }

    // Bonus: This method checks to see if this node is a BST
    boolean checkBST(Node root) {

        // left smaller
        boolean leftOK = false;

        if (root.left != null) {
            if (root.left.key < root.key) {
                leftOK = true;
            }
        } else {
            leftOK = true;
        }

        // right larger
        boolean rightOK = false;

        if (root.right != null) {
            if (root.right.key > root.key) {
                rightOK = true;
            }
        } else {
            rightOK = true;
        }

        // get distinct check for free via <>
        return leftOK && rightOK;
    }
}