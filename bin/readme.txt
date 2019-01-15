启动:
	windows运行程序在目录下run.bat
	linux运行程序所在目录下run.sh(需要分配执行权限)


访问:
	方法:post
	格式:mulitpart/form_data
	参数:
		file:      上传的文件
		path:	   上传在根目录下的哪个目录,必须事先创建
		file_name: 上传文件改名
	地址:http://127.0.0.1:8888/upload

-------------------------------------------------------------------------
自定义配置:
	默认端口为8888，上传文件的根目录为jar包所在目录
	端口修改：修改run.bat或run.sh的-port后面参数
	目录修改：修改run.bat或run.sh的-uploadpath后面参数





