package TP4.exercice5;

public class PrefixToPostfix {
    private String prefix;
    private String postfix;
    private int pos;

    public PrefixToPostfix(String prefix){
        this.pos = 0;
        this.prefix = prefix;
    }

    public String transform(){
        return this.postfix;
    }
}
