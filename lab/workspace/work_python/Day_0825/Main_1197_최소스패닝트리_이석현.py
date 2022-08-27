# # =============크루스칼=================
# import sys
# input = sys.stdin.readline

# # find 연산
# def find(x):
#     while x != parents[x]:
#         x = parents[x]
#     return x

# # union 연산
# def union_parent(a,b):
#     a = find(a); b = find(b)
#     if a < b:
#         parents[b] = a
#     else:
#         parents[a] = b

# V,E = map(int,input().split())
# edges = []
# total_cost = 0

# for _ in range(E):
#     a,b,weight = map(int,input().split())
#     edges.append((a,b,weight))

# edges.sort(key=lambda x:x[2])

# parents = [x for x in range(V+1)]

# for fr,to,weight in edges:
#     if find(fr) != find(to):
#         union_parent(fr, to)
#         total_cost += weight
# print(total_cost)



# =============프림=================
import sys, heapq
input = sys.stdin.readline

V,E = map(int,input().split())
edges = [[] for _ in range(V+1)]
visited = [False] * (V+1)
hq = [[0,1]]
total_cost = 0

for _ in range(E):
    a,b,weight = map(int,input().split())
    edges[a].append((weight,b))
    edges[b].append((weight,a))

cnt = 0
while hq:
    cost, nowV = heapq.heappop(hq)

    if cnt == V: break

    if not visited[nowV]:
        visited[nowV] = True
        cnt += 1
        total_cost += cost
        for v in edges[nowV]:
            heapq.heappush(hq,v)

print(total_cost)