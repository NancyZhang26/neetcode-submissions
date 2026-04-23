class Solution:
    def trap(self, height: List[int]) -> int:
        output = 0
        maxLeft = 0
        maxRight = 0
        if height == None or len(height) == 0:
            return output
        
        l = 0
        r = len(height)-1

        while (l < r):
            maxLeft = max(maxLeft, height[l])
            maxRight = max(maxRight, height[r])

            if (maxLeft < maxRight):
                l += 1
                maxLeft = max(maxLeft, height[l])
                output += maxLeft - height[l]
            else:
                r -= 1
                maxRight = max(maxRight, height[r])
                output += maxRight - height[r]

        return output