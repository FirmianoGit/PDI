/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package br.dev.firmiano.pdisimulator;

import View.MainView;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Firmiano
 */
public class PdiSimulator {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainView FramePrincipal = new MainView();
            FramePrincipal.setSize(1280, 650);
            FramePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            FramePrincipal.setVisible(true);
        });
    }
}
