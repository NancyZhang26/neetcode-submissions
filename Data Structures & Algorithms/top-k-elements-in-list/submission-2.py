class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        
        map = dict()
        for num in nums:
            if num not in map:
                map[num] = 1
            else:
                map[num] += 1

        helper = list();

        for key, val in map.items():
            helper.append((val, key))

        helper.sort(key=lambda x: x[0], reverse=True)

        output = list()
        for num in range(k):
            output.append(helper[num][1])

        return output

