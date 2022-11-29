import sys
input = sys.stdin.readline

def combination(words, n):
    result = []
    if n == 0:
        return [[]]
    
    for i in range(len(words)):
        elem = words[i]
        
        for rest in combination(words[i+1:], n-1):
            result.append([elem] + rest)
    return result

L, C = map(int, input().split())
words = sorted(list(input().rstrip().split()))

for combi in combination(words, L):
    vowel, consonant = 0,0
    for c in combi:
        if c in ['a','e','i','o','u']:
            vowel += 1
        else:
            consonant += 1
    if vowel >= 1 and consonant >= 2:
        for c in combi:
            print(c, end='')
        print()