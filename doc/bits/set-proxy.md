# 常用软件代理设置

## anki

```bat
set HTTP_PROXY=socks5://127.0.0.1:7890
set HTTPS_PROXY=socks5://127.0.0.1:7890
start anki.exe
exit
```

## git

```sh
git config --global http.proxy 'socks5://127.0.0.1:7890'
git config --global https.proxy 'socks5://127.0.0.1:7890'
```

在 .ssh/config 文件中添加配置，使 git 协议的仓库走代理.
```
ProxyCommand connect -S 127.0.0.1:7890 %h %p
```

## powershell 中使用命令设置环境变量

```powershell
# 设置
[Environment]::SetEnvironmentVariable("HTTP_PROXY","socks5h://127.0.0.1:7890","User")
[Environment]::SetEnvironmentVariable("HTTPS_PROXY","socks5h://127.0.0.1:7890","User")
[Environment]::SetEnvironmentVariable("HTTP_PROXY","http://127.0.0.1:7890","User")
[Environment]::SetEnvironmentVariable("HTTPS_PROXY","http://127.0.0.1:7890","User")
# 取消
[Environment]::SetEnvironmentVariable("HTTP_PROXY",$null,"User")
[Environment]::SetEnvironmentVariable("HTTPS_PROXY",$null,"User")
```

## windows 下使用 poetry 可能存在哪些问题？

1. 代理设置里面socks 代理需修改为 socks5h，因为可能遇到 `ConnectionError` 报错；
2. 在 VSCode 里面使用 poetry 添加包，可能会因 IDM 导致无法下载。

## 参考文档
- [1] [如何为你的命令行设置加速](https://segmentfault.com/a/1190000040510873)
- [2] [powershell set environemnt](https://www.digitalcitizen.life/remove-edit-clear-environment-variables/)
