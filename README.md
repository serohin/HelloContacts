# HelloContacts

[![Build Status](https://travis-ci.org/serohin/HelloContacts.svg?branch=master)](https://travis-ci.org/serohin/HelloContacts)

#### Создание базы данных в СУБД PostgreSQL :
1. Создате новую базу данных с именем "kamazz" в СУБД PostgreSQL.(выполните команду в консоли :)  
>create database kamazz;   

2. Импортируйте дамп базы.(выполните команду в консоли :)  
>psql kamazz < contacts_db.sql  

Файл *contacts_db.sql* находится в корне проэкта.  

#### Запуск приложения через Maven :
Загрузите исходный код проекта. Перейдите в корневую папку проекта с помощью командной строки и запустите команду:  
>mvn spring-boot:run


 

