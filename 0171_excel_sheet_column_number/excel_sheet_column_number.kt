class Solution {
  fun titleToNumber(s: String): Int = s.map { it - 'A' + 1 }.fold(0) { acc, e -> acc * 26 + e }
}
