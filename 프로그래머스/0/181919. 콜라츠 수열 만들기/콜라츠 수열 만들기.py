def solution(n):
    answer = [n]
    while True:
        top = answer[-1]
        if top==1:
            break
        if top%2==0:
            answer.append(top//2)
        else:
            answer.append(3*top + 1)
    return answer