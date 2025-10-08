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

        int largura = getWidth() - margemEsquerda; // largura útil
        int altura = getHeight() - margemInferior; // altura útil

        // Encontrar o valor máximo
        int max = 0;
        for (int valor : histograma) {
            if (valor > max) {
                max = valor;
            }
        }

        double escala = (double) altura / max;

        // Desenhar barras sólidas pretas
        double larguraBarra = (double) largura / histograma.length;
        g.setColor(Color.BLACK);

        // INVERTE: 255 à esquerda, 0 à direita
        for (int i = 0; i < histograma.length; i++) {
            int alturaBarra = (int) (histograma[i] * escala);
            int posInvertida = histograma.length - 1 - i;
            g.fillRect(margemEsquerda + (int) (posInvertida * larguraBarra), altura - alturaBarra, (int) Math.ceil(larguraBarra), alturaBarra);
        }

        // Desenhar legenda horizontal (0 e 255)
        g.setColor(Color.BLACK);
        g.drawString("255", margemEsquerda, altura + 15);
        g.drawString("0", getWidth() - 20, altura + 15);

        // Desenhar linha base
        g.drawLine(margemEsquerda, altura, getWidth(), altura);
    }
}
