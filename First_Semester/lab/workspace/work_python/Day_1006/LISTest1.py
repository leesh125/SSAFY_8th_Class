N = int(input())
arr = list(map(int,input().split())) # 숫자들
lis = [0] * N # 동적 테이블: 각 원소를 끝으로 하는 LIS 값
ans = 0

for i in range(N): # 앞쪽부터 모든 원소기준으로 자신을 끝으로 하는 LIS 계산
    lis[i] = 1
    for j in range(i):
        if arr[j] < arr[i] and lis[i] < lis[j] + 1:
            lis[i] = lis[j] + 1
        print(lis)
    ans = max(ans, lis[i])
print(lis)
print(ans)