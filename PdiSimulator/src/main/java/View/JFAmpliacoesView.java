package View;

import Controller.ampliacoes.Ampliacoes;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class JFAmpliacoesView extends JFrame {

    private final MainView mainView; // referência ao JFrame principal
    private final JTextField txtLargura;
    private final JTextField txtAltura;
    private final JComboBox<String> comboMetodo;
    private final JButton btnAplicar;
    private final JButton btnCancelar;

    public JFAmpliacoesView(MainView mainView) {
        setLocationRelativeTo(mainView);
        this.mainView = mainView;

        setTitle("Ampliações - Nearest Neighbor / Bilinear");
        setLayout(new FlowLayout());

        add(new JLabel("Nova Largura:"));
        txtLargura = new JTextField("600", 6);
        add(txtLargura);

        add(new JLabel("Nova Altura:"));
        txtAltura = new JTextField("600", 6);
        add(txtAltura);

        comboMetodo = new JComboBox<>(new String[]{"Nearest Neighbor", "Bilinear"});
        add(comboMetodo);

        btnAplicar = new JButton("Aplicar");
        btnCancelar = new JButton("Cancelar");
        add(btnAplicar);
        add(btnCancelar);

        btnAplicar.addActionListener(e -> aplicarAmpliacao());
        btnCancelar.addActionListener(e -> dispose());

        pack();
        setLocationRelativeTo(mainView);
    }

    private void aplicarAmpliacao() {
        BufferedImage imagem = mainView.getImagemAtual();
        if (imagem == null) {
            JOptionPane.showMessageDialog(this, "Nenhuma imagem carregada na tela principal.");
            return;
        }

        try {
            int novaLargura = Integer.parseInt(txtLargura.getText());
            int novaAltura = Integer.parseInt(txtAltura.getText());
            BufferedImage novaImagem;

            if (comboMetodo.getSelectedItem().equals("Nearest Neighbor")) {
                novaImagem = Ampliacoes.ampliarNearestNeighbor(imagem, novaLargura, novaAltura);
            } else {
                novaImagem = Ampliacoes.ampliarBilinear(imagem, novaLargura, novaAltura);
            }

            mainView.setImagemAtual(novaImagem); // atualiza imagem principal
            mainView.repaintPainelImagem();
            mainView.atualizarHistograma();

            JOptionPane.showMessageDialog(this, "Ampliação aplicada com sucesso!");
            dispose();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Insira valores válidos para largura e altura.");
        }
    }
}
