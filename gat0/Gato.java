import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Gato extends JFrame implements ActionListener{
    JButton botones [] = new JButton[9];
    boolean turnoX;
    Font fuente  = new Font("Arial", 1, 50);

    public Gato(){
        setSize(400,400);
        setTitle("Juego Gato");
        setDefaultCloseOperation(3);
        setLayout(new GridLayout(3, 3));

        /*
        botones[0] = new JButton("");
        Font fuente  = new Font("Arial", 1, 50);
        botones[0].setFont(fuente);
        botones[0].addActionListener(this);
        add(botones[0]);
        */

        for(int i=0; i<botones.length;i++){
            botones[i] = new JButton("");
            botones[i].setFont(fuente);
            botones[i].addActionListener(this);
            add(botones[i]);
        }


    }

    public void actionPerformed(ActionEvent e){
        String letra;
        if(turnoX){
            letra = "X";
            turnoX=false;
        }else{
            letra = "O";
            turnoX=true;
        }
        for(int i=0;i<botones.length;i++){
            if((e.getSource()==botones[i])){
                botones[i].setText(letra);
                botones[i].setEnabled(false);
            }
        }
        int[][] combinaciones_ganadoras ={
                {0,1,2},
                {3,4,5},
                {6,7,8},
                {0,4,8},
                {2,4,6},
                {0,3,6},
                {1,4,7},
                {2,5,8}
        };
        for(int i=0;i<combinaciones_ganadoras.length;i++){
            int psc1 = combinaciones_ganadoras[i][0];
            int psc2 = combinaciones_ganadoras[i][1];
            int psc3 = combinaciones_ganadoras[i][2];

            if(!botones[psc1].getText().equals("")&&
                    botones[psc1].getText().equals(botones[psc2].getText())&&
                    botones[psc2].getText().equals(botones[psc3].getText())){

                JOptionPane.showMessageDialog(null, "Gana: "+ botones[psc1].getText());

            }
        }
    }
}
