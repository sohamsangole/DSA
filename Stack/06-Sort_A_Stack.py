from collections import deque

def sortStack(stack):
    if len(stack) == 0:
        return  
    num = stack.pop()  
    sortStack(stack)  
    insertSorted(stack, num)  

def insertSorted(stack, num):
    if len(stack) == 0 or stack[-1] <= num:  
        stack.append(num)  
        return
    x = stack.pop()  
    insertSorted(stack, num)  
    stack.append(x)  

if __name__=="__main__":
    stack = deque([3, 2, 1, 4, 5, 6, 0])
    sortStack(stack)
    print(stack)  
