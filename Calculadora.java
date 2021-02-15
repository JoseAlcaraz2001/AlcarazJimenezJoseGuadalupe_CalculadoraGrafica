import javax.swing.*;
import java.awt.event.*;
import java.util.*;

// Programador: Alcaraz Jimenez Jose Guadalupe

public class Calculadora extends JFrame implements ActionListener
{
   JTextField numero1, numero2, resultado;
   JButton sumar, restar, multiplicar, dividir, limpiar;
   JLabel campoR;
   JPanel panel;
   float n1 = 0, n2 = 0;
   
   public Calculadora()
   {
      initComponents();
   }
   
   private void initComponents()
   {
      setSize(260, 300);
      setTitle("Calculadora Grafica");
      setLocationRelativeTo(null);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
         
      numero1 = new JTextField("0", 20);
      numero2 = new JTextField("0", 20);
      resultado = new JTextField(20);
      campoR = new JLabel("Resultado: ");
      resultado.setEditable(false);
      
      sumar = new JButton("Sumar");
      restar = new JButton("Restar");
      multiplicar = new JButton("Multiplicar");
      dividir = new JButton("Dividir");
      limpiar = new JButton("Limpiar");
      
      sumar.addActionListener(this);
      restar.addActionListener(this);
      multiplicar.addActionListener(this);
      dividir.addActionListener(this);
      limpiar.addActionListener(this);
      
      panel = new JPanel();
      panel.add(numero1);
      panel.add(numero2);
      panel.add(campoR);
      panel.add(resultado);
      panel.add(sumar);
      panel.add(restar);
      panel.add(multiplicar);
      panel.add(dividir);
      panel.add(limpiar);
      setContentPane(panel);
      setVisible(true);
   }
   
   public void actionPerformed(ActionEvent event)
   {
      try{
         obtenerNums();
         
         if (event.getSource() == sumar)
            resultado.setText(String.valueOf(n1 + n2));
       
         else if (event.getSource() == restar)
            resultado.setText(String.valueOf(n1 - n2));

         else if (event.getSource() == multiplicar)
            resultado.setText(String.valueOf(n1 * n2));
         
         else if (event.getSource() == dividir)
         {
            if (n2 == 0)
            {
               JOptionPane.showMessageDialog(null, "Division entre 0, ingrese los valores de nuevo");
               limpiar();
            }
            else
               resultado.setText(String.valueOf(n1 / n2));
         } 
         else 
            limpiar();
      }
      catch(NumberFormatException e)
      {
         JOptionPane.showMessageDialog(null, "Entrada invalida, ingrese los valores de nuevo");
         limpiar();
      }
   }
   
   public void obtenerNums()
   {
      n1 = Float.parseFloat(numero1.getText());
      n2 = Float.parseFloat(numero2.getText());   
   }
   
   public void limpiar()
   {
      numero1.setText("0");
      numero2.setText("0");
      resultado.setText(null);
   }
}