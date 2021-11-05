Create database TestAss1
go
use TestAss1
go

if OBJECT_ID('MONHOC') is not null
drop table MONHOC
go

create table MONHOC
(
MaMH nvarchar(15) not null,
TenMH nvarchar(50) not null,
sogio int not null,
sotinchi int not null,
ghichu nvarchar(50),
constraint PK_Monhoc primary key(MaMH)
)
go
if OBJECT_ID('SINHVIEN') is not null
drop table SINHVIEN
go

create table SINHVIEN
(
MaSV nvarchar(10) not null,
HoTenSV nvarchar(30) not null,
Ngaysinh datetime,
GioiTinh nvarchar(5) not null,
MaKN nvarchar(15) not null,
Diachi nvarchar(100),
Dienthoai nvarchar(20),
Email nvarchar(30) not null,
constraint PK_SV primary key (MaSV)
)
go
create table DIEM
(
Masv nvarchar(10) not null,
MaMH nvarchar(15) not null,
diem decimal not null,
constraint PK_DIEM primary key(MaSV,MaMH),
constraint FK_DIEM_Sinhvien foreign key(masv) references SinhVien(Masv),
constraint FK_DIEM_MonHoc foreign key(MaMh) references MonHoc(MaMH)
)
go

insert into MONHOC(MaMH,TenMH,sogio,sotinchi,ghichu) values(N'COM1012',N'Tin học cơ sở',36,3,null)
insert into MONHOC(MaMH,TenMH,sogio,sotinchi,ghichu) values(N'COM1022',N'Tin học văn phòng',36,3,null)
insert into MONHOC(MaMH,TenMH,sogio,sotinchi,ghichu) values(N'COM2012',N'Cơ sở dữ liệu',36,3,null)
insert into MONHOC(MaMH,TenMH,sogio,sotinchi,ghichu) values(N'COM2032',N'SQL Server',36,3,null)

insert into MONHOC(MaMH,TenMH,sogio,sotinchi,ghichu) values(N'WEB1012',N'Thiết kế WEB',36,3,null)
insert into MONHOC(MaMH,TenMH,sogio,sotinchi,ghichu) values(N'MUL1013',N'Thiết kế đồ họa',36,3,null)

insert into MONHOC(MaMH,TenMH,sogio,sotinchi,ghichu) values(N'ENT1112',N'Tiếng Anh 1.1',36,3,null)
insert into MONHOC(MaMH,TenMH,sogio,sotinchi,ghichu) values(N'ENT1122',N'Tiếng Anh 1.2',36,3,null)
insert into MONHOC(MaMH,TenMH,sogio,sotinchi,ghichu) values(N'ENT2122',N'Tiếng Anh 2.1',36,3,null)
insert into MONHOC(MaMH,TenMH,sogio,sotinchi,ghichu) values(N'ENT2222',N'Tiếng Anh 2.2',36,3,null)


insert into MONHOC(MaMH,TenMH,sogio,sotinchi,ghichu) values(N'SKI1013',N'Kỹ năng học tập',36,3,null)
insert into MONHOC(MaMH,TenMH,sogio,sotinchi,ghichu) values(N'VIE103',N'Giáo dục thể chất',56,3,null)
go

-- Nhập liệu bảng Sinhvien
insert into SINHVIEN(MaSV,HoTenSV,Ngaysinh,GioiTinh,MaKN,Diachi,Dienthoai,Email) 
values(N'PH00123',N'Lê Xuân Lý','7-15-1990',N'Nam',N'K12.3-UD',N'Hà nội',null,N'LyLxPH00123@fpt.edu.vn')

insert into SINHVIEN(MaSV,HoTenSV,Ngaysinh,GioiTinh,MaKN,Diachi,Dienthoai,Email) 
values(N'PH00124',N'Lê Thiện Trung','1990-7-18',N'Nam',N'K12.3-UD',N'Hà nội',null,N'TrungLTPH00124@fpt.edu.vn')

