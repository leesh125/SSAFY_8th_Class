import sys
from collections import deque

N = int(sys.stdin.readline())
q = deque()
q.append((N,0))
ans = -2

while q:
    num, cnt = q.popleft()

    if num % 5 == 0:
        cnt += num // 5
        ans = cnt
        break

    if num == 0:
        ans = cnt
        break
    elif num > 2:
        q.append((num-3,cnt+1))
        q.append((num-5,cnt+1))

print(-1 if ans == -2 else ans)