import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JogoDaVelha extends JFrame implements ActionListener {

    private JButton[][] botoes = new JButton[3][3];
    private boolean vezX = true;
    private JLabel label = new JLabel("");

    private JLabel turno = new JLabel("Vez Jogador 1");

    private boolean vitoria = false;
    private JButton reiniciarButton;

    public JogoDaVelha() {
        setTitle("Jogo da Velha");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 3));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                botoes[i][j] = new JButton();
                botoes[i][j].addActionListener(this); // adiciona um listener de acao aos botoes
                add(botoes[i][j]);
            }
        }

        reiniciarButton = new JButton("Reiniciar");
        reiniciarButton.addActionListener(this);
        add(reiniciarButton);

        add(turno);
        add(label);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == reiniciarButton) { //verifica se o botao de reiniciar foi clicado
            reiniciarJogo();
        } else {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (e.getSource() == botoes[i][j] && botoes[i][j].getText().equals("")) {
                        if (vezX) {
                            botoes[i][j].setText("X");
                            vezX = false;
                        } else {
                            botoes[i][j].setText("O");
                            vezX = true;
                        }
                    }
                }
            }
            verificarVitoria();
            verificarTurno();
        }
    }

    public void verificarTurno() {
        if (vezX) {
            turno.setText("Vez Jogador 1");
        } else {
            turno.setText("Vez Jogador 2");
        }
    }

    public void verificarVitoria() {
        if (botoes[0][0].getText().equals(botoes[0][1].getText()) && botoes[0][1].getText().equals(botoes[0][2].getText()) && !botoes[0][0].getText().isEmpty()) {
            vitoria = true;
        }
        if (botoes[1][0].getText().equals(botoes[1][1].getText()) && botoes[1][1].getText().equals(botoes[1][2].getText()) && !botoes[1][0].getText().isEmpty()) {
            vitoria = true;
        }
        if (botoes[2][0].getText().equals(botoes[2][1].getText()) && botoes[2][1].getText().equals(botoes[2][2].getText()) && !botoes[2][0].getText().isEmpty()) {
            vitoria = true;
        }
        if (botoes[0][0].getText().equals(botoes[1][0].getText()) && botoes[1][0].getText().equals(botoes[2][0].getText()) && !botoes[0][0].getText().isEmpty()) {
            vitoria = true;
        }
        if (botoes[0][1].getText().equals(botoes[1][1].getText()) && botoes[1][1].getText().equals(botoes[2][1].getText()) && !botoes[0][1].getText().isEmpty()) {
            vitoria = true;
        }
        if (botoes[0][2].getText().equals(botoes[1][2].getText()) && botoes[1][2].getText().equals(botoes[2][2].getText()) && !botoes[0][2].getText().isEmpty()) {
            vitoria = true;
        }
        if (botoes[0][0].getText().equals(botoes[1][1].getText()) && botoes[1][1].getText().equals(botoes[2][2].getText()) && !botoes[0][0].getText().isEmpty()) {
            vitoria = true;
        }
        if (botoes[0][2].getText().equals(botoes[1][1].getText()) && botoes[1][1].getText().equals(botoes[2][0].getText()) && !botoes[0][2].getText().isEmpty()) {
            vitoria = true;
        }

        if (vitoria) {
            label.setText("VENCEU!!");
        }
    }

    public void reiniciarJogo() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                botoes[i][j].setText("");
            }
        }
        vezX = true;
        vitoria = false;
        label.setText("");
        turno.setText("Vez Jogador 1");
    }


}
