package Controller.Rotacoes;

import java.awt.image.BufferedImage;

public class Rotacoes {
    
    public static BufferedImage aplicarRotacao90Horario(BufferedImage imagemOriginal) {
        if (imagemOriginal == null) {
            return null;
        }
        
        int larguraOriginal = imagemOriginal.getWidth();
        int alturaOriginal = imagemOriginal.getHeight();
        
        // Na rotação 90°, as dimensões são invertidas
        int novaLargura = alturaOriginal;
        int novaAltura = larguraOriginal;
        
        BufferedImage imagemRotacionada = new BufferedImage(
            novaLargura, 
            novaAltura, 
            imagemOriginal.getType()
        );
        
        // Aplicar rotação 90° horária
        for (int y = 0; y < alturaOriginal; y++) {
            for (int x = 0; x < larguraOriginal; x++) {
                int pixel = imagemOriginal.getRGB(x, y);
                
                // Mapeamento para rotação 90° anti-horária:
                // (x, y) → (alturaOriginal - 1 - y, x)
                int novoX = alturaOriginal - 1 - y;
                int novoY = x;
                
                imagemRotacionada.setRGB(novoX, novoY, pixel);
            }
        }
        
        return imagemRotacionada;
    }
    
    public static BufferedImage aplicarRotacao90AntiHorario(BufferedImage imagemOriginal) {
        if (imagemOriginal == null) {
            return null;
        }
        
        int larguraOriginal = imagemOriginal.getWidth();
        int alturaOriginal = imagemOriginal.getHeight();
        
        // Na rotação 90°, as dimensões são invertidas
        int novaLargura = alturaOriginal;
        int novaAltura = larguraOriginal;
        
        BufferedImage imagemRotacionada = new BufferedImage(
            novaLargura, 
            novaAltura, 
            imagemOriginal.getType()
        );
        
        // Aplicar rotação 90° anti-horária
        for (int y = 0; y < alturaOriginal; y++) {
            for (int x = 0; x < larguraOriginal; x++) {
                int pixel = imagemOriginal.getRGB(x, y);
                
                // Mapeamento para rotação 90° horária:
                // (x, y) → (y, larguraOriginal - 1 - x)
                int novoX = y;
                int novoY = larguraOriginal - 1 - x;
                
                imagemRotacionada.setRGB(novoX, novoY, pixel);
            }
        }
        
        return imagemRotacionada;
    }
    
    public static BufferedImage aplicarRotacao180(BufferedImage imagemOriginal) {
        if (imagemOriginal == null) {
            return null;
        }
        
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        
        BufferedImage imagemRotacionada = new BufferedImage(
            largura, 
            altura, 
            imagemOriginal.getType()
        );
        
        // Aplicar rotação 180° (inversão completa)
        for (int y = 0; y < altura; y++) {
            for (int x = 0; x < largura; x++) {
                int pixel = imagemOriginal.getRGB(x, y);
                
                // Mapeamento para rotação 180°:
                // (x, y) → (largura - 1 - x, altura - 1 - y)
                int novoX = largura - 1 - x;
                int novoY = altura - 1 - y;
                
                imagemRotacionada.setRGB(novoX, novoY, pixel);
            }
        }
        
        return imagemRotacionada;
    }
}
