# uploader
一个自带jetty容器、提供restful接口的jar包级启动配置服务
### 启动
windows运行程序在bin目录下run.bat<br>
linux运行程序所在bin目录下run.sh
### 配置
默认端口为8888，上传文件的根目录为jar包所在目录<br>
端口修改：修改run.bat或run.sh的`-port`后面参数<br>
目录修改：修改run.bat或run.sh的`-uploadpath`后面参数<br> 
### 访问 
`http://yourip:port/upload`
### restful api
前端使用post方法mulitpart/form_data<br><br>
`file`      上传的文件<br>
`path`      上传在根目录下的哪个目录,必须事先创建<br>
`file_name` 上传文件改名<br>
