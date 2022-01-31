class Solution {
    fun lengthOfLongestSubstring(s: String): Int = 
        s.indices
            .map { i ->
                val set = mutableSetOf<Char>()
                (i until s.length).takeWhile { set.add(s[it]) }.count()
            }
            .max() ?: 0
}
