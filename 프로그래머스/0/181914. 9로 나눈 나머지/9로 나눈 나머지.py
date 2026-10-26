def solution(number):
    total = 0
    for n in number:
        total += int(n)
    return total%9