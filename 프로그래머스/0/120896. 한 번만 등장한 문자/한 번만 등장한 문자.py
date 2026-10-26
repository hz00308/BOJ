def solution(s):
    answer = ''
    di = {}
    for c in s:
        di[c] = di.get(c, 0) + 1
    li = sorted([k for k, v in di.items() if v==1])
    return ''.join(li)