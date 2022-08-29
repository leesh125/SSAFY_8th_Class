from itertools import combinations
from collections import deque
import time

def checkHouse(i,j):
    cnt,ans = 0, 0
    for house in houses:
        x,y, dis = house
        toCharge = abs(x-i) + abs(y-j)
        if toCharge <= dis:
            cnt += 1
            ans += toCharge
    if cnt == N:
        return ans
    return 0

def checkHouse2(i1,j1,i2,j2):
    cnt,ans = 0, 0
    min_charge = INF
    for house in houses:
        x,y, dis = house
        if (i1 == x and j1 == y) or (i2 == x and j2 == y):
            return 0
        toCharge1 = abs(x-i1) + abs(y-j1)
        toCharge2 = abs(x-i2) + abs(y-j2)
        min_charge = min(toCharge1, toCharge2)
        if min_charge <= dis:
            cnt += 1
            ans += min_charge
    if cnt == N:
        return ans
    return 0

def bfs(i,j,cnt):
    q = deque()
    q.append((i,j,cnt))
    visited = [[False] * 31 for _ in range(31)]
    visited[i+15][j+15] = True
    while q:
        x,y,cnt = q.popleft()

        if cnt == 0: continue

        for dir in [(-1,0),(1,0),(0,-1),(0,1)]:
            nx = x + dir[0]
            ny = y + dir[1]

            if -15<=nx<=15 and -15<=ny<=15 and not visited[nx+15][ny+15]:
                visited[nx+15][ny+15] = True
                q.append((nx,ny,cnt-1))
                candidate.add((nx,ny))

INF = int(1e9)
for tc in range(1,int(input())+1):
    N = int(input())
    candidate = set()
    houses = [list(map(int,input().split())) for _ in range(N)]
    start = time.time()  # 시작 시간 저장
    res = INF
    for house in houses:
        x, y, dis = house
        bfs(x,y,dis)

    for candi in candidate:
        temp = checkHouse(candi[0],candi[1])
        if temp != 0:
            res = min(res,temp)
    
    if res == INF:
        for combi in combinations(candidate,2):
            temp = checkHouse2(combi[0][0],combi[0][1],combi[1][0],combi[1][1])
            if temp != 0:
                res = min(res,temp)
    if res == INF: res = -1
    print('#{0} {1}'.format(tc,res))
print("time :", time.time() - start)  # 현재시각 - 시작시간 = 실행 시간