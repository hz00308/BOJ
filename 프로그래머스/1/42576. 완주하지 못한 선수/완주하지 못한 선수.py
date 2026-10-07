def solution(participant, completion):
    # dictionary 이름: 숫자
    p = {}
    for name in participant:
        p[name] = p.get(name, 0) + 1
    for name in completion: 
        p[name]-=1
    for name, num in p.items():
        if num == 1:
            return name