package com.example.design.base;

import com.example.design.common.entity.User;
import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

@Slf4j
public class SerializeTest {

    public static void main(String[] args) throws Exception {
        User user = new User();
        user.setName("jia");
        user.setAge(18);

        serialize(user);
        log.info("Java序列化前的结果:{} ", user);

        User duser = deserialize();
        log.info("Java反序列化的结果:{} ", duser);
    }

    private static User deserialize() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/Users/jiaxianyang/develop_file/111.txt"));
        return (User) ois.readObject();
    }

    private static void serialize(User user) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/Users/jiaxianyang/develop_file/111.txt"));
        oos.writeObject(user);
        oos.close();
    }
}
