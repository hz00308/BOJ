N = input()
digit = len(N)
N = int(N)
result = 0
if digit == 7:
    pass
else:
    for i in range(1, 9*digit+1):
        if N<18:
            if i==N:
                break
        s = N - i
        s_num = list(str(s))
        s_sum = 0
        for j in s_num:
            s_sum+=int(j)
        if i==s_sum:
            result = s
print(result)