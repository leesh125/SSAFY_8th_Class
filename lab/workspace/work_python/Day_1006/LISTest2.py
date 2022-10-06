from bisect import bisect_left
N = int(input())
arr = list(map(int,input().split())) # 숫자들
C = [int(1e9)] * N # 동적 테이블 C[k]: 해당(k) 길이를 만족하는 자리(k자리)에 오는 수의 최소값

size = 0
for i in range(N):
    # print(bisect_left(C,arr[i]))
    pos = bisect_left(C,arr[i])
    print(pos)
    if pos <= i:
        C[pos] = arr[i]

        if pos == size: size += 1

print(size)