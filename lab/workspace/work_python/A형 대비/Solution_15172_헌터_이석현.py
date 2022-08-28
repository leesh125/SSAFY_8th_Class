def hunt(x,y,dist):
    global next, res

    if dist >= res:
        return
    if not next:
        res = min(res, dist)
        return

    temp = next[:]
    for num, nx, ny in temp:
        d = abs(x-nx) + abs(y-ny)

        next.remove((num,nx,ny))

        if num > 0:
            i,j = customer[num]
            next.append((-num,i,j))

        hunt(nx,ny,dist+d)

        next.append((num,nx,ny))

        if num > 0:
            next.remove((-num,i,j))

for tc in range(1, int(input())+1):
    N = int(input())
    monster,customer = [],{}
    res = int(1e9)
    for i in range(N):
        row = list(map(int,input().split()))

        for j in range(N):
            if row[j] in [1,2,3,4]:
                monster.append((row[j],i,j))
            elif row[j] in [-1,-2,-3,-4]:
                customer[-row[j]] = (i,j)

    next = monster # 다음으로 이동할 지점
    hunt(0,0,0)

    print('#{0} {1}'.format(tc, res))