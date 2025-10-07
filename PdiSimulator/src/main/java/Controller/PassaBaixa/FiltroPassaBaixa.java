package Controller.PassaBaixa;

import java.awt.image.BufferedImage;

public class FiltroPassaBaixa {

    public static BufferedImage aplicarFiltroMediaCinza(BufferedImage original, int tamanhoMascara) {
        int largura = original.getWidth();
        int altura = original.getHeight();
        BufferedImage filtrada = new BufferedImage(largura, altura, original.getType());

        int raio = tamanhoMascara / 2;

        for (int y = 0; y < altura; y++) {
            for (int x = 0; x < largura; x++) {
                int somaCinza = 0;
                int contador = 0;

                for (int dy = -raio; dy <= raio; dy++) {
                    for (int dx = -raio; dx <= raio; dx++) {
                        int nx = x + dx;
                        int ny = y + dy;

                        if (nx >= 0 && nx < largura && ny >= 0 && ny < altura) {
                            int rgb = original.getRGB(nx, ny);
                            int cinza = rgb & 0xFF;

                            somaCinza += cinza;
                            contador++;
                        }
                    }
                }

                int mediaCinza = somaCinza / contador;
                int novaCor = (255 << 24) | (mediaCinza << 16) | (mediaCinza << 8) | mediaCinza;
                filtrada.setRGB(x, y, novaCor);
            }
        }

        return filtrada;
    }

    public static BufferedImage aplicarFiltroMedianaCinza(BufferedImage original, int tamanhoMascara) {
        int largura = original.getWidth();
        int altura = original.getHeight();
        BufferedImage filtrada = new BufferedImage(largura, altura, original.getType());

        int raio = tamanhoMascara / 2;
        int maxElementos = tamanhoMascara * tamanhoMascara;

        for (int y = 0; y < altura; y++) {
            for (int x = 0; x < largura; x++) {
                int[] vizinhos = new int[maxElementos];
                int k = 0;

                for (int dy = -raio; dy <= raio; dy++) {
                    for (int dx = -raio; dx <= raio; dx++) {
                        int nx = x + dx;
                        int ny = y + dy;

                        if (nx >= 0 && nx < largura && ny >= 0 && ny < altura) {
                            int rgb = original.getRGB(nx, ny);
                            vizinhos[k++] = rgb & 0xFF;
                        }
                    }
                }

                java.util.Arrays.sort(vizinhos, 0, k);
                int mediana = vizinhos[k / 2];

                int novaCor = (255 << 24) | (mediana << 16) | (mediana << 8) | mediana;
                filtrada.setRGB(x, y, novaCor);
            }
        }
        return filtrada;
    }

    public static BufferedImage aplicarFiltroModaCinza(BufferedImage original, int tamanhoMascara) {
        int largura = original.getWidth();
        int altura = original.getHeight();
        BufferedImage filtrada = new BufferedImage(largura, altura, original.getType());

        int raio = tamanhoMascara / 2;

        for (int y = 0; y < altura; y++) {
            for (int x = 0; x < largura; x++) {
                int[] freq = new int[256]; // faixa de cores cinza 0-255

                for (int dy = -raio; dy <= raio; dy++) {
                    for (int dx = -raio; dx <= raio; dx++) {
                        int nx = x + dx;
                        int ny = y + dy;

                        if (nx >= 0 && nx < largura && ny >= 0 && ny < altura) {
                            int rgb = original.getRGB(nx, ny);
                            int valor = rgb & 0xFF;
                            freq[valor]++;
                        }
                    }
                }

                int moda = 0;
                int maxFreq = 0;
                for (int i = 0; i < 256; i++) {
                    if (freq[i] > maxFreq) {
                        maxFreq = freq[i];
                        moda = i;
                    }
                }

                int novaCor = (255 << 24) | (moda << 16) | (moda << 8) | moda;
                filtrada.setRGB(x, y, novaCor);
            }
        }
        return filtrada;
    }

    public static BufferedImage aplicarFiltroMinimoCinza(BufferedImage original, int tamanhoMascara) {
        int largura = original.getWidth();
        int altura = original.getHeight();
        BufferedImage filtrada = new BufferedImage(largura, altura, original.getType());

        int raio = tamanhoMascara / 2;

        for (int y = 0; y < altura; y++) {
            for (int x = 0; x < largura; x++) {
                int min = 255;

                for (int dy = -raio; dy <= raio; dy++) {
                    for (int dx = -raio; dx <= raio; dx++) {
                        int nx = x + dx;
                        int ny = y + dy;

                        if (nx >= 0 && nx < largura && ny >= 0 && ny < altura) {
                            int rgb = original.getRGB(nx, ny);
                            int valor = rgb & 0xFF;
                            if (valor < min) {
                                min = valor;
                            }
                        }
                    }
                }

                int novaCor = (255 << 24) | (min << 16) | (min << 8) | min;
                filtrada.setRGB(x, y, novaCor);
            }
        }
        return filtrada;
    }

    public static BufferedImage aplicarFiltroMaximoCinza(BufferedImage original, int tamanhoMascara) {
        int largura = original.getWidth();
        int altura = original.getHeight();
        BufferedImage filtrada = new BufferedImage(largura, altura, original.getType());

        int raio = tamanhoMascara / 2;

        for (int y = 0; y < altura; y++) {
            for (int x = 0; x < largura; x++) {
                int max = 0;

                for (int dy = -raio; dy <= raio; dy++) {
                    for (int dx = -raio; dx <= raio; dx++) {
                        int nx = x + dx;
                        int ny = y + dy;

                        if (nx >= 0 && nx < largura && ny >= 0 && ny < altura) {
                            int rgb = original.getRGB(nx, ny);
                            int valor = rgb & 0xFF;
                            if (valor > max) {
                                max = valor;
                            }
                        }
                    }
                }

                int novaCor = (255 << 24) | (max << 16) | (max << 8) | max;
                filtrada.setRGB(x, y, novaCor);
            }
        }
        return filtrada;
    }

}
