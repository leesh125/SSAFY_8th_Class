import sys
from sortedcontainers import SortedSet
input = sys.stdin.readline

n, m = map(int, input().split())
nums = list(map(int,input().split()))
s_num = SortedSet()
s_len = SortedSet()

s_num.add(-1)
s_num.add(n + 1)
s_len.add(-(n+1), -1, n+1)

for y in nums:
    s_num.add(y)

    z = s_num[s_num.bisect_right(y)]
    x = s_num[s_num.bisect_left(y)-1]

    s_len.remove((
        -(z-x-1),x,z
    ))
    s_len.add((
        -(z-x-1),x,z
    ))
    s_len.add((
        -(z-x-1),x,z
    ))

    best_length, _, _ = s_len[0]
    print(-best_length)