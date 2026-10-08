def solution(brown, yellow):
    
    total = brown + yellow
    for h in range(3, int(total**0.5) + 1):
        if total%h == 0:
            w = total//h
            if yellow == (w-2)*(h-2):
                return [w, h]

"""
가로 >= 세로 
가로, 세로는 최소 3 
---
갈색 개수 = (가로+세로)*2 - 4
노랑 개수 = (가로-2)*(세로-2)
"""