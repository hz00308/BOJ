from collections import deque
def solution(priorities, location):
    q = deque(enumerate(priorities))
    cnt = 0
    while q:
        max_pri = max(p for _, p in q)
        idx, pri = q.popleft()
        if pri == max_pri:
            cnt+=1
            if idx == location:
                return cnt
        else:
            q.append((idx, pri))

"""
(초기 인덱스, 우선순위) deque 만들기 
deque에서 max를 구하기
popleft해서 우선순위 max가 아니면 append하기 
max이면 실행된 것! cnt 증가. 이때, 초기 인덱스가 location이면 cnt 리턴. 
"""