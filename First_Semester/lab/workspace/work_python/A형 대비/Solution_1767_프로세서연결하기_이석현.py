INF = int(1e9)

def findcores(graph):
    fix = 0
    cores = []
    for i in range(N):
        for j in range(N):
            if graph[i][j] != 0:
                if i == 0 or i == N-1 or j == 0 or j == N-1:
                    fix += 1
                else:
                    cores.append((i,j))
    return fix, cores
dx = [-1,1,0,0]
dy = [0,0,-1,1]

def cancel(x,y,dir,plus):
    nx = x+dx[dir]
    ny = y+dy[dir]
    for i in range(plus):
        graph[nx][ny] = 0
        nx += dx[dir]
        ny += dy[dir]

def install(x,y,dir):
    plus = 0
    nx = x+dx[dir]
    ny = y+dy[dir]
    while 0<=nx<N and 0<=ny<N:
        if graph[nx][ny] != 0:
            break
        graph[nx][ny] = 1
        plus += 1
        nx += dx[dir]
        ny += dy[dir]
    else:
        return plus
    cancel(x,y,dir,plus)
    return 0

def dfs(now, last, code):
    global minCode, maxCores
    if maxCores < len(now):
        maxCores = len(now)
        minCode = INF
    if maxCores == len(now) and minCode > code:
        minCode = code
    
    for i in range(last, len(cores)):
        for dir in range(4):
            plus = install(cores[i][0],cores[i][1],dir)
            if plus == 0:
                continue
            next = now[:]
            next.append(i)
            dfs(next, i+1, code+plus)
            cancel(cores[i][0],cores[i][1],dir,plus)


for tc in range(1,int(input())+1):
    N = int(input())
    graph = [list(map(int,input().split())) for _ in range(N)]
    fix, cores = findcores(graph)
    maxCores = -1
    minCode = INF
    dfs([],0,0)
    print('#{0} {1}'.format(tc, minCode))