package com.example.demo;

import lombok.Data;

/**
 * @author fanchaochao
 * @className A
 * @description
 * @date 2020-03-02 16:41
 **/
@Data
public class A {
    String a;
}

class Solution {
    public double myPow(double x, int n) {
        double res = x;
        if (n > 0){
            for (int i = 0; i < n - 1; i++){
                res *= x;
            }
        }else if (n < 0){
            for (int i = 0; i >= n; i--){
                res *= 1/x;
            }
        }
        return res;
    }
}
