package com.ljf.demo;

import java.util.concurrent.*;

/**
 * @author liujf05
 * @date 2019/3/18
 */
public class ThreadExecutorTest {
    public static final ThreadPoolExecutor e = new ThreadPoolExecutor(2,2,60000L, TimeUnit.MILLISECONDS,new LinkedBlockingDeque<>());

    public static ExecutorService executor = Executors.newCachedThreadPool();
}
