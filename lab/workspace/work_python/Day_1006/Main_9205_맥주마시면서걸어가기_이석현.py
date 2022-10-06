import sys
input = sys.stdin.readline

# if abs(homeX-festivalX) + abs(homeY-festivalY) <= 1000:
#     print('happy')
#     continue

for tc in range(int(input())):
    n = int(input())
    homeX,homeY = map(int,input().split())
    convenience = []
    for _ in range(n):
        convenience.append(list(map(int,input().split())))
    convenience.sort(key=lambda x: (x[0],x[1]))
    festivalX,festivalY = map(int,input().split())

    
    
        
    