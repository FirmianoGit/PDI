/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.ampliacoes;

import java.awt.image.BufferedImage;

public class Ampliacoes {

    public static BufferedImage ampliarNearestNeighbor(BufferedImage imgOriginal, int novaLargura, int novaAltura) {
        int largura = imgOriginal.getWidth();
        int altura = imgOriginal.getHeight();

        BufferedImage novaImg = new BufferedImage(novaLargura, novaAltura, imgOriginal.getType());
        double escalaX = (double) largura / novaLargura;
        double escalaY = (double) altura / novaAltura;

        for (int y = 0; y < novaAltura; y++) {
            for (int x = 0; x < novaLargura; x++) {
                int px = (int) (x * escalaX);
                int py = (int) (y * escalaY);
                int cor = imgOriginal.getRGB(px, py);
                novaImg.setRGB(x, y, cor);
            }
        }
        return novaImg;
    }

    public static BufferedImage ampliarBilinear(BufferedImage imgOriginal, int novaLargura, int novaAltura) {
        int largura = imgOriginal.getWidth();
        int altura = imgOriginal.getHeight();

        BufferedImage novaImg = new BufferedImage(novaLargura, novaAltura, imgOriginal.getType());
        double escalaX = (double) (largura - 1) / (novaLargura - 1);
        double escalaY = (double) (altura - 1) / (novaAltura - 1);

        for (int y = 0; y < novaAltura; y++) {
            for (int x = 0; x < novaLargura; x++) {
                double gx = x * escalaX;
                double gy = y * escalaY;

                int x0 = (int) gx;
                int y0 = (int) gy;
                int x1 = Math.min(x0 + 1, largura - 1);
                int y1 = Math.min(y0 + 1, altura - 1);

                double dx = gx - x0;
                double dy = gy - y0;

                int rgb00 = imgOriginal.getRGB(x0, y0);
                int rgb10 = imgOriginal.getRGB(x1, y0);
                int rgb01 = imgOriginal.getRGB(x0, y1);
                int rgb11 = imgOriginal.getRGB(x1, y1);

                int r = (int) (
                        (1 - dx) * (1 - dy) * ((rgb00 >> 16) & 0xFF) +
                        dx * (1 - dy) * ((rgb10 >> 16) & 0xFF) +
                        (1 - dx) * dy * ((rgb01 >> 16) & 0xFF) +
                        dx * dy * ((rgb11 >> 16) & 0xFF)
                );
                int g = (int) (
                        (1 - dx) * (1 - dy) * ((rgb00 >> 8) & 0xFF) +
                        dx * (1 - dy) * ((rgb10 >> 8) & 0xFF) +
                        (1 - dx) * dy * ((rgb01 >> 8) & 0xFF) +
                        dx * dy * ((rgb11 >> 8) & 0xFF)
                );
                int b = (int) (
                        (1 - dx) * (1 - dy) * (rgb00 & 0xFF) +
                        dx * (1 - dy) * (rgb10 & 0xFF) +
                        (1 - dx) * dy * (rgb01 & 0xFF) +
                        dx * dy * (rgb11 & 0xFF)
                );

                int corFinal = (0xFF << 24) | (r << 16) | (g << 8) | b;
                novaImg.setRGB(x, y, corFinal);
            }
        }
        return novaImg;
    }
}

