import sys
input = sys.stdin.readline
INF = int(1e9)
# if abs(homeX-festivalX) + abs(homeY-festivalY) <= 1000:
#     print('happy')
#     continue

for tc in range(int(input())):
    n = int(input())
    graph = [[INF] * (n+2) for _ in range(n+2)]

    for i in range(n+2):
        graph[i][i] = 0
    
    temp = []
    for i in range(n+2):
        pos = list(map(int, input().split()))

        for j in range(len(temp)):
            if abs(temp[j][0] - pos[0]) + abs(temp[j][1] - pos[1]) <= 1000:
                graph[i][j] = graph[j][i] = 1
        temp.append(pos)
    
    for k in range(n+2):
        for i in range(n+2):
            for j in range(n+2):
                graph[i][j] = min(graph[i][j], graph[i][k]+graph[k][j])
    print('happy' if graph[0][-1] != INF else 'sad')
    
        
    