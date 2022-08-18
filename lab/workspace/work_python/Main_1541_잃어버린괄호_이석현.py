exp = [sum(map(int, ex.split('+'))) for ex in input().split('-')]
print(exp[0]-sum(exp[1:]))