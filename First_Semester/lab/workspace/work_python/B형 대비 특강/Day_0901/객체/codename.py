# class Student():

#     def __init__(self, name='', score=0):
#         self.name = name
#         self.score = score
    
#     def __str__(self):
#         return '{0} {1}'.format(self.name, self.score)

# students = [
#     Student(),
#     Student(),
#     Student(),
#     Student(),
#     Student()
# ]
# min_score = float('inf')
# for i in range(5):
#     name, score = input().split()
#     students[i].name = name; students[i].score = int(score)
#     min_score = min(min_score, int(score))

# for student in students:
#     if student.score == min_score:
#         print(student)
#         break

dic = dict()
min_score = float('inf')
for _ in range(5):
    name, score = input().split()
    score = int(score)
    dic[score] = name
    if min_score > score: min_score = score
print(dic[min_score], min_score)