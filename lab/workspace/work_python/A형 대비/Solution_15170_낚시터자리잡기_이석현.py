from itertools import permutations

def left(entry, dist):
    global fishing, cnt
    if entry - dist > 0 and not fishing[entry-dist]:
        fishing[entry-dist] = dist + 1
        cnt += 1

def right(entry, dist):
    global fishing, cnt
    if entry + dist <= N and not fishing[entry+dist]:
        fishing[entry+dist] = dist + 1
        cnt += 1

for tc in range(1, int(input())+1):
    N = int(input())
    gates = [list(map(int, input().split())) for _ in range(3)]
    res = int(1e9)

    for perm in permutations(range(3),3):
        for leftOrRight in [-1,1]:
            fishing = [0 for _ in range(N+1)]

            for p in perm:
                entry, fisher = gates[p]

                if fishing[entry]:
                    cnt = 0
                else:
                    fishing[entry] = 1
                    cnt = 1

                dist = 1
                while cnt < fisher:
                    if leftOrRight == -1:
                        left(entry, dist)
                    elif leftOrRight == 1:
                        right(entry, dist)
                    if cnt == fisher:
                        break
                    leftOrRight *= -1
                    if leftOrRight == -1:
                        left(entry, dist)
                    elif leftOrRight == 1:
                        right(entry, dist)
                    dist += 1
            res = min(res, sum(fishing))

    print('#{0} {1}'.format(tc, res))