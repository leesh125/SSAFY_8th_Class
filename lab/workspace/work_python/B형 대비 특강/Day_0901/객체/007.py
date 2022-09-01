# class Student():
#     def __init__(self,kor,eng,math):
#         self.__kor = kor
#         self.__eng = eng
#         self.__math = math
    
#     @property
#     def kor(self):
#         return self.__kor

#     @kor.setter
#     def set_kor(self,kor):
#         self.__kor = kor

#     @property
#     def eng(self):
#         return self.__eng

#     @eng.setter
#     def set_eng(self,eng):
#         self.__eng = eng

#     @property
#     def math(self):
#         return self.__math

#     @math.setter
#     def set_math(self,math):
#         self.__math = math

# student1 = Student(90, 80, 90)
# print(student1.kor)
# print(student1.eng)
# print(student1.math)
import sys
input = sys.stdin.readline

class Secret():
    def __init__(self,code,point,time):
        self.__code = code
        self.__point = point
        self.__time = time
    
    @property
    def code(self):
        return self.__code

    @code.setter
    def set_code(self,code):
        self.__code = code

    @property
    def point(self):
        return self.__point

    @point.setter
    def set_point(self,point):
        self.__point = point

    @property
    def time(self):
        return self.__time

    @time.setter
    def set_time(self,time):
        self.__time = time

code, point, time = input().split()
secret = Secret(code, point, time)
print('secret code :',secret.code)
print('meeting point :',secret.point)
print('time :',secret.time)