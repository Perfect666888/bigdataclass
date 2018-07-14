#查询年龄大于平均年龄的学生  子查询被当成了常量处理
select * from student where age>(select avg(age)  from student);

#查询班级平均分排名前三的班级的所有学生
 #阅读复杂sql的时候，从里面往外面阅读

#1.查询学生总分
select  a.id,a.name,a.clazz,sum(score) from score as b  join student as a on a.id =b.studentId group by a.id;

#2.查询班级平均分 取前三
select B.clazz,avg(B.zf) as pjf from (
select  a.id,a.name,a.clazz,sum(score) as zf from score as b
join student as a on a.id=b.studentId group by a.id) as B
 group by B.clazz order by pjf desc limit 3

#3.根据班级去取学生
select F.*,D.pjf from student as F
join (select B.clazz,avg(B.zf) as pjf from (
select  a.id,a.name,a.clazz,sum(score) as zf from score as b
join student as a on a.id=b.studentId group by a.id) as B
 group by B.clazz order by pjf desc limit 3) as D on F.clazz =D.clazz;
