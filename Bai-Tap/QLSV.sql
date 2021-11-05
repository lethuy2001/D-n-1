create database QLSV 
go

use QLSV
go

create table STUDENTS(
    MaSV varchar(10) not null primary key ,
	HoTen nvarchar(50) ,
	Email varchar(50) ,
	SoDT varchar(15) ,
	GioiTinh bit ,
	DiaChi nvarchar(100) ,
	Hinh nvarchar(50)
)

create table GRADE(
     ID int not null primary key,
	 MaSV varchar(10) ,
	 TiengAnh float , 
	 TinHoc float ,
	 GDTC float ,
	 foreign key (MaSV) references STUDENTS(MaSV)
)

create table USERS(
    username nvarchar(50) not null primary key ,
	pass nvarchar(50) ,
	VaiTro nvarchar(50)
)

insert into STUDENTS ( MaSV , HoTen , Email , SoDT , GioiTinh , DiaChi , Hinh )
values ('PH13751' , N'Lê Minh Thụy' , 'thuylmph13751@fpt.edu.vn' , '0369978158' , 1 , N'Hà Nội' , null ) ,
       ('PH13752' , N'Tạ Văn Nam' , 'namtvph13752@fpt.edu.vn' , '0358978158' , 1 , N'Hải Phòng' , null ) ,
	   ('PH13753' , N'Đào Huy Bắc' , 'bacdhph13753@fpt.edu.vn' , '0382898158' , 1 , N'Hà Nội' , null ) ,
	   ('PH13754' , N'Lê Văn Sơn' , 'sonlvph13754@fpt.edu.vn' , '0369912588' , 1 , N'Tây Nguyên' , null ) ,
	   ('PH13755' , N'Phạm Tú Anh' , 'anhptph13755@fpt.edu.vn' , '0369827158' , 1 , N'Hải Phòng' , null ) ;

insert into GRADE ( ID , MaSV , TiengAnh , TinHoc , GDTC )
values ( 13751 , 'PH13751' , 10 , 8 , 9.5 ) ,
       ( 13754 , 'PH13754' , 9 , 8 , 9.5 ) ,
       ( 13755, 'PH13755' , 10 , 7 , 9 ) ;

insert into USERS ( username , pass , VaiTro ) 
values ('thuylmph13751@fpt.edu.vn' , '0329459996' , N'Cán Bộ' ) , 
       ('namtvph13752@fpt.edu.vn' , '032948856' , N'Giáo Viên' ) , 
	   ('sonlvph13753@fpt.edu.vn' , '0329992696' , N'Cán Bộ' ) , 
	   ('anhptph13754@fpt.edu.vn' , '0329185696' , N'Giáo Viên' ) ;

select * from STUDENTS 
select * from GRADE
select * from USERS

update STUDENTS
set Hinh = N'PH13759'
where MaSV = 'PH13759'

delete from GRADE

select HoTen, ID , STUDENTS.MaSV , TiengAnh , TinHoc , GDTC
from GRADE right outer join STUDENTS on GRADE.MaSV = STUDENTS.MaSV