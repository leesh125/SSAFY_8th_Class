# ====================순열, 조합==============================

def permutation(numbers, n):
    result = []

    if n == 0:
        return [[]]

    for i in range(len(numbers)):
        elem = numbers[i]
        for rest in permutation(numbers[:i]+numbers[i+1:], n-1):
            result.append([elem] + rest)
    return result

def combination(numbers, n):
    result = []

    if n == 0:
        return [[]]

    for i in range(len(numbers)):
        elem = numbers[i]
        for rest in combination(numbers[i+1:], n-1):
            result.append([elem] + rest)
    return result

N, R = map(int,input().split())
numbers = list(map(int, input().split()))
perms = permutation(numbers, R)
combi = combination(numbers, R)

print('========permutation===========')
for p in perms:
    print(p)
print('========combination===========')
for c in combi:
    print(c)

# ====================부분집합==============================

N2= int(input())
numbers2 = list(map(int, input().split()))

for flag in range(1<<N2):
    for i in range(N2):
        if flag & (1<<i) != 0:
            print(numbers2[i], end=' ')
    print()

# ====================NextPermutation======================

def np():
    i,j,k = N-1,N-1,N-1
    global numbers3
    # 1. 꼭대기 찾기
    while i>0 and numbers3[i] <= numbers3[i-1]: i-=1
    if i == 0: return False

    # 2. 바꿀 값 찾기
    while numbers3[j] <= numbers3[i-1]: j-=1

    # 3. 바꾸기
    numbers3[j], numbers3[i-1] = numbers3[i-1], numbers3[j]

    # 4. 바꾼 숫자 뒤부터 정렬
    while i<k: 
        numbers3[i], numbers3[k] = numbers3[k], numbers3[i]
        i+=1; k-=1
    return True

N = int(input())
numbers3 = sorted(list(map(int, input().split())))

while True:
    print(*numbers3)
    if not np(): break

# ====================AdjList======================
from collections import deque

def dfs(start):
    visited = [False] * N
    visited[start] = True
    print(chr(start + 65))

    for line in adjList[start]:
        if not visited[line]:
            dfs(line)

def bfs(start):
    visited = [False] * N
    q = deque()
    visited[start] = True
    print(chr(start + 65))
    q.append(start)

    while q:
        now = q.popleft()

        for line in adjList[now]:
            if not visited[line]:
                visited[line] = True
                print(chr(line + 65))
                q.append(line)

N = int(input())
E = int(input())
adjList = [set() for _ in range(N)]

for _ in range(E):
    fr, to = map(int, input().split())
    adjList[fr].add(to)
    adjList[to].add(fr)

# dfs(0)
bfs(0)