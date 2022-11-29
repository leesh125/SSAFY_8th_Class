from sortedcontainers import SortedList

for _ in range(int(input())):
    s = SortedList()
    N = int(input())
    for _ in range(N):
        cmd, num = input().split()
        num = int(num)
        if cmd == 'I':
            s.add(num)
        elif cmd == 'D':
            if len(s) == 0:
                continue
            else:
                if num == 1:
                    s.remove(s[-1])
                elif num == -1:
                    s.remove(s[0])
    if len(s) == 0:
        print('EMPTY')
    else:
        print(s[-1], s[0])
