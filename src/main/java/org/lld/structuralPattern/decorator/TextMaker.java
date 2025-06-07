package org.lld.structuralPattern.decorator;
interface Text{
    String getFormattedText();
}
class PlainText implements Text{
    Text text;
    public String getFormattedText(){
        return "Hello World";
    }
}
abstract class TextDecorator implements Text{
    Text text;
    public TextDecorator(Text text){
        this.text = text;
    }
}

class BoldText extends TextDecorator{
    public BoldText(Text text){
        super(text);
    }
    public String getFormattedText(){
        return "<b>" + text.getFormattedText() + "</b>";
    }
}
class ItalicText extends TextDecorator{
    public ItalicText(Text text){
        super(text);
    }
    public  String getFormattedText(){
        return  "<I>" + text.getFormattedText() + "</I>";
    }
}
public class TextMaker {
    public static void main(String[] args) {
        Text text =  new PlainText();
        System.out.println(text.getFormattedText());
        text = new BoldText(text);
        System.out.println(text.getFormattedText());
        text  = new ItalicText(text);
        System.out.println(text.getFormattedText());

    }
}
