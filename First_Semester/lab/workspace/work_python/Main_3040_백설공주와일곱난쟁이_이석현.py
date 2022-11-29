# Using Library
import sys
from itertools import combinations as combi
input = sys.stdin.readline

dwarfs = [int(input()) for _ in range(9)]
for c in list(combi(dwarfs, 7)):
    if sum(c) == 100:
        for dwarf in c:
            print(dwarf)

# ============================================================ #
# Not Using Library
import sys
input = sys.stdin.readline

dwarfs = [int(input()) for _ in range(9)]
sum_dwarfs = sum(dwarfs)

try:
    for i in dwarfs:
        for j in dwarfs:
            if i == j: continue
            if sum_dwarfs - i - j == 100:
                dwarfs.remove(i); dwarfs.remove(j)
                raise NotImplementedError
except:
    for dwarf in dwarfs: print(dwarf)