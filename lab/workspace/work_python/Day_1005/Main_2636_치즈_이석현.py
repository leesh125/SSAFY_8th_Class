import sys
input = sys.stdin.readline

def melt():
    pass

n,m = map(int, input().split())
graph = []
ice_list = []
for i in range(n):
    graph.append(list(map(int,input().split())))
    for j in range(m):
        if graph[i][j] == 1:
            ice_list.append((i,j))
    
while True:
    melt()
