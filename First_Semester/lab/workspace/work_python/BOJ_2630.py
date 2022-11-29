import sys
input = sys.stdin.readline

def divide(x,y,N):
    global blue, white
    now = graph[x][y]

    for i in range(x,x+N):
        for j in range(y,y+N):
            if now != graph[i][j]:
                divide(x,y,N//2)
                divide(x,y+N//2,N//2)
                divide(x+N//2,y,N//2)
                divide(x+N//2,y+N//2,N//2)
                return
    if now == 1:
        blue += 1
    else:
        white += 1

N = int(input())
graph = [list(map(int, input().split())) for _ in range(N)]
white, blue = 0,0
divide(0,0,N)
print(white)
print(blue)