package com.example.design.base;

import com.example.design.juc.c006.T;
import lombok.SneakyThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author jiaxianyang
 * @date 2025/2/14 14:58
 */
@ExtendWith(MockitoExtension.class)
public class CopyOnWriteArrayListTest {

    public static void main(String[] args) throws InterruptedException {
        List<String> userNames = new CopyOnWriteArrayList<String>() {{
            add("Hollis");
            add("hollis");
            add("HollisChuang");
            add("H");
        }};


        Iterator it = userNames.iterator();

        for (String userName : userNames) {
            if (userName.equals("Hollis")) {
                userNames.remove(userName);
            }
        }

        System.out.println(userNames);

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

}
