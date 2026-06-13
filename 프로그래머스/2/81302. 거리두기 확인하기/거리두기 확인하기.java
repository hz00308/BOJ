class Solution {
    public int[] solution(String[][] places) {
        int[] answer = {1,1,1,1,1};
        int[] dr1 = {0, 0, 1, -1};
        int[] dc1 = {1, -1, 0, 0};
        int[] dr2 = {0, 0, 2, -2};
        int[] dc2 = {2, -2, 0, 0};
        int[] drd = {1, 1, -1, -1};
        int[] dcd = {1, -1, 1, -1};
        
        int n = 0; // 몇 번째 방인지 (정답 저장용)
        for(String[] room : places) {
            roomLoop: // 라벨 break
            for(int row=0; row<5; row++) {
                for(int col=0; col<5; col++) {
                    if(room[row].charAt(col) != 'P') continue;
                    
                    // 맨허튼 거리 1 확인
                    for(int i=0; i<4; i++) {
                        int nr = row + dr1[i];
                        int nc = col + dc1[i];
                        if(nr>=0 && nc>=0 && nr<5 && nc<5 && room[nr].charAt(nc)=='P') {
                            answer[n] = 0;
                            break roomLoop;
                        }
                    }
                    
                    // 맨허튼 거리 2 확인 (상하좌우)
                    for(int i=0; i<4; i++) {
                        int nr = row + dr2[i];
                        int nc = col + dc2[i];
                        if(nr>=0 && nc>=0 && nr<5 && nc<5 && room[nr].charAt(nc)=='P') {
                            int xr = row + dr2[i]/2;
                            int xc = col + dc2[i]/2;
                            if(room[xr].charAt(xc) != 'X') {
                                answer[n] = 0;
                                break roomLoop;
                            }
                        }
                    }
                    
                    // 맨허튼 거리 2 확인 (대각선)
                    for(int i=0; i<4; i++) {
                        int nr = row + drd[i];
                        int nc = col + dcd[i];
                        if(nr>=0 && nc>=0 && nr<5 && nc<5 && room[nr].charAt(nc)=='P') {
                            if(room[row].charAt(nc) != 'X' || room[nr].charAt(col) != 'X') {
                                answer[n] = 0;
                                break roomLoop;
                            }
                        }
                    }
                    
                }
            }
            n++;
        }
        
        return answer;
    }
}
/*
- 5*5 크기의 대기실 5개
- 각 대기실별로 응시자가 거리두기를 지키고 있는지 리턴
- 거리두기 조건: 맨허튼 거리 3이상 또는 2인데 파티션 존재 
*/
/*
- 각 대기실별로,
- 25칸을 돌면서,
- 해당 칸이 사람(P)인 경우에 거리두기 조건 확인
- 맨허튼 거리가 1이면 (상하좌우) 불충족
- 맨허튼 거리가 2이면 (상하좌우2, 대각선) 파티션 확인 
    - 케이스1) 상하좌우2 --> 상하좌우1 위치에 파티션 존재해야 함
    - 케이스2) 대각선 --> x/y 좌표를 하나씩 택한 위치에 파티션 모두 존재해야 함 
- 불충족 시 즉시 0 저장하고 break 
*/