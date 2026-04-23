class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        l, r = 0, 0
        output = []
        helper = deque()
        
        while r < len(nums):
            while len(helper)!=0 and nums[helper[-1]] < nums[r]:
                helper.pop()
            helper.append(r)

            if l > helper[0]:
                helper.popleft()
            
            if r+1 >= k:
                output.append(nums[helper[0]])
                l+=1
            r+=1
        return output