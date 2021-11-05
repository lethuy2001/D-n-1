create database QLSV1 
go

use QLSV1 
go 

create table STUDENTS (
     MaSV varchar(10) primary key ,
	 HoTen nvarchar(50) , 
	 Email varchar(60)  ,
	 SoDT varchar(15) , 
	 GioiTinh nvarchar(4) ,
	 DiaChi nvarchar(100) 
)

insert STUDENTS 
values ('SV001' , N'Lê Văn Phụng' , 'Phunglv135@gmail.com' , '0369917685' , N'Nam'  , N'Ninh Thuận') ,
       ('SV002' , N'Lê Quang Trung' , 'Trunglq135@gmail.com' , '0369587685' , N'Nam'  , N'Hà Nội') ,
	   ('SV003' , N'Lê Thị Bảo Hiếu' , 'Hieultb85@gmail.com' , '0369718685' , N'Nữ'  , N'Phan Rang') ,
	   ('SV004' , N'Lê Thị Hạnh' , 'Hanhlt964@gmail.com' , '0369919648' , N'Nữ'  , N'Hồ Chí Minh') ;

