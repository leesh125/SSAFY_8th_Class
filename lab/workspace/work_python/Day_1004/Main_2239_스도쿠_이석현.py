import sys
input = sys.stdin.readline

def possible_row(x,num):
    for i in range(N):
        if graph[x][i] == num:
            return False
    return True

def possible_col(y,num):
    for i in range(N):
        if graph[i][y] == num:
            return False
    return True

def possible_sqr(x,y,num):
    c_x, c_y = x//3*3, y//3*3
    for i in range(c_x,c_x+3):
        for j in range(c_y,c_y+3):
            if graph[i][j] == num:
                return False
    return True

def possible(x,y):
    possible_list = []
    for i in range(1,10):
        if possible_row(x,i) and possible_col(y,i) and possible_sqr(x,y,i):
            possible_list.append(i)
    return possible_list

def dfs(i):
    if i >= len(blank):
        return False
    nx, ny = blank[i][0], blank[i][1]
    possible_list = possible(nx,ny)
    for p_num in possible_list:
        graph[nx][ny] = p_num
        if not dfs(i+1):
            return False
        graph[nx][ny] = 0
    return True

N = 9
blank = []
graph = []

for i in range(N):
    graph.append(list(map(int,list(input().rstrip()))))

for i in range(N):
    for j in range(N):
        if graph[i][j] == 0:
            blank.append([i,j])
dfs(0)

for g in graph:
    print(*g,sep='')
