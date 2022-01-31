private const val SIZE = 9
private val INDICES = 0 until SIZE
private val CHAR_RANGE = '1'..'9'
private typealias Board = Array<CharArray>

class Solution {
    fun solveSudoku(board: Board): Unit = solve(board, 0, 0).let { }
    
    private fun solve(a: Board, col: Int, row: Int): Boolean {
        when {
            col > SIZE - 1 -> return if (row < SIZE - 1) solve(a, 0, row + 1) else true
            a[row][col] == '.' -> {
                for (next in CHAR_RANGE) {
                    if (check(a, col, row, next)) {
                        a[row][col] = next
                        if (solve(a, col + 1, row)) return true
                        a[row][col] = '.'
                    }
                }
            }
            else -> return solve(a, col + 1, row)
        }
        return false
    }
    
    private fun check(a: Board, col: Int, row: Int, next: Char): Boolean = 
        (next !in a[row])
            && INDICES.all { a[it][col] != next }
            && (row / 3 * 3 until row / 3 * 3 + 3).all { r ->
                (col / 3 * 3 until col / 3 * 3 + 3).all { a[r][it] != next }
            }
}
