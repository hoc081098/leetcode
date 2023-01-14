/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

typealias Acc = TreeMap<Int, MutableList<Int>>

class Solution {
    val levelOrderBottom = { root: TreeNode? ->
        fun traverse(root: TreeNode?, level: Int, acc: Acc) {
            root ?: return
            acc.getOrPut(level) { ArrayList() }.add(root.`val`)
            traverse(root.left, level+1, acc)
            traverse(root.right, level+1, acc)
        }
        Acc(reverseOrder()).also { traverse(root, 0, it) }.values.toList()
    }
}
