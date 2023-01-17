/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
import kotlin.sequences.generateSequence as seq

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val p2 = seq(head) { it.next }
            .elementAtOrNull(n)
            ?: return head?.next.also { head?.next = null }
        
        seq(p2.next) { it.next }
            .fold(head) { a, _ -> a?.next }
            ?.let { p -> p.next = p.next?.next?.also { p.next?.next = null } }
        return head
    }
}
