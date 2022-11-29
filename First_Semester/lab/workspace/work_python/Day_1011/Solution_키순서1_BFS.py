from collections import deque

def bfs(start): # 자신보다 키가 큰 학생따라 검색
    cnt = 0
    q = deque()
    q.append(start)
    visited = [False] * (N+1)
    visited[start] = True

    while q:
        now = q.popleft()

        for i in range(1, N+1):
            if graph[now][i] == 1 and not visited[i]: # i가 now보다 키가 크고 아직 탐색되지 않았다면
                cnt += 1 # 나보다 큰 학생 카운트
                visited[i] = True
                q.append(i)
    return cnt

def lt_bfs(start): # 자신보다 키가 큰 학생따라 검색
    cnt = 0
    q = deque()
    q.append(start)
    visited = [False] * (N+1)
    visited[start] = True

    while q:
        now = q.popleft()

        for i in range(1, N+1): # 인접행렬에서 자신의 열로 간선정보를 갖고있는 정점 들여다보기
            if graph[i][now] == 1 and not visited[i]: # now가 i보다 키가 크고 아직 탐색되지 않았다면
                cnt += 1 # 나보다 작은 학생 카운트
                visited[i] = True
                q.append(i)
    return cnt

for tc in range(1, int(input())+1):
    N = int(input())
    M = int(input())
    ans = 0
    graph = [[0] * (N+1) for _ in range(N+1)]
    for i in range(M):
        a,b = map(int, input().split())
        graph[a][b] = 1 # a보다 b가 키가 크다
    
    for i in range(1,N+1):
        if bfs(i) + lt_bfs(i) == N-1:
            ans += 1
    print("#{0} {1}".format(tc, ans))

