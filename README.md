# springmvc-demo

## 小笔记
### @RequestMapping
* url 映射
* 限制请求方法
* 明确请求类型

e.g.`@RequestMapping(value = "/sayhello/{sb}", method = RequestMethod.GET)`

### GET 请求 & POST 请求接收参数
* GET
	* `@RequestParam` 关键字修饰
* POST
	* `@RequestBody` 关键字修饰

### @ResponseBody
* 将Controller的方法返回的对象，通过适当的HttpMessageConverter转换为指定格式后，写入到Response对象的body数据区。
* 返回的数据不是 jsp 页面，而是其他某种格式的数据时（如json、xml等）使用；

### 解决中文乱码问题
``` xml
<!-- web.xml 文件 -->
<!-- encoding filter -->
  <filter>
    <filter-name>encodingFilter</filter-name>
    <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
    <init-param>
      <param-name>encoding</param-name>
      <param-value>utf8</param-value>
    </init-param>
  </filter>
  <filter-mapping>
    <filter-name>encodingFilter</filter-name>
    <url-pattern>/*</url-pattern>
  </filter-mapping>
```