# def permutation(arr, N):
#     result = []

#     if N == 0:
#         return [[]]

#     for i in range(len(arr)):
#         elem = arr[i]

#         for rest in permutation(arr[:i]+arr[i+1:], N-1):
#             result.append([elem] + rest)
#     return result

# def combination(arr, N):
#     result = []

#     if N == 0:
#         return [[]]

#     for i in range(len(arr)):
#         elem = arr[i]

#         for rest in combination(arr[i+1:], N-1):
#             result.append([elem] + rest)
#     return result

# N, R = map(int, input().split())
# numbers = list(map(int, input().split()))

# permutation_res = permutation(numbers, R)
# combination_res = combination(numbers, R)

# print(permutation_res)
# print(combination_res)

# # 부분조합
# N = int(input())
# numbers = list(map(int, input().split()))

# for flag in range(1<<N):
#     for i in range(N):
#         if (flag & 1<<i) != 0:
#             print(numbers[i],end=' ')
#     print()


# # 넥퍼
# def np(numbers):
#     i,j,k = N-1, N-1, N-1
    
#     while i > 0 and numbers[i-1] >= numbers[i]: i-=1
#     if i == 0: return False

#     while numbers[i-1] >= numbers[j]: j-=1

#     numbers[i-1], numbers[j] = numbers[j], numbers[i-1]

#     while k > i:
#         numbers[i], numbers[k] = numbers[k], numbers[i]
#         i+=1; k-=1
#     return True

# N = int(input())
# numbers = sorted(list(map(int, input().split())))

# while True:
#     print(*numbers)
#     if not np(numbers): break

# 인접리스트
# from collections import deque

# def dfs(start):
#     visited[start] = True
#     print(chr(start + 65))

#     for next in edges[start]:
#         if not visited[next]:
#             visited[next] = True
#             dfs(next)
            

# def bfs(start):
#     q = deque()
#     q.append(start)
#     visited = [False] * V
#     visited[start] = True
#     print(chr(start + 65))
#     while q:
#         now = q.popleft()

#         for next in edges[now]:
#             if not visited[next]:
#                 visited[next] = True
#                 q.append(next)
#                 print(chr(next + 65))

# V = int(input())
# E = int(input())
# visited = [False] * V
# edges = [[] for _ in range(E)]
# for _ in range(E):
#     fr, to = map(int, input().split())
#     edges[fr].append(to)
#     edges[to].append(fr)

# bfs(0)
#dfs(0)

# kruscal
# def find(x):
#     while x != parents[x]:
#         x = parents[x]
#     return x

# V,E = map(int, input().split())
# edges = []
# for _ in range(E):
#     fr, to, weight = map(int, input().split())
#     edges.append((weight,fr,to))
# edges.sort()

# parents = [x for x in range(V+1)]

# cnt = 0
# total_cost = 0
# for weight, a, b in edges:
#     a_root = find(a)
#     b_root = find(b)
#     if a_root > b_root:
#         parents[a] = b
#         total_cost += weight
#     elif a_root < b_root:
#         parents[b] = a
#         total_cost += weight
# print(total_cost)

# prim
import heapq

V,E = map(int, input().split())
edges = [[] for _ in range(V+1)]
visited = [False] * (V+1)
hq = [[0,1]]
for _ in range(E):
    fr, to, weight = map(int, input().split())
    edges[fr].append((weight,to))
    edges[to].append((weight,fr))

cnt = 0
total_cost = 0
while hq:
    cost, node = heapq.heappop(hq)

    if cnt == V: break

    if not visited[node]:
        visited[node] = True
        cnt += 1
        total_cost += cost

        for next in edges[node]:
            heapq.heappush(hq, next)

print(total_cost)