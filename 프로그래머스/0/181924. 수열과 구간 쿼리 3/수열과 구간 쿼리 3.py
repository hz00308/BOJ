def solution(arr, queries):
    for a, b in queries:
        temp = arr[a]
        arr[a] = arr[b]
        arr[b] = temp
    return arr