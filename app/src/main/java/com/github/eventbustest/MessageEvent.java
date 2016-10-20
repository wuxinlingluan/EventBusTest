package com.github.eventbustest;

/**
 * Created by Administrator on 2016/10/20.
 */

public class MessageEvent {
    public final String name;
    public  final  String password;

    public MessageEvent(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
