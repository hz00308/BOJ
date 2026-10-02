def solution(a, b, c):
    abc = a+b+c
    abc2 = a**2 + b**2 + c**2
    abc3 = a**3 + b**3 + c**3
    if a==b and b==c:
        return abc * abc2 * abc3
    if a==b or b==c or a==c:
        return abc * abc2
    else:
        return abc