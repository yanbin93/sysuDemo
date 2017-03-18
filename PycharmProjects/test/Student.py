#!/usr/bin/env python
#-*-coding:utf-8-*-
class Student(object):
    def __init__(self,name,score):
        self.name=name
        self.score=score
    def talk(self):
        print "i am a student"
    def print_score(self):
        print '%s:%s'%(self.name,self.score)
    def get_grade(self):
        if self.score>=90:
            return 'A'
        elif self.score>=60:
            return 'B'
        else:
            return 'C'
xiaoming = Student('yanbin',90)
xiaoming.print_score()
print xiaoming.get_grade()
print xiaoming.name
print xiaoming.score

class xiaohong(Student):
   def talk(self):
        print "i am student xiaohong"
class liaoming(Student):
   def talk(self):
        print "i am student liaoming"
ming=liaoming("liaoming",90)
ming.talk()
ming.print_score()
def talk_n(Student):
    Student.talk()
    Student.talk()
talk_n(xiaohong("xiaohong",80))
talk_n(ming)
talk_n(Student('yanbin',90))
