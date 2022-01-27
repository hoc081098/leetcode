/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

typealias Seq<T> = Sequence<T>

internal inline fun ListNode.asSeq() = generateSequence(this) { it.next }.map { it.`val` }

internal fun Seq<Pair<Int, Int>>.toListNode() : ListNode? {
    var head = null as ListNode?
    var l = 0

    fold(null as ListNode?) { tail, (r, v) ->
        ListNode(v).also {
            tail?.next = it
            head = head ?: it
            l = r
        }
    }?.next = if (l > 0) ListNode(l) else null
    
    return head
}

class Solution {
    fun addTwoNumbers(l1: ListNode, l2: ListNode): ListNode? = 
        alignSum(l1.asSeq(), l2.asSeq())
            .scan(0 to 0) { (reminder), sum ->
                (reminder + sum).let { (it / 10) to (it % 10) }
            }
            .drop(1)
            .toListNode()
}

fun alignSum(ls: Seq<Int>, rs: Seq<Int>) = sequence {
    val l = ls.iterator()
    val r = rs.iterator()
    
    while (l.hasNext() && r.hasNext()) yield(l.next() + r.next())
    while (l.hasNext()) yield(l.next())
    while (r.hasNext()) yield(r.next())
}

// Because [scan] is only available since Kotlin 1.4.0 (leetcode is using Kotlin < 1.4.0)
fun <T, R> Seq<T>.scan(r: R, f: (acc: R, T) -> R) = sequence {
    var acc = r.also { yield(it) }
    for (e in this@scan) yield(f(acc, e).also { acc = it })
}
