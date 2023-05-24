import java.util.ArrayList;
public class QuizGame {
    private ArrayList<Quiz> wordList;
    private Quiz q;
    private MainGUI gameWindow;
    public QuizGame(){
        wordList=new ArrayList<Quiz>();
        wordList.add(new Quiz("hola", "hello"));
        q=null;
        gameWindow=new MainGUI(this);
    }
    public String sendWord(){
        q=wordList.get(0);
        return q.getWord();
    }
    public void play(){
        System.out.println("play");
    }

}
