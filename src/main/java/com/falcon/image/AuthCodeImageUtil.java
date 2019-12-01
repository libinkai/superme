package com.falcon.image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * @Author: Equator
 * @Date: 2019/11/30 16:34
 **/

public class AuthCodeImageUtil {
    private static int height = 32;
    // 128/4 = 32
    private static int width = 128;
    private static String charSet = "ABCDEFGHJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static int charSetLength = charSet.length();
    private static int fontSize = 20;

    public void generateImage() throws IOException {
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = bufferedImage.getGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, width, height);
        addChar((Graphics2D) graphics);
        addLine((Graphics2D) graphics);
        ImageIO.write(bufferedImage, "jpg", new File("X:/test.jpg"));
    }

    private void addChar(Graphics2D graphics2D) {
        graphics2D.setColor(Color.RED);
        graphics2D.setFont(new Font("KAITI", Font.BOLD, fontSize));
        Random random = new Random();
        int index, degree, x, y;
        StringBuilder authCode = new StringBuilder();
        String charContent;
        for (int i = 0, bit = width / height, charWidth = width / bit; i < bit; i++) {
            degree = new Random().nextInt() % 45;
            x = (i * charWidth) + charWidth / 2;
            y = height * 2 / 3;
            index = random.nextInt(charSetLength);
            charContent = String.valueOf(charSet.charAt(index));
            graphics2D.rotate(degree * Math.PI / 180, x, y);
            graphics2D.drawString(charContent, x, y);
            graphics2D.rotate(-degree * Math.PI / 180, x, y);
            authCode.append(charContent);
        }
        System.out.println(authCode);
    }

    private void addLine(Graphics2D graphics2D) {
        graphics2D.setColor(Color.GREEN);
        //随机在(x1,y1),(x2,y2)画五条线
        for (int i = 0; i < 3; i++) {
            int x1 = new Random().nextInt(width);
            int y1 = new Random().nextInt(height);
            int x2 = new Random().nextInt(width);
            int y2 = new Random().nextInt(height);
            graphics2D.drawLine(x1, y1, x2, y2);
        }
    }

    public static void main(String[] args) throws IOException {
        new AuthCodeImageUtil().generateImage();
    }
}
