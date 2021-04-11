drop database if exists HRDB;
Create database HRDB;
use HRDB;
create table HRUser(
uId int  auto_increment not null primary key,
uName varchar(50) not null unique,
uPassword varchar(50) not null default '123456',
uIcon varchar(200) not null default '../resource/icon.png',
uPhoneNumber varchar(20) default null unique,
uEmail varchar(20) default null unique,
uBirthday Date default null, 
uAge int default 18 check(uAge>=18 and uAge<=100),
uGender Boolean default null comment 'female->false,male->true',
uDescription varchar(200) default null,
uLocation varchar(100) default null,
uVerification timestamp default now(), 
uMoney float  not null default 0,
uStatus boolean not null default true comment 'false=ban',
uType varchar(10) not null default 'user' comment 'user/admin/owner'
);

insert into HRUser values(null,'xge',"123456","icon.png","13561915657","962613262@qq.com",default,20,true,null,null,default,0,true,"admin");
insert into HRUser values(null,'JiaWen',"123456","icon.png","1234567","1234567@qq.com",default,20,true,null,null,default,0,true,"owner");
insert into HRUser values(null,'HaoYuan',"123456","icon.png","123456","123456@qq.com",default,20,true,null,null,default,0,true,"user");
select * from HRUser;

create table HRType(
tId int auto_increment not null primary key,
tContext varchar(100) not null unique,
tDescription varchar(100) not null
);

insert into HRType values(null,"apartment","apartment");
insert into HRType values(null,"compound apartment","compound apartment");
insert into HRType values(null,"low block","low block");
insert into HRType values(null,"mansion","mansion");
insert into HRType values(null,"datcha","datcha");

create table HRHouse(
hId int auto_increment not null primary key,
hOwnerId int not null  ,
hPicture varchar(50) default null,
hAddress varchar(100) not null,
hType int not null,
hSize int not null,
hDate timestamp not null default now(),
hEnergy varchar(50) default null,
hEquipment varchar(100) default null,
hPark int default 1,
hDescription varchar(300) ,
hVerification timestamp default now(),
check(hDate < hVerification),
Foreign key (hType) references  HRType(tId) on update cascade on delete no action,
Foreign key (hOwnerId) references HRUser(uId) on update cascade on delete cascade
);

insert into HRHouse values(null,2,"picture.png","Ireland,limerick",1,130,'2010-9-15',"B3","microwave",1,"really new house",default);

create table HRRental(
rId int auto_increment not null primary key,
rHId int not null,
rUId int not null,
rPrice int not null,
rStart timestamp not null default now(), 
rEnd timestamp not null default now(),
rDeal timestamp default now(),
check(rStart<rEnd),
Foreign key (rHId) references HRHouse(hId) on update cascade on delete cascade,
Foreign key (rUId) references HRUser(uId) on update cascade on delete cascade
);
insert into HRRental values (null,1,3,3360,'2020-12-11','2020-12-12',null);
insert into HRRental values (null,1,3,3360,'2020-12-11','2020-12-13',null);
create table HRTopUp(
tId int auto_increment not null primary key,
tUId int not null,
tMoney float not null ,
tPayType varchar(50) not null,
tTime timestamp not null default now(),
check(tMoney>0),
Foreign key (tUId) references HRUser(uId) on update cascade on delete cascade
);

insert into HRTopUp values (null,1,10,'card',default);



create table HRVisitor(
vId int auto_increment not null primary key,
vIP varchar(50) not null,
vDate timestamp not null default now()
);


insert into HRVisitor values (null,"1.1.1.1",default);