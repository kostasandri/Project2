#!/bin/bash
docker logs mysql 1> pass.sql
PASS=`grep "PASSWORD: " pass.sql`;
echo $PASS > pass.sql;
PASS=`awk '{print $5}' pass.sql`
echo $PASS > pass.sql;
docker cp pass.sql mysql:/mysql/pass.sql
docker cp mysql_scripts/create_table.sql mysql:/mysql/create_table.sql
docker cp mysql_scripts/mysql_setup.sh mysql:/mysql/mysql_setup.sh
docker cp mysql_scripts/insert_into.sql mysql:/mysql/insert_into.sql
docker exec mysql chmod +x mysql_setup.sh
rm pass.sql;
docker exec mysql ./mysql_setup.sh