DROP DATABASE mldn ;
CREATE DATABASE mldn CHARACTER SET UTF8 ;
USE mldn ;
CREATE TABLE dept(
	deptno			BIGINT		AUTO_INCREMENT ,
	dname			VARCHAR(50) ,
	loc				VARCHAR(50) ,
	dflag			INT ,
	CONSTRAINT pk_deptno PRIMARY KEY(deptno)
) ;
INSERT INTO dept(dname,loc,dflag) VALUES ('管理部','北京',0) ;
INSERT INTO dept(dname,loc,dflag) VALUES ('财务部','上海',0) ;
INSERT INTO dept(dname,loc,dflag) VALUES ('销售部','广州',0) ;
INSERT INTO dept(dname,loc,dflag) VALUES ('后勤部','济南',0) ;