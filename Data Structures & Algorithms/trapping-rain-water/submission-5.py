class Solution:
    def trap(self, height: List[int]) -> int:
        output = 0

        if height == None or len(height) == 0:
            return output

        for i in range(0, len(height)):
            leftMax = height[i]
            rightMax = height[i]

            for j in range(0, i): # Remember the end is not inclusive
                leftMax = max(leftMax, height[j])

            for j in range(i+1, len(height)):
                rightMax = max(rightMax, height[j])
            
            output = output + min(leftMax, rightMax) - height[i]

        return output