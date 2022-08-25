# from collections import deque

# def bfs(startX,startY):
#     q = deque()
#     q.append((startX,startY,0,0))
#     q.append((startX,startY,0,1))
#     visited[startX][startY][0] = True
#     visited[startX][startY][1] = True

#     while q:
#         x, y, cnt, check = q.popleft()
#         if x == x2 and y == y2:
#             return cnt

#         for i in range(1,5):
#             if i % 2 != check: continue

#             nx = x + dx[i-1]
#             ny = y + dy[i-1]

#             next_check = (check+1)%2
#             if 0<=nx<=200 and 0<=ny<=200 and not visited[nx][ny][next_check]:
#                 visited[nx][ny][next_check] = True
#                 q.append((nx,ny,cnt+1,next_check))

# dx = [-1,0,1,0]
# dy = [0,-1,0,1]

# T = int(input())
# for tc in range(1,T+1):
#     x1, y1, x2, y2 = map(int, input().split())
#     x1 += 100; x2 += 100; y1 += 100; y2 += 100;
#     visited = [[[False for _ in range(2)] for _ in range(201)] for _ in range(201)]
#     print('#{0} {1}'.format(tc,bfs(x1,y1)))

# Good Explanation
T = int(input())
for tc in range(1,T+1):
    x1, y1, x2, y2 = map(int, input().split())
    x_dis = abs(x1-x2)
    y_dis = abs(y1-y2)

    print(max(x_dis,y_dis) * 2 if (x_dis+ y_dis) % 2 == 0 else max(x_dis,y_dis) * 2-1)
    
    