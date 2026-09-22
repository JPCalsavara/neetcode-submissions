class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if nums == []:
            return 0
        visited = set(nums)
        maxLength = 0

        for num in nums:
            if (num - 1) not in visited:
                cur_num = num
                length = 1

                while (cur_num + 1) in visited:
                    cur_num += 1
                    length += 1
                
                maxLength = max(maxLength, length)
    
        return maxLength
        