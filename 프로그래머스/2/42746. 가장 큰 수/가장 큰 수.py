def solution(numbers):
    numbers = list(map(str, numbers))
    numbers.sort(key=lambda x: (x*4)[:4], reverse=True)
    answer = ''.join(numbers)
    return '0' if answer[0]=='0' else answer

'''
0 또는 양의 정수 
정수 이어 붙여 만들 수 있는 가장 큰 수 
가장 큰 수 문자열로 리턴 
34 3 30 
'''