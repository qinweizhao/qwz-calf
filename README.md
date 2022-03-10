<p align="center">
  <a class="logo" href="https://github.com/qinweizhao/qwz-calf">
    <img src="https://cdn.jsdelivr.net/gh/qinweizhao/qwz-calf@master/logo.png" height="80" width="45%" alt="Calf">
  </a>
</p>

<p align="center">
👉 <a href="https://www.qinweizhao.com">https://www.qinweizhao.com</a> 👈
</p>

<p align="center">
  <a href="https://github.com/qinweizhao/qwz-calf" target="_blank">
    <img src="https://img.shields.io/badge/Release-1.0.0-green" alt="Release"/>
  </a>
</p>


![Alt](https://repobeats.axiom.co/api/embed/eb3662176aaf698084ee4be0d84f33895612eac1.svg "Analytics image")

## 简介

calf 是一个前后端分离的权限管理系统。

### 技术栈

- 前端采用 Vue、Element UI、Axios 。
- 后端采用 Spring Boot、SpringSecurity 、Jwt、Hibernate validatior、MyBatis Plus 。

### 仓库结构

```
qwz-calf
├─calf-backend  后端源码
│
├─calf-frontend 前端源码
│ 
├─calf-resource 项目资源
```

## 使用

- 启动项目

    1. 用 calf-resource 中的 sql 文件创建数据库。

    2. 更改 calf-back 配置文件中的数据库配置（根据实际情况更改）

    3. 项目地址：http://ip:port/index.html
- 二次开发
    1. 这个需要部署前端。前端在运行时，需要准备一个 nodejs。
    2. 前端项目打开后，需要在项目根目录下，执行 npm install （默认安装比较慢，可以修改为淘宝的源。[下载源修改为淘宝](https://mp.weixin.qq.com/s/HWRYAR16vLE1XFep6_i1tA)）。
    3. npm install 执行成功后，再执行 npm run serve 启动前端项目。
    4. 二次开发完成后，执行 npm run build 前端编译打包。把打包后的文件拷贝到后端。

## 演示

### 体验地址



<p align="center">
👉 <a href="https://www.qinweizhao.com:88">http://www.qinweizhao.com:88</a> 👈
</p>

### 部分截图

<table>
    <tr>
        <td><img src="https://cdn.jsdelivr.net/gh/qinweizhao/qwz-calf/calf-resource/img/2021-12-27_175324.png"/></td>
        <td><img src="https://cdn.jsdelivr.net/gh/qinweizhao/qwz-calf/calf-resource/img/2021-12-27_175351.png"/></td>
    </tr>
    <tr>
        <td><img src="https://cdn.jsdelivr.net/gh/qinweizhao/qwz-calf/calf-resource/img/2021-12-27_175404.png"/></td>
        <td><img src="https://cdn.jsdelivr.net/gh/qinweizhao/qwz-calf/calf-resource/img/2021-12-27_175453.png"/></td>
    </tr>
    <tr>
        <td><img src="https://cdn.jsdelivr.net/gh/qinweizhao/qwz-calf/calf-resource/img/2022-02-04_220740.png"/></td>
        <td><img src="https://cdn.jsdelivr.net/gh/qinweizhao/qwz-calf/calf-resource/img/2022-02-04_220749.png"/></td>
    </tr>
    <tr>
        <td><img src="https://cdn.jsdelivr.net/gh/qinweizhao/qwz-calf/calf-resource/img/2022-02-04_220813.png"/></td>
        <td><img src="https://cdn.jsdelivr.net/gh/qinweizhao/qwz-calf/calf-resource/img/2022-02-04_220823.png"/></td>
    </tr>
</table>
