class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        for i in range(0, len(numbers)):
            for j in range(i, len(numbers)):
                if numbers[i]+numbers[j]==target:
                    return list([i+1, j+1])
        return null