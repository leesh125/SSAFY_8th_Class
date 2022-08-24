import sys
from collections import deque

def find_smaller_dis(fishes):
    temp = []
    for fish in fishes:
        x,y,fish_dis = fish
        if graph[x][y] >= shark[2]:
            continue
        else:
            dis = fish_dis
            if len(temp) == 0:
                temp = [x,y]
                min_dis = dis
            elif min_dis == dis:
                if temp[0] == x:
                    if temp[1] > y:
                        temp = [x,y]
                elif temp[0] > x:
                    temp = [x,y]
            elif min_dis > dis:
                temp = [x,y]
                min_dis = dis
        
    if temp == []:
        return [], -1
    else:
        return temp, min_dis

def bfs(i,j,sharksize):
    q = deque()
    visited = [[False] * N for _ in range(N)]
    visited[i][j] = True
    q.append((i,j,0))
    fishes = []
    while q:
        x, y, cnt = q.popleft()

        for dir in [(-1,0),(1,0),(0,-1),(0,1)]:
            nx = x + dir[0]
            ny = y + dir[1]

            if 0<=nx<N and 0<=ny<N and not visited[nx][ny]:
                if graph[nx][ny] == 0: 
                    visited[nx][ny] = True
                    q.append((nx,ny,cnt+1))
                elif graph[nx][ny] <= sharksize:
                    fishes.append([nx,ny,cnt+1])
                    visited[nx][ny] = True
                    q.append((nx,ny,cnt+1))
    return fishes


input = sys.stdin.readline
N = int(input())
graph = []
shark = []
ans = 0
eat = 0

for i in range(N):
    temp = list(map(int, input().split()))
    graph.append(temp)
    for j in range(N):
        if temp[j] == 9:
            shark = [i,j,2]

while True:
    fishes = bfs(shark[0], shark[1], shark[2])
    kill_fish, dis = find_smaller_dis(fishes)
    if dis == -1: break
    fishes.remove(kill_fish + [dis])
    graph[shark[0]][shark[1]] = 0
    shark[0] = kill_fish[0]; shark[1] = kill_fish[1]
    graph[kill_fish[0]][kill_fish[1]] = 0
    eat += 1
    if eat == shark[2]:
        shark[2] += 1
        eat = 0
    ans += dis

print(ans)