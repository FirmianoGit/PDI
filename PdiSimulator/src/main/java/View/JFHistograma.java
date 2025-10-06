/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author Firmiano
 */
public class JFHistograma extends JPanel {
    private int[] histograma; // array com 256 posições para frequências

    public void calcularHistograma(BufferedImage imagem) {
        histograma = new int[256];
        for (int y = 0; y < imagem.getHeight(); y++) {
            for (int x = 0; x < imagem.getWidth(); x++) {
                int rgb = imagem.getRGB(x, y);
                int r = (rgb >> 16) & 0xFF;
                int g = (rgb >> 8) & 0xFF;
                int b = rgb & 0xFF;
                // Usar luminosidade para escala de cinza
                int cinza = (int)(0.2126 * r + 0.7152 * g + 0.0722 * b);
                histograma[cinza]++;
            }
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (histograma == null) {
            return;
        }
        int largura = getWidth();
        int altura = getHeight();

        int max = 0;
        for (int valor : histograma) {
            if (valor > max) {
                max = valor;
            }
        }

        double escala = (double) altura / max;

        int larguraBarra = largura / histograma.length;

        for (int i = 0; i < histograma.length; i++) {
            int alturaBarra = (int)(histograma[i] * escala);
            g.fillRect(i * larguraBarra, altura - alturaBarra, larguraBarra, alturaBarra);
        }
    }
}
