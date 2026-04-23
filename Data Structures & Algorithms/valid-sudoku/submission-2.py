class Solution:
    def isValidSudoku(self, nums: List[List[str]]) -> bool:
        for i in range(0, len(nums)):
            helper = set()
            for j in range(0, len(nums[i])): # Check the rows
                if nums[i][j] != '.' and nums[i][j] in helper:
                    return False
                elif nums[i][j] != '.':
                    helper.add(nums[i][j])
            
            helper2 = set()
            for j in range(0, len(nums[i])): # Check the columns
                if nums[j][i] != '.' and nums[j][i] in helper2:
                    return False
                elif nums[j][i] != '.':
                    helper2.add(nums[j][i])
                
        for i in range(0, len(nums), 3):
            for j in range(0, len(nums[i]), 3): # Check the 3*3
                helper = set()
                for k in range(i, i+3):
                    for n in range(j, j+3):
                        if nums[k][n] != '.' and nums[k][n] in helper:
                            return False
                        elif nums[k][n] != '.':
                            helper.add(nums[k][n])
        return True