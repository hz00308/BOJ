def solution(a, b, c, d):
    dice = [0]*7
    answer = 0
    for i in (a, b, c, d):
        dice[i] +=1
    
    if 4 in dice:
        answer = 1111 * dice.index(4)
    elif 3 in dice:
        answer = (10 * dice.index(3) + dice.index(1))**2
    elif 2 in dice:
        if dice.count(2)==2:
            p = dice.index(2)
            q = dice.index(2, p+1)
            answer = (p+q)*abs(p-q)
        else:
            q = dice.index(1)
            r = dice.index(1, q+1)
            answer = q*r
    else:
        answer = min(a, b, c, d)
    return answer