class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        l1 = len(word1)
        l2 = len(word2)
        s = ""
        for i in range(max(l1,l2)):
            if l1>i:
                s = s + word1[i]
            if l2>i:
                s = s+word2[i]
        return s
            