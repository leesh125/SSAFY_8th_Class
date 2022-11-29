import sys
from collections import deque
input = sys.stdin.readline
INF = int(1e9)

def subset(numbers):
    res = []
    for flag in range(1<<N):
        temp1, temp2 = [], []
        for i in range(N):
            if (flag & 1<<i) != 0:
                temp1.append(numbers[i])
            else:
                temp2.append(numbers[i])
        res.append([temp1] + [temp2])
    return res

def bfs(arr):
    visited = [True] * (N+1)
    q = deque()
    q.append(arr[0])
    visited[arr[0]] = True
    for a in arr:
        visited[a] = False
    
    while q:
        now = q.popleft()

        for next in edges[now]:
            if not visited[next]:
                visited[next] = True
                q.append(next)
    
    for v in visited:
        if not v: return False
    return True
            

def isConnected(arr):
    len_arr = len(arr)
    if len_arr == 1: return True

    return bfs(arr)

N = int(input())
peoples = [0] + list(map(int,input().split()))
edges = [[] for _ in range(N+1)]
min_val = INF

for i in range(1, N+1):
    for edge in list(map(int, input().split()))[1:]:
        edges[i].append(edge)
    
for sub in subset(range(1,N+1)):
    set1,set2 = sub[0],sub[1]
    
    if set1 == [] or set2 == []:
        continue
    
    if isConnected(set1) and isConnected(set2):
        set1_total,set2_total = 0,0

        for people in set1:
            set1_total += peoples[people]
        for people in set2:
            set2_total += peoples[people]
        min_val = min(min_val, abs(set1_total - set2_total))

print(-1 if min_val == INF else min_val)
