create database Lab5_SOF203
go
use Lab5_SOF203
go

create table HOCSINH
(
	MaHS nvarchar(7) not null,
	TenHS nvarchar(50) not null,
	GioiTinh nvarchar(10),
	DiemTB float not null
)
go

Insert into HOCSINH 
values ('PH13751' , N'Lê Minh Thụy' , 'Nam' , 9.8)

insert into HOCSINH
values('PH00123',N'Lê Thiện Trung','Nam',9.5),
		('PH00125',N'Lê Minh Đăng','Nam',10),
		('PH00120',N'Trần Thu Hà',N'Nữ',8),
		('PH00132',N'Nguyễn Lan Hương',N'Nữ',7.5),
		('PH00363',N'Đào Thanh Lâm','Nam',6.5)

select * from HOCSINH