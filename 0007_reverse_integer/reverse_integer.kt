class Solution {
    fun reverse(x: Int): Int = runCatching { 
        if (x < 0) -reverse(-x)
        else x.toString().reversed().toInt()
    }.getOrElse { 0 }
}
