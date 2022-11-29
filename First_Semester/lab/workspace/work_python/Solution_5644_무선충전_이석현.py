def check_in_battery(x,y):
    battery_num = []

    for i in range(1, battery_cnt+1):
        if abs(x-batteries[i][1]) + abs(y-batteries[i][0]) <= batteries[i][2]:
            battery_num.append(i)
    return battery_num

def check_best(battery1, battery2):
    max_num,total = 0,0
    for b1 in battery1:
        for b2 in battery2:
            if b1 != b2:
                total += batteries[b1][3] + batteries[b2][3]
            else:
                total += (batteries[b1][3] // 2) + (batteries[b2][3] // 2)
            max_num = max(max_num, total)
            total = 0
    return max_num

def check_best_onlyone(battery):
    max_num = 0
    for b in battery:
        max_num = max(max_num,batteries[b][3])
    return max_num

def move(user, dir):
    x, y = user
    if dir == 0:
        return (x,y)
    elif dir == 1:
        return (x-1,y)
    elif dir == 2:
        return (x,y+1)
    elif dir == 3:
        return (x+1,y)
    elif dir == 4:
        return (x,y-1)

T = int(input())
for tc in range(1, T+1):
    total_time, battery_cnt = map(int, input().split())
    A = list(map(int, input().split()))
    B = list(map(int, input().split()))
    batteries = [[] for _ in range(battery_cnt+1)]
    cnt = 0

    for i in range(1, battery_cnt+1):
        batteries[i] = list(map(int,input().split()))

    user1 = (1,1)
    user2 = (10,10)
    move_idx = -1
    while True:
        user1_battery = check_in_battery(user1[0], user1[1])
        user2_battery = check_in_battery(user2[0], user2[1])
        
        if len(user1_battery) >= 1 and len(user2_battery) == 0:
            cnt += check_best_onlyone(user1_battery)
        elif len(user1_battery) == 0 and len(user2_battery) >= 1:
            cnt += check_best_onlyone(user2_battery)
        elif len(user1_battery) >= 1 and len(user2_battery) >= 1:
            cnt += check_best(user1_battery, user2_battery)

        move_idx += 1
        total_time -= 1
        if total_time < 0: break

        user1 = move(user1, A[move_idx])
        user2 = move(user2, B[move_idx])

    print('#{0} {1}'.format(tc,cnt))