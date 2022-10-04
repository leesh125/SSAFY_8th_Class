from collections import deque

dx = [-1,1,0,0]
dy = [0,0,-1,1]

def copy(graph):
    newGraph = [g[:] for g in graph]
    return newGraph

def boom(graph, r, c):
    q = deque()
    # 벽돌이 있던 자리를 0으로 변경 : 빈칸으로 만들어서 방문처리
    if graph[r][c] > 1:
        q.append((r,c,graph[r][c]))
    graph[r][c] = 0 # 방문처리 => 제거처리

    while q:
        x,y,val = q.popleft()

        # 벽돌의 크기 -1만큼 주변 벽돌(4방) 연쇄 처리
        for i in range(4):
            nx = x
            ny = y
            for _ in range(1,val):
                nx += dx[i]
                ny += dy[i]
                if 0<=nx<H and 0<=ny<W and graph[nx][ny] > 0:
                    if graph[nx][ny] > 1:
                        q.append((nx,ny,graph[nx][ny]))
                    graph[nx][ny] = 0 # 방문처리 => 제거처리

# def down(graph):
#     for c in range(W):
#         r = H-1
#         while r>0:
#             if graph[r][c] == 0:
#                 nr = r-1
#                 while nr > 0 and graph[nr][c] == 0: nr -= 1

#                 graph[r][c] = graph[nr][c]
#                 graph[nr][c] = 0
#             r -= 1

def down(graph):
    stack = []
    for c in range(W):
        # 남은 벽돌 스택에 넣기
        r = 0
        for r in range(H): # 남은 벽돌은 스택에 들어있고 모든 칸은 빈칸
            if graph[r][c] > 0: 
                stack.append(graph[r][c])
                graph[r][c] = 0
        nr = H-1
        while stack:
            graph[nr][c] = stack.pop()
            nr -= 1

def getRemain(graph):
    cnt = 0
    for i in range(H):
        for j in range(W):
            if graph[i][j] > 0: cnt += 1
    return cnt

def go(graph, cnt):
    global ans
    if cnt == N: # 구슬을 다 던진 상태
        # 남은 벽돌 수 카운트 최솟값 갱신
        temp = getRemain(graph)
        if ans>temp: ans = temp
        return
    # 구슬 던지기(중복 순열)
    for c in range(W):
        # 구슬에 맞는 시작벽돌 찾기
        r = 0
        while r<H and graph[r][c] == 0: r += 1

        if r == H: # 맞는 시작벽돌이 없는 상태
            go(graph, cnt+1)
        else: # 맞는 시작벽돌이 있는 상태
            newGraph = copy(graph)
            # 제거될 벽돌 연쇄 처리
            boom(newGraph,r,c)
            # 벽돌 중력 처리
            down(newGraph)
            # 다음 구슬 던지기
            go(newGraph, cnt+1)

for tc in range(1,int(input())+1):
    N,W,H = map(int,input().split())
    graph = [list(map(int, input().split())) for _ in range(H)]
    ans = float('inf')
    go(graph, 0)
    print('#{0} {1}'.format(tc,ans))