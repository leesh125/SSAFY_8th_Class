import sys
input = sys.stdin.readline

def factorial(n): # 팩토리얼 + 나머지 연산
    num = 1
    for i in range(2,n+1):
        num *= i
        num %= p
    return num

def square(n,k): # 거듭제곱 함수
    if k == 0:
        return 1
    elif k == 1:
        return n

    tmp = square(n,k//2)
    if k % 2:
        return tmp * tmp * n % p
    else:
        return tmp * tmp % p

def nCr(n,k):
    top = factorial(n)
    bottom = factorial(k) * factorial(n-k) % p

    return top * square(bottom, p-2) % p

n,k = map(int,input().split())
p = 1000000007
print(nCr(n,k))
# 이항계수 공식
# n! / k!(n-k)!

# 분수는 나머지 연산이 되지 않으므로 페르마의 소 공식을 이용함
# B^P-1 ≡ 1 (P로 나눴을경우 나머지 연산, P는 소수 & B가 P의 배수가 아님)
# B*B^P-2 ≡ 1
# B^P-2 ≡ B^-1
# 따라서 AB^-1 % P = AB^P-2%P = (A%P)(B^P-2%P) % P