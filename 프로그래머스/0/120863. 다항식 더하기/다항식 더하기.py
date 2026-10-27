def solution(polynomial):
    li = polynomial.split(" + ")
    print(li)
    x = 0
    n = 0
    for i in li:
        if i.endswith('x'):
            if i=='x':
                x+=1
            else:
                x+=int(i[:-1])
        else:
            n+=int(i)
            
    if x==0:
        return str(n)
    if x==1:
        answer = 'x'
    else:
        answer = f'{x}x'
    return answer if n==0 else f'{answer} + {n}'