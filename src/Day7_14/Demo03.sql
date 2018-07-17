#行列转置

#1.查询全部学生成绩
select a.*,
max(if(c.name ='语文',b.score,0)) as 语文,
max(if(c.name ='数学',b.score,0)) as 数学,
max(case c.name when '英语' then b.score else 0 end) as 英语,
max(case c.name when '政治' then b.score else 0 end) as 政治,
max(case c.name when '历史' then b.score else 0 end) as 历史,
max(if(c.name='地理',b.score,0)) as 地理
from student as a
join score as b on a.id =b.studentId
join cource as c on b.courceId =c.id
group by a.id;
