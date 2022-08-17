import sys
input = sys.stdin.readline
N, r, c = map(int, input().split())
cnt = 0
def divide(N,x,y):
    global cnt
    if N != 2:
        N //= 2
        if x < N and y < N:
            divide(N, x, y)
        elif x < N and y >= N:
            cnt += (N**2)
            divide(N, x, y-N)
        elif x >= N and y < N:
            cnt += (N**2)*2
            divide(N, x-N, y)
        elif x >= N and y >= N:
            cnt += (N**2)*3
            divide(N, x-N, y-N)
    else:
        if x == 0 and y == 0:
            print(cnt)
        elif x == 0 and y == 1:
            print(cnt+1)
        elif x == 1 and y == 0:
            print(cnt+2)
        elif x == 1 and y == 1:
            print(cnt+3)
        
divide(2**N,r,c)
