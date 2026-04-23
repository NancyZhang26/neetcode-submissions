class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        output = 0
        helper = dict()
        l = 0
        maxf = 0
        for r in range(0, len(s)):
            helper[s[r]] = 1 + helper.get(s[r], 0)
            maxf = max(maxf, helper[s[r]])
            while (r-l+1)-maxf > k:
                helper[s[l]]-=1
                l+=1
            output = max(output, r-l+1)
        return output 