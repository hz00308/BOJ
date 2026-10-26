def solution(n):
    answer = []
    num = 2
    while num <= n:
        if n%num == 0:
            answer.append(num)
            while n % num == 0:
                n//=num
        num+=1
    return answer