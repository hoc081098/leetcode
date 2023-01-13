class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var curSum = nums[0]
        return nums
            .asSequence()
            .drop(1)
            .fold(nums[0]) { acc, e ->
                curSum = maxOf(e, curSum + e)
                maxOf(acc, curSum)
            }
    }
}
