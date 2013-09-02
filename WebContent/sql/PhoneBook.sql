drop table PhoneBook;

select * from PhoneBook;

CREATE TABLE `PhoneBook` (
    `id` int NOT NULL AUTO_INCREMENT,		/*아이디(연번), 시퀀시(자동증가)*/
    `name` varchar(45) NOT NULL,			/*이름*/
    `tel` varchar(45) NOT NULL,				/*연락처*/
    `email` varchar(100) DEFAULT NULL,		/*이메일*/
    `birthday` varchar(45) DEFAULT NULL,	/*생년월일*/	
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

/*테스트용 데이터*/
insert into PhoneBook value (id, '홍길동', '010-000-0000', 'hong@gmail.com', '1995.01.22');
insert into PhoneBook value (id, '유관순', '010-111-1111', 'ryu@gmail.com', '1995.03.09');

