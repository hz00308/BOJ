def solution(n):
    if n%2==1:
        return sum(range(1, n+1, 2))
    else:
        ans = 0
        for i in range(2, n+1, 2):
            ans += i*i
        return ans