### 完成度：
* 功能都完成了, well down

__Details:__

- \- 返回的分组缺少组名
- \- 应该在点击分组的时候才生成组

### 测试：
* 有Controller层测试，覆盖了部分功能的Happy Path

__Details:__



### 知识点：
* 需要了解Restful实践
* 需要了解下三层架构
* 了解下lombok的使用

__Details:__

- \- 推荐使用构造器注入
- \- 没有使用泛型
- \- 违反Restful实践, url不合理
- \- 违反Restful实践, Post请求成功后应该返回201
- \- 应该使用Repository层保存数据

### 工程实践：
* 需要加强面向对象的意识
* 注意单一职责，group和student应该有单独的Controller和Service

__Details:__

- \- 注意代码风格，方法名和小括号中间不加空格
- \- 应该创建专门的对象来表示Group
- \- 方法名不合理
- \- 代码不优雅
- \- 计算id的方式不够健壮，可以使用字段保存最大id
- \- 长方法，建议抽子方法来提高可读性
- \- Magic Number

### 综合：


__Details:__



