### 命名规范

#### Service 层

- 获取单个对象的方法用 get 做前缀。 

  ```java
  @GetMapping("/get")
  public Result getUser() {
  
  }
  方法名： getXXX()  XXX一般为去掉统一前缀的实体名
  url: 如：/get, url建议与方法名一致（去掉统一前缀，和实体名）
  请求类型：Get
      
  @GetMapping("/get/name")
  public Result getUser(UserDTO user) {
  
  }
  方法名： getXXXByFFF()  XXX一般为去掉统一前缀的实体名，FFF 一般为查询条件
  url: 如：/getByName, url 建议与方法名一致（去掉统一前缀，和实体名）,若条件过多可转为业务描述，如 /getForBusiness
  请求类型：Get
  ```

- 获取多个对象的方法用 list 做前缀，复数结尾。 

  ```java
  @PostMapping("/list")
  public Result listUsers() {
  
  }
  方法名： listXXX()  XXX一般为去掉统一前缀的实体名
  url: 如：/list, url建议与方法名一致（去掉统一前缀，和实体名）
  请求类型：Post
      
  @PostMapping("/list/name")
  public Result listUsersByName(UserDTO user) {
  
  }
  方法名： listXXXByFFF()  XXX 一般为去掉统一前缀的实体名，FFF 一般为查询条件
  url: 如：/listByName, url 建议与方法名一致（去掉统一前缀，和实体名）,若条件过多可转为业务描述，如/listForBusiness
  请求类型：Post
  ```

- 获取分页信息用 page 做前缀。

  ```java
  @PostMapping("/page")
  public Result pageUsers() {
  
  }
  方法名： pageXXX()  XXX一般为去掉统一前缀的实体名
  url: 如：/page, url建议与方法名一致（去掉统一前缀，和实体名）
  请求类型：Post
      
  @PostMapping("/page/name")
  public Result pageUsersByName(UserDTO user) {
  
  }
  方法名： pageXXXByFFF()  XXX 一般为去掉统一前缀的实体名，FFF 一般为分页条件
  url: 如：/pageByName, url建议与方法名一致（去掉统一前缀，和实体名）,若条件过多可转为业务描述，如/pageForBusiness
  请求类型：Post
  ```

- 获取统计值的方法用 count 做前缀。

  ```java
  @PostMapping("/count")
  public Result countUser() {
  
  }
  方法名： countXXX()  XXX一般为去掉统一前缀的实体名
  url: 如：/count, url建议与方法名一致（去掉统一前缀，和实体名）
  请求类型：Post
      
  @PostMapping("/count/name")
  public Result countUserByName(String name) {
  
  }
  方法名： countXXXByFFF()  XXX一般为去掉统一前缀的实体名,FFF一般为统计条件
  url: 如：/countByName, url建议与方法名一致（去掉统一前缀，和实体名）,若条件过多可转为业务描述，如/countForBusiness
  请求类型：Post
  ```

- 新增的方法用 save 做前缀。

  ```java
  @PostMapping("/save") 
  public Result saveUser(SysUser sysUser) {
  
  }
  方法名： saveXXX()  XXX一般为去掉统一前缀的实体名
  url: 如：/save, url建议与方法名一致（去掉统一前缀，和实体名）
  请求类型：Post
  ```

- 删除的方法用 remove 做前缀。

  ```java
  @PostMapping("/delete")
  public Result deleteUser() {
  
  }
  方法名： deleteXXX()  XXX一般为去掉统一前缀的实体名
  url: 如：/delete, url建议与方法名一致（去掉统一前缀，和实体名）
  请求类型：Post
      
  @PostMapping("/delete/name")
  public Result deleteUserByName(String name) {
  
  }
  方法名： deleteXXXByFFF()  XXX一般为去掉统一前缀的实体名,FFF一般为删除条件
  url: 如：/delete/name, url建议与方法名一致（去掉统一前缀，和实体名）。若条件过多可转为业务描述，如/deleteForBusiness
  请求类型：Post
  ```

- 修改的方法用 update 做前缀。

  ```java
  @PostMapping("/update")
  public Result updateUser(UserDTO user) {
  
  }
  方法名： updateXXX()  XXX一般为去掉统一前缀的实体名
  url: 如：/update, url建议与方法名一致（去掉统一前缀，和实体名）
  请求类型：Post
      
  @PostMapping("/update/name")
  public Result updateUserByName(UserDTO user) {
  
  }
  方法名： updateXXXByFFF()  XXX一般为去掉统一前缀的实体名，FFF 一般为更新条件
  url: 如：/update/name, url 建议与方法名一致（去掉统一前缀，和实体名）。若条件过多可转为业务描述，如/updateForBusiness
  请求类型：Post
  ```

#### DAO 层

- 新增用 insert 做前缀。
- 删除用 delete 做前缀。
- 修改用 update 做前缀。
- 查询用 select 做前缀。

#### 模型

- DO（Data Object）：此对象与数据库表结构一一对应，通过 DAO 层向上传输数据源对象。

- DTO（Data Transfer Object）：数据传输对象，Service 或Manager 向外传输的对象

- BO（Business Object）：业务对象，可以由 Service 层输出的封装业务逻辑的对象。

- Query：数据查询对象，各层接收上层的查询请求。注意超过 2 个参数的查询封装，禁止使用 Map 类来传输。

- VO（View Object）：显示层对象，通常是 Web 向模板渲染引擎层传输的对象。

