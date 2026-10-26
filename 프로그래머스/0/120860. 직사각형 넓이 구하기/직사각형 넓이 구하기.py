def solution(dots):
    xs, ys = set(), set()
    for x, y in dots:
        xs.add(x)
        ys.add(y)
    xs, ys = list(xs), list(ys)
    return abs(xs[0]-xs[1])*abs(ys[0]-ys[1])