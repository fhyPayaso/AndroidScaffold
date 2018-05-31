package cn.fhypayaso.androidscaffold.business;

import java.io.Serializable;

/**
 * @author FanHongyu.
 * @since 18/5/31 21:02.
 * email fanhongyu@hrsoft.net.
 */

public class TestModel implements Serializable{


    String a;
    String b;

    public TestModel(String a, String b) {
        this.a = a;
        this.b = b;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }
}
