INF = int(1e9)
for tc in range(1, int(input())+1):
    N, limit = map(int, input().split())
    graAndCal = []
    dp = [[0] * (limit+1) for _ in range(N+1)]

    for i in range(N):
        graAndCal.append(list(map(int, input().split())))
    
    for i in range(1,N+1):
        for j in range(1,limit+1):
            score, weight = graAndCal[i-1][0],graAndCal[i-1][1]

            if j < weight:
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = max(score + dp[i-1][j-weight], dp[i-1][j])
    print('#{0} {1}'.format(tc,dp[N][limit]))
    
            
        

    