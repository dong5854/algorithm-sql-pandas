    public int maxLevelSum(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list, 0);
        return 1 + IntStream.range(0, list.size()).reduce(0, (a, b) -> list.get(a) < list.get(b) ? b : a);
    }
    private void dfs(TreeNode n, List<Integer> l, int level) {
        if (n == null) { return; } 
        if (l.size() == level) { l.add(n.val); } // never reach this level before, add first value.
        else { l.set(level, l.get(level) + n.val); } // reached the level before, accumulate current value to old value.
        dfs(n.left, l, level + 1);
        dfs(n.right, l, level + 1);
    }

    class Solution {
    public int maxLevelSum(TreeNode root) {
        
        List<Integer> levels = new ArrayList<>();
        getAns(root, 0, levels);

        return levels.indexOf(Collections.max(levels)) + 1;
    }

    private void getAns(TreeNode node, int level, List<Integer> levels) {
        if (node == null) return;
        if (levels.size() <= level) {
            levels.add(node.val);
        } else {
            levels.set(level, levels.get(level) + node.val);
        }

        getAns(node.left, level + 1, levels);
        getAns(node.right, level + 1, levels);
    }
}