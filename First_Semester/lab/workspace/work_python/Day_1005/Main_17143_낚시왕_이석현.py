import sys
input = sys.stdin.readline

def fishing(col):
    global ans
    for i in range(1,R+1):
        if graph[i][col]:
            ans += graph[i][col][0]
            graph[i][col] = 0
            return


def get_next_loc(x,y,speed,dir):
    if dir == 1 or dir == 2:
        speed = speed % ((R-1)*2)
    elif dir == 3 or dir == 4:
        speed = speed % ((C-1)*2)
    while speed > 0:
        if dir == 1:
            nx = x - 1
            if nx < 1:
                x=2;speed-=1;dir=2
            else:
                x=nx;speed-=1
        elif dir == 2:
            nx = x + 1
            if nx > R:
                x=R-1;speed-=1;dir=1
            else:
                x=nx;speed-=1
        elif dir == 3:
            ny = y + 1
            if ny > C:
                y=C-1;speed-=1;dir=4
            else:
                y=ny;speed-=1
        elif dir == 4:
            ny = y - 1
            if ny < 1:
                y=2;speed-=1;dir=3
            else:
                y=ny;speed-=1
    return x,y,dir

def move():
    global graph
    newGraph = [[0 for _ in range(C+1)] for _ in range(R+1)]

    for i in range(1,R+1):
        for j in range(1,C+1):
            if graph[i][j]:
                speed = graph[i][j][1]
                nx,ny,ndir = get_next_loc(i,j,graph[i][j][1],graph[i][j][2])

                if newGraph[nx][ny]:
                    if newGraph[nx][ny][0] < graph[i][j][0]:
                        newGraph[nx][ny] = (graph[i][j][0],speed,ndir)
                else:
                    newGraph[nx][ny] = (graph[i][j][0], speed, ndir)
                    
    graph = newGraph

R,C,M = map(int,input().split())
graph = [[0 for _ in range(C+1)] for _ in range(R+1)]
ans = 0
sharks = [list(map(int,input().split())) for _ in range(M)]

for shark in sharks:
    graph[shark[0]][shark[1]] = (shark[4],shark[2],shark[3])

for c in range(1,C+1):
    fishing(c)
    move()
    
print(ans)