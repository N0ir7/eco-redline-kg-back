# 生态红线知识图谱项目后端项目
> 现仍在开发中！！！
## 技术栈

- SpringBoot 2.6
- MyBatis
- MySQL
- Neo4j
- JDK11
- Swagger 3.0

# 一些说明

- 所有数据应该统一返回成如下形式:

  ```json
  {
    code:
    msg:
    data:
  }
  ```

- 对于状态码和信息，请自行发挥一下

  - 所有可能出现的状态码和信息应提前写至Vo包下的ResultCode内

- params为必须传的参数，options为可选参数

- 数据库表请自行设计

- 节点id可以考虑使用Integer，也可以考虑使用uuid（字符串），若使用字符串，以下id均改为String

# 知识共享展示界面

**base_url:**`/detail`

## 获取实例/卡片对应的图谱json文件

**url: **`/getGraph`

**method:** get

**params**：none

**options:**

- inId
  - Integer
  - Request Param
  - 实例卡片的id
- nodeId
  - Integer
  - Request Param
  - 节点的id

**function**：

- 当传入实例卡片的inId，返回实例对应的json（固定json文件）
- 当传入节点的nodeId，返回节点对应的json（返回该节点及其第一代儿子节点的json）
- 当两个都传时，只处理实例卡片的。
- 当两个都未传时，应抛出异常并返回对应的错误码

**data format：**

```json
{
  nodes:[
    id: 节点id,
    name: 节点名称,
    description: 节点描述, 
    imgUrl:节点背景图片地址
  ],
  links:[
    id: 边id,
    from: 源节点id,
    to: 目标节点id,
    name: 边名称,
    description: 边描述
  ]
}
```

## 获取两个节点之间的路径

**url: **`/getRoute`

**method:** get

**params**：

- fromName
  - String
  - Request Param
  - 源节点名称
- toName
  - String
  - Request Param
  - 目标节点名称

**function**：

- 传入两个节点的名称，返回其间的路径的node与link的json文件
- 当源节点或者目标节点不存在时，应当抛出异常并返回相应状态信息
  - 需具体到是源还是目标节点找不到

**data format：**

```json
{
  nodes:[
    {
      id: 节点id,
    	name: 节点名称,
    	description: 节点描述, 
    	imgUrl:节点背景图片地址
    }
  ],
  links:[
    {
    	id: 边id,
    	from: 源节点id,
    	to: 目标节点id,
    	name: 边名称,
    	description: 边描述
    }
  ]
}
```

# 知识管理界面

**base_url**:`/manage`

## 获取相关节点

**url: **`/getNodes`

**method:** get

**params**：

- pageNo
  - Integer
  - Request Param
  - 页号，从1开始
  - default：1
- pageSize
  - Integer
  - Request Param
  - 每页的数量
  - default：4

**options**:

- name
  - String
  - Request Param
  - 搜索词

**function**：

- 需支持分页功能，传入页号和页大小，返回对应的节点数组
- 需对页号和页大小做校验，若超出总节点数，抛出相应异常与信息
- 需返回最大页数
- 若传入了name，对节点名使用name进行模糊查询，返回节点数组

**data format：**

```json
{
  nodes:[
    {
      id: 节点id,
    	name: 节点名称,
    	description: 节点描述, 
    	imgUrl:节点背景图片地址
    }
  ],
  totalNum:数据库中以给定pageSize的最大页数
}
```

## 获取相关实例

**url: **`/getInstance`

**method:** get

**params**：

- pageNo
  - Integer
  - Request Param
  - 页号，从1开始
  - default：1
- pageSize
  - Integer
  - Request Param
  - 每页的数量
  - default：4

**options**：

- name

  - String

  - Request Param

  - 搜索词

**function**：

- 需支持分页功能，传入页号和页大小，返回对应的实例json文件
- 需对页号和页大小做校验，若超出总节点数，抛出相应异常与信息
- 需返回最大页数
- 若传入了name，则对实例标题和实例描述使用name进行模糊查询，返回对应实例数组

**data format：**

```json
{
  instances:[
    {
      id: 实例id,
      title: 实例标题
    	description: 实例描述, 
    	imgUrl:实例背景图片地址
    }
  ],
  totalNum:数据库中以给定pageSize的最大页数
}
```

# 资料下载界面

**base_url:**`/document`

## 获取所有的资料信息

**url: **`/getDocuments`

**method:** get

**params**：

- pageNo
  - Integer
  - Request Param
  - 页号，从1开始
  - default: 1
- pageSize
  - Integer
  - Request Param
  - 每页的数量
  - default: 10

**options**:

- name
  - String
  - Request param
  - 文件名

- type
  - Integer
  - Request Param
  - 文件类型

**function**：

- 需支持分页功能，传入页号和页大小，返回对应的资料数组
- 需对页号和页大小做校验，若超出总节点数，抛出相应异常与信息
- 需返回最大页数
- 若传入了文件名，对文件名作模糊查询
- 若传入了文件类型，对文件类型作筛选

**data format：**

```json
{
  documents:[
    {
      id: 资料id,
    	name: 资料名称（含后缀）,
    	uploadDate: 上传时间, 
    	downloads: 下载量,
      type: 资料类型,
      size: 文件大小，单位kb
    }
  ],
  totalNum:数据库中以给定pageSize的最大页数
}
```

资料类型暂定有4种，可以考虑以int对应：

- 标准文件--1
- 文献--2
- 数据--3
- 报告--4

## 下载相应的资料

**url: **`/download`

**method:** get

**params**：

- id

**function**：

- 给定文件id，返回相应文件流
- 需对id作是否存在判断，不存在或者id为空都抛出异常并返回相应信息
- 记得使相应文件的下载量+1

**data format：**

- 文件流