class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        helper = dict()
        l = 0
        r = 0
        start = 0
        end = 0
        biggest = 0
        while (r < len(s)):
            if (s[r]) in helper.keys():
                start = max(helper[s[r]]+1, start)
            helper[s[r]] = r
            r+=1
            end+=1
            biggest = max(biggest, len(s[start:end]))
        return biggest