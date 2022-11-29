import sys
input = sys.stdin.readline

M, N, L = map(int, input().split())
M_X = sorted(list(map(int, input().split())))
animal = [list(map(int, input().split())) for _ in range(N)]
cnt = 0
visited = [False] * N

for a_x, b_x in animal:
    start = 0
    end = len(M_X)-1
    while start<end:
        mid = (start + end)//2
        if M_X[mid] < a_x:
            start = mid + 1
        else:
            end = mid
    if abs(M_X[end]-a_x)+b_x<=L or abs(M_X[end-1]-a_x)+b_x<=L:
        cnt += 1

# for i in range(N):
#     if abs(x-animal[i][0]) + animal[i][1] <= L and not visited[i]:
#         visited[i] = True
#         cnt+=1

print(cnt)