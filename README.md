# SSMbookstore
基于SSM整合框架的网上书城,由SpringBoot启动。
仅后端，前端的静态页部分和数据库的.sql是专业课老师发的资源包,搜了下数据库里的信息应该是来自北京市昌平区金燕龙办公楼一层传智播客。</br>
controller写到后面一个文件堆太多方法了，还没写多少注释，由本人全权负责otz</br>
**除非画了类图和业务流程图，否则代码不加注释就是自杀**
这下不得不写read me了。 </br>
端口号：8080</br>
使用数据库：MySQL</br>
***
## 控制层

* 特殊：MyController: /jump.action:用来回到根目录指定文件夹跳到想要的位置（:P</br>
					/:主页重定向至/client/ShowIndex.action</br>

### 1、用户
LoginController: /client/login.action登录</br>
IfLoginController: /client/iflogin.action判断是否登录状态，否则返回权限不足页面</br>
LogoutController: /client/logout.action登出 </br>
ModifyController: /modifyuserinfo.action更改用户信息</br>
RegisterController:/register.action注册，user表中新增一行</br>
</br>
ProductsController:  /client/findProductById.action用来打开商品页</br>
								/showProductByPage.action根据商品类别返回符合的商品列表</br>
								/findProductByName.action模糊查询商品名，返回符合的商品列表</br>
ShowIndexController:/client/ShowIndex.action显示主页，但包括最新添加的商品显示</br>
</br>
### 2.网站管理人员
ListProductController: /admin/list.action后台展示所有商品</br>
									/admin/complex.action多条件复合查询商品（允许有空允许模糊）</br>
									/admin/search.action用来根据商品id打开编辑操作（同时编辑框显示商品内容）</br>
									/admin/edit.action提交编辑后的商品</br>
									/admin/add.action提交新增的商品</br>
									/admin/delete.action删除这件商品（也许应该有个确认按钮或者回收站）</br>
OrdersAdminController:/admin/orderlist.action展示所有订单</br>
									 /admin/findOrderByManyCondition.action多条件复合查询订单（允许有空允许模糊）</br>
									 /admin/delOrderById.action删除这个订单</br>
***
参考
