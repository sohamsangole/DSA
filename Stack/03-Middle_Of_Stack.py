from collections import deque

def findMiddle(stack):
    n = len(stack)
    if n == 0: 
        print("WOAH")
        return
    m = n//2 if n%2==0 else n//2 + 1
    while(len(stack) > m):
        stack.pop()
    print(stack.pop())

if __name__ == "__main__":
    stack1 = deque([1,2,3,4,5,6,7])
    stack2 = deque([1,2,3,4,5,6])
    stack3 = deque([1])
    stack4 = deque([])
    findMiddle(stack1)
    findMiddle(stack2)
    findMiddle(stack3)
    findMiddle(stack4)