import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class MainGUI extends JFrame implements ActionListener {
    private JPanel MyJPanel;
    private JButton submitAnswerButton;
    private JLabel label1;
    private JTextArea theQuestionIsTextArea;

    public MainGUI(){
        createUIComponents();
    }

    public void createUIComponents(){
        setContentPane(MyJPanel);
        setTitle("My GUI");
        setSize(500, 500);
        setLocation(450,100);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        submitAnswerButton.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){}

    public void keyTyped(KeyEvent e){}

    public void keyPressed(KeyEvent e){}

    public void keyReleased(KeyEvent e){}

}
