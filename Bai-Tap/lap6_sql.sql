create database KidSchool
go  

use KidSchool 
go

create table STUDENTS(
     ID int identity primary key ,
	 Name nvarchar(50) , 
	 Address nvarchar(100) , 
	 ParentName nvarchar(50) , 
	 ContactNo nvarchar(50) , 
	 Standard nvarchar(60) , 
	 Fee money 
)

select * from STUDENTS

insert STUDENTS (Name , Address , ParentName , ContactNo , Standard , Fee)
values (N'Lê Minh Thụy' , N'Hà Nội' , N'Siêu Nhân' , N'Siêu Nhân' , N'Chế độ ưu tiên' , '6000000.0') ,
       (N'Lê Minh Thụy' , N'Hà Nội' , N'Siêu Nhân' , N'Siêu Nhân' , N'Chế độ ưu tiên' , '6000000.0') ;

