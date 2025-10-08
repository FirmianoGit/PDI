package Controller.PassaAlta;

import java.awt.image.BufferedImage;

public class FiltrosPassaAlta {

    public static BufferedImage aplicarFiltroLaplacianoCinza(BufferedImage original) {
        int largura = original.getWidth();
        int altura = original.getHeight();
        BufferedImage filtrada = new BufferedImage(largura, altura, BufferedImage.TYPE_BYTE_GRAY);

        // Máscara Laplaciana 3x3
        int[][] mascara = {
            {0, -1, 0},
            {-1, 4, -1},
            {0, -1, 0}
        };

        int raio = 1; // para máscara 3x3

        for (int y = 0; y < altura; y++) {
            for (int x = 0; x < largura; x++) {
                int soma = 0;

                for (int dy = -raio; dy <= raio; dy++) {
                    for (int dx = -raio; dx <= raio; dx++) {
                        int nx = x + dx;
                        int ny = y + dy;

                        if (nx >= 0 && nx < largura && ny >= 0 && ny < altura) {
                            int rgb = original.getRGB(nx, ny);
                            int cinza = rgb & 0xFF;
                            soma += cinza * mascara[dy + raio][dx + raio];
                        }
                    }
                }
                // Clamp do resultado para [0, 255]
                int valorFinal = Math.min(255, Math.max(0, soma));

                int novaCor = (valorFinal << 16) | (valorFinal << 8) | valorFinal;
                filtrada.setRGB(x, y, novaCor);
            }
        }
        return filtrada;
    }

    public static BufferedImage aplicarFiltroHighBoost(BufferedImage original, float k) {
        int largura = original.getWidth();
        int altura = original.getHeight();

        // Primeiro calcula o filtro Laplaciano usando a função anterior
        BufferedImage laplaciano = FiltrosPassaAlta.aplicarFiltroLaplacianoCinza(original);

        BufferedImage resultado = new BufferedImage(largura, altura, BufferedImage.TYPE_BYTE_GRAY);

        for (int y = 0; y < altura; y++) {
            for (int x = 0; x < largura; x++) {
                int origRGB = original.getRGB(x, y);
                int lapRGB = laplaciano.getRGB(x, y);

                int origCinza = origRGB & 0xFF;
                int lapCinza = lapRGB & 0xFF;

                // Aplica filtro high boost: original + k * laplaciano
                int valor = (int) (origCinza + k * lapCinza);

                // Limita para [0, 255]
                valor = Math.min(255, Math.max(0, valor));

                int novaCor = (valor << 16) | (valor << 8) | valor;
                resultado.setRGB(x, y, novaCor);
            }
        }

        return resultado;
    }

    public static BufferedImage aplicarFiltroPrewitt(BufferedImage original) {
        int largura = original.getWidth();
        int altura = original.getHeight();
        BufferedImage filtrada = new BufferedImage(largura, altura, BufferedImage.TYPE_BYTE_GRAY);

        int[][] gx = {
            {-1, 0, 1},
            {-1, 0, 1},
            {-1, 0, 1}
        };

        int[][] gy = {
            {1, 1, 1},
            {0, 0, 0},
            {-1, -1, -1}
        };

        int raio = 1;

        for (int y = 0; y < altura; y++) {
            for (int x = 0; x < largura; x++) {
                int somaX = 0;
                int somaY = 0;

                for (int dy = -raio; dy <= raio; dy++) {
                    for (int dx = -raio; dx <= raio; dx++) {
                        int nx = x + dx;
                        int ny = y + dy;

                        if (nx >= 0 && nx < largura && ny >= 0 && ny < altura) {
                            int rgb = original.getRGB(nx, ny);
                            int cinza = rgb & 0xFF;

                            somaX += cinza * gx[dy + raio][dx + raio];
                            somaY += cinza * gy[dy + raio][dx + raio];
                        }
                    }
                }

                int magnitude = (int) Math.min(255, Math.sqrt(somaX * somaX + somaY * somaY));
                int novaCor = (magnitude << 16) | (magnitude << 8) | magnitude;
                filtrada.setRGB(x, y, novaCor);
            }
        }

        return filtrada;
    }

    public static BufferedImage aplicarFiltroSobel(BufferedImage original) {
        int largura = original.getWidth();
        int altura = original.getHeight();
        BufferedImage filtrada = new BufferedImage(largura, altura, BufferedImage.TYPE_BYTE_GRAY);

        int[][] gx = {
            {-1, 0, 1},
            {-2, 0, 2},
            {-1, 0, 1}
        };

        int[][] gy = {
            {1, 2, 1},
            {0, 0, 0},
            {-1, -2, -1}
        };

        int raio = 1;

        for (int y = 0; y < altura; y++) {
            for (int x = 0; x < largura; x++) {
                int somaX = 0;
                int somaY = 0;

                for (int dy = -raio; dy <= raio; dy++) {
                    for (int dx = -raio; dx <= raio; dx++) {
                        int nx = x + dx;
                        int ny = y + dy;

                        if (nx >= 0 && nx < largura && ny >= 0 && ny < altura) {
                            int rgb = original.getRGB(nx, ny);
                            int cinza = rgb & 0xFF;

                            somaX += cinza * gx[dy + raio][dx + raio];
                            somaY += cinza * gy[dy + raio][dx + raio];
                        }
                    }
                }

                int magnitude = (int) Math.min(255, Math.sqrt(somaX * somaX + somaY * somaY));
                int novaCor = (magnitude << 16) | (magnitude << 8) | magnitude;
                filtrada.setRGB(x, y, novaCor);
            }
        }

        return filtrada;
    }
}
