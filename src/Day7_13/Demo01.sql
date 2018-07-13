#创建表，设置主键，唯一，并且自动增长
create table `user`
(
    id int primary key auto_increment,
    name char(5) unique,
    age int not null
);

#增加列
alter table user add gender char(2);

#可以增加多列
alter table user add (clazz char(10),addr int);

#修改列类型
alter table user modify addr char(10);

#删除列
alter table user drop clazz;

#插入数据
insert into user
values
(1,'一',11,'男','合肥学院')，
(2,'二',22,'女','合肥学院');

#更新数据
update user
set
age = 12
where
name ='一';

#删除数据
delete from user where name ='二';

#清空表数据
truncate user;




