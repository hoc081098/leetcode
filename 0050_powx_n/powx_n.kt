class Solution {
    fun myPow(x: Double, n: Int): Double = when {
        n < 0 -> 1 / (x * myPow(x, -n - 1))
        n == 0 -> 1.0
        else -> myPow(x, n shr 1).let {
            it * it * (if (n and 1 != 0) x else 1.0)
        }
    }
}
