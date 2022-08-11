# =====================bfs===============================#

from collections import deque

def bfs():
    ans = -1
    while q:
        now_score, now_cal, idx = q.popleft()

        if now_cal > L: continue
        ans = max(ans, now_score)

        for i in range(idx+1,N):
            n_score, n_cal, n_idx = gradients[i][0],gradients[i][1],gradients[i][2]
            q.append((n_score+now_score, n_cal+now_cal, n_idx))
    return ans        

T = int(input())
for tc in range(T):
    N, L = map(int, input().split())
    gradients = [list(map(int,input().split())) for i in range(N)]
    q = deque()
    for i in range(N): 
        gradients[i].append(i)
        q.append(gradients[i])
    print("#{0} {1}".format(tc+1,bfs()))

# =====================dfs===============================#

from collections import deque
def main():
    global max_score
    for i in range(int(input())):
        N, limit_cal = map(int,input().split())
        gradients,calories = [],[]
        for j in range(N):
            gradient, cal = map(int,input().split())
            gradients.append(gradient)
            calories.append(cal)

        max_score = 0
        def dfs(idx, sum_cal, sum_score):
            global max_score
            if sum_cal > limit_cal:
                return
            if sum_score > max_score:
                max_score = sum_score
            if idx >= N:
                return

            now_gradient, now_cal = gradients[idx], calories[idx]
            dfs(idx+1, sum_cal,sum_score) # 현재 재료 사용 안했을때
            dfs(idx+1, sum_cal+now_cal,sum_score+now_gradient) # 현재 재료 사용했을때

        dfs(0,0,0)
        print("#{0} {1}".format(i+1,max_score))

if __name__ == '__main__':
    main()