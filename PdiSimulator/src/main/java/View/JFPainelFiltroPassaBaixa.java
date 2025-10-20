package View;

import Controller.PassaBaixa.FiltroPassaBaixa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class JFPainelFiltroPassaBaixa extends JFrame {

    private JComboBox<String> comboFiltro;
    private JSpinner spinnerTamanho;
    private JButton btnAplicar;
    private MainView mainView;

    public JFPainelFiltroPassaBaixa(MainView mainView) {
        this.mainView = mainView;
        setTitle("Filtro Passa-Baixa");
        setLocationRelativeTo(mainView);
        setSize(300, 150);
        setLayout(new java.awt.FlowLayout());

        comboFiltro = new JComboBox<>(new String[]{"Média", "Mediana", "Moda", "Mínimo", "Máximo"});
        spinnerTamanho = new JSpinner(new SpinnerNumberModel(3, 3, 15, 2)); // de 3 a 15, passo 2 para ímpar
        btnAplicar = new JButton("Aplicar");

        add(new JLabel("Tipo do filtro:"));
        add(comboFiltro);
        add(new JLabel("Tamanho da máscara:"));
        add(spinnerTamanho);
        add(btnAplicar);

        btnAplicar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int tamanhoMascara = (Integer) spinnerTamanho.getValue();
                String filtro = (String) comboFiltro.getSelectedItem();

                BufferedImage imgOriginal = mainView.getImagemAtual();
                if (imgOriginal == null) {
                    JOptionPane.showMessageDialog(null, "Nenhuma imagem carregada");
                    return;
                }

                BufferedImage imgFiltrada = null;

                switch (filtro) {
                    case "Média":
                        imgOriginal = mainView.getImagemAtual();
                        if (imgOriginal == null) {
                            JOptionPane.showMessageDialog(null, "Nenhuma imagem carregada");
                            return;
                        }
                        imgFiltrada = FiltroPassaBaixa.aplicarFiltroMediaCinza(imgOriginal, tamanhoMascara);
                        break;
                    case "Mediana":
                        imgOriginal = mainView.getImagemAtual();
                        if (imgOriginal == null) {
                            JOptionPane.showMessageDialog(null, "Nenhuma imagem carregada");
                            return;
                        }
                        imgFiltrada = FiltroPassaBaixa.aplicarFiltroMedianaCinza(imgOriginal, tamanhoMascara);
                        break;
                    case "Moda":
                        imgOriginal = mainView.getImagemAtual();
                        if (imgOriginal == null) {
                            JOptionPane.showMessageDialog(null, "Nenhuma imagem carregada");
                            return;
                        }
                        imgFiltrada = FiltroPassaBaixa.aplicarFiltroModaCinza(imgOriginal, tamanhoMascara);
                        break;
                    case "Mínimo":
                        imgOriginal = mainView.getImagemAtual();
                        if (imgOriginal == null) {
                            JOptionPane.showMessageDialog(null, "Nenhuma imagem carregada");
                            return;
                        }
                        imgFiltrada = FiltroPassaBaixa.aplicarFiltroMinimoCinza(imgOriginal, tamanhoMascara);
                        break;
                    case "Máximo":
                        imgOriginal = mainView.getImagemAtual();
                        if (imgOriginal == null) {
                            JOptionPane.showMessageDialog(null, "Nenhuma imagem carregada");
                            return;
                        }
                        imgFiltrada = FiltroPassaBaixa.aplicarFiltroMaximoCinza(imgOriginal, tamanhoMascara);
                        break;
                }

                if (imgFiltrada != null) {
                    mainView.setImagemAtual(imgFiltrada);
                    mainView.atualizarHistograma();
                }
            }
        });
    }
}
