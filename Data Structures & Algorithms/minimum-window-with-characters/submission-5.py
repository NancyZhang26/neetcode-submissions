class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if len(s) < len(t) or t == "":
            return ""

        sCount = dict()
        tCount = dict()

        match = 0
        arr = [-1, -1]

        length = len(s)+1

        l, r = 0, 0

        for i in range(len(t)):
            tCount[t[i]] = 1+tCount.get(t[i], 0)
        
        for i in range(len(s)):
            sCount[s[i]] = 1+sCount.get(s[i], 0)

            if s[i] in tCount and sCount[s[i]] == tCount[s[i]]:
                match+=1

            r = i

            while match == len(tCount):
                if r-l+1 < length:
                    length = r-l+1
                    arr[0] = l
                    arr[1] = r
                
                sCount[s[l]] -= 1
                if s[l] in tCount.keys() and sCount[s[l]] < tCount[s[l]]:
                    match-=1
                l+=1

        return s[arr[0]:arr[1]+1]