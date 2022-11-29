from collections import deque

def shuffle(x,cards):
    standard = N // 2
    if x == N-1:
        return cards[standard:] + cards[:standard]
    result = []
    if x < standard:
        left = deque(cards[:standard])
        right = deque(cards[standard:])
        num = standard - x
    else:
        right = deque(cards[:standard])
        left = deque(cards[standard:])
        num = x - standard + 1

    for _ in range(num):
        result.append(left.popleft())

    while len(right) > num:
        result.append(right.popleft())
        result.append(left.popleft())

    while right:
        result.append(right.popleft())

    return result


def mixed(count, cards):
    global answer

    if count >= answer or count > 5:
        return

    if cards == up_res or cards == down_res:
        answer = min(answer, count)
        return

    for i in range(1,N):
        mixed(count+1, shuffle(i, cards))


for tc in range(1, int(input())+1):
    N = int(input())
    cards = list(map(int, input().split()))
    answer = int(1e9)
    up_res = sorted(cards)
    down_res = sorted(cards,reverse=True)
    mixed(0, cards)

    if answer > 5: answer = -1
    print('#{0} {1}'.format(tc, answer))