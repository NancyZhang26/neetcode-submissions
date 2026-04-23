class Solution:
    def maxArea(self, nums: List[int]) -> int:
        biggest = 0
        for i in range(0, len(nums)):
            for j in range(i+1, len(nums)):
                num = min(nums[i], nums[j])
                width = j-i
                area = num*width
                if area > biggest:
                    biggest = area
        return biggest