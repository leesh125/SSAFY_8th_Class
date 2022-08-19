from copy import deepcopy
import sys
from itertools import combinations as combi
input = sys.stdin.readline

N, M, D = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(N)]
q_list = []
ans = 0

for i in range(N):
    for j in range(M):
        if graph[i][j] == 1:
            q_list.append([i,j])

for c in list(combi(range(M), 3)):
    archery = [[N,c[0]], [N,c[1]], [N,c[2]]]
    q = deepcopy(q_list)
    cnt = 0 
    while q:
        attack_set = []
        for a in archery:
            target = []
            target_distance = int(1e9)
            for i in range(len(q)):
                x,y = q[i]
                distance = abs(x - a[0]) + abs(y - a[1])
                if distance <= D and distance <= target_distance:
                    if len(target) == 0:
                        target = [x,y]
                        target_distance = distance
                    elif distance == target_distance and target[1] > y:
                        target = [x,y]
                    else:
                        target = [x,y]
                        target_distance = distance
            if len(target) != 0 and target not in attack_set:
                attack_set.append(target)
        print(attack_set)
        for attack in attack_set:
            q.remove(attack)
            cnt += 1
        new_q = []
        print(q)
        print()
        for i in range(len(q)):
            enemy_x, enemy_y = q[i]
            if enemy_x + 1 < N:
                new_q.append([enemy_x+1,enemy_y])
        q = new_q
        print(q)
        print()
    ans = max(ans,cnt)
print(ans)