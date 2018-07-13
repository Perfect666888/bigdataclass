#查询所有数据
select * from student;

#查询指定列
select id,name,age from student;

#去除重复列
select distinct gender from student;

#取别名
select name as '名字' from student;

#统计学生数
select count(*) from student;
select count(1) from student;

#求学生总年龄
select sum(age) from student;

#求平均年龄
select avg(age) from student;

#where条件
select * from student where age =23 and gender ='男';

#比较运算符
select * from student where age <23;

#between
select * from student where age between 21 and 23;

#in
select * from student where age in (21,22);

#like
select * from student where clazz like '理科%';

#not null
select * from student where clazz is not null;

#concat
select concat(name,'===') from student;











