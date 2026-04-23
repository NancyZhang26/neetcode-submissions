class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        map = dict()
        for i in range(len(nums)):
            num = nums[i]
            diff = target - num
            if num in map:
                return [map.get(num), i]
            map[diff] = i
        return [0, 0]