package org.wangc.dp.creational.singleton;

/**
 * @Title:
 * @Description:
 * @Company: 北京九恒星科技股份有限公司
 * @author: 王晨
 * @Date: 2021/10/11 17:43
 */
public class ThreadSafeLazyLoadedSingleton {

    private static volatile ThreadSafeLazyLoadedSingleton instance;

    public String value;

    private ThreadSafeLazyLoadedSingleton(String value){

        if(instance != null){
            throw new IllegalStateException("Already initialized.");
        }

        this.value = value;
    }

    public static ThreadSafeLazyLoadedSingleton getInstance(String value){
        ThreadSafeLazyLoadedSingleton result = instance;
        if(result != null){
            return  result;
        }
        synchronized (ThreadSafeLazyLoadedSingleton.class){
            if(instance == null){
                instance = new ThreadSafeLazyLoadedSingleton(value);
            }

            return instance;
        }
    }

}
