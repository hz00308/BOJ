def solution(my_string):
    nums = [int(c) for c in my_string if c.isdigit()]
    return sum(nums)