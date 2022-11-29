def find(graph):
    fix, cores = 0, []
    for i in range(N):
        for j in range(N):
            if graph[i][j] != 0:
                if i == 0 or i == N-1 or j == 0 or j == N-1:
                    fix += 1
                else:
                    cores.append((i,j))
    return fix,cores

def disconnect(x,y,dir,plus):
    nx = x + dx[dir]
    ny = y + dy[dir]
    for _ in range(plus):
        graph[nx][ny] = 0
        nx += dx[dir]
        ny += dy[dir]

def connect(x,y,dir):
    nx = x + dx[dir]
    ny = y + dy[dir]
    plus = 0
    while 0<=nx<N and 0<=ny<N:
        if graph[nx][ny] != 0:
            break
        graph[nx][ny] = 1
        plus += 1
        nx += dx[dir]
        ny += dy[dir]
    else:
        return plus
    disconnect(x,y,dir,plus)
    return False

def dfs(now, last, code):
    global minCode, maxCores
    if len(now) > maxCores:
        maxCores = len(now)
        minCode = INF
    if len(now) == maxCores and code < minCode:
        minCode = code

    for i in range(last, len(cores)):
        for dir in range(4):
            plus = connect(cores[i][0], cores[i][1], dir)
            if not plus:
                continue
            next = now[:]
            next.append(i)
            dfs(next, i+1, code+plus)
            disconnect(cores[i][0], cores[i][1], dir, plus)
    
dx = [-1,1,0,0]
dy = [0,0,-1,1]
INF = int(1e9)
for tc in range(1, int(input())+1):
    N = int(input())
    graph = [list(map(int,input().split())) for _ in range(N)]
    minCode = INF
    maxCores = -1
    fix, cores = find(graph)
    dfs([],0,0)
    
    print('#{0} {1}'.format(tc,minCode))