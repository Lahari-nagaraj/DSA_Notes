public class bascics {
    import java.util.*;

public class TreeMetrics {
    // --------- Basic Binary Tree Node -----------
    static class Node {
        int val;
        Node left, right;
        Node(int v) { this.val = v; }
    }

    // ---------- Size / Counts ----------
    public static int size(Node root) {
        if (root == null) return 0;
        return 1 + size(root.left) + size(root.right);
    }

    public static int countLeaves(Node root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return countLeaves(root.left) + countLeaves(root.right);
    }

    public static int countInternal(Node root) {
        // Internal = nodes with at least one child
        if (root == null) return 0;
        int left = countInternal(root.left);
        int right = countInternal(root.right);
        boolean internal = (root.left != null) || (root.right != null);
        return (internal ? 1 : 0) + left + right;
    }

    public static int countFullNodes(Node root) {
        // Full nodes = nodes with two children
        if (root == null) return 0;
        int left = countFullNodes(root.left);
        int right = countFullNodes(root.right);
        int self = (root.left != null && root.right != null) ? 1 : 0;
        return self + left + right;
    }

    public static int countSingleChild(Node root) {
        // Exactly one child
        if (root == null) return 0;
        int left = countSingleChild(root.left);
        int right = countSingleChild(root.right);
        boolean one = (root.left == null) ^ (root.right == null);
        return (one ? 1 : 0) + left + right;
    }

    public static int sum(Node root) {
        if (root == null) return 0;
        return root.val + sum(root.left) + sum(root.right);
    }

    // ---------- Height / Depth ----------
    // Height (in nodes): #nodes on longest root-to-leaf path
    public static int heightNodes(Node root) {
        if (root == null) return 0;
        return 1 + Math.max(heightNodes(root.left), heightNodes(root.right));
    }

    // Height (in edges): longest root-to-leaf edges; empty tree = -1, single node = 0
    public static int heightEdges(Node root) {
        if (root == null) return -1;
        return 1 + Math.max(heightEdges(root.left), heightEdges(root.right));
    }

    // Max depth (same as height in nodes)
    public static int maxDepth(Node root) { return heightNodes(root); }

    // Min depth (shortest root-to-leaf path in nodes)
    public static int minDepth(Node root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        if (root.left == null) return 1 + minDepth(root.right);
        if (root.right == null) return 1 + minDepth(root.left);
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    // ---------- Diameter ----------
    // Diameter in nodes: max #nodes on any path between two nodes
    public static int diameterNodes(Node root) {
        return diameterHelper(root).diameterNodes;
    }

    // Diameter in edges = diameterNodes - 1 (if tree non-empty), else 0 for empty
    public static int diameterEdges(Node root) {
        int dn = diameterNodes(root);
        if (dn == 0) return 0;
        return dn - 1;
    }

    private static class DiaInfo {
        int heightNodes;     // height in nodes
        int diameterNodes;   // diameter in nodes
        DiaInfo(int h, int d) { heightNodes = h; diameterNodes = d; }
    }
    private static DiaInfo diameterHelper(Node root) {
        if (root == null) return new DiaInfo(0, 0);
        DiaInfo L = diameterHelper(root.left);
        DiaInfo R = diameterHelper(root.right);
        int height = 1 + Math.max(L.heightNodes, R.heightNodes);
        int throughRoot = L.heightNodes + 1 + R.heightNodes; // nodes along path L-leaf -> root -> R-leaf
        int best = Math.max(Math.max(L.diameterNodes, R.diameterNodes), throughRoot);
        return new DiaInfo(height, best);
    }

    // ---------- Balance / Completeness ----------
    // Height-balanced (AVL): |hl - hr| <= 1 for every node
    public static boolean isBalanced(Node root) {
        return balanceHeight(root) != -1;
    }
    // returns height if balanced else -1
    private static int balanceHeight(Node root) {
        if (root == null) return 0;
        int lh = balanceHeight(root.left);
        if (lh == -1) return -1;
        int rh = balanceHeight(root.right);
        if (rh == -1) return -1;
        if (Math.abs(lh - rh) > 1) return -1;
        return 1 + Math.max(lh, rh);
    }

    // Complete Binary Tree check (level-order, no gaps before end)
    public static boolean isComplete(Node root) {
        if (root == null) return true;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        boolean seenNull = false;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur == null) {
                seenNull = true;
            } else {
                if (seenNull) return false; // found a node after a null in level order
                q.add(cur.left);
                q.add(cur.right);
            }
        }
        return true;
    }

    // ---------- Width / Level Order ----------
    public static int maxWidth(Node root) {
        if (root == null) return 0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int max = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            max = Math.max(max, sz);
            for (int i = 0; i < sz; i++) {
                Node n = q.poll();
                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
            }
        }
        return max;
    }

    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int sz = q.size();
            List<Integer> level = new ArrayList<>(sz);
            for (int i = 0; i < sz; i++) {
                Node n = q.poll();
                level.add(n.val);
                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
            }
            res.add(level);
        }
        return res;
    }

    // ---------- Optional: BST-only helpers ----------
    // If your tree is a BST and you want to verify:
    public static boolean isBST(Node root) {
        return isBSTRange(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private static boolean isBSTRange(Node root, long lo, long hi) {
        if (root == null) return true;
        if (root.val <= lo || root.val >= hi) return false;
        return isBSTRange(root.left, lo, root.val) && isBSTRange(root.right, root.val, hi);
    }

    // ---------- Demo ----------
    public static void main(String[] args) {
        /*
                 10
               /    \
              5      20
             / \    /  \
            3   7  15  30
                   /
                  12
        */
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(20);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
        root.right.left = new Node(15);
        root.right.right = new Node(30);
        root.right.left.left = new Node(12);

        System.out.println("Size (nodes): " + size(root));
        System.out.println("Sum: " + sum(root));
        System.out.println("Leaves: " + countLeaves(root));
        System.out.println("Internal nodes: " + countInternal(root));
        System.out.println("Full nodes (2 children): " + countFullNodes(root));
        System.out.println("Single-child nodes: " + countSingleChild(root));

        System.out.println("Height (nodes): " + heightNodes(root));
        System.out.println("Height (edges): " + heightEdges(root));
        System.out.println("Min depth (nodes): " + minDepth(root));
        System.out.println("Diameter (nodes): " + diameterNodes(root));
        System.out.println("Diameter (edges): " + diameterEdges(root));

        System.out.println("Max width: " + maxWidth(root));
        System.out.println("Is balanced? " + isBalanced(root));
        System.out.println("Is complete? " + isComplete(root));
        System.out.println("Is BST? " + isBST(root));

        System.out.println("Level order: " + levelOrder(root));
    }
}

}
