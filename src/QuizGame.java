import java.util.ArrayList;
public class QuizGame {
    private int index;
    private ArrayList<Quiz> wordList;
    private Quiz q;
    private MainGUI gameWindow;
    private StartWindow start;
    public QuizGame(){
        wordList=new ArrayList<Quiz>();
        wordList.add(new Quiz("hola", "hello"));
        wordList.add(new Quiz("sombrero", "hat"));
        wordList.add(new Quiz("limpiar","clean"));
        wordList.add(new Quiz("tener", "to have"));
        index=0;

        q=null;

        start = new StartWindow(this);

        //gameWindow=new MainGUI(this);
    }

    public void clearList(){
        wordList.clear();
        index=0;
    }
    public void addWord(String word, String translation){
        wordList.add(new Quiz(word, translation));
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
        if(index>0&&index+1<wordList.size()){
            index--;
            System.out.println("decreased");
        }
    }
    public void increaseIndex(){
        if(index>-1&&index+1<wordList.size()){
            index++;
            System.out.println("increased");
        }
    }


}
