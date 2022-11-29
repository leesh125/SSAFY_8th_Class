import sys, copy
from collections import deque
input = sys.stdin.readline

def calc1(graph,x,y,d):
    if d == 0: # 위
        for i in range(x-1,-1,-1):
            if graph[i][y] == 6:
                break
            graph[i][y] = '#'
    elif d == 1: # 오른
        for i in range(y+1,M):
            if graph[x][i] == 6:
                break
            graph[x][i] = '#'
    elif d == 2: # 아래
        for i in range(x+1,N):
            if graph[i][y] == 6:
                break
            graph[i][y] = '#'
    elif d == 3: # 왼
        for i in range(y-1,-1,-1):
            if graph[x][i] == 6:
                break
            graph[x][i] = '#'
    return graph

def calc2(graph,x,y,d):
    if d % 2 == 0:
        for i in range(x-1,-1,-1):
            if graph[i][y] == 6:
                break
            graph[i][y] = '#'
        for i in range(x+1,N):
            if graph[i][y] == 6:
                break
            graph[i][y] = '#'
    elif d % 2 == 1:
        for i in range(y+1,M):
            if graph[x][i] == 6:
                break
            graph[x][i] = '#'
        for i in range(y-1,-1,-1):
            if graph[x][i] == 6:
                break
            graph[x][i] = '#'
    return graph

def calc3(graph,x,y,d):
    if d == 0:
        for i in range(x-1,-1,-1):
            if graph[i][y] == 6:
                break
            graph[i][y] = '#'
        for i in range(y+1,M):
            if graph[x][i] == 6:
                break
            graph[x][i] = '#'
    elif d == 1:
        for i in range(y+1,M):
            if graph[x][i] == 6:
                break
            graph[x][i] = '#'
        for i in range(x+1,N):
            if graph[i][y] == 6:
                break
            graph[i][y] = '#'
    elif d == 2:
        for i in range(x+1,N):
            if graph[i][y] == 6:
                break
            graph[i][y] = '#'
        for i in range(y-1,-1,-1):
            if graph[x][i] == 6:
                break
            graph[x][i] = '#'
    elif d == 3:
        for i in range(y-1,-1,-1):
            if graph[x][i] == 6:
                break
            graph[x][i] = '#'
        for i in range(x-1,-1,-1):
            if graph[i][y] == 6:
                break
            graph[i][y] = '#'
    return graph

def calc4(graph,x,y,d):
    if d == 0:
        for i in range(x-1,-1,-1):
            if graph[i][y] == 6:
                break
            graph[i][y] = '#'
        for i in range(y+1,M):
            if graph[x][i] == 6:
                break
            graph[x][i] = '#'
        for i in range(x+1,N):
            if graph[i][y] == 6:
                break
            graph[i][y] = '#'
    elif d == 1:
        for i in range(y+1,M):
            if graph[x][i] == 6:
                break
            graph[x][i] = '#'
        for i in range(x+1,N):
            if graph[i][y] == 6:
                break
            graph[i][y] = '#'
        for i in range(y-1,-1,-1):
            if graph[x][i] == 6:
                break
            graph[x][i] = '#'
    elif d == 2:
        for i in range(x+1,N):
            if graph[i][y] == 6:
                break
            graph[i][y] = '#'
        for i in range(y-1,-1,-1):
            if graph[x][i] == 6:
                break
            graph[x][i] = '#'
        for i in range(x-1,-1,-1):
            if graph[i][y] == 6:
                break
            graph[i][y] = '#'
    elif d == 3:
        for i in range(y-1,-1,-1):
            if graph[x][i] == 6:
                break
            graph[x][i] = '#'
        for i in range(x-1,-1,-1):
            if graph[i][y] == 6:
                break
            graph[i][y] = '#'
        for i in range(y+1,M):
            if graph[x][i] == 6:
                break
            graph[x][i] = '#'
    return graph

def check(graph):
    cnt = 0
    for i in range(N):
        for j in range(M):
            if graph[i][j] == 0:
                cnt+=1
    return cnt

def bfs(m,graph):
    q = deque()
    if m == 5:
        for i,j in number_cnt[5]:
            for direction in range(4):
                q.append((i,j,direction))
            
            while q:
                x,y,d = q.popleft()
                
                nx = x + dir[d][0]
                ny = y + dir[d][1]

                if 0<=nx<N and 0<=ny<M and graph[nx][ny] != 6:
                    if graph[nx][ny] not in [1,2,3,4,5,'#']:
                        graph[nx][ny] = '#'
                    q.append((nx,ny,d))
    return graph


N, M = map(int, input().split())
number_cnt = [[] for _ in range(6)]
dir = [(0,1),(1,0),(0,-1),(-1,0)]
graph = []

for i in range(N):
    temp = list(map(int, input().split()))
    graph.append(temp)
    for j in range(M):
        if temp[j] in [1,2,3,4,5]:
            number_cnt[temp[j]].append((i,j))

candidate = []
for i in range(1, 5):
    for numbers in number_cnt[i]:
        candidate.append((i,numbers[0],numbers[1]))

if len(number_cnt[5])>0:
    graph = bfs(5,graph)


def dfs(graph,idx):
    global ans
    if idx == len(candidate):
        ans = min(ans, check(graph))
        return

    cctv, x, y = candidate[idx][0],candidate[idx][1],candidate[idx][2]
    for d in range(4):
        temp_graph = copy.deepcopy(graph)
        if cctv == 1: dfs(calc1(temp_graph,x,y,d),idx+1)
        elif cctv == 2: dfs(calc2(temp_graph,x,y,d),idx+1)
        elif cctv == 3: dfs(calc3(temp_graph,x,y,d),idx+1)
        elif cctv == 4: dfs(calc4(temp_graph,x,y,d),idx+1)
ans = check(graph)   
dfs(graph,0)
print(ans)