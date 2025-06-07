package org.lld.structuralPattern.adapter.AudioPlayer;

//Target interface
interface MediaPlayer{
    void play(String audioType,String filename);
}

//Adaptee interface
interface AdvancedMediaPlayer{
    void playVlc(String fileName);
    void playMp4(String fileName);
}



public class Main {
    public static void main(String[] args) {

    }
}
