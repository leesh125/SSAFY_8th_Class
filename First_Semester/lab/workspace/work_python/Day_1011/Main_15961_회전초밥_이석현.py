import sys
input = sys.stdin.readline

N,d,k,c = map(int, input().split())
left, right = 0, k
sushi_list = []
for _ in range(N):
    sushi_list.append(int(input()))

dict = {}
for i in range(k):
    if sushi_list[i] not in dict:
        dict[sushi_list[i]] = 1
    else:
        dict[sushi_list[i]] += 1
ans = len(dict) if c in dict else len(dict) + 1

while left < N:
    if dict[sushi_list[left]] == 1:
        del dict[sushi_list[left]]
    else:
        dict[sushi_list[left]] -= 1
    
    if sushi_list[right % N] not in dict:
        dict[sushi_list[right % N]] = 1
    else:
        dict[sushi_list[right % N]] += 1
    left += 1; right += 1
    size = len(dict) if c in dict else len(dict) + 1 
    ans = max(ans,size)

print(ans)