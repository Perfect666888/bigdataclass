#查询班级平均年龄大于22的
select clazz,avg(age) as pj from student group by clazz having pj>22;

#取前几条数据
select * from student limit 3;
select * from student limit 3,5;



#降序排列
select * from student order by age asc;
select * from student order by age desc;

#分组加聚合函数
select gender,count(1) from student group by gender;