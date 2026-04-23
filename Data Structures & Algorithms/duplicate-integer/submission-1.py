class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        map = dict()
        for item in nums:
            if item in map:
                return True
            else:
                map[item] = 1
        return False