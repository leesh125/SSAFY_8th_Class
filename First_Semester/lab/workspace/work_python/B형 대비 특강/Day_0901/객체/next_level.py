class User():
    def __init__(self,id = 'codetree',level = '10'):
        self.__id = id
        self.__level = level

    def __str__(self):
        return 'user {0} lv {1}'.format(self.__id, self.__level)

    @property
    def id(self):
        return self.__id

    @id.setter
    def set_id(self,id):
        self.__id = id

    @property
    def level(self):
        return self.__level

    @level.setter
    def set_level(self,level):
        self.__level = level

user1 = User()
id, level = input().split()
user2 = User(id, level)
userList = [user1, user2]

for user in userList:
    print(user)
