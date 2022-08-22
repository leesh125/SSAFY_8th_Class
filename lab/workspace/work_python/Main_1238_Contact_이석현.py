from collections import deque

def bfs(start):
    q = deque()
    q.append((start,1))
    visited[start] = True
    max_num = 0
    max_list = []

    while q:
        now,cnt = q.popleft()
        if cnt > max_num:
            max_list = [now]
            max_num = cnt
        elif cnt == max_num:
            max_list.append(now)

        for next in graph[now]:
            if not visited[next]:
                visited[next] = True
                q.append((next, cnt+1))

    return max_list

for tc in range(1, 11):
    length, start = map(int, input().split())
    contact = list(map(int, input().split()))
    graph = [set() for _ in range(101)]
    visited = [False] * 101

    for i in range(0,length-1,2):
        graph[contact[i]].add(contact[i+1])
        
    print('#{0} {1}'.format(tc,max(bfs(start))))


