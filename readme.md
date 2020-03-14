# 说明
> 本代码为各种数据结构以及算法的Demo（运行环境 JDK8）

# 数据结构
## 数组
- [实现一个int数组并完成增删改查](./src/main/java/com/equator/datastruct/array/MyIntArray.java)
- [实现一个泛型动态数组并实现增删改查](./src/main/java/com/equator/datastruct/array/MyGenericArray.java)
- 时间复杂度分析以及均摊时间复杂度：并不是每次操作都会触发resize方法，resize的成本可以均摊到其它的操作上面
- 防止时间复杂度的震荡（延迟缩容的时机）：缩容的条件与扩容的条件不对偶即可，如扩容2倍，那么在数组元素为容量的1/4时缩容一半，而不是在数组元素为容量的1/2时缩容

# 算法

# leetcode题解