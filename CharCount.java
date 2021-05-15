import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class CharCount extends JFrame implements ActionListener{
  JLabel lb1, lb2;
  JTextArea ta;
  JButton b, pad, text;
  CharCount(){
    super("Text Counter");

    ImageIcon icon = new ImageIcon("word.jpg");
    setIconImage(icon.getImage());

    lb1= new JLabel("Characters: ");
    lb1.setBounds(40,30,100,20);

    lb2= new JLabel("Words: ");
    lb2.setBounds(40,60,100,20);

    ta= new JTextArea();
    JScrollPane sp=new JScrollPane(ta);
    sp.setBounds(40,90,320,200);

    b= new JButton("Count");
    b.setBounds(40,300, 80,30); //x,y,w,h
    b.addActionListener(this);

    pad= new JButton("Pad Color");
    pad.setBounds(130,300, 110,30); //x,y,w,h
    pad.addActionListener(this);

    text= new JButton("Text Color");
    text.setBounds(250,300, 110,30); //x,y,w,h
    text.addActionListener(this);

    add(lb1);add(lb2);add(sp);add(b);add(pad);add(text);

    setSize(420,400);
    setLayout(null); //using no layout manager
    setVisible(true);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
  }
  public void actionPerformed(ActionEvent e){
    if(e.getSource()==b){
      String text = ta.getText();
      int clen = text.length();
      char[] charArr = text.toCharArray();
      for (char ch : charArr){
        if (ch == ' ' || ch == '\n' || ch == '\t'){
          clen--;
        }
      }
      lb1.setText("Characters: "+ clen);

      String wordArr[] = text.split("\\s");
      int wlen = wordArr.length;
      for (String str : wordArr){
        if (str == " " || str == "\n" || str == "\t"){
          wlen--;
        }
      }
      lb2.setText("Words: "+ wlen);
    }
    else if(e.getSource()==pad){
      Color c = JColorChooser.showDialog(this,"Choose Color",Color.WHITE);
      ta.setBackground(c);
    }
    else if(e.getSource()==text){
      Color c = JColorChooser.showDialog(this,"Choose Color",Color.BLACK);
      ta.setForeground(c);
    }
  }

  public static void main(String[] args) {
    new CharCount();
  }
}
