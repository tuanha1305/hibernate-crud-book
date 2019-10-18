# Simple CRUD App using Servlet & Hibernate
## Step 1: Create database & table
database: crud_servlet_jsp
```sql
create database hibernate
```
table: books
```sql
CREATE TABLE `books` (
  `id` int(11) NOT NULL,
  `ten` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `mota` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
```
## Step 2: Change your url database, user & password in hibernate.cfg.xml
Change here:
```xml
...
<property name="connection.driver_class">com.mysql.jdbc.Driver</property>
<property name="connection.url">jdbc:mysql://localhost:3306/crud_example</property>
<property name="connection.username">root</property>
<property name="connection.password"></property>
...
```
Read tutorial [Tìm hiểu Hibernate và tạo ra 1 ứng dụng quản lý sách đơn giản](2019/10/17/tim-hieu-hibernate-va-tao-ra-1-ung-dung-quan-ly-sach.html)

Thanks for watching !
