class Solution:
    def isPalindrome(self, input):
        ref = re.sub(r'[^a-zA-Z0-9]', '', input.lower())
        start = 0
        end = len(ref)-1
        while start < end:
            if ref[start] != ref[end]:
                return False
            start += 1
            end -= 1
        return True
        