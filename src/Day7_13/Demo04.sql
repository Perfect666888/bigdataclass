#表连接
select * from student where gender = '女'
union
select * from student where gender = '男';

#求全部学生成绩总和
select id,name,sum(score) as zf from student join score
on id =studentId group by id  order by zf desc;

#创建视图
create view girlt as select * from student where gender ='女';

#修改视图
alter view girlt as select * from student where gender ='女' and age <22;

#查询视图
select * from girlt;

#查看视图结构
desc girlt;

#删除视图
drop view girlt;