insert into SINHVIEN(MaSV,HoTenSV,Ngaysinh,GioiTinh,MaKN,Diachi,Dienthoai,Email) 
values(N'PH00125',N'Lê Minh Đăng','7-18-1992',N'Nam',N'K12.3-UD',N'Hà nội','0912345678',N'DangLMPH00125@fpt.edu.vn')

insert into SINHVIEN(MaSV,HoTenSV,Ngaysinh,GioiTinh,MaKN,Diachi,Dienthoai,Email) 
values(N'PH00126',N'Trịnh Quốc Chiến','8-18-1990',N'Nam',N'K12.3-UD',N'Hải Phòng',null,N'ChienTQPH00126@fpt.edu.vn')

insert into SINHVIEN(MaSV,HoTenSV,Ngaysinh,GioiTinh,MaKN,Diachi,Dienthoai,Email)
 values(N'PH00127',N'Lê Thu Lan','9-23-1990',N'Nữ',N'K12.3-UD',N'Thanh Hóa',null,N'LanLTPH00127@fpt.edu.vn')
 
insert into SINHVIEN(MaSV,HoTenSV,Ngaysinh,GioiTinh,MaKN,Diachi,Dienthoai,Email) 
values(N'PH00128',N'Trịnh Thảo Phương','4-26-1992',N'Nữ',N'K12.3-UD',N'Hải Phòng',null,N'PhuongTTPH00128@fpt.edu.vn')

insert into SINHVIEN(MaSV,HoTenSV,Ngaysinh,GioiTinh,MaKN,Diachi,Dienthoai,Email) 
values(N'PH00130',N'Trịnh Ngọc Lê','4-23-1992',N'Nữ',N'K12.3-UD',N'Hải Phòng',null,N'LeTNPH00130@fpt.edu.vn')

insert into SINHVIEN(MaSV,HoTenSV,Ngaysinh,GioiTinh,MaKN,Diachi,Dienthoai,Email)
 values(N'PH00268',N'Trần Ngọc Khiêm','1-26-1992',N'Nam',N'K12.1-MOB',N'Bắc Giang',null,N'KhiemTNPH00268@fpt.edu.vn')
 
insert into SINHVIEN(MaSV,HoTenSV,Ngaysinh,GioiTinh,MaKN,Diachi,Dienthoai,Email)
 values(N'PH02268',N'Trần Ngọc Thu Phương','1-3-1990',N'Nữ',N'K12.1-MOB',N'Bắc Giang',null,N'PhuongTNTPH02268@fpt.edu.vn')
 
insert into SINHVIEN(MaSV,HoTenSV,Ngaysinh,GioiTinh,MaKN,Diachi,Dienthoai,Email)
 values(N'PH00269',N'Trần Thảo Phương','5-3-1990',N'Nữ',N'K12.1-MOB',N'Bắc Giang',null,N'PhuongTTPH00269@fpt.edu.vn')
 
insert into SINHVIEN(MaSV,HoTenSV,Ngaysinh,GioiTinh,MaKN,Diachi,Dienthoai,Email)
 values(N'PH04270',N'Lưu Thị Lương','1-6-1990',N'Nữ',N'K12.1-MOB',N'Hải Dương',null,N'LuongLTPH04270@fpt.edu.vn')
 
insert into SINHVIEN(MaSV,HoTenSV,Ngaysinh,GioiTinh,MaKN,Diachi,Dienthoai,Email)
 values(N'PH04278',N'Trần Thị Diệu','1-3-1990',N'Nữ',N'K12.1-MUL',N'Bắc Giang',null,N'DieuTTPH04278@fpt.edu.vn')
 
 
 --Nhap lieu bang Diem
 insert into DIEM values('PH00123','COM1012',9.5)
 insert into DIEM values('PH00123','COM1022',6)
 insert into DIEM values('PH00123','COM2012',7.5)
 
 insert into DIEM values('PH00268','COM1012',7)  
 insert into DIEM values('PH04270','COM1012',6)
 insert into DIEM values('PH04278','COM1012',8.5)
 
 insert into DIEM values('PH00130','COM2032',7)  
 insert into DIEM values('PH00269','COM2032',6)
 insert into DIEM values('PH04278','WEB1012',8.5)

update DIEM 

