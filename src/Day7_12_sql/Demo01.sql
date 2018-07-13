--建立数据库
create database Demo01;

--查看建数据库命令
show create database Demo01;

--使用数据库
use Demo01;

--看看在哪个数据库下
select database();

--创建表
create table user
 (  id int,
    name char(5),
    age int
);

--查看所有表
show tables;


#创建学生信息表
create table student
 (
     id char(10),
     name char(5),
     age int,
     gender char(2),
     clazz char(4)
 ) DEFAULT CHARSET=utf8;


 #导入数据到学生表
load data local infile "F:/BigData/IDEA/bigdataclass/src/SqlDataSource/students.txt" into table student fields terminated by ',';

#创建score表
create table score
(
    studentId char(10),
    courceId char(7),
    score int
)default charset=utf8;

#导入数据到成绩表
load data local infile "F:/BigData/IDEA/bigdataclass/src/SqlDataSource/score.txt" into table score fields terminated by ',';

#创建课程表
create table cource
(
    id char(7),
    name char(4),
    score int
)default charset=utf8;

#导入数据到课程表
load data local infile "F:/BigData/IDEA/bigdataclass/src/SqlDataSource/Cource.txt" into table cource fields terminated by ',';












