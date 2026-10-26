def solution(tickets):
    
    tickets.sort()
    visited = [False]*len(tickets)
    answer = []
    
    def dfs(curr, route):
        if len(route)==len(tickets)+1:
            answer.append(route)
            return True
        
        for i in range(len(tickets)):
            fr, to = tickets[i]
            if fr==curr and not visited[i]:
                visited[i] = True
                if dfs(to, route+[to]):
                    return True
                visited[i] = False
                
        return False
    
    dfs("ICN", ["ICN"])
    return answer[0]