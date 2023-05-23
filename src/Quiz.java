public class Quiz {
    private String word;
    private String answer;

    public Quiz(String word, String answer){
        this.word=word;
        this.answer=answer;
    }

    public String getWord(){
        return word;
    }

    public String getAnswer(){
        return answer;
    }

}
