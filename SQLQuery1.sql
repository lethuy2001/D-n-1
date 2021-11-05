Create database LT6C
go
use LT6C
go

CREATE TABLE KhoaHoc
(
	MaKH nvarchar(5) NOT NULL,
	TenKH nvarchar(50) NOT NULL,
	HocPhi float NOT NULL,
	ThoiLuong int NOT NULL,	
	primary key(MaKH)
)
go

CREATE TABLE HocVien(
	MaHV nvarchar(7) NOT NULL,
	MaKH nvarchar(5) NOT NULL,	
	Diem float NOT NULL,
	primary key(MaHV, MaKH),
	foreign key(MaKh) references KhoaHoc(MaKH)
)
go

insert KhoaHoc 
values ( 'KH01' , N'Lập Trình C' , 12000 , 15 ) ,
       ( 'KH02' , N'Lập Trình Java' , 12000 , 15 ) ,
       ( 'KH03' , N'Lập Trình C#' , 12000 , 15 ) ;

insert HocVien
values ( 'HV01' , 'KH01' , 10) ,
       ( 'HV01' , 'KH02' , 9) ,
       ( 'HV02' , 'KH01' , 7) 

update KhoaHoc
set TenKH = N'Lập Trình C#'
where MaKH = 'KH03'