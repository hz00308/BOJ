from collections import deque
def solution(bridge_length, weight, truck_weights):
    
    truck_weights = deque(truck_weights)
    bridge = deque([0]*bridge_length)
    total = 0
    ans = 0
    
    while(truck_weights):
        ans += 1
        total -= bridge.popleft()
        
        if total + truck_weights[0] > weight:
            bridge.append(0)
        else:
            temp = truck_weights.popleft()
            bridge.append(temp)
            total += temp
    
    return ans + bridge_length

'''
모든 트럭이 순서대로 다리를 건너려면 최소 몇 초? 
다리에는 트럭이 최대 bridge_length대 
weight 이하의 무게 견딜 수 있음 

deque
마지막 트럭이 들어온 시간 + bridge_length 
'''