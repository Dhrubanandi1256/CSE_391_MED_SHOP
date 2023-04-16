package com.example.carg.global;

import com.example.carg.model.Product;

import java.util.ArrayList;
import java.util.List;

public class GlobalData {
    public static List<Product>cart;
    static {
        cart=new ArrayList<Product>();

    }
}
