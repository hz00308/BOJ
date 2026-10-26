def solution(sides):
    longest = max(sides)
    sides.remove(longest)
    return 1 if longest < sum(sides) else 2