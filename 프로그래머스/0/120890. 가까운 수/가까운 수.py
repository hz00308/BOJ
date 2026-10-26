def solution(array, n):
    arr2 = [(abs(num-n), num) for num in array]
    arr2.sort()
    return arr2[0][1]