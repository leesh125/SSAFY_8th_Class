import sys

def find_smaller_dis():
    temp = []
    for fish in fishes:
        x,y,size = fish
        if size >= shark[2]:
            continue
        else:
            dis = abs(shark[0] - x) + abs(shark[1] - y)
            if len(temp) == 0:
                temp = [x,y]
                min_dis = dis
            elif min_dis == dis:
                if temp[0] == x:
                    if temp[1] > y:
                        temp = [x,y]
                elif temp[0] > x:
                    temp = [x,y]
            elif min_dis > dis:
                temp = [x,y]
                min_dis = dis
        
    if temp == []:
        return [], -1
    else:
        return temp, min_dis

input = sys.stdin.readline
N = int(input())
graph = []
shark = []
fishes = []
ans = 0
eat = 0

for i in range(N):
    temp = list(map(int, input().split()))
    graph.append(temp)
    for j in range(N):
        if temp[j] == 9:
            shark = [i,j,2]
        elif 1<=temp[j]<=6:
            fishes.append([i,j,temp[j]])

while True:
    kill_fish, dis = find_smaller_dis()
    if dis == -1: break
    fishes.remove(kill_fish)
    eat += 1
    if eat == shark[2]:
        shark[2] += 1
        eat = 0
    ans += dis
print(ans)