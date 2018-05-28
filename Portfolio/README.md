
OS:windows10

JDK：JDK1.8

Apachetomcat：8.0

Mysql:5.7.21

Eclipse Version:Oxygen 4.7.3


DB Database:page
DB Table
member			
	num	int	
	id	varchar(20)	
	pass	varchar(100)	
	email	varchar(40)	
	name	varchar(20)	
	joindate	datetime	
	logindate	datetime	
			
			
board			
	b_num	int	
	b_id	varchar(20)	
	b_title	varchar(50)	
	b_contents	varchar(500)	
	b_count	int	
	b_date	datetime	
			
			
portfolio			
	p_num	int	
	item	varchar(10)	
	p_title	varchar(50)	
	p_contents	varchar(500)	
	p_date	datetime	
	img	mediumblob	



