public class TreeNode {
    public String key;
    public String value;
    public TreeNode left, right;

    public TreeNode(String key, String value) {
        this.key = key;
        this.value = value;
        this.left = this.right = null;
    }
}