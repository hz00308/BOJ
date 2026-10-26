def solution(cipher, code):
    li = [c for i, c in enumerate(cipher) if (i+1)%code==0]
    return ''.join(li)