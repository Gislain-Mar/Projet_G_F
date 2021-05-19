#----green comp is only a working title and will be adjusted once feedback from group has been given----------------#

CREATE DATABASE IF NOT EXISTS green_comp;


#-------this will also be altered constantly for as it needs to have new users added.-------------------------------#
#----------I don't know if the password can be stored unreadable----------------------------------------------------#

	CREATE TABLE users (
		user_id INT (50) NOT NULL PRIMARY KEY AUTO_INCREMENT,
		username VARCHAR (50) NOT NULL,
		password VARCHAR (10) NOT NULL,
		last_login DATETIME (5)
	);

#------here the different sizes of plastic should be connected to the amount of points they bring.------------------#
#---------those points will be used to add/multiply the total_points in ranking-------------------------------------#

	CREATE TABLE value_items (
		size_id INT (10) NOT NULL PRIMARY KEY,
		size CHAR (10),
		amount INT (10),
		points INT (50)
	);

#------ranking saves the points for each user. This is the table that should be visible.---------------------------#
#---------If a certain threshhold is reached in the points, people will get rewards.-------------------------------#
#------------There should be a max in rewards or a repetition for the demo.----------------------------------------#

	CREATE TABLE ranking (
		user_id INT (50) NOT NULL AUTO_INCREMENT,
		username VARCHAR (50) NOT NULL,
		total_points INT (100) NOT NULL,

		FOREIGN KEY (user_id) REFERENCES users (user_id)
		FOREIGN KEY (username) REFERENCES users (username)
	);

