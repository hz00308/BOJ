def solution(nums):
    N2 = len(nums)//2
    types =  len(set(nums))
    return min(N2, types)
"""
N마리 중 N/2 가져가도 됨
같은 종류 => 같은 번호 
최대한 많은 종류를 포함해서 N/2 선택하려 함 

nums: 번호 담긴 리스트 
N/2마리 선택하는 방법 중 가장 많은 종류를 선택하는 방법 => 종류 번호 개수 리턴 
---
N/2, 종류 수 구하기 
종류 수 >= N/2이면 답은 N/2
종류 수 < N/2 이면 답은 종류 수 

"""