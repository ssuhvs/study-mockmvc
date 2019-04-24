# study-mockmvc

## 本项目使用使用SpringBoot2.13+JPA，主要目的是学习MockMVC。

###　1、首先在Mysql中创建名称为sunshine数据库，当然也可以修改application.properties中spring.datasource.url连接地址为你自己的。

###　2、测试本项目的接口：点击MockApplication启动类启动项目，数据表会自动进行创建，不过数据需要自行添加。(本项目要不要数据表无所谓，因为根本不会跟数据持久层交互，也就是说不会从数据库中取出真实数据进行返回，返回的都是mock的数据)。

###　3、测试外部项目的接口：使用httpClient　＋　Junit


使用了　lombok　不想用的可以删除




