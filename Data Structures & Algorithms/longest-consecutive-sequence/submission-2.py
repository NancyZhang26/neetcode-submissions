class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        lookup = set(nums)
        output = 0
        for num in nums:
            if num-1 not in lookup: # Starting point found
                length = 0
                while num+length in lookup:
                    length += 1
                output = max(output, length)

        return output