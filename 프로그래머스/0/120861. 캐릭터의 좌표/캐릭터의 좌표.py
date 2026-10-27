def solution(keyinput, board):
    answer = [0, 0]
    dx = {"up":0, "down":0, "left":-1, "right":1}
    dy = {"up":1, "down":-1, "left":0, "right":0}
    for k in keyinput:
        if -board[0]//2+1 <= answer[0]+dx[k] <= board[0]//2 and -board[1]//2+1 <= answer[1]+dy[k] <= board[1]//2:
            answer[0]+=dx[k]
            answer[1]+=dy[k]
    return answer