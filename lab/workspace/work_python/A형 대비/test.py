import random

team = []
team.append([])
team.append([])
team.append([])
team.append([])
team.append([])

members = ["강효진", "강희연", "고진석", "김은지",
           "김필선", "류정민", "안기주", "안승수",
           "오종석", "이윤환", "이정열", "이지연",
           "이혜지", "전미원", "전병현", "정해석",
           "정희주", "최지연", "하승룡", "황수정"]

picked = 0

for i in range(0, 20):
    while True:
        team_pick = random.randrange(0, 5)
        if members[i] not in team[team_pick] and len(team[team_pick]) != 4:
            team[team_pick].append(members[i])
            break

for t in team:
    print(t)