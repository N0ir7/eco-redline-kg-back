# 生态红线知识图谱项目后端项目
> 现仍在开发中！！！

##技术栈
- SpringBoot
- MyBatis
- MySQL
- Neo4j

##预期功能

###首页
- 展示轮播图并跳转至相应页面
- 展示实例卡片并跳转至相应页面

###知识建模页面
- 导入文件或者文本提取三元组，或者直接导入三元组
- 根据三元组生成知识图谱
- 存图

###知识管理页面
- 对知识图谱增删改查

###知识共享页面
- 查看实例的详细图谱（固定JSON文件）
- 查看节点的图谱（初始展示节点及其儿子节点，可通过点击节点无限向外延伸）
- 输入两个节点名，返回两个节点之间的路径并显示

###资料共享页面
- 可提供文件进行下载
- 需要基本的文档管理系统的功能，如：
  - 分页
  - 过滤
  - 排序
  - 搜索
- 可供用户上传文件

##后续考虑
- 加入用户及权限管理
