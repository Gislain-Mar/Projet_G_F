USE green_comp;

#----the sizes and points are simply for test purposes, the numbers can be adjusted anytime-----------------

INSERT INTO value_items (size_id, size, points)
	VALUES
		(1, "s", 50),
		(2, "m", 100),
		(3, "l", 200),
		(4, "xl", 500);

#----one user is made to be a testuser. The others will be added with an insert script-----------------------
#------this has to be combined with ranking and points have to be set to 0 so everything can be added up-----

INSERT INTO users (user_id, username, PASSWORD, last_login)
	VALUES
		(1, "Katha2", "13483", "2021-05-18")
INSERT INTO ranking (user_id, username, total_points)
	VALUES
		(1, "Katha2", "0")

#----script for updating tables with points------------------------------------------------------------------
#------i still have to figure out how to do this with the amount as a multiplier.----------------------------
#--------maybe combine it with a counter on the clicks?------------------------------------------------------

UPDATE ranking AS r
	SET r.total_points = SUM(r.total_points + value_items.points))* value_items.amount AS v
WHERE value_items.size_id = 2;	