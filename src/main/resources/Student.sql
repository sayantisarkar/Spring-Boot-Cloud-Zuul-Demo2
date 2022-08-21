DROP TABLE IF EXISTS student;
CREATE TABLE IF NOT EXISTS student (
  studentId int(11) unsigned NOT NULL AUTO_INCREMENT,
  studentName varchar(20) DEFAULT NULL,
  percentage double DEFAULT NULL,
  age int(11),
  PRIMARY KEY (studentId)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

INSERT INTO student (studentId, studentName,percentage, age) VALUES
	(1001, 'MSD'   ,89 , 34),
	(1002, 'James' ,77 , 29),
	(1003, 'Rocky' ,54 , 39);
commit;
