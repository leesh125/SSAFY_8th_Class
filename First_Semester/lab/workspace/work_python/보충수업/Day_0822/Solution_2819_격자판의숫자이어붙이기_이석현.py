from collections import deque

def bfs(i,j,words):
    q = deque()
    words = graph[i][j]
    q.append((i,j,words))

    while q:
        x,y,n_words = q.popleft()

        if len(n_words) == 7:
            ans.add(n_words)
            continue

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0<=nx<4 and 0<=ny<4:
                q.append((nx,ny,n_words+graph[nx][ny])) 

dx = [-1,1,0,0]
dy = [0,0,-1,1]

T = int(input())
for tc in range(1, T+1):
    graph = [list(input().split()) for _ in range(4)]
    ans = set()
    
    for i in range(4):
        for j in range(4):
            bfs(i,j,'')

    print('#{0} {1}'.format(tc,len(ans)))