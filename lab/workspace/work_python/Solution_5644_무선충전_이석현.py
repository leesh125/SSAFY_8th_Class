from collections import deque

def bfs(x,y,cnt,i):
    q = deque()
    q.append((x,y))



T = int(input())
total_time, battery_cnt = map(int, input().split())
A = list(map(int, input().split()))
B = list(map(int, input().split()))
batteries = [[] for _ in range(battery_cnt+1)]
using = [[False] * ]
for i in range(1, battery_cnt+1):
    batteries[i] = list(map(int,input().split()))

graph = [[0] * 10 for _ in range(10)]
for i in range(1, battery_cnt+1):
    y, x, cnt = batteries[i][0], batteries[i][1], batteries[i][2]
    bfs(x,y,cnt,i)

