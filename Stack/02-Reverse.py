from collections import deque

# Using another stack
def reverse1(stack):
    stack1 = deque()
    while stack:
        stack1.append(stack.pop())
    stack.clear()
    stack.extend(stack1)

# Using Recursion
def putLast(stack,x):
    if len(stack) == 0:
        stack.append(x)
        return
    top = stack.pop()
    putLast(stack,x)
    stack.append(top)

def reverse2(stack):
    if len(stack) == 0:
        return
    top = stack.pop()
    reverse2(stack)
    putLast(stack,top)

if __name__ == "__main__":
    stack = deque([1,2,3])
    reverse2(stack)
    print(stack)