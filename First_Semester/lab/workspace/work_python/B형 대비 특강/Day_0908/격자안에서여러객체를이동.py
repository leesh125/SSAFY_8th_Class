import sys
input = sys.stdin.readline

dx = [-1,1,0,0]
dy = [0,0,-1,1]
n,m,t= map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]
dice = [[0] * n for _ in range(n)]
dice_pos = []
for _ in range(m):
    x,y = map(int, input().split())
    dice_pos.append((x-1,y-1))
second = 0

def check():
    result = []
    for i in range(n):
        for j in range(n):
            if dice[i][j] == 1:
                result.append((i,j))
    return result

while second < t:
    pos = []
    for dice_x,dice_y in dice_pos:
        max_num = -1
        temp_x, temp_y = -1,-1
        
        for i in range(4):
            nx = dice_x + dx[i]
            ny = dice_y + dy[i]

            if 0<=nx<n and 0<=ny<n and max_num < graph[nx][ny]:
                max_num = graph[nx][ny]
                temp_x = nx; temp_y = ny
        pos.append((temp_x,temp_y))
        dice[temp_x][temp_y] += 1

    dice_pos = check()
    for x,y in pos:
        dice[x][y] = 0
    second += 1
    
print(len(dice_pos))

