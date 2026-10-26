def solution(num, k):
    ans = str(num).find(str(k))
    return -1 if ans==-1 else ans+1