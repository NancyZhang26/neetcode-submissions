class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        arr = list(s1)
        arr.sort()
        mod = ''.join(arr)

        for i in range(0, len(s2)):
            for j in range(i, len(s2)):
                arr2 = list(s2[i:j+1])
                arr2.sort()
                comp = ''.join(arr2)
                if mod == comp:
                    return True
        return False