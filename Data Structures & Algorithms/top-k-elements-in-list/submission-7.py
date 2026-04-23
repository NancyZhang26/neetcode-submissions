class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        map = dict()

        for num in nums:
            map[num] = map.get(num, 0)+1
        
        bucket = [[] for i in range(len(nums)+1)]

        for key, val in map.items():
            bucket[val].append(key)

        output = list()
        for i in range(len(bucket)-1, -1, -1):
            for n in range(len(bucket[i])):
                output.append(bucket[i][n])
                if len(output) == k:
                    return output

