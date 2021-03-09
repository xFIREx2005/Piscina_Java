
package piscina_hard;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Piscina_Hard extends JFrame{
    
    private JTextField txtnum1;
    private JTextField txtnum2;
    private JTextField txtnum3;
    private JTextField txtresult;
    private JLabel lbnum1;
    private JLabel lbnum2;
    private JLabel lbnum3;
    private JLabel lbresult;
    private JButton btnresult;
    private JButton btnlimpar;
    private static Piscina_Hard frame;
    
    public Piscina_Hard(){
        inicializarComponentes();
        definirEventos();
    }   
    
    private void inicializarComponentes(){
        setTitle("Calcular Valor");
        setBounds(0,0,340,255);
        setLayout(null);
        txtnum1 = new JTextField(5);
        txtnum2 = new JTextField(5);
        txtnum3 = new JTextField(5);
        txtresult = new JTextField(5);
        lbnum1 = new JLabel("Largura");
        lbnum2 = new JLabel("Comprimento");
        lbnum3 = new JLabel("Profundidade");
        lbresult = new JLabel("Resultado");
        btnresult = new JButton("Calcular");
        btnlimpar = new JButton("Limpar");
        txtnum1.setBounds(150,30,120,25);
        txtnum2.setBounds(150,60,120,25);
        txtnum3.setBounds(150,90,120,25);
        txtresult.setBounds(150,170,120,25);         
        lbnum1.setBounds(40,30,80,25);
        lbnum2.setBounds(40,60,80,25);
        lbnum3.setBounds(40,90,80,25);
        lbresult.setBounds(40,170,80,25);
        btnresult.setBounds(40,130,100,25);
        btnlimpar.setBounds(170,130,100,25);
        add(txtnum1);
        add(txtnum2);
        add(txtnum3);
        add(txtresult);
        add(lbnum1);
        add(lbnum2);
        add(lbnum3);
        add(lbresult);
        add(btnresult);
        add(btnlimpar);      
    }
    private void definirEventos(){
       btnresult.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
            double num1=0, num2=0, num3=0, result=0;
            try
            {
                num1 = Double.parseDouble(txtnum1.getText());
                num2 = Double.parseDouble(txtnum2.getText());
                num3 = Double.parseDouble(txtnum3.getText());
            }
            catch(NumberFormatException erro)
            {
                txtresult.setText("Apenas números");
                return;
            }
            
            if(e.getSource()==btnresult) result = (num1 * num2 * num3) * 300;
            txtresult.setText("" + result); 
            
           }
       });
       
       btnlimpar.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
                txtnum1.setText("");
                txtnum2.setText("");
                txtnum3.setText("");
                txtresult.setText("");
                return;
           }       
       });    
    }
    
    public static void main (String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
          public void run(){
              frame = new Piscina_Hard();
              frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
              frame.setLocation((tela.width - frame.getSize().width)/2,
                      (tela.height - frame.getSize().height)/2);
              frame.setVisible(true);
          }       
        });
    }   
}