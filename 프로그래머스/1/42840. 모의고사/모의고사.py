def solution(answers):
    questions = len(answers)
    first = [1, 2, 3, 4, 5] * (questions//5 + 1) 
    second = [2, 1, 2, 3, 2, 4, 2, 5] * (questions//8 + 1)
    third = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5] * (questions//10 + 1)
    
    first_ans = 0
    second_ans = 0
    third_ans = 0
    
    for ans, f, s, t in zip(answers, first, second, third):
        if ans==f:
            first_ans+=1
        if ans==s:
            second_ans+=1
        if ans==t:
            third_ans+=1
    
    answer = []
    max_score = max(first_ans, second_ans, third_ans)
    if max_score==first_ans:
        answer.append(1)
    if max_score==second_ans:
        answer.append(2)
    if max_score==third_ans:
        answer.append(3)
    return answer