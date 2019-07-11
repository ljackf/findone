# java技术栈
1. 字符串常量池的迁移  
jdk 1.6之前字符串常量池是放在方法区，jdk1.6之后在永久代，jdk1.7后是在堆内存（运行时常量池） 如果在堆内存找不到才在静态常量池创建字符串 有的话直接返回堆内存的引用  

2. 字符串KMP算法  
其实就是根据待匹配的字符串特性减少多余的判断  
  
3. equals和hashcode  
equals是比较地址值，即两个对象是否相同，但是效率低。hashcode是用hash算法生成的hashcode，可能发生hash碰撞，但是效率高，对于频繁需要比较的场景一般的做法是先比较hashcode再比较equals，hashcode重写一般用于比较hashcode，不重写会发现同一个class，是不同的，比如hashSet就要杜绝这个情况，String和Integer都重写了  
4. 泛型、异常、反射  
集合-Map、反射一般是接入第三方框架使用的，因为是不知道具体的类的，无法编译成功，比如JDBC。  
5. string的hash算法  
采用31为系数11111[2]，质数减少碰撞，且不会溢出  
6. hash冲突的解决办法：拉链法  
 这就是hashMap的实现
7. foreach循环的原理    
   有实现iterator接口的反编译成了iterator形式，数组就是for形式。语法糖  
8. static、final、transient等关键字的作用  
static初始化时候加载到内存,final不可变、transient不可序列化的  
9. volatile关键字的底层实现原理  
    内存模型：都有自己的工作内存和主内存  
    x = 1 是原子操作 赋值写工作内存 x++、y = x等都不是源自操作，有赋值写入多个原子操作就不是原子操作  
    volatile修饰的变量保证修改的数据立马更新到主内存，别人读取的也是最新的数据，从而保持可见性，可以修饰变量双重检查防止指令重排  
10. Collections.sort排序方式  
   二分插入排序  
   11. Future以及线程池FutureTask实现
    
