package com.sarah;

import java.net.InetSocketAddress;

import net.spy.memcached.MemcachedClient;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by vagrant on 5/6/17.
 */
public class memcache {
    private static String memcacheServer = "127.0.0.1";
    private static int memcachePort = 11211;
    private static int EXP = 60000;

    public void addStringData(String key, String value) {
        try {
            MemcachedClient cache = new MemcachedClient(new InetSocketAddress(memcacheServer, memcachePort));
            cache.add(key, EXP, value);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getStringData(String key) {
        try {
            MemcachedClient cache = new MemcachedClient(new InetSocketAddress(memcacheServer, memcachePort));
            if (cache.get(key) instanceof String) {
                String value = (String) cache.get(key);
                return value;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public void addListOfStringData(String key, String value) {
        try {
            MemcachedClient cache = new MemcachedClient(new InetSocketAddress(memcacheServer, memcachePort));
            if (cache.get(key) instanceof Set) {
                HashSet<String> valList = (HashSet<String>) cache.get(key);
                valList.add(value);
                cache.set(key, EXP, valList);
            } else {
                HashSet<String> valList = new HashSet<>();
                valList.add(value);
                cache.add(key, EXP, valList);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HashSet<String> getListOfStringData(String key) {
        try {
            MemcachedClient cache = new MemcachedClient(new InetSocketAddress(memcacheServer, memcachePort));
            if (cache.get(key) instanceof HashSet) {
                HashSet<String> valList = (HashSet<String>) cache.get(key);
                return valList;
            } else
                return null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
