class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        st = list()
        for i in range(0, len(tokens)):
            if tokens[i] == '+':
                st.append(int(st.pop()) + int(st.pop()))
            elif tokens[i] == '-':
                a = int(st.pop())
                b = int(st.pop())
                st.append(b-a)
            elif tokens[i] == '*':
                st.append(int(st.pop()) * int(st.pop()))
            elif tokens[i] == '/':
                a = int(st.pop())
                b = int(st.pop())
                st.append(b/a)
            else:
                st.append(tokens[i])
        return int(st.pop())