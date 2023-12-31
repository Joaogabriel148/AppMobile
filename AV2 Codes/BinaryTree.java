import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BinaryTree {
    private TreeNode root;

    public BinaryTree() {
        this.root = null;
    }

    public void insert(String key, String value) {
        root = insertRec(root, key, value);
    }

    private TreeNode insertRec(TreeNode root, String key, String value) {
        if (root == null) {
            return new TreeNode(key, value);
        }

        if (value.compareTo(root.value) < 0) {
            root.left = insertRec(root.left, key, value);
        } else if (value.compareTo(root.value) > 0) {
            root.right = insertRec(root.right, key, value);
        }

        return root;
    }

    public List<TreeNode> getSortedItems() {
        List<TreeNode> sortedItems = new ArrayList<>();
        inOrderTraversal(root, sortedItems);
        return sortedItems;
    }

    private void inOrderTraversal(TreeNode root, List<TreeNode> sortedItems) {
        if (root != null) {
            inOrderTraversal(root.left, sortedItems);
            sortedItems.add(root);
            inOrderTraversal(root.right, sortedItems);
        }
    }

    public TreeNode[] getRandomItems() {
        List<TreeNode> itemsList = getSortedItems();
        int size = itemsList.size();

        if (size >= 2) {
            Random random = new Random();
            int index1 = random.nextInt(size);
            int index2;

            do {
                index2 = random.nextInt(size);
            } while (index1 == index2);

            return new TreeNode[]{itemsList.get(index1), itemsList.get(index2)};
        } else {
            return new TreeNode[0];
        }
    }

    // Classe TreeNode
    public class TreeNode {
        public String key;
        public String value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(String key, String value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    String findLongestCommonSubsequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int index = dp[m][n];
        char[] lcs = new char[index];

        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                lcs[--index] = str1.charAt(i - 1);
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        return new String(lcs);
    }
}