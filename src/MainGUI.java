import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Color.*;

public class MainGUI extends JFrame implements ActionListener {
    private JPanel MyJPanel;
    private JButton submitAnswerButton;
    private JLabel label1;
    private JTextField answerField;
    private JButton StartButton;
    private JLabel wordLabel;
    private JTextField questionField;
    private JButton nextButton;
    private QuizGame game;


    public MainGUI(QuizGame gameRef){
        game=gameRef;
        createUIComponents();
        setupListeners();
    }

    public void setupListeners(){
        StartButton.addActionListener(this);
        submitAnswerButton.addActionListener(this);
        nextButton.addActionListener(this);
    }

    public void createUIComponents(){
        setContentPane(MyJPanel);
        setTitle("My GUI");
        setSize(500, 300);
        setLocation(450,100);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        Object source=e.getSource();
        JButton clickedButton=(JButton) source;
        String buttonText= clickedButton.getText();
        if(buttonText.equals("START")){
            game.play();
            questionField.setText(game.sendWord());
            StartButton.setVisible(false);
        }
        else if(buttonText.equals("Submit answer")){
            game.processGuess(buttonText);
            updateScreen();
        }
        else if(buttonText.equals("Next")){
            answerField.setBackground(white);
            questionField.setText(game.sendWord());
            answerField.setText("");
        }

    }


    private void updateScreen(){
        String currentGuess = answerField.getText();
        if(game.processGuess(currentGuess)){
            answerField.setBackground(cyan);
            questionField.setText("Correct!\n");
        }
        else{
            answerField.setBackground(red);
            questionField.setText("Try again! \n"+game.sendWord());
        }
        if(game.getWordListSize()==0){
            questionField.setText("\nNo more words to review");
            nextButton.setEnabled(false);
            submitAnswerButton.setEnabled(false);
            questionField.setEnabled(false);
        }
    }



}
