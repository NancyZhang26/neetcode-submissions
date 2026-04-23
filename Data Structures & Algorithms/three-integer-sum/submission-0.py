class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        output = set() # Does not allow dupes
        nums.sort() # So the tuples will all be in non-decreasing order
        for i in range(0, len(nums)):
            for j in range(i+1, len(nums)):
                for k in range(j+1, len(nums)):
                    if nums[i]+nums[j]+nums[k]==0:
                        add = list([nums[i],nums[j],nums[k]])
                        output.add(tuple(add))
        return list([list(numbers) for numbers in output])
    