def process():
    cnt = 0
    for i in range(N):
        if makeRoad(graph[i]): cnt += 1
        if makeRoad(list(zip(*graph))[i]): cnt += 1
    return cnt

def makeRoad(road): # 해당 지형 정보로 활주로 건설이 가능하면 true, 불가능하면 false
    beforeHeight = road[0]
    size,j = 0,0

    while j<N:
        if beforeHeight == road[j]: # 동일 높이
            size += 1
            j += 1
        elif beforeHeight + 1 == road[j]: # 이전높이보다 1높음: 오르막 경사로 설치 체크
            if size < X: return False # X 길이 미만이면 활주로 건설 불가

            beforeHeight += 1
            size = 1
            j += 1
        elif beforeHeight - 1 == road[j]: # 이전 높이보다 1 낮음
            count = 0
            for k in range(j,N):
                if road[k] != beforeHeight-1: return False
                count += 1
                if count == X: break
            if count < X: return False
            beforeHeight -= 1
            j += X
            size = 0
        else: #높이가 2 이상 차이
            return False
    return True

for tc in range(1,int(input())+1):
    N, X = map(int, input().split())
    graph = [list(map(int,input().split())) for _ in range(N)]
    # graph2 = list(map(list,zip(*graph)))
    print('#{0} {1}'.format(tc,process()))