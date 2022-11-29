money = int(input())
dp = [i for i in range(0,money+1)]
dp[0] = 0

INF = float('inf')
for i in range(1, money+1):
    minVal = INF
    minVal = min(minVal, dp[i-1] + 1)
    if i>=4: minVal = min(minVal, dp[i-4] + 1)
    if i>=6: minVal = min(minVal, dp[i-6] + 1)

    dp[i] = minVal

print(dp)
print(dp[money])
