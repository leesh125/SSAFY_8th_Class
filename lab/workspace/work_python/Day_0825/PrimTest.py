import sys, heapq
input = sys.stdin.readline

V,E = map(int, input().split())
graph = [[] for _ in range(V)]
visited = [False] * V
minEdge = [int(1e9) for _ in range(V)]
hq = [[0,1]]
total_cost = 0

for _ in range(E):
    fr, to, weight = map(int,input().split())
    graph[fr].append((weight,to))
    graph[to].append((weight,fr))

''' 인접리스트 사용 '''

# 1. 임의의 시작점 처리, 0번 정점을 신장트리의 구성의 시작점으로
minEdge[0] = 0 
res = 0 # 최소신장트리 비용 누적

for i in range(V):

    # step1. 신장트리의 구성에 포함되지 않은 정점 중 최소 비용 정점 선택
    minVal = int(1e9)
    minIdx = -1
    for j in range(V):
        if not visited[j] and minVal > minEdge[j]:
            minVal = minEdge[j]
            minIdx = j
    
    # step2. 신장트리에 추가
    visited[minIdx] = True
    res += minVal

    # step3. 신장트리에 새롭게 추가되는 정점과 신장트리에 포함되지 않은 정점들의 기존 최소비용과 비교해서 갱신
    #        신장트리에 새롭게 추가되는 정점의 모든 인접정점 들여다보며 처리
    for v in graph[minIdx]:
        if not visited[v[1]] and minEdge[v[1]] > v[0]:
            minEdge[v[1]] = v[0]

print(res)


''' pq 사용 '''
cnt = 0
while hq:
    cost, now = heapq.heappop(hq)

    if not visited[now]:
        visited[now] = True
        cnt += 1
        total_cost += cost
        if cnt == V: break
        for v in graph[now]:
            heapq.heappush(hq,v)
print(total_cost)
