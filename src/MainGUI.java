import javax.swing.*;
import java.awt.*;
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
    private JButton previousButton;
    private QuizGame game;


    public MainGUI(QuizGame gameRef){
        super();

        game=gameRef;
        createUIComponents();
        setupListeners();
        questionField.setEnabled(false);
        answerField.setEnabled(false);
        nextButton.setEnabled(false);
        submitAnswerButton.setEnabled(false);
    }

    public void setupListeners(){
        StartButton.addActionListener(this);
        submitAnswerButton.addActionListener(this);
        nextButton.addActionListener(this);
        previousButton.addActionListener(this);
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
        if(game.getIndex()==game.getWordListSize()-1){
            questionField.setText("\nNo more words to review");
            nextButton.setEnabled(false);
            submitAnswerButton.setEnabled(false);
        }
        if(buttonText.equals("START")){
            game.play();
            questionField.setEnabled(true);
            answerField.setEnabled(true);
            questionField.setText(game.sendWord());
            StartButton.setVisible(false);
            submitAnswerButton.setEnabled(true);
        }
        else if(buttonText.equals("Submit answer")){
            updateScreen();

        }
        else if(buttonText.equals("Next")){

            game.increaseIndex();
            if(game.checkAnswered(0)){
                showAnswer();
            }
            else {
                nextButton.setEnabled(false);
                answerField.setBackground(white);
                questionField.setText(game.sendWord());
                answerField.setText("");
                submitAnswerButton.setEnabled(true);
            }
        }
        else if(buttonText.equals("Previous")){
            game.decreaseIndex();
            System.out.println(game.checkAnswered(0));
            questionField.setText(game.sendWord());
            answerField.setText(game.correctAnswer());
            submitAnswerButton.setEnabled(false);
            nextButton.setEnabled(true);
        }

    }


    private void updateScreen(){
        String currentGuess = answerField.getText();
        Color myColor;
        if(game.processGuess(currentGuess)){
            myColor = new Color (162, 232, 184);  //creates your new color
            answerField.setBackground(myColor);
            questionField.setText("Correct!\n");
            submitAnswerButton.setEnabled(false);
            nextButton.setEnabled(true);
        }
        else{
            myColor = new Color (252, 104, 104);
            answerField.setBackground(pink);
        }

    }

    public void showAnswer(){
        questionField.setText(game.sendWord());
        answerField.setText(game.correctAnswer());
    }



}
