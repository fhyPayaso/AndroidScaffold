package cn.fhypayaso.androidscaffold.login;

/**
 * @author FanHongyu.
 * @since 18/4/17 20:00.
 * email fanhongyu@hrsoft.net.
 */

public class UserModle {


    private String name;
    private int id;
    private int age;


    public UserModle(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
