def dfs(now,graph): # 자신보다 키가 큰 학생따라 검색
    for i in range(1, N+1):
        if graph[now][i] == 1:
            if graph[i][0] == -1: dfs(i,graph) # 나보다 큰 i가 탐색을 하지 않은 상태라면 탐색 go
            
            # 나보다 큰 정점의 탐색 정보를 메모
            if graph[i][0] > 0: # i보다 큰 정점이 존재: now<i<j 를 만족하는 j존재 ==> cur<j 상태로 메모
                for j in range(1,N+1):
                    if graph[i][j] == 1: graph[now][j] = 1
    
    # 자신보다 큰 정점의 탐색을 모두 완료 메모하기
    cnt = 0
    for k in range(1,N+1):
        cnt += graph[now][k] # 1의 갯수만큼 더해짐

    graph[now][0] = cnt

for tc in range(1, int(input())+1):
    N = int(input())
    M = int(input())
    ans = 0
    
    graph = [[0] * (N+1) for _ in range(N+1)] # 자신보다 큰 학생 정보
    for i in range(1,N+1):
        graph[i][0] = -1 # 탐색하지 않은 초기값

    for i in range(M):
        a,b = map(int, input().split())
        graph[a][b] = 1 # a보다 b가 키가 크다
    
    for i in range(1,N+1):
        if graph[i][0] == -1:
            dfs(i,graph)
    
    # 모든 정점이 알고 있는 관계로 탐색을 마친 상태(큰 정점을 따라 탐색해서 간접관계를 직접괄계로 다 반영해서 인접행렬 update)
    # 열 기준 정보를 확인하면 자신보다 작은 정점을 파악 가능
    for k in range(1,N+1):
        for i in range(1,N+1):
            graph[0][k] += graph[i][k]
    
    for k in range(1,N+1):
        if graph[k][0] + graph[0][k] == N-1:
            ans += 1

    print("#{0} {1}".format(tc, ans))