# Project2
Project 2 is a project based on cloud and networking technologies.
Uses docker, mysql, rest API and JavaEE.

Consists of three docker images and two seperate networks(project2_frontend & project2_backend). 
1) Mysql  
  uses mysql-server as base image and has a volume for data saving at /var/lib/mysql  
  belongs to project2_backend  
2) Service  
  service image uses tomcat to host a .war file  
  belong to project2_backend & project2_frontend  
3) Client  
  client image  
  belong to project2_frontend  
  
  Execution:
  1) we have to place the file of project at $HOME directory of a non root user  
  2) cd Project2  
  3) docker-compose up -d  
  4) docker ps - we should check that service and mysql running for at least half a minute  
  5) ./mysql_scripts/db_init.sh - **this should run only the first time as it initializes the database**  
  6) docker run  --rm  --name client --network project2_frontend lazaros7sar/project_2:client  
