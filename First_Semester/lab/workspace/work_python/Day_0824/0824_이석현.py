# 1. 순열, 조합
def permutation(arr, R):
    result = []

    if R == 0:
        return [[]]

    for i in range(len(arr)):
        elem = arr[i]

        for rest in permutation(arr[:i]+arr[i+1:], R-1):
            result.append([elem] + rest)
    return result

def combination(arr, R):
    result = []

    if R == 0:
        return [[]]

    for i in range(len(arr)):
        elem = arr[i]

        for rest in combination(arr[i+1:], R-1):
            result.append([elem] + rest)
    return result

N, R = map(int, input().split())
numbers = list(map(int,input().split()))

permutation_list = permutation(numbers, 2)
combination_list =  combination(numbers, 2)
print('============순열============')
for permu in permutation_list:
    print(*permu)
print('============조합============')
for combi in combination_list:
    print(*combi)

# 2. 부분집합
def subset():
    for flag in range(1<<N):
        for i in range(N):
            if flag & 1<<i != 0:
                print(numbers[i], end=' ')
        print()
N = int(input())
numbers = list(map(int,input().split()))

subset()

# 3. 넥퍼
def np(numbers):
    i,j,k = N-1,N-1,N-1
    while i > 0 and numbers[i-1] >= numbers[i]: i-=1
    if i == 0: return False

    while numbers[i-1] >= numbers[j]: j-=1

    numbers[i-1], numbers[j] = numbers[j], numbers[i-1]

    while k > i: 
        numbers[i], numbers[k] = numbers[k], numbers[i]
        i += 1; k -= 1
    return True

N = int(input())
numbers = sorted(list(map(int, input().split())))
print(*numbers)
while np(numbers):
    print(*numbers)

# 4. 인접리스트
from collections import deque

def dfs(start):
    visited[start] = True
    print(start)
    for edge in edges[start]:
        if not visited[edge]:
            dfs(edge)

def bfs(start):
    q = deque()
    q.append(start)
    visited[start] = True

    while q:
        nowV = q.popleft()
        print(nowV)

        for edge in edges[nowV]:
            if not visited[edge]:
                visited[edge] = True
                q.append(edge)

V = int(input())
E = int(input())
visited = [False] * V
edges = [[] for _ in range(V)]
for _ in range(E):
    fr, to = map(int,input().split())
    edges[fr].append(to)
    edges[to].append(fr)

dfs(0)
bfs(0)
    
