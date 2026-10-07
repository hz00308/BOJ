def solution(numbers, target):
    answer = 0
    
    def backtrack(curr, idx):
        nonlocal answer
        if idx==len(numbers):
            if curr==target:
                answer+=1
            return
        backtrack(curr + numbers[idx], idx+1)
        backtrack(curr - numbers[idx], idx+1)
    
    backtrack(0, 0)
    return answer