class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        visited = {}
        for i in range(len(nums)):
            n = nums[i]
            complement = target - n
            if complement in visited:
                return [visited[complement], i]
            else:
                visited[n] = i
        return []
        