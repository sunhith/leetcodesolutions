class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        l1 = len(word1)
        l2 = len(word2)
        i=0
        j=0
        s = ""
        while(i < l1 and j <l2):
            s = s + word1[i]+word2[j]
            i = i+1
            j = j+1
        while i < l1:
            s = s+ word1[i]
            i = i + 1
        while j < l2:
            s = s+word2[j]
            j = j+1
        return s
            