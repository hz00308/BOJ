def solution(a, d, included):
    ans = 0
    val = a
    for b in included:
        if not b: 
            val += d
            continue
        ans += val
        val += d
    return ans