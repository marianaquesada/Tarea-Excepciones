//Mariana Quesada
//2021579438
//15/04/22

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class OrderException extends Exception{
   @Override
   public String toString(){
      return "Orden inválido";
   }
}
class Frame implements ActionListener
{
   JButton boton1 = new JButton("1");
   JButton boton2 = new JButton("2");
   JButton boton3 = new JButton("3");
   JFrame frame = new JFrame("Excepciones");
   String str = "";
   String re = "^(1|12|123)$";
   Pattern pt=Pattern.compile(re);
   public Frame ()
   {
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      boton1.addActionListener(this);
      boton2.addActionListener(this);
      boton3.addActionListener(this);
      frame.setLayout(new FlowLayout());
      frame.add(boton1);
      frame.add(boton2);
      frame.add(boton3);
      frame.setSize(500,300);
      frame.setVisible(true);
   }
   
   void validar(){
      try{
         System.out.println(str);
         Matcher mt=pt.matcher(str);
         boolean result=mt.matches();
         System.out.println(result);
         if (mt.matches()){
            if (str.length()==3){
               JOptionPane.showMessageDialog(frame,"Bien hecho!");
               str="";
            }
         }
         else{
            throw new OrderException();
         }
      }
      catch(OrderException e){
         JOptionPane.showMessageDialog(frame,"Debe presionar los botones en orden.", "ERROR DE ORDEN",JOptionPane.ERROR_MESSAGE);
         str="";
      }
   }

   public void actionPerformed (ActionEvent e)
   {
      if (e.getSource() == boton1)
         str=str+"1";
      if (e.getSource() == boton2)
         str=str+"2";
      if (e.getSource() == boton3)
         str=str+"3";
      validar();
      }

   public static void main(String[] args)
   {
      new Frame();
   }
} 