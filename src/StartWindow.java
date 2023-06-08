import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StartWindow extends JFrame implements ActionListener{
    private JButton startQuizButton;
    private JPanel StartPanel;
    private JButton addWordsButton;
    private QuizGame game;
    private MainGUI test;
    private String buttonText;
    private PersonalizedQuiz test2;

    public StartWindow(QuizGame gameRef){
        game=gameRef;
        createUIComponents();
        setupListeners();
    }

    public void createUIComponents(){
        setContentPane(StartPanel);
        setTitle("Start Window");
        setSize(500, 300);
        setLocation(450,100);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setVisible(true);
    }

    public void setupListeners(){
        startQuizButton.addActionListener(this);
        addWordsButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        Object source=e.getSource();
        JButton clickedButton=(JButton) source;
        buttonText= clickedButton.getText();
        System.out.println(buttonText);
        if(buttonText.equals("Start Quiz")){
            setVisible(false);
            test=new MainGUI(game);
        }
        if(buttonText.equals("Make Your Own Quiz")){
            setVisible(false);
            test2=new PersonalizedQuiz(game);
        }
    }


}
