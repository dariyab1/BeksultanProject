import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonalizedQuiz extends JFrame implements ActionListener {
    private JButton addWordButton;
    private JTextField textField1;
    private JTextField textField2;
    private JPanel PersonalizedQuizPanel;
    private JButton takeQuizButton;
    private QuizGame game;
    private MainGUI takeQuiz;


    public PersonalizedQuiz(QuizGame game){
        super();
        createUIComponents();
        setupListeners();
        this.game=game;
    }

    public void createUIComponents(){
        setContentPane(PersonalizedQuizPanel);
        setTitle("Make Your Own Quiz!");
        setSize(600, 200);
        setLocation(450,100);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void setupListeners(){
        addWordButton.addActionListener(this);
        takeQuizButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        Object source=e.getSource();
        JButton clickedButton=(JButton) source;
        String buttonText= clickedButton.getText();
        if(buttonText.equals("Add Word")) {
            String tempWord = textField1.getText();
            String tempAnswer = textField2.getText();
            game.addWord(tempWord, tempAnswer);
        }
        else if(buttonText.equals("Take Quiz")){
            System.out.println("take quiz");
            takeQuiz=new MainGUI(game);
            setVisible(false);
        }
    }
}
