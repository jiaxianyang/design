package com.example.design.ai;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
public class FaceRecognition {
    public static void main(String[] args) {
        // 读取图片
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("face.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 获取图片的宽度和高度
        int width = image.getWidth();
        int height = image.getHeight();
        // 将图片转换为灰度图
        int[][] gray = new int[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int rgb = image.getRGB(x, y);
                gray[x][y] = (int) (((rgb & 0xFF0000) >> 16) * 0.3 + ((rgb & 0xFF00) >> 8) * 0.59 + (rgb & 0xFF) * 0.11);
            }
        }
        // 进行人脸识别
        int faceNum = 0;
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (gray[x][y] > 200) {
                    faceNum++;
                }
            }
        }
        System.out.println("图片中共有" + faceNum + "张人脸");
    }
}