#----------------------------------------------查询年级排名前十学生各科的分数 [学号,学生姓名，学生班级，科目名，分数]
#1.求出学生总分选出前10
select a.id from student as a join score as b on a.id =b.studentId
group by a.id order by sum(b.score) desc limit 10;

#2.根据id去取学生信息
select * from student as aa
join (select a.id from student as a join score as b on a.id =b.studentId
group by a.id order by sum(b.score) desc limit 10)as bb on aa.id =bb.id;

#3.取到学生信息,取学生的全部成绩,已经对应的课程名
select A.*,C.name,B.score
from (select aa.id,aa.name,aa.clazz from student as aa
join (select a.id from student as a join score as b on a.id =b.studentId
group by a.id order by sum(b.score) desc limit 10)as bb on aa.id =bb.id) as A
join score as B on A.id =B.studentId
join cource as C on B.courceId =C.id;


#============================子查询==================================
#查询年级排名前十学生各科的分数 [学号,学生姓名，学生班级，科目名，分数]
#1.求出学生总分选出前10
select a.id from student as a join score as b on a.id =b.studentId
group by a.id order by sum(b.score) desc limit 10;
#2,取出前十学生的全部成绩
select * from score as bb where bb.studentId in (select * from(select a.id from student as a join score as b on a.id =b.studentId
group by a.id order by sum(b.score) desc limit 10) as t);

#3.去找对应的学生信息，以及科目信息
select A.id,A.name,C.name,B.score
from student as A
join (select * from score as bb where bb.studentId in (select * from(select a.id from student as a join score as b on a.id =b.studentId
group by a.id order by sum(b.score) desc limit 10) as t))as B on A.id = B.studentId
join cource as C on B.courceId =C.id;



#-----------------------查询总分大于班级平均分的学生文理科分开 [学号，姓名，班级，总分]
#1.获得学生总分,和对应的班级
select bb.studentId,aa.clazz,sum(score) as xszf
from score as bb
join student as aa on aa.id =bb.studentId
 group by studentId;

#2.获得班级平均分
select a.clazz,avg(b.xszf)
from student as a
join (select bb.studentId,aa.clazz,sum(score) as xszf
      from score as bb
      join student as aa on aa.id =bb.studentId
      group by studentId) as b on a.id =b.studentId
group by a.clazz;

#3.获得总分大于班级平均分的学生id
select A.studentId,A.xszf
from (select bb.studentId,aa.clazz,sum(score) as xszf
       from score as bb
join student as aa on aa.id =bb.studentId
 group by studentId) as A
 join (select a.clazz,avg(b.xszf) as bjpjf
       from student as a
       join (select bb.studentId,aa.clazz,sum(score) as xszf
             from score as bb
             join student as aa on aa.id =bb.studentId
             group by studentId) as b on a.id =b.studentId
       group by a.clazz) as B on A.clazz =B.clazz
       where A.xszf >B.bjpjf;

#4.根据获取到id,取出学生信息[学号，姓名，班级，总分]
select AA.id,AA.name,AA.clazz,BB.xszf,BB.bjpjf
from student as AA
join (select A.studentId,A.xszf,B.bjpjf
      from (select bb.studentId,aa.clazz,sum(score) as xszf
             from score as bb
      join student as aa on aa.id =bb.studentId
       group by studentId) as A
       join (select a.clazz,avg(b.xszf) as bjpjf
             from student as a
             join (select bb.studentId,aa.clazz,sum(score) as xszf
                   from score as bb
                   join student as aa on aa.id =bb.studentId
                   group by studentId) as b on a.id =b.studentId
             group by a.clazz) as B on A.clazz =B.clazz
             where A.xszf >B.bjpjf)as BB on AA.id =BB.studentId;

#5.文理科分开
#文科
select AA.id,AA.name,AA.clazz,BB.xszf as 学生总分,BB.bjpjf as 班级平均分
from student as AA
join (select A.studentId,A.xszf,B.bjpjf
      from (select bb.studentId,aa.clazz,sum(score) as xszf
             from score as bb
      join student as aa on aa.id =bb.studentId
       group by studentId) as A
       join (select a.clazz,avg(b.xszf) as bjpjf
             from student as a
             join (select bb.studentId,aa.clazz,sum(score) as xszf
                   from score as bb
                   join student as aa on aa.id =bb.studentId
                   group by studentId) as b on a.id =b.studentId
             group by a.clazz) as B on A.clazz =B.clazz
             where A.xszf >B.bjpjf)as BB on AA.id =BB.studentId
 where AA.clazz like '文科%' order by AA.clazz,BB.xszf desc;

