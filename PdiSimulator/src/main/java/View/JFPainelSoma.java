package View;

import Controller.Soma.Soma;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.io.File;

public class JFPainelSoma extends javax.swing.JFrame {

    private MainView mainView;
    private BufferedImage segundaImagem;
    
    public JFPainelSoma(MainView mainView) {
        this.mainView = mainView;
        initComponents();
        setLocationRelativeTo(mainView);
        
        // Verificar se há imagem atual
        if (mainView.getImagemAtual() == null) {
            JOptionPane.showMessageDialog(this, 
                "Não há imagem carregada na tela principal!", 
                "Aviso", 
                JOptionPane.WARNING_MESSAGE);
        }
        
        // Inicializar interface
        atualizarLabelPorcentagem();
        btnAplicar.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblImagemAtual = new javax.swing.JLabel();
        lblSegundaImagem = new javax.swing.JLabel();
        btnSelecionarImagem = new javax.swing.JButton();
        lblInfoImagem = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblPorcentagem = new javax.swing.JLabel();
        sliderPorcentagem = new javax.swing.JSlider();
        lblValorPorcentagem = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnAplicar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Soma de Imagens");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTitulo.setText("Soma de Duas Imagens com Porcentagem");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addContainerGap(84, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Seleção de Imagens"));

        lblImagemAtual.setText("Imagem Atual: Carregada");

        lblSegundaImagem.setText("Segunda Imagem:");

        btnSelecionarImagem.setText("Selecionar Imagem");
        btnSelecionarImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarImagemActionPerformed(evt);
            }
        });

        lblInfoImagem.setText("Nenhuma imagem selecionada");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImagemAtual)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblSegundaImagem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSelecionarImagem))
                    .addComponent(lblInfoImagem))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImagemAtual)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSegundaImagem)
                    .addComponent(btnSelecionarImagem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInfoImagem)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Configuração da Soma"));

        lblPorcentagem.setText("Porcentagem da Imagem Atual:");

        sliderPorcentagem.setMaximum(100);
        sliderPorcentagem.setValue(50);
        sliderPorcentagem.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderPorcentagemStateChanged(evt);
            }
        });

        lblValorPorcentagem.setText("50%");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPorcentagem)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(sliderPorcentagem, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblValorPorcentagem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPorcentagem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sliderPorcentagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblValorPorcentagem))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnAplicar.setText("Aplicar Soma");
        btnAplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAplicarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAplicar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAplicar)
                    .addComponent(btnCancelar))
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
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelecionarImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarImagemActionPerformed
        selecionarSegundaImagem();
    }//GEN-LAST:event_btnSelecionarImagemActionPerformed

    private void sliderPorcentagemStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderPorcentagemStateChanged
        atualizarLabelPorcentagem();
    }//GEN-LAST:event_sliderPorcentagemStateChanged

    private void btnAplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAplicarActionPerformed
        aplicarSoma();
    }//GEN-LAST:event_btnAplicarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    // ========== MÉTODOS PERSONALIZADOS ==========
    
    private void selecionarSegundaImagem() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Selecionar Segunda Imagem para Soma");
        
        // Filtro para arquivos de imagem
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter(
            "Imagens", "jpg", "jpeg", "png", "bmp", "gif"));
        
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                File arquivo = fileChooser.getSelectedFile();
                System.out.println("Carregando imagem: " + arquivo.getAbsolutePath());
                
                BufferedImage imagem = javax.imageio.ImageIO.read(arquivo);
                
                if (imagem == null) {
                    throw new Exception("Não foi possível carregar a imagem");
                }
                
                System.out.println("Imagem carregada - Tipo: " + imagem.getType() + 
                                 ", Dimensões: " + imagem.getWidth() + "x" + imagem.getHeight());
                
                // Verificar se a imagem atual existe
                if (mainView.getImagemAtual() == null) {
                    JOptionPane.showMessageDialog(this, 
                        "A imagem atual foi removida! Por favor, carregue uma imagem primeiro.", 
                        "Erro", 
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                this.segundaImagem = imagem;
                lblInfoImagem.setText(
                    String.format("Imagem selecionada: %dx%d pixels", 
                        imagem.getWidth(), imagem.getHeight())
                );
                
                // Habilitar o botão aplicar
                btnAplicar.setEnabled(true);
                
            } catch (Exception ex) {
                System.err.println("Erro ao carregar imagem: " + ex.getMessage());
                ex.printStackTrace();
                
                JOptionPane.showMessageDialog(this, 
                    "Erro ao carregar imagem: " + ex.getMessage() + 
                    "\nFormatos suportados: JPG, PNG, BMP, GIF", 
                    "Erro", 
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void atualizarLabelPorcentagem() {
        int valor = sliderPorcentagem.getValue();
        lblValorPorcentagem.setText(valor + "%");
        
        // Atualizar também o label principal para maior clareza
        lblPorcentagem.setText(
            String.format("Porcentagem da Imagem Atual: %d%% (Imagem 2: %d%%)", 
                valor, 100 - valor)
        );
    }
    
    private void aplicarSoma() {
        // Validar se há imagem atual
        if (mainView.getImagemAtual() == null) {
            JOptionPane.showMessageDialog(this, 
                "Não há imagem carregada na tela principal!", 
                "Erro", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Validar se a segunda imagem foi selecionada
        if (segundaImagem == null) {
            JOptionPane.showMessageDialog(this, 
                "Por favor, selecione a segunda imagem!", 
                "Aviso", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            double porcentagem = sliderPorcentagem.getValue();
            
            System.out.println("Aplicando soma...");
            System.out.println("Imagem 1 - Tipo: " + mainView.getImagemAtual().getType() + 
                             ", Dimensões: " + mainView.getImagemAtual().getWidth() + "x" + mainView.getImagemAtual().getHeight());
            System.out.println("Imagem 2 - Tipo: " + segundaImagem.getType() + 
                             ", Dimensões: " + segundaImagem.getWidth() + "x" + segundaImagem.getHeight());
            System.out.println("Porcentagem: " + porcentagem + "%");
            
            // Aplicar a soma
            BufferedImage resultado = Soma.somarImagens(
                mainView.getImagemAtual(), 
                segundaImagem, 
                porcentagem
            );
            
            // Atualizar a imagem principal
            mainView.setImagemAtual(resultado);
            
            // Mensagem de sucesso
            JOptionPane.showMessageDialog(this, 
                String.format("Soma aplicada com sucesso!\n" +
                            "%.0f%% Imagem Atual + %.0f%% Segunda Imagem", 
                    porcentagem, 100 - porcentagem));
            
            // Fechar a janela
            dispose();
            
        } catch (Exception e) {
            System.err.println("Erro detalhado na soma: ");
            e.printStackTrace();
            
            JOptionPane.showMessageDialog(this, 
                "Erro ao aplicar soma: " + e.getMessage() + 
                "\nDetalhes no console.", 
                "Erro", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAplicar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSelecionarImagem;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblImagemAtual;
    private javax.swing.JLabel lblInfoImagem;
    private javax.swing.JLabel lblPorcentagem;
    private javax.swing.JLabel lblSegundaImagem;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblValorPorcentagem;
    private javax.swing.JSlider sliderPorcentagem;
    // End of variables declaration//GEN-END:variables
}