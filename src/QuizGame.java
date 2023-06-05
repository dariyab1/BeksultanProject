import java.util.ArrayList;
public class QuizGame {
    private int index;
    private ArrayList<Quiz> wordList;
    private Quiz q;
    private MainGUI gameWindow;
    public QuizGame(){
        wordList=new ArrayList<Quiz>();
        wordList.add(new Quiz("hola", "hello", false));
        wordList.add(new Quiz("sombrero", "hat", false));
        wordList.add(new Quiz("limpiar","clean", false));
        wordList.add(new Quiz("tener", "to have", false));
        index=0;

        q=null;
        gameWindow=new MainGUI(this);
    }

    public String sendWord(){
        q=wordList.get(index);
        return q.getWord();
    }

    public boolean checkAnswered(int n){
        if(index>0){
            return wordList.get(index+n).getAnswered();
        }
        return false;
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
                q.setAnswered();
                index++;
            }
            else{
                q=new Quiz("","", false);
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
        if(index>0&&index+1<wordList.size()){
            index--;
        }
    }
    public void increaseIndex(){
        if(index>0&&index+1<wordList.size()){
            index++;
        }
    }


}
