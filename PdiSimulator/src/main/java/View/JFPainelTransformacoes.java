package View;

import Controller.Transformacoes.FiltrosTransformacoes;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class JFPainelTransformacoes extends javax.swing.JFrame {

    private MainView mainView;
    
    public JFPainelTransformacoes(MainView mainView) {
        this.mainView = mainView;
        initComponents();
        setLocationRelativeTo(mainView);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtParametroA = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtParametroB = new javax.swing.JTextField();
        btnExpansao = new javax.swing.JButton();
        btnCompressao = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Transformações de Imagem");
        setResizable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros de Intensidade"));

        jLabel1.setText("Parâmetro a:");

        txtParametroA.setText("1.0");

        jLabel2.setText("Parâmetro b:");

        txtParametroB.setText("0.0");

        btnExpansao.setText("Expansão (g = a*r + b)");
        btnExpansao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExpansaoActionPerformed(evt);
            }
        });

        btnCompressao.setText("Compressão (g = r/a - b)");
        btnCompressao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompressaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnExpansao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCompressao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtParametroA)
                            .addComponent(txtParametroB))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtParametroA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtParametroB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnExpansao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCompressao)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // ========== MÉTODOS DE AÇÃO PARA FILTROS DE INTENSIDADE ==========
    
    private void btnExpansaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExpansaoActionPerformed
        aplicarFiltroIntensidade("expansao");
    }//GEN-LAST:event_btnExpansaoActionPerformed

    private void btnCompressaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompressaoActionPerformed
        aplicarFiltroIntensidade("compressao");
    }//GEN-LAST:event_btnCompressaoActionPerformed

    // ========== MÉTODOS AUXILIARES ==========
    
    /**
     * Método genérico para aplicar transformações geométricas
     */
    private void aplicarTransformacao(Transformacao transformacao, String nomeTransformacao) {
        if (mainView.getImagemAtual() == null) {
            JOptionPane.showMessageDialog(this, "Nenhuma imagem carregada!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            BufferedImage resultado = transformacao.aplicar();
            mainView.setImagemAtual(resultado);
            JOptionPane.showMessageDialog(this, nomeTransformacao + " aplicado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, 
                "Erro ao aplicar " + nomeTransformacao + ": " + e.getMessage(), 
                "Erro", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Método para aplicar filtros de intensidade (expansão/compressão)
     */
    private void aplicarFiltroIntensidade(String tipo) {
        if (mainView.getImagemAtual() == null) {
            JOptionPane.showMessageDialog(this, "Nenhuma imagem carregada!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            double a = Double.parseDouble(txtParametroA.getText());
            double b = Double.parseDouble(txtParametroB.getText());
            
            BufferedImage resultado;
            String mensagem;
            
            if (tipo.equals("expansao")) {
                resultado = FiltrosTransformacoes.aplicarExpansao(mainView.getImagemAtual(), a, b);
                mensagem = String.format("Expansão aplicada: g = %.2f * r + %.2f", a, b);
            } else {
                if (a == 0) {
                    JOptionPane.showMessageDialog(this, 
                        "O parâmetro 'a' não pode ser zero para compressão!", 
                        "Erro", 
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }
                resultado = FiltrosTransformacoes.aplicarCompressao(mainView.getImagemAtual(), a, b);
                mensagem = String.format("Compressão aplicada: g = r / %.2f - %.2f", a, b);
            }
            
            mainView.setImagemAtual(resultado);
            JOptionPane.showMessageDialog(this, mensagem);
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, 
                "Por favor, insira valores numéricos válidos para os parâmetros a e b.", 
                "Erro de Entrada", 
                JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, 
                "Erro ao aplicar filtro: " + e.getMessage(), 
                "Erro", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Interface funcional para as transformações
     */
    @FunctionalInterface
    private interface Transformacao {
        BufferedImage aplicar();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCompressao;
    private javax.swing.JButton btnExpansao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtParametroA;
    private javax.swing.JTextField txtParametroB;
    // End of variables declaration//GEN-END:variables
}