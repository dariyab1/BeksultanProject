import java.util.ArrayList;
public class QuizGame {
    private ArrayList<Quiz> wordList;
    private Quiz q;
    private MainGUI gameWindow;
    public QuizGame(){
        wordList=new ArrayList<Quiz>();
        q=null;
        gameWindow=new MainGUI(this);
    }
    public String sendWord(){
        return q.getWord();
    }
    public void play(){
        System.out.println("play");
    }

}
