from heapq import heapify, heappush, heappop
def solution(N, road, K):
    
    # 인접리스트
    graph = [[] for _ in range(N+1)]
    for r in road:
        a, b, c = r
        graph[a].append((b, c)) # (마을, 비용)
        graph[b].append((a, c))
    
    dist = [float('inf')]*(N+1)
    dist[1] = 0
    
    h = [] # (비용, 마을)
    heappush(h, (0, 1))
    
    while h:
        cdist, cnode = heappop(h)
        if dist[cnode] < cdist: 
            continue
        for nnode, weight in graph[cnode]:
            cost = cdist + weight
            
            if cost < dist[nnode]:
                dist[nnode] = cost
                heappush(h, (cost, nnode))
    
    answer = 0
    for num in dist:
        if num <= K:
            answer+=1
    return answer

"""
N개의 마을 중 K시간 이하로 배달이 가능한 마을만 주문 받음 => 개수 리턴 
road 원소: (마을, 마을, 시간)
두 마을을 연결하는 도로는 여러 개 가능
"""