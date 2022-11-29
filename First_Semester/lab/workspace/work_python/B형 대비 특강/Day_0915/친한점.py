# from sortedcontainers import SortedSet

# s = SortedSet()

# s.add((170, 60))
# s.add((160, 55))
# s.add((180, 82))
# s.add((185, 77))
# s.add((170, 30))

# best_person = s[s.bisect_left((165, 50))]
# height, weight = best_person
# print(height, weight)

import sys
from sortedcontainers import SortedSet
input = sys.stdin.readline

n, m = map(int, input().split())
dirs = [tuple(map(int,(input().split()))) for _ in range(n)]
s = SortedSet(dirs)

for _ in range(m):
    xy = tuple(map(int, input().split()))
    idx = s.bisect_left(xy)
    if idx >= len(dirs):
        print(-1, -1)
    else:
        print(s[idx][0], s[idx][1])