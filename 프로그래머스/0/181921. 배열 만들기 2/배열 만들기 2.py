def solution(l, r):
    answer = []
    for i in range(l, r+1):
        if i%5!=0: continue
        temp = set(str(i))
        temp.add('0')
        if temp == {'0', '5'}:
            answer.append(i)
    return answer if answer else [-1]