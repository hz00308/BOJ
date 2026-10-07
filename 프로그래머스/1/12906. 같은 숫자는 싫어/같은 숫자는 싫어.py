def solution(arr):
    answer = []
    for num in arr:
        if not answer: # 비어 있음
            answer.append(num)
            continue
        # 하나라도 있음
        if num == answer[-1]: # top과 동일함 
            continue
        else:
            answer.append(num)
    return answer