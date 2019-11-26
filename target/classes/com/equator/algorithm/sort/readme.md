# 说明
- 以整数数组（长度10W，内容随机）作为示例
- 默认为升序排序

# 排序分类
## 基于比较的排序
### 交换排序类：冒泡排序 bubble、快速排序 quick
> 每次只调换两个元素之间的值
- 快速排序时可能发生StackOverflowError异常，因为其基于栈进行递归调用。
可以设置虚拟机参数Run-->Edit Configurations-->VM Options添加参数 -Xss1024M 增加JVM栈内存
### 插入排序类：直接插入排序 insertion、希尔排序 shell
> 遍历到的元素放入到之前维护的已经完成排序的序列中
### 选择排序类：直接选择排序selection、堆排序 heap
> 选择剩余元素中最大或者最小的元素
### 归并排序 merge
## 非基于比较的排序
### 计数排序 counting
### 基数排序 radix
### 桶排序 bucket