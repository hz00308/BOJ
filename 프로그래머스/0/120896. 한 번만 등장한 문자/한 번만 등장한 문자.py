def solution(s):
    answer = ''
    di = {}
    for c in s:
        if c not in di:
            di[c] = 1
        else:
            di[c]+=1
    li = sorted([k for k, v in di.items() if v==1])
    return ''.join(li)