class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        visited = dict()
        for c in s:
            if c in visited:
                visited[c] += 1
            else:
                visited[c] = 1
        for c in t:
            if c in visited:
                visited[c] -= 1
                if visited[c] < 0:
                    return False
            else:
                return False
        return True

        