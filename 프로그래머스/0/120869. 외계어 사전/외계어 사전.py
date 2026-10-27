def solution(spell, dic):
    spell = set(spell)
    for word in dic:
        if set(word)==spell:
            return 1
    return 2