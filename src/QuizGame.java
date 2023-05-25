import java.util.ArrayList;
public class QuizGame {
    private ArrayList<Quiz> wordList;
    private Quiz q;
    private MainGUI gameWindow;
    public QuizGame(){
        wordList=new ArrayList<Quiz>();
        wordList.add(new Quiz("hola", "hello"));
        wordList.add(new Quiz("sombrero", "hat"));
        wordList.add(new Quiz("limpiar","clean"));
        wordList.add(new Quiz("tener", "to have"));

        q=null;
        gameWindow=new MainGUI(this);
    }
    public String sendWord(){
        q=wordList.get(0);
        return q.getWord();
    }
    public void play(){
        if(wordList != null && wordList.size()>0){
            q=wordList.get(0);
        }
    }
    public String correctAnswer(){
        return wordList.get(0).getAnswer();
    }

    public boolean processGuess(String guess){
        if(guess.equals(correctAnswer())){
            wordList.remove(0);
            if(wordList.size()>0){
                q=wordList.get(0);
            }
            else{
                q=new Quiz("","");
            }
            return true;
        }
        else{
            return false;
        }

    }
    public int getWordListSize(){
        return wordList.size();
    }

}
