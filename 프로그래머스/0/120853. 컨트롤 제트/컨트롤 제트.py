def solution(s):
    li = []
    for c in s.split():
        if c=='Z':
            li.pop()
        else:
            li.append(int(c))
    return sum(li)