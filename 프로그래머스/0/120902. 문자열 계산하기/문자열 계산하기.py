def solution(my_string):
    tks = my_string.split()
    answer = int(tks[0])
    for i in range(1, len(tks), 2):
        if tks[i]=='+':
            answer+=int(tks[i+1])
        else:
            answer-=int(tks[i+1])
    return answer