class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        map1 = dict()
        map2 = dict()

        for char in s:
            if char not in map1:
                map1[char] = 1
            else:
                freq = map1[char]+1
                map1[char] = freq

        for char in t:
            if char not in map2:
                map2[char] = 1
            else:
                freq = map2[char]+1
                map2[char] = freq

        return map1 == map2