#理科
select AA.id,AA.name,AA.clazz,BB.xszf as 学生总分,BB.bjpjf as 班级平均分
from student as AA
join (select A.studentId,A.xszf,B.bjpjf
      from (select bb.studentId,aa.clazz,sum(score) as xszf
             from score as bb
      join student as aa on aa.id =bb.studentId
       group by studentId) as A
       join (select a.clazz,avg(b.xszf) as bjpjf
             from student as a
             join (select bb.studentId,aa.clazz,sum(score) as xszf
                   from score as bb
                   join student as aa on aa.id =bb.studentId
                   group by studentId) as b on a.id =b.studentId
             group by a.clazz) as B on A.clazz =B.clazz
             where A.xszf >B.bjpjf)as BB on AA.id =BB.studentId
 where AA.clazz like '理科%' order by AA.clazz,BB.xszf desc;


#-----------------------查询每科都及格的学生 [学号，姓名，班级，科目，分数]
#1.取出每门科目的及格分数
select id,name,score*0.6 as jgx from cource;

#2.对比学生的成绩,统计出有多少门及格
select studentId,count(studentId) as jgms
from score as b
join (select id,name,score*0.6 as jgx from cource) as c on b.courceId =c.id
where b.score>c.jgx group by studentId;

#3.统计每个学生考了多少门科目
select studentId,count(studentId) as ksms
from score group by studentId;

#4.对比及格科目和考试科目是不是相等,取出学号
select A.studentId
from (select studentId,count(studentId) as jgms
      from score as b
      join (select id,name,score*0.6 as jgx from cource) as c on b.courceId =c.id
      where b.score>=c.jgx group by studentId) as A
join (select studentId,count(studentId) as ksms
      from score group by studentId)as B
on A.studentId =B.studentId
where A.jgms =B.ksms;

#5.根据取出的id,去获得学生信息[学号，姓名，班级，科目，分数]
select AA.id,AA.name,AA.clazz,CC.name,BB.score
from student as AA
join score as BB on AA.id= BB.studentId
join cource as CC on BB.courceId=CC.id
join (select A.studentId
      from (select studentId,count(studentId) as jgms
            from score as b
            join (select id,name,score*0.6 as jgx from cource) as c on b.courceId =c.id
            where b.score>=c.jgx group by studentId) as A
      join (select studentId,count(studentId) as ksms
            from score group by studentId)as B
      on A.studentId =B.studentId
      where A.jgms =B.ksms) as DD on DD.studentId =AA.id
;

#-----------------------查询偏最严重的前100名学生  [学号，姓名，班级，科目，分数]
#1.求出每个学生的平均分
select studentId,avg(score) as pjf
from score group by studentId;

#2.求出每个学生的每门科目的差值和
select b.studentId,sum(abs(b.score-c.pjf)) as czh
from score as b
join (select studentId,avg(score) as pjf
      from score group by studentId) as c on b.studentId=c.studentId
 group by b.studentId;

#3.取出结果的前100
select b.studentId, sqrt(power(sum(abs(b.score-c.pjf)),2)) as czh
from score as b
join (select studentId,avg(score) as pjf
      from score group by studentId) as c on b.studentId=c.studentId
 group by b.studentId order by czh desc limit 100;

#4.根据学号去取信息[学号，姓名，班级，科目，分数]
select A.id,A.name,A.clazz,C.name,B.score
from student as A
join score as B on A.id =B.studentId
join cource as C on B.courceId =C.id
join (select b.studentId,sqrt(power(sum(abs(b.score-c.pjf)),2)) as czh
      from score as b
      join (select studentId,avg(score) as pjf
            from score group by studentId) as c on b.studentId=c.studentId
       group by b.studentId order by czh desc limit 100) as D on B.studentId=D.studentId
;


#-----------------------查询总分大于学科(文理科)平均分的学生文理科分开 [学号，姓名，班级，总分]
#1.求出每个学生的总分
select studentId,a.name,a.clazz,sum(score) as xszf
from score as b
join student as a on a.id =b.studentId
group by studentId;

#2.求出文理科总分平均分
select substring(b.clazz,1,2) as lb,avg(b.xszf) as kmpjf
from (select studentId,a.clazz,sum(score) as xszf
      from score as b
      join student as a on a.id =b.studentId
      group by studentId)as b
group by lb

#3.求出大于平均分的学生
select a.*,b.kmpjf
from(select studentId,a.name,a.clazz,sum(score) as xszf
     from score as b
     join student as a on a.id =b.studentId
     group by studentId) as a
join (select substring(b.clazz,1,2) as lb,avg(b.xszf) as kmpjf
      from (select studentId,a.clazz,sum(score) as xszf
            from score as b
            join student as a on a.id =b.studentId
            group by studentId)as b
      group by lb)as b on substring(a.clazz,1,2)=b.lb
where a.xszf>b.kmpjf















