drop table PhoneBook;

select * from PhoneBook;

CREATE TABLE `PhoneBook` (
    `id` int NOT NULL AUTO_INCREMENT,		/*���̵�(����), ������(�ڵ�����)*/
    `name` varchar(45) NOT NULL,			/*�̸�*/
    `tel` varchar(45) NOT NULL,				/*����ó*/
    `email` varchar(100) DEFAULT NULL,		/*�̸���*/
    `birthday` varchar(45) DEFAULT NULL,	/*�������*/	
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

/*�׽�Ʈ�� ������*/
insert into PhoneBook value (id, 'ȫ�浿', '010-000-0000', 'hong@gmail.com', '1995.01.22');
insert into PhoneBook value (id, '������', '010-111-1111', 'ryu@gmail.com', '1995.03.09');

