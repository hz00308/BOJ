def solution(my_string, overwrite_string, s):
    answer = list(my_string)
    for i in list(overwrite_string):
        answer[s] = i
        s+=1
    return ''.join(answer)