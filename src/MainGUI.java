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
    private JTextArea QuestionArea;
    private QuizGame game;


    public MainGUI(QuizGame gameRef){
        game=gameRef;
        createUIComponents();
        setupListeners();
    }

    public void setupListeners(){
        StartButton.addActionListener(this);
        submitAnswerButton.addActionListener(this); //need to add action listener for submit answer button
    }

    public void createUIComponents(){
        setContentPane(MyJPanel);
        setTitle("My GUI");
        setSize(500, 500);
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
            QuestionArea.append(game.sendWord());
            StartButton.setVisible(false);
        }
        else if(buttonText.equals("Submit answer")){
            game.processGuess(buttonText);
            updateScreen();
        }

    }


    private void updateScreen(){
        String currentGuess = answerField.getText();
        QuestionArea.append("\nYou have guessed: "+currentGuess+"\n");
        if(game.processGuess(currentGuess)){
            QuestionArea.setBackground(cyan);
            QuestionArea.append("Correct!\n");
            QuestionArea.append(game.sendWord());
        }
        else{
            QuestionArea.setBackground(red);
            QuestionArea.append("Try again");
        }
        if(game.getWordListSize()==0){
            QuestionArea.append("\nNo more words to review");
            submitAnswerButton.setEnabled(false);
            QuestionArea.setEnabled(false);
        }
    }



}
