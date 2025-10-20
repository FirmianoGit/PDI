package Controller.Espelhamentos;

import java.awt.image.BufferedImage;

public class Espelhamentos {
    
        public static BufferedImage aplicarEspelhamentoHorizontal(BufferedImage imagemOriginal) {
        if (imagemOriginal == null) {
            return null;
        }
        
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        
        // Criar nova imagem com o mesmo tipo
        BufferedImage imagemEspelhada = new BufferedImage(
            largura, 
            altura, 
            imagemOriginal.getType()
        );
        
        // Aplicar espelhamento
        for (int y = 0; y < altura; y++) {
            for (int x = 0; x < largura; x++) {
                // Obter pixel da posição atual
                int pixel = imagemOriginal.getRGB(x, y);
                
                // Calcular posição espelhada
                int xEspelhado = largura - 1 - x;
                
                // Colocar pixel na posição espelhada
                imagemEspelhada.setRGB(xEspelhado, y, pixel);
            }
        }
        
        return imagemEspelhada;
    }
        
    public static BufferedImage aplicarEspelhamentoVertical(BufferedImage imagemOriginal) {
        if (imagemOriginal == null) {
            return null;
        }
        
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        
        // Criar nova imagem com o mesmo tipo
        BufferedImage imagemEspelhada = new BufferedImage(
            largura, 
            altura, 
            imagemOriginal.getType()
        );
        
        // Aplicar espelhamento vertical
        for (int y = 0; y < altura; y++) {
            for (int x = 0; x < largura; x++) {
                // Obter pixel da posição atual
                int pixel = imagemOriginal.getRGB(x, y);
                
                // Calcular posição espelhada verticalmente
                int yEspelhado = altura - 1 - y;
                
                // Colocar pixel na posição espelhada
                imagemEspelhada.setRGB(x, yEspelhado, pixel);
            }
        }
        
        return imagemEspelhada;
    }
}