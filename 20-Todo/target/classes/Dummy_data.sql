-- Note : by default data.sql file is is executed before the entities are processed.
-- so if your entities are not processed yet means No Link establised No table .
-- use this is APPILCATION.PROPERTIES => spring.jpa.defer-datasource-initialization=trues

--insert into todo (ID,Username,Description,target_date,done)
--	values(1001,'Prateek','Learn DSA',CURRENT_DATE(),false);

--the data in sql is permanent when you close the server the data still remains 
--and when you restart it with this it causes duplicate entry. So you need to change id everytime


-- if you have empty data.sql file in resources that is also not allowed. so I renamed it.