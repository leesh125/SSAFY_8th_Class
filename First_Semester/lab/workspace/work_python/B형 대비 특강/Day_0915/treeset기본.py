from sortedcontainers import SortedList
s = SortedList()

N = int(input())
for _ in range(N):
    string = input().split()
    if len(string) == 2:
        cmd = string[0]
        num = int(string[1])
        if cmd == 'add':
            s.add(num)
        elif cmd == 'remove':
            if len(s) == 0:
                print('None')
            else:
                while True:
                    if num in s:
                        s.remove(num)
                    else:
                        break
        elif cmd == 'find':
            if num in s:
                print('true')
            else:
                print('false')
        elif cmd == 'lower_bound':
            if len(s) == 0:
                print('None')
            else:
                if s[-1] < num:
                    print('None')
                else:
                    print(s[s.bisect_left(num)])
        elif cmd == 'upper_bound':
            if len(s) == 0:
                print('None')
            else:
                if s[-1] <= num:
                    print('None')
                else:
                    print(s[s.bisect_right(num)])
    else:
        cmd = string[0]
        if len(s) == 0:
            print('None')
        else:
            if cmd == 'largest':
                print(s[-1])
            elif cmd == 'smallest':
                print(s[0])