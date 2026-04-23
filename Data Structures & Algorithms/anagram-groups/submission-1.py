class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        map = dict()
        for str in strs:
            chars = list(str)
            chars.sort()
            key = ''.join(chars)

            if key not in map:
                map[key] = list()
            map[key].append(str)
        return list(map.values())