def solution(my_string):
    temp = ''
    li = []
    for c in my_string:
        if c.isdigit():
            temp+=c
        else:
            if temp!='':
                li.append(int(temp))
                temp = ''
    if temp!='':
        li.append(int(temp))
    return sum(li) if li else 0