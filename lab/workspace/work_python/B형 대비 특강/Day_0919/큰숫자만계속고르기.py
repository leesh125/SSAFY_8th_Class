import sys,heapq
input = sys.stdin.readline

n,m = map(int, input().split())
nums = list(map(int,input().split()))
pq = []

for num in nums:
    heapq.heappush(pq,-num)

for _ in range(m):
    num = heapq.heappop(pq)
    heapq.heappush(pq,num+1)
    
print(-heapq.heappop(pq))
