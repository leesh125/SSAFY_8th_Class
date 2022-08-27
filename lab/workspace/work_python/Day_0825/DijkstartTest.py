import sys
input = sys.stdin.readline
INF = int(1e9)

V = int(input())
adjMatrix = [list(map(int,input().split())) for _ in range(V)]

# start -> end로의 최단경로
start = 0 # 시작 정점
end = V-1 # 도착 정점
# 다익스트라 알고리즘에 필요한 자료구조
min_path = [INF] * V
visited = [False] * V # 처리한 정점 여부

min_path[start] = 0

for i in range(V):
    # step1. 미방문 정점 중 출발지에서 자신으로의 비용이 최소인 정점 선택
    #        (방문해야하는 나머지 정점 중 출발지에서 가장 가까운 정점 찾기)
    min_dis = INF
    min_idx = -1
    for j in range(V):
        if not visited[j] and min_dis>min_path[j]:
            min_dis = min_path[j]
            min_idx = j
    
    # step2 방문처리
    visited[min_idx] = True
    # if min_dis == end: break # 문제가 start -> end로의 최단이면 탈출

    # step3. 선택된 정점을 경유지로 해서 미방문 정점들로 가는 비용을 따져보고 기존 최적해보다 유리하면 갱신
    for j in range(V):
        if not visited[j] and adjMatrix[min_idx][j] > 0 and min_path[j] > min_path[min_idx]+adjMatrix[min_idx][j]:
            min_path[j] = min_path[min_idx] + adjMatrix[min_idx][j]
            
print(min_path[end])
