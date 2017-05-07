package com.sarah;

import com.sarah.memcache;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) {

        test();
        // write your code here

    }

    public static void doPut(String key, HashSet<String> varlist) {
        memcache memclient = new memcache();
        for (String val : varlist) {
            memclient.addListOfStringData(key, val);
        }
    }

    public static void doGet(String key) {
        memcache memclient = new memcache();
        HashSet<String> varlist = new HashSet<>();
        varlist = memclient.getListOfStringData(key);
        for (String val : varlist) {
            System.out.println(val);
        }

    }

    public static void test1() {
        String key = "ds2";
        String value = "127.0.0.1";
        memcache memclient = new memcache();
        memclient.addStringData(key, value);
        System.out.println(memclient.getStringData(key));
    }

    public static void test() {
        String key2 = "ds2";
        HashSet<String> vallist = new HashSet<>();
        vallist.add("127.0.0.11");
        vallist.add("127.0.0.2");
        vallist.add("127.0.0.13");
        vallist.add("127.0.0.4");
        doPut(key2, vallist);
        doGet(key2);
    }
}
