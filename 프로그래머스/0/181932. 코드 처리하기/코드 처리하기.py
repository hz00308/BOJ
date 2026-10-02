def solution(code):
    ret = ''
    mode = False
    for i in range(len(code)):
        if code[i]=='1': 
            mode = not mode
            continue
        if (mode and i%2==1) or (not mode and i%2==0): 
            ret += code[i]
    if ret=='':
        ret = 'EMPTY'
    return ret