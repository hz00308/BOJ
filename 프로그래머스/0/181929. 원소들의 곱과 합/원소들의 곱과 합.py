def solution(num_list):
    mul = 1
    for i in num_list:
        mul *= i
    
    sum2 = sum(num_list)**2
    
    return 1 if mul < sum2 else 0