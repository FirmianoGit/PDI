package Controller.Transformacoes;

import java.awt.image.BufferedImage;

public class FiltrosTransformacoes {
    
    public static BufferedImage aplicarExpansao(BufferedImage imagemOriginal, double a, double b) {
        if (imagemOriginal == null) {
            return null;
        }
        
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        
        BufferedImage imagemProcessada = new BufferedImage(
            largura, 
            altura, 
            BufferedImage.TYPE_BYTE_GRAY
        );
        
        for (int y = 0; y < altura; y++) {
            for (int x = 0; x < largura; x++) {
                // Obter valor do pixel original (0-255)
                int rgb = imagemOriginal.getRGB(x, y);
                int r = (rgb >> 16) & 0xFF;
                
                // Aplicar fórmula de expansão: g = a * r + b
                double valor = a * r + b;
                
                // Garantir que o valor fique no intervalo [0, 255]
                valor = Math.max(0, Math.min(255, valor));
                
                int novoValor = (int) Math.round(valor);
                
                // Criar novo pixel
                int novoPixel = (255 << 24) | (novoValor << 16) | (novoValor << 8) | novoValor;
                imagemProcessada.setRGB(x, y, novoPixel);
            }
        }
        
        return imagemProcessada;
    }
    
    public static BufferedImage aplicarCompressao(BufferedImage imagemOriginal, double a, double b) {
        if (imagemOriginal == null || a == 0) {
            return null; // Evitar divisão por zero
        }
        
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        
        BufferedImage imagemProcessada = new BufferedImage(
            largura, 
            altura, 
            BufferedImage.TYPE_BYTE_GRAY
        );
        
        for (int y = 0; y < altura; y++) {
            for (int x = 0; x < largura; x++) {
                // Obter valor do pixel original (0-255)
                int rgb = imagemOriginal.getRGB(x, y);
                int r = (rgb >> 16) & 0xFF;
                
                // Aplicar fórmula de compressão: g = r / a - b
                double valor = (r / a) - b;
                
                // Garantir que o valor fique no intervalo [0, 255]
                valor = Math.max(0, Math.min(255, valor));
                
                int novoValor = (int) Math.round(valor);
                
                // Criar novo pixel
                int novoPixel = (255 << 24) | (novoValor << 16) | (novoValor << 8) | novoValor;
                imagemProcessada.setRGB(x, y, novoPixel);
            }
        }
        
        return imagemProcessada;
    }

    public static BufferedImage aplicarExpansao(BufferedImage imagemOriginal) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static BufferedImage aplicarTransformacoes(BufferedImage imagemOriginal) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}