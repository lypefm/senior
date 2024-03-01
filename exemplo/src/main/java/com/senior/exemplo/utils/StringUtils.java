package com.senior.exemplo.utils;

import java.text.NumberFormat;
import java.util.Locale;

public class StringUtils {
    public static synchronized String formatarPreco(float preco){
        return NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(preco);
    }
}
