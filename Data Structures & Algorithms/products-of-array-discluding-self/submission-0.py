class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        output = list()
        for i in range(len(nums)):
            ans = 1
            for j in range(len(nums)):
                if i != j:
                    ans *= nums[j]
            output.append(ans) # append not add
        return output