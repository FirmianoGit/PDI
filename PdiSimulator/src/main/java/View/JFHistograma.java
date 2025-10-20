package View;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class JFHistograma extends JPanel {

    private int[] histograma; // array com 256 posições para frequências
    private final int margemInferior = 20; // espaço para legenda
    private final int margemEsquerda = 30;  // espaço para valores verticais

    public JFHistograma() {
        setPreferredSize(new Dimension(750, 100)); // painel maior
    }

    public void calcularHistograma(BufferedImage imagem) {
        histograma = new int[256];
        for (int y = 0; y < imagem.getHeight(); y++) {
            for (int x = 0; x < imagem.getWidth(); x++) {
                int rgb = imagem.getRGB(x, y);
                int r = (rgb >> 16) & 0xFF;
                int g = (rgb >> 8) & 0xFF;
                int b = rgb & 0xFF;
                int cinza = (int) (0.2126 * r + 0.7152 * g + 0.0722 * b);
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

        int largura = getWidth() - margemEsquerda;  // largura útil para barras
        int altura = getHeight() - margemInferior;  // altura útil para barras

        // Valor máximo para escalar
        int max = 0;
        for (int valor : histograma) {
            if (valor > max) {
                max = valor;
            }
        }

        if (max == 0) {
            return;
        }

        double escala = (double) altura / max;

        g.setColor(Color.BLACK);

        // Calcula espaçamento horizontal
        double espacamento = (double) largura / 256;

        // Desenha exatamente 256 barras
        for (int i = 0; i < 256; i++) {
            int alturaBarra = (int) (histograma[i] * escala);
            int posX = margemEsquerda + (int) (i * espacamento);
            g.drawLine(posX, altura, posX, altura - alturaBarra);
        }

        // Legendas
        g.setColor(Color.BLACK);
        g.drawString("0", margemEsquerda, altura + 15);
        g.drawString("255", margemEsquerda + largura - 20, altura + 15);
        g.drawLine(margemEsquerda, altura, margemEsquerda + largura, altura);
    }

}
