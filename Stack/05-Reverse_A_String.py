from collections import deque

def rev(str):
    stack = deque()
    for i in range(len(str)):
        stack.append(str[i])
    str2 = ""
    while(len(stack) != 0):
        str2 = str2 + stack.pop()
    return str2

if __name__=="__main__":
    str = "sohamsangole"
    str2 = rev(str)
    print(str2)