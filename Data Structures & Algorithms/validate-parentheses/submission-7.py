class Solution:
    def isValid(self, s: str) -> bool:
        st = []
        map = dict()
        map.setdefault('}','{')
        map.setdefault(']','[')
        map.setdefault(')','(')
        for i in range(0, len(s)):
            if s[i] == ']' or s[i] == '}' or s[i] == ')':
                if len(st) != 0 and st[-1] == map.get(s[i]):
                    st.pop()
                else:
                    return False
            else:
                st.append(s[i])
        return len(st)==0
