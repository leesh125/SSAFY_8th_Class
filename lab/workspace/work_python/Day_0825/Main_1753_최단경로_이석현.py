import sys, heapq
input = sys.stdin.readline

def dijkstra(start):
    q = [] # pq
    heapq.heappush(q, (0,start)) # 현재까지 거리, 시작점
    min_path[start] = 0

    while q:
        distance, now = heapq.heappop(q)

        if min_path[now] < distance:
            continue

        for nextV, cost in paths[now]:
            sum_cost = cost + distance

            if sum_cost < min_path[nextV]:
                min_path[nextV] = sum_cost
                heapq.heappush(q, (sum_cost, nextV))

V,E = map(int, input().split())
start = int(input())
min_path = [int(1e9)] * (V+1)
paths = [[] for _ in range(V+1)]

for _ in range(E):
    fr,to,weight = map(int,input().split())
    paths[fr].append((to,weight))

dijkstra(start)
for i in range(1, V+1):
    print(min_path[i] if min_path[i] != int(1e9) else 'INF')