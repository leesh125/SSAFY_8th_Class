import sys
input = sys.stdin.readline

def move(x,y,d):
    nx = x + dx[d]
    ny = y + dy[d]

    if 0<=nx<n and 0<=ny<n:
        count_arr[nx][ny] += 1
        pos.append((nx,ny,d))
    else:
        count_arr[x][y] += 1
        pos.append((x,y,(d+2)%4))

def extract(pos):
    result = []
    for x,y,dir in pos:
        if count_arr[x][y] == 1:
            result.append((x,y,dir))
    return result

def tozero():
    for i in range(n):
        for j in range(n):
            count_arr[i][j] = 0

dx = [-1,0,1,0] # 상,우,하,좌
dy = [0,1,0,-1]

T = int(input())
for tc in range(1,T+1):
    n,m = map(int, input().split())
    dice = []
    count_arr = [[0] * n for _ in range(n)]
    for _ in range(m):
        x,y,dir = input().split()
        if dir == 'U': dir = 0
        elif dir == 'R': dir = 1
        elif dir == 'D': dir = 2
        elif dir == 'L': dir = 3
        dice.append((int(x)-1,int(y)-1,dir))

    for _ in range(2*n):
        pos = []
        for x,y,d in dice:
            move(x,y,d)
        dice = extract(pos)
        tozero()
        
    print(len(dice))
