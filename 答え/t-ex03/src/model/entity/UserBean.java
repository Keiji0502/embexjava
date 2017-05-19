/*
 * 総合３ 解答例  UserBean.java
 *
 * Copyright(C) 2016 emBex Education Inc. All Rights Reserved.
 */
package model.entity;

import java.io.Serializable;

public class UserBean implements Serializable {

    private String name;      // 氏名
    private String kanaName;  // 氏名（カナ）
    private int sex;          // 性別
    private String strSex;    // 性別（漢字）
    private int age;          // 年齢

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKanaName() {
        return kanaName;
    }

    public void setKanaName(String kanaName) {
        this.kanaName = kanaName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
        if (sex == 0) {
            strSex = "男";
        } else {
            strSex = "女";
        }
    }

    public String getStrSex() {
        return strSex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
