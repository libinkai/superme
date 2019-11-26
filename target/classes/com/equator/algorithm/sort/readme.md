# 说明
- 以整数数组作为示例
- 默认为升序排序

# 排序
## 交换排序类
- 冒泡排序
- 快速排序
- 快速排序时可能发生StackOverflowError异常，因为其基于栈进行递归调用。可以设置虚拟机参数
Run-->Edit Configurations-->VM Options添加参数 -Xss1024M 增加JVM栈内存