# Kruscal 알고리즘
def find_set(x):
    while x != parents[x]:
        x = parents[x]
    return x

for tc in range(1,int(input())+1):
    V, E = map(int, input().split())
    edges = []
    for _ in range(E):
        fr, to, val = map(int, input().split())
        edges.append((fr,to,val))
    edges.sort(key=lambda x:x[2])
    
    parents = [x for x in range(V+1)]
    distance, cnt = 0,0

    for a,b,value in edges:
        a_root = find_set(a)
        b_root = find_set(b)
        if a_root > b_root:
            parents[b_root] = a_root
            distance += value
        elif a_root < b_root:
            parents[a_root] = b_root
            distance += value
            
    print('#{0} {1}'.format(tc, distance))

# Prim 알고리즘
import sys, heapq
input = sys.stdin.readline

V, E = map(int, input().split())
edges = [[] for _ in range(V+1)]
hq = [[0,1]]
visited = [False] * (V+1)
for _ in range(E):
    fr, to, weight = map(int,input().split())
    edges[fr].append((weight, to))
    edges[to].append((weight, fr))

total_weight = 0
cnt = 0
while hq:
    weight, now = heapq.heappop(hq)

    if cnt == V: break

    if not visited[now]:
        visited[now] = True
        total_weight += weight
        cnt += 1
        for edge in edges[now]:
            heapq.heappush(hq, edge)

print(total_weight)