def bruteforce(prevX,prevY,nextX,nextY,total,visited, cnt):
    global ans, end
    total += abs(prevX-nextX) + abs(prevY-nextY)
    cnt += 1
    if total > ans:
        return

    if cnt == N:
        total += abs(nextX-end[0]) + abs(nextY-end[1])
        ans = min(ans,total)
        return

    for i in range(N):
        if not visited[i]:
            visited[i] = True
            bruteforce(nextX,nextY,customers[i][0],customers[i][1],total,visited, cnt)
            visited[i] = False

T = int(input())
for tc in range(1, T+1):
    N = int(input())
    temp = list(map(int, input().split()))
    start = [temp[0],temp[1]]
    end = [temp[2], temp[3]]
    customers = [[temp[i],temp[i+1]] for i in range(4,len(temp)-1,2)]
    visited = [False] * N
    ans = int(1e9)
    total = 0
    for i in range(N):
        visited[i] = True
        bruteforce(start[0],start[1],customers[i][0],customers[i][1],total, visited, 0)
        visited[i] = False
    print('#{0} {1}'.format(tc,ans))