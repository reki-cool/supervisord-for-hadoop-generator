# supervisor针对守护进程的配置生成器
## 重要参数解释
 - common:
    - monitor-dir-parent-path
        ```
        这个路径是用来保存监控脚本的；
        这些监控脚本是用来监控守护进程的PID文件和进程号的，是本程序自动生成的；
        ```
    - log-dir-parent-path
        ```
        supervisord在执行程序的supervisor配置时，会产生正常输出的日志文件和错误日志文件，
        这个路径就是用来保存这些日志文件的路径
        ```
    - supervisord-conf-user
        ```
        这个用户是用来执行上述的监控脚本的用户，和supervisord守护进程应当是一个用户，
        supervisord守护进程的用户一般都是root用户，所以这个用户一般也是root
        ```
    - monitor-shell-user
        ```
        监控脚本在监控守护进程时，使用的应该是正常启动守护进程时使用的用户，
        所以应该和程序的使用用户一致；
        ```
## 使用办法
访问: http://localhost:8080/generate  
将生成的```src\main\resources\output```路径下的```monitor```目录拷贝到服务器的```${monitor-dir-parent-path}```中去;  
同时，将生成的```src\main\resources\output```路径下的```conf```目录拷贝到服务器supervisor守护进程可以读取的配置目录中；


