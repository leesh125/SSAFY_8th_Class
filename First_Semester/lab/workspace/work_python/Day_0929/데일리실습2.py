N = int(input())
dp = [0] * (N+1)
dp_red = [0] * (N+1)
dp[1] = 2
dp_red[2] = 1

for i in range(2,N+1):
    dp[i] = dp[i-1] * 2

for i in range(3,N+1):
    dp_red[i] =  dp[i-2]*(i-1) + dp_red[i-2]
print(dp)
print(dp_red)
print(dp[N] + dp_red[N])

