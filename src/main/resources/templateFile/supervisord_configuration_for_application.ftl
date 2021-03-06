[program:${applicationName}]
command=${command}   ; 程序启动命令(必须使用完整路径)
autostart=false       ; 在supervisord启动的时候也自动启动
startsecs=10         ; 启动10秒后没有异常退出，就表示进程正常启动了，默认为1秒
autorestart=unexpected     ; 程序退出后自动重启,可选值：[unexpected,true,false]，默认为unexpected，表示进程意外>杀死后才重启
startretries=3       ; 启动失败自动重试次数，默认是3
user=${user}          ; 用哪个用户启动进程，默认是root
priority=999         ; 进程启动优先级，默认999，值小的优先启动
redirect_stderr=false    ; 把stderr重定向到stdout，默认false
stdout_logfile_maxbytes=20MB  ; stdout 日志文件大小，默认50MB
stdout_logfile_backups = 20   ; stdout 日志文件备份数，默认是10
stdout_logfile=${logDirParentPath}/log/${applicationName}.log    ;设置日志文件的路径
stdout_errfile_maxbytes=20MB  ; stdout 日志文件大小，默认50MB
stdout_errfile_backups = 20   ; stdout 日志文件备份数，默认是10
stdout_errfile=${logDirParentPath}/log/${applicationName}.err.log    ;设置日志文件的路径
stopasgroup=false     ;默认为false,进程被杀死时，是否向这个进程组发送stop信号，包括子进程
killasgroup=false     ;默认为false，向进程组发送kill信号，包括子进程