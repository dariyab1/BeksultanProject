import java.util.ArrayList;
public class QuizGame {
    private int index;
    private ArrayList<Quiz> wordList;
    private Quiz q;
    private MainGUI gameWindow;
    public QuizGame(){
        wordList=new ArrayList<Quiz>();
        wordList.add(new Quiz("hola", "hello"));
        wordList.add(new Quiz("sombrero", "hat"));
        wordList.add(new Quiz("limpiar","clean"));
        wordList.add(new Quiz("tener", "to have"));
        index=0;

        q=null;
        gameWindow=new MainGUI(this);
    }
    public String sendWord(){
        q=wordList.get(index);
        return q.getWord();
    }
    public void play(){
        if(wordList != null && index<wordList.size()){
            q=wordList.get(index);
        }
    }
    public String correctAnswer(){
        return wordList.get(index).getAnswer();
    }

    public boolean processGuess(String guess){
        if(guess.equals(correctAnswer())){
            if(index<wordList.size()){
                index++;
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
    public int getIndex(){return index;}
    public void decreaseIndex(){
        if(index-1>-1&&index+1<wordList.size()){
            index--;
        }
    }


}
