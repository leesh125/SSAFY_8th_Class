def fibo1(n): # 메모하지 않는 버전
    global calls1, callCnt1
    callCnt1 += 1
    calls1[n] += 1

    if n<=1: return n
    return fibo1(n-1) + fibo1(n-2)

def fibo2(n): # 메모하는 버전
    global calls2, callCnt2
    callCnt2 += 1
    calls2[n] += 1

    if memo[n] == -1:
        memo[n] = fibo2(n-1) + fibo2(n-2)
    return memo[n]

N = int(input())
calls1 = [0] * (N+1)
calls2 = [0] * (N+1)
callCnt1, callCnt2= 0,0

memo = [-1] * (N+1) # 메모되지 않는 상태를 나타내는 값으로 초기화
memo[0] = 0; memo[1] = 1 # 처음부터 계산이 가능한 값 초기화

print('ans : ', fibo1(N))
print(callCnt1)
for i in range(1,N+1):
    print("fibo1(", i, ") : ", calls1[i])

print('======================')

print('ans : ', fibo2(N))
print(callCnt2)
for i in range(0,N+1):
    print("fibo2(", i, ") : ", calls2[i])

print('======================')