package com.user;

import java.util.ArrayList;

import  main.java.com.api.app.*;

public class App
{
    public static void  main(String[] args ) {
        int cidade = 1010500;
            cidade = Integer.parseInt(args[0]);
            System.out.println(cidade);


        IpmaClient a = new IpmaClient();
        a.callApi(cidade);


    }
}