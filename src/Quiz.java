public class Quiz {
    private String word;
    private String answer;
    private boolean answered;

    public Quiz(String word, String answer, boolean answered){
        this.word=word;
        this.answer=answer;
        this.answered=answered;
    }

    public String getWord(){
        return word;
    }

    public String getAnswer(){
        return answer;
    }

    public void setAnswered(){
        answered=true;
    }

    public boolean getAnswered(){
        return answered;
    }

}
