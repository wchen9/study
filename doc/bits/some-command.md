# 使用过的某些实用命令

## virtualbox 重新生成 disk 的 uuid(复用 disk 创建多个虚拟机)

`VBoxManage.exe internalcommands sethduuid "CentOS 8.4 Server (64bit).vdi"`

## 使用 root 直接无视简单密码校验修改密码

`echo "1" | passwd --stdin osboxes`


## redis 安装并作为服务启动，允许局域网远程连接

https://linuxize.com/post/how-to-install-and-configure-redis-on-centos-7/


## windows 创建计划任务定期访问某个网址

```powershell
schtasks /create /tn "aaa-visit-speedtest" /tr "powershell -ExecutionPolicy Bypass -Command Invoke-WebRequest 'https://www.speedtest.cn/' -UseBasicParsing" /sc HOURLY /ru System
```
