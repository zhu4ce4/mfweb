package com.lqj.Listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class OnlineNumberListener implements HttpSessionListener {

    private static int online=0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        online++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        online--;
    }

    public static int getOnline() {
        return online;
    }

    public static void setOnline(int online) {
        OnlineNumberListener.online = online;
    }
}
