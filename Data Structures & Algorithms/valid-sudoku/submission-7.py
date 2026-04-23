class Solution:
    def isValidSudoku(self, nums: List[List[str]]) -> bool:
        rows = collections.defaultdict(set) # Auto creates a set if the key does not exist
        cols = collections.defaultdict(set)
        grids = collections.defaultdict(set) # key is a pair: row, grid

        for i in range(0, 9):
            for j in range(0, 9):
                if nums[i][j] in rows[i] and nums[i][j] != '.':
                    return False
                if nums[i][j] in cols[j] and nums[i][j] != '.':
                    return False
                if nums[i][j] in grids[(i//3, j//3)] and nums[i][j] != '.':
                    return False
                if nums[i][j] != '.':
                    rows[i].add(nums[i][j])
                    cols[j].add(nums[i][j])
                    grids[(i//3, j//3)].add(nums[i][j])
        return True