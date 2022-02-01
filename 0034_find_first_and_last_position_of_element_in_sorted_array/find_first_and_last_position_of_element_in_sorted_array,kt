class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray = intArrayOf(find(nums, target), find(nums, target, false))
    
    private fun find(nums: IntArray, target: Int, first: Boolean = true): Int {
        var l = 0
        var r = nums.lastIndex
        
        while(l <= r) {
            val m = l + (r - l) / 2
            when {
                target < nums[m] -> r = m - 1
                target > nums[m] -> l = m + 1
                else -> if (first) r = if (m - 1 in nums.indices && nums[m - 1] == target) m - 1 else return m
                        else       l = if (m + 1 in nums.indices && nums[m + 1] == target) m + 1 else return m
            }
        }
        return -1
    }
}
