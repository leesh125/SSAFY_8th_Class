import sys,heapq
input = sys.stdin.readline

pq = []
N = int(input())
for _ in range(N):
    cmd = input().rstrip()
    if cmd == '0':
        if len(pq) == 0:
            print(0)
        else:
            print(heapq.heappop(pq))
    else:
        heapq.heappush(pq,int(cmd))
    