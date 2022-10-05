import sys
input = sys.stdin.readline

def deleteShark(x,y,size):
    for i in range(len(sharks)):
        if sharks[i][0] == x and sharks[i][1] == y and sharks[i][4] == size:
            del sharks[i]
            return

def fishing(col):
    global ans
    for i in range(1,R+1):
        if graph[i][col] != 0:
            ans += graph[i][col]           
            deleteShark(i,col,graph[i][col])
            graph[i][col] = 0
            return

def move(x,y,speed,dir):
    global origin_speed
    while speed > 0:
        if dir == 1:
            nx = x - 1
            if nx < 1:
                x=2;dir=2
            else:
                x=nx;
        elif dir == 2:
            nx = x + 1
            if nx > R:
                x=R-1;dir=1
            else:
                x=nx;
        elif dir == 3:
            ny = y + 1
            if ny > C:
                y=C-1;dir=4
            else:
                y=ny
        elif dir == 4:
            ny = y - 1
            if ny < 1:
                y=2;dir=3
            else:
                y=ny
        speed-=1
    return [x,y,origin_speed,dir]
    
R,C,M = map(int,input().split())
graph = [[0] * (C+1) for _ in range(R+1)]
empty_list = [[0] * (C+1) for _ in range(R+1)]
ans = 0
sharks = []
for i in range(M):
    sharks.append(list(map(int,input().split())))
    graph[sharks[i][0]][sharks[i][1]] = sharks[i][4]

time = C
fisher = 0
while fisher < C:
    fisher += 1
    fishing(fisher)
    delete_list = []
    newGraph = [g[:] for g in empty_list]
    for i in range(len(sharks)):
        x,y,speed,dir,size = sharks[i]
        graph[x][y] = 0
        origin_speed = speed
        sharks[i] = move(x,y,speed,dir) + [size]
        if newGraph[sharks[i][0]][sharks[i][1]] == 0:
            newGraph[sharks[i][0]][sharks[i][1]] = size
        else:
            if newGraph[sharks[i][0]][sharks[i][1]] > size:
                delete_list.append([sharks[i][0],sharks[i][1],size])
            else:
                delete_list.append([sharks[i][0],sharks[i][1],newGraph[sharks[i][0]][sharks[i][1]]])
    
    for delete in delete_list:
        deleteShark(delete[0],delete[1],delete[2])

    graph = newGraph
    
print(ans)