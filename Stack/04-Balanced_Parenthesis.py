from collections import deque

def checkParenthesis(str):
    stack1 = deque()
    for i in range(len(str)):
        print(stack1)
        if str[i] == '{' or str[i] == '(' or str[i] == '[':
            stack1.append(str[i])
        else:
            if len(stack1) == 0: return False
            top = stack1.pop()
            if (str[i] == '}' and top != '{') or (str[i] == ')' and top != '(') or (str[i] == ']' and top != '['):
                return False
    return len(stack1) == 0
        

if __name__=="__main__":
    str = "{{{(((])))}}}"
    print(checkParenthesis(str))