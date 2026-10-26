def solution(quiz):
    answer = []
    
    for q in quiz:
        tks = q.split()
        
        res = 0
        if tks[1]=='+':
            res = int(tks[0]) + int(tks[2])
        else:
            res = int(tks[0]) - int(tks[2])
            
        if res==int(tks[4]):
            answer.append('O')
        else:
            answer.append('X')
            
    return answer