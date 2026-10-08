def solution(n, lost, reserve):
    
    lost = set(lost)
    reserve = set(reserve)

    both = lost & reserve
    lost -= both
    reserve -= both
    
    # reserve 돌기, 본인/앞뒤 확인
    for s in sorted(reserve):
        if s-1 in lost:
            lost.remove(s-1)
        elif s+1 in lost:
            lost.remove(s+1)
            
    return n - len(lost)

"""
바로 앞이나 뒷번호에게만 빌려줄 수 있음 
전체 학생 수 n
도난 당한 학생들 번호 리스트 lost
여벌 체육복 보유 학생들 리스트 reserve 
=> 체육 수업을 들을 수 있는 학생의 최댓값 리턴 
여벌 체육복 보유 학생이 체육복을 도난당했을 때는, 빌려줄 수 없음 
"""