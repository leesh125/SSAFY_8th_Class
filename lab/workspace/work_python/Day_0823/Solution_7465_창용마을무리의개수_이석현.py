def dfs(start):
    if visited[start]: return False
    visited[start] = True

    for friend in knows[start]:
        if not visited[friend]:
            dfs(friend)
    return True

for tc in range(1,int(input())+1):
    N, M = map(int,input().split())
    knows = [[] for _ in range(N+1)]
    visited = [False] * (N+1)
    ans = 0
    for _ in range(M):
        fr, to = map(int,input().split())
        knows[fr].append(to)
        knows[to].append(fr)
    for i in range(1,N+1):
        if dfs(i): 
            ans += 1
    print('#{0} {1}'.format(tc, ans))
    
    