def solution(arr, queries):
    answer = [-1] * len(queries)
    for i, q in enumerate(queries):
        s, e, k = q
        temp = arr[s:e+1]
        temp.sort()
        for t in temp:
            if t > k:
                answer[i] = t
                break
    return answer