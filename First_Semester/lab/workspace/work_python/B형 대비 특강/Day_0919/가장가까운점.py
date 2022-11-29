import sys,heapq
input = sys.stdin.readline

n,m = map(int, input().split())
pq = []

for _ in range(n):
    x,y = map(int,input().split())
    dist = abs(x) + abs(y)

    heapq.heappush(pq,(dist, x, y))

for _ in range(m):
    dist,x,y = heapq.heappop(pq)
    dist = abs(x+2) + abs(y+2)    
    heapq.heappush(pq, (dist,x+2,y+2))
max_val = heapq.heappop(pq)
print(max_val[1], max_val[2])