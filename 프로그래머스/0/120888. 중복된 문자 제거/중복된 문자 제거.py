def solution(my_string):
    answer = list(my_string)
    bag = set()
    for i, c in enumerate(answer):
        if c not in bag:
            bag.add(c)
        else:
            answer[i] = ''
    return ''.join(answer)