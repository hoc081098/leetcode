function twoSum(nums: number[], target: number): number[] {
  const map = new Map();
  nums.forEach((e, i) => map.set(e, i));
  
  for (let i in nums) {
    let j = map.get(target - nums[i]);
    if (j !== undefined && j != i) {
      return [i, j];
    }
  }
};
