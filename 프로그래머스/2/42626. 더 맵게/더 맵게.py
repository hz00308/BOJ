from heapq import heapify, heappush, heappop
def solution(scoville, K):
    answer = 0
    heapify(scoville)
    while scoville[0] < K:
        if len(scoville) == 1:
            return -1
            
        answer+=1
        first = heappop(scoville)
        second = heappop(scoville)
        heappush(scoville, first+second*2)
        
    return answer