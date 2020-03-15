
package core;

public class Question {
    private int id;
    private String question;
    
    public Question(int id, String question){
        this.id = id;
        this.question = question;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setQuestion(String question){
        this.question = question;
    }
    public int getId(){
        return this.id;
    }
    public String getQuestion(){
        return this.question;
    }
    
    @Override
    public String toString(){
        return this.question;
    }
}
