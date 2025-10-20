
package View;

import Controller.FuncoesDeTransformacao.FuncoesDeTransformacao;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class JFGammaForm extends JFrame {

    private final MainView mainView;
    private final JTextField gammaField;
    private final JComboBox<String> comboFiltro;
    private final JButton aplicarButton;
    private final JButton cancelarButton;

    public JFGammaForm(MainView mainView) {
        this.mainView = mainView;
        setTitle("Filtro Gama - Potência ou Raiz");
        setSize(350, 150);
        setLocationRelativeTo(mainView);
        setLayout(new FlowLayout());

        add(new JLabel("Valor do Gamma (ex: 0.5, 1.0, 2.2):"));
        gammaField = new JTextField("1.0", 10);
        add(gammaField);

        add(new JLabel("Selecione o filtro:"));
        comboFiltro = new JComboBox<>(new String[] {"Potência", "Raiz"});
        add(comboFiltro);

        aplicarButton = new JButton("Aplicar");
        cancelarButton = new JButton("Cancelar");
        add(aplicarButton);
        add(cancelarButton);

        aplicarButton.addActionListener(this::aplicarFiltro);
        cancelarButton.addActionListener(e -> dispose());
    }

    private void aplicarFiltro(ActionEvent e) {
        String gammaText = gammaField.getText();
        String filtroSelecionado = (String) comboFiltro.getSelectedItem();

        try {
            double gamma = Double.parseDouble(gammaText);
            if (gamma <= 0) {
                JOptionPane.showMessageDialog(this, "Gamma deve ser maior que zero.", "Erro",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (mainView.getImagemAtual() == null) {
                JOptionPane.showMessageDialog(this, "Nenhuma imagem carregada!", "Erro",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Aplica o filtro conforme seleção
            BufferedImage imagemFiltrada;
            if ("Potência".equals(filtroSelecionado)) {
                imagemFiltrada = FuncoesDeTransformacao.aplicarFiltroPotenciaCinza(mainView.getImagemAtual(), gamma);
            } else {  // Raiz
                imagemFiltrada = FuncoesDeTransformacao.aplicarFiltroRaizCinza(mainView.getImagemAtual(), gamma);
            }

            // Atualiza imagem na MainView
            mainView.setImagemAtual(imagemFiltrada);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Valor inválido para gamma.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}