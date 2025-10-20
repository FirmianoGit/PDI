package Controller.FuncoesDeTransformacao;

import java.awt.image.BufferedImage;

public class FuncoesDeTransformacao {

    public static BufferedImage aplicarFiltroNegativoCinza(BufferedImage original) {
        int largura = original.getWidth();
        int altura = original.getHeight();
        BufferedImage filtrada = new BufferedImage(largura, altura, BufferedImage.TYPE_BYTE_GRAY);

        for (int y = 0; y < altura; y++) {
            for (int x = 0; x < largura; x++) {
                int rgb = original.getRGB(x, y);
                int cinza = rgb & 0xFF;
                int negativo = 255 - cinza;

                int novaCor = (negativo << 16) | (negativo << 8) | negativo;
                filtrada.setRGB(x, y, novaCor);
            }
        }
        return filtrada;
    }

    public static BufferedImage aplicarFiltroLogaritmoCinza(BufferedImage original) {
        int largura = original.getWidth();
        int altura = original.getHeight();
        BufferedImage filtrada = new BufferedImage(largura, altura, BufferedImage.TYPE_BYTE_GRAY);

        // Fator de escala para normalizar resultado para faixa [0,255]
        double c = 255.0 / Math.log10(1.0 + 255.0);

        for (int y = 0; y < altura; y++) {
            for (int x = 0; x < largura; x++) {
                int rgb = original.getRGB(x, y);
                int cinza = rgb & 0xFF;

                int valor = (int) (c * Math.log10(1.0 + cinza));

                valor = Math.max(0, Math.min(255, valor)); // clamp

                int novaCor = (valor << 16) | (valor << 8) | valor;
                filtrada.setRGB(x, y, novaCor);
            }
        }
        return filtrada;
    }

    public static BufferedImage aplicarFiltroExponencialCinza(BufferedImage original) {
        int largura = original.getWidth();
        int altura = original.getHeight();
        BufferedImage filtrada = new BufferedImage(largura, altura, BufferedImage.TYPE_BYTE_GRAY);

        double a = 5.0; // constante que controla o contraste, ajuste conforme desejado

        for (int y = 0; y < altura; y++) {
            for (int x = 0; x < largura; x++) {
                int rgb = original.getRGB(x, y);
                int cinza = rgb & 0xFF;

                double normalized = cinza / 255.0;  // normaliza para [0,1]
                double valorExp = (Math.exp(a * normalized) - 1) / (Math.exp(a) - 1);
                int valorFinal = (int) (valorExp * 255);

                valorFinal = Math.max(0, Math.min(255, valorFinal)); // clamp

                int novaCor = (valorFinal << 16) | (valorFinal << 8) | valorFinal;
                filtrada.setRGB(x, y, novaCor);
            }
        }
        return filtrada;
    }

    public static BufferedImage aplicarFiltroRaizCinza(BufferedImage original, double gamma) {
        int largura = original.getWidth();
        int altura = original.getHeight();
        BufferedImage filtrada = new BufferedImage(largura, altura, BufferedImage.TYPE_BYTE_GRAY);

        double invGamma = 1.0 / gamma;

        for (int y = 0; y < altura; y++) {
            for (int x = 0; x < largura; x++) {
                int rgb = original.getRGB(x, y);
                int cinza = rgb & 0xFF;

                double normalized = cinza / 255.0;
                double valorRaiz = Math.pow(normalized, invGamma);
                int valorFinal = (int) (valorRaiz * 255);

                valorFinal = Math.min(255, Math.max(0, valorFinal));

                int novaCor = (valorFinal << 16) | (valorFinal << 8) | valorFinal;
                filtrada.setRGB(x, y, novaCor);
            }
        }
        return filtrada;
    }

    public static BufferedImage aplicarFiltroPotenciaCinza(BufferedImage original, double gamma) {
        int largura = original.getWidth();
        int altura = original.getHeight();
        BufferedImage filtrada = new BufferedImage(largura, altura, BufferedImage.TYPE_BYTE_GRAY);

        for (int y = 0; y < altura; y++) {
            for (int x = 0; x < largura; x++) {
                int rgb = original.getRGB(x, y);
                int cinza = rgb & 0xFF;

                double normalized = cinza / 255.0;
                double valorPotencia = Math.pow(normalized, gamma);
                int valorFinal = (int) (valorPotencia * 255);

                valorFinal = Math.min(255, Math.max(0, valorFinal));

                int novaCor = (valorFinal << 16) | (valorFinal << 8) | valorFinal;
                filtrada.setRGB(x, y, novaCor);
            }
        }
        return filtrada;
    }

    public static BufferedImage aplicarEqualizacaoDaImagem(BufferedImage imgOriginal) {
        int largura = imgOriginal.getWidth();
        int altura = imgOriginal.getHeight();
        BufferedImage imgEq = new BufferedImage(largura, altura, BufferedImage.TYPE_BYTE_GRAY);
        int[] hist = new int[256];
        int totalPixels = largura * altura;

        // calcula o histograma
        for (int y = 0; y < altura; y++) {
            for (int x = 0; x < largura; x++) {
                int pixel = imgOriginal.getRGB(x, y) & 0xFF; // pega apenas o canal Y/tons de cinza
                hist[pixel]++;
            }
        }

        // CDF
        int[] cdf = new int[256];
        cdf[0] = hist[0];
        for (int i = 1; i < 256; i++) {
            cdf[i] = cdf[i - 1] + hist[i];
        }
        // Normaliza LUT
        int[] lut = new int[256];
        for (int i = 0; i < 256; i++) {
            lut[i] = Math.min(255, Math.round(((float) cdf[i] - cdf[0]) / (totalPixels - 1) * 255));
        }

        // Aplica LUT no novo buffer
        for (int y = 0; y < altura; y++) {
            for (int x = 0; x < largura; x++) {
                int pixel = imgOriginal.getRGB(x, y) & 0xFF;
                int valorEq = lut[pixel];
                int corFinal = (0xFF << 24) | (valorEq << 16) | (valorEq << 8) | valorEq;
                imgEq.setRGB(x, y, corFinal);
            }
        }
        return imgEq;
    }
}
