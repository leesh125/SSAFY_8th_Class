import sys
input = sys.stdin.readline

N,d,k,c = map(int, input().split())
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
print(dict)
for i in range(1,N):
    if dict[sushi_list[i-1]] == 1:
        del dict[sushi_list[i-1]]
    else:
        dict[sushi_list[i-1]] -= 1
    
    if i >= N-k+1:
        i -= (k+1)
        if sushi_list[i] not in dict:
            dict[sushi_list[i]] = 1
        else:
            dict[sushi_list[i]] += 1
    else:
        if sushi_list[i+k-1] not in dict:
            dict[sushi_list[i+k-1]] = 1
        else:
            dict[sushi_list[i+k-1]] += 1
    size = len(dict) if c in dict else len(dict) + 1 
    ans = max(ans,size)
print(ans)