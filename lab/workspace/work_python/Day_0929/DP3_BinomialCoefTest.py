import sys
input = sys.stdin.readline

n,k = map(int,input().split())
B = [[0] * (k+1) for _ in range(n+1)]

for i in range(n+1):
    end = min(i,k)
    for j in range(end+1):
        if j == 0 or j == 1:
            B[i][j] = 1; # 아무것도 안뽑거나 전부 뽑거나
        else:
            B[i][j] = B[i-1][j-1] + B[i-1][j]

print(B[n][k])