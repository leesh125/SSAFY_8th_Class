import sys
from sortedcontainers import SortedList
input = sys.stdin.readline

n, m = map(int, input().split())
nums = list(map(int,input().split()))
s = SortedList(nums)

for _ in range(m):
    num = int(input())
    if s[-1] < num:
        print(-1)
    else:
        print(s[s.bisect_left(num)])