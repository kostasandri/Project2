#!/bin/sh
PASS=`cat pass.sql`
mysqladmin -uroot -p$PASS password 'toor'
mysql -uroot -ptoor -e "create database Project2";
mysql -uroot -ptoor < create_table.sql
mysql -uroot -ptoor < insert_into.sql