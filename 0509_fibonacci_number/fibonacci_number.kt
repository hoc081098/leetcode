class Solution {
    fun fib(n: Int): Int = generateSequence(0 to 1) { (a, b) -> b to a + b }
        .elementAt(n)
        .first
}
