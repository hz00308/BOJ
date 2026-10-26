def solution(numLog):
    key = {1:'w', -1:'s', 10:'d', -10:'a'}
    answer = ''
    for a, b in zip(numLog, numLog[1:]):
        answer += key[b - a]
    return answer