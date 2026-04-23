class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        map = {}
        for num in nums:
            map[num] = map.get(num, 0)+1
        
        list = [[] for i in range(len(nums)+1)]

        for key, val in map.items():
            list[val].append(key)

        res = []
        for i in range(len(list)-1, 0, -1):
            for val in list[i]:
                res.append(val)
                if len(res) == k:
                    return res