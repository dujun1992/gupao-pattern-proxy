package com.gupao.example.db;

/**
 * Created by DJ on 2019年07月23日 19:35
 * 模拟动态切换数据源
 **/
public class DynamicDataSourceEntity {
    public final static String DEFAULE_SOURCE = null;

    private final static ThreadLocal<String> local = new ThreadLocal<String>();

    private DynamicDataSourceEntity(){}


    public static String get(){return  local.get();}

    public static void restore(){
        local.set(DEFAULE_SOURCE);
    }

    public static void set(String source){local.set(source);}

    public static void set(int year){local.set("DB_" + year);}
}
