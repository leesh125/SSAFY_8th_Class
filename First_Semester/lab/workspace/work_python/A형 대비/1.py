from itertools import combinations

def checkHouse(i,j):
    cnt,ans = 0, 0
    for house in houses:
        y, x, dis = house
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
        y, x, dis = house
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

INF = int(1e9)
for tc in range(1,int(input())+1):
    N = int(input())
    graph = [[0] * 31 for _ in range(31)]
    houses = [list(map(int,input().split())) for _ in range(N)]
    res = INF

    for i in range(-15, 16):
        temp = checkHouse(i,i)
        if temp != 0:
            res = min(res,temp)

    for x, y in combinations(range(-15,16),2):
        temp = checkHouse(x,y)
        if temp != 0:
            res = min(res,temp)
    
    if res == INF:
        for i1 in range(-15,16):
            for j1 in range(-15,16):
                for i2 in range(-15,16):
                    for j2 in range(-15,16):
                        if i1 == i2 and j1 == j2: continue
                        temp = checkHouse2(i1,j1,i2,j2)
                        if temp != 0:
                            res = min(res,temp)
    if res == INF: res = -1
    print('#{0} {1}'.format(tc,res))
                
            


