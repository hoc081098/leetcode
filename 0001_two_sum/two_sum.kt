class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val indexed = nums.zip(nums.indices)
        val map = indexed.toMap()

        return indexed
            .mapNotNull { (v, i) ->
                map[target - v]
                    ?.takeIf { it != i } 
                    ?.let { intArrayOf(i, it) }
            }
            .first()
    }
}
