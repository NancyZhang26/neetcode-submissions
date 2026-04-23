class MinStack:
    def __init__(self):
        self.st = deque()
        self.temp = deque()

    def push(self, val: int) -> None:
        self.st.append(val)
        if not self.temp or val <= self.temp[-1]:
            self.temp.append(val)

    def pop(self) -> None:
        if self.st[-1] == self.temp[-1]:
            self.temp.pop()
        self.st.pop()

    def top(self) -> int:
        return self.st[-1]

    def getMin(self) -> int:
        return self.temp[-1]
