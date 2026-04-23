class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        map = dict()
        
        for num in nums:
            if num in map:
                map[num] += 1
            else:
                map[num] = 1
        
        helper = list()

        for key, val in map.items():
            helper.append((val, key)) # tuple
        
        helper.sort(key = lambda x: x[0], reverse=True)

        output = list()

        for i in range(k):
            output.append(helper[i][1])

        return output

