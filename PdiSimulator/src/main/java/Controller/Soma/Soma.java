package Controller.Soma;

import java.awt.image.BufferedImage;

public class Soma {
    
    /**
     * Soma duas imagens com porcentagem: resultado = p*img1 + (1-p)*img2
     * Implementação manual sem usar bibliotecas de terceiros
     */
    public static BufferedImage somarImagens(BufferedImage imagem1, BufferedImage imagem2, double porcentagem) {
        
        // Validações iniciais
        if (imagem1 == null) {
            throw new IllegalArgumentException("A primeira imagem não pode ser nula");
        }
        
        if (imagem2 == null) {
            throw new IllegalArgumentException("A segunda imagem não pode ser nula");
        }
        
        // Converter porcentagem para o range 0.0 a 1.0
        double p = porcentagem / 100.0;
        p = Math.max(0.0, Math.min(1.0, p));
        
        // Usar as dimensões da primeira imagem
        int largura = imagem1.getWidth();
        int altura = imagem1.getHeight();
        
        // Redimensionar a segunda imagem se necessário (implementação manual)
        BufferedImage img2Redimensionada = redimensionarImagem(imagem2, largura, altura);
        
        // Garantir que AMBAS as imagens estão em tons de cinza
        BufferedImage img1Convertida = converterParaTonsDeCinza(imagem1);
        BufferedImage img2Convertida = converterParaTonsDeCinza(img2Redimensionada);
        
        // Criar imagem resultante
        BufferedImage imagemResultante = new BufferedImage(
            largura, 
            altura, 
            BufferedImage.TYPE_BYTE_GRAY
        );
        
        // Aplicar a soma com porcentagem - implementação manual
        for (int y = 0; y < altura; y++) {
            for (int x = 0; x < largura; x++) {
                // Obter valores dos pixels manualmente
                int valor1 = obterValorCinza(img1Convertida, x, y);
                int valor2 = obterValorCinza(img2Convertida, x, y);
                
                // Aplicar fórmula: resultado = p*valor1 + (1-p)*valor2
                double novoValor = (p * valor1) + ((1.0 - p) * valor2);
                
                // Garantir que está no intervalo [0, 255]
                novoValor = Math.max(0, Math.min(255, novoValor));
                
                int valorFinal = (int) Math.round(novoValor);
                
                // Definir o pixel manualmente
                definirValorCinza(imagemResultante, x, y, valorFinal);
            }
        }
        
        return imagemResultante;
    }
    
    /**
     * Redimensiona uma imagem manualmente sem usar bibliotecas de terceiros
     */
    private static BufferedImage redimensionarImagem(BufferedImage imagem, int novaLargura, int novaAltura) {
        if (imagem.getWidth() == novaLargura && imagem.getHeight() == novaAltura) {
            return imagem;
        }
        
        BufferedImage imagemRedimensionada = new BufferedImage(
            novaLargura, 
            novaAltura, 
            BufferedImage.TYPE_BYTE_GRAY
        );
        
        // Calcular fatores de escala
        double escalaX = (double) imagem.getWidth() / novaLargura;
        double escalaY = (double) imagem.getHeight() / novaAltura;
        
        // Redimensionamento manual usando interpolação por vizinho mais próximo
        for (int y = 0; y < novaAltura; y++) {
            for (int x = 0; x < novaLargura; x++) {
                // Calcular posição correspondente na imagem original
                int origX = (int) (x * escalaX);
                int origY = (int) (y * escalaY);
                
                // Garantir que está dentro dos limites
                origX = Math.min(origX, imagem.getWidth() - 1);
                origY = Math.min(origY, imagem.getHeight() - 1);
                
                // Obter valor do pixel original
                int valor = obterValorCinza(imagem, origX, origY);
                
                // Definir na imagem redimensionada
                definirValorCinza(imagemRedimensionada, x, y, valor);
            }
        }
        
        return imagemRedimensionada;
    }
    
    /**
     * Converte qualquer imagem para TYPE_BYTE_GRAY manualmente
     */
    private static BufferedImage converterParaTonsDeCinza(BufferedImage imagem) {
        // Se já está em tons de cinza, retorna a própria imagem
        if (imagem.getType() == BufferedImage.TYPE_BYTE_GRAY) {
            return imagem;
        }
        
        // Criar nova imagem em tons de cinza
        BufferedImage imagemCinza = new BufferedImage(
            imagem.getWidth(), 
            imagem.getHeight(), 
            BufferedImage.TYPE_BYTE_GRAY
        );
        
        // Conversão manual para tons de cinza usando a fórmula: 0.299R + 0.587G + 0.114B
        for (int y = 0; y < imagem.getHeight(); y++) {
            for (int x = 0; x < imagem.getWidth(); x++) {
                int rgb = imagem.getRGB(x, y);
                
                // Extrair componentes RGB
                int r = (rgb >> 16) & 0xFF;
                int g = (rgb >> 8) & 0xFF;
                int b = rgb & 0xFF;
                
                // Aplicar fórmula de conversão para tons de cinza
                int cinza = (int) (0.299 * r + 0.587 * g + 0.114 * b);
                cinza = Math.max(0, Math.min(255, cinza));
                
                // Definir na imagem em tons de cinza
                definirValorCinza(imagemCinza, x, y, cinza);
            }
        }
        
        return imagemCinza;
    }
    
    /**
     * Obtém o valor de cinza de um pixel manualmente
     */
    private static int obterValorCinza(BufferedImage imagem, int x, int y) {
        if (imagem.getType() == BufferedImage.TYPE_BYTE_GRAY) {
            // Para imagens TYPE_BYTE_GRAY, usar getRGB e extrair um componente
            int rgb = imagem.getRGB(x, y);
            return (rgb >> 16) & 0xFF;
        } else {
            // Para outros tipos, extrair o componente de cinza
            int rgb = imagem.getRGB(x, y);
            int r = (rgb >> 16) & 0xFF;
            int g = (rgb >> 8) & 0xFF;
            int b = rgb & 0xFF;
            return (int) (0.299 * r + 0.587 * g + 0.114 * b);
        }
    }
    
    /**
     * Define o valor de cinza de um pixel manualmente
     */
    private static void definirValorCinza(BufferedImage imagem, int x, int y, int valor) {
        valor = Math.max(0, Math.min(255, valor));
        
        if (imagem.getType() == BufferedImage.TYPE_BYTE_GRAY) {
            // Para TYPE_BYTE_GRAY, criar RGB com todos os componentes iguais
            int rgb = (valor << 16) | (valor << 8) | valor;
            imagem.setRGB(x, y, rgb);
        } else {
            // Para outros tipos, usar setRGB normal
            int rgb = (255 << 24) | (valor << 16) | (valor << 8) | valor;
            imagem.setRGB(x, y, rgb);
        }
    }
}