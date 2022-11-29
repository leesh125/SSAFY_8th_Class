def gt_dfs(now,visited): # 자신보다 키가 큰 학생따라 검색
    global gtCnt
    visited[now] = True

    for i in range(1, N+1):
        if graph[now][i] == 1 and not visited[i]: # i가 now보다 키가 크고 아직 탐색되지 않았다면
            gtCnt += 1 # 나보다 큰 학생 카운트
            gt_dfs(i,visited)


def lt_dfs(now,visited): # 자신보다 키가 큰 학생따라 검색
    global ltCnt
    visited[now] = True

    for i in range(1, N+1):
        if graph[i][now] == 1 and not visited[i]: # i가 now보다 키가 크고 아직 탐색되지 않았다면
            ltCnt += 1 # 나보다 큰 학생 카운트
            lt_dfs(i,visited)

for tc in range(1, int(input())+1):
    N = int(input())
    M = int(input())
    ans = 0
    
    graph = [[0] * (N+1) for _ in range(N+1)]
    for i in range(M):
        a,b = map(int, input().split())
        graph[a][b] = 1 # a보다 b가 키가 크다
    
    for i in range(1,N+1):
        gtCnt, ltCnt = 0,0
        gt_dfs(i,[False] * (N+1)); lt_dfs(i,[False] * (N+1))
        if gtCnt+ltCnt == N-1: ans += 1

    print("#{0} {1}".format(tc, ans))

