package org.lld.structuralPattern.facade;
// Subsystem classes
class DVDPlayer {
    public void on() {
        System.out.println("DVD Player turned ON");
    }
    public void play(String movie) {
        System.out.println("Playing movie: " + movie);
    }
    public void off() {
        System.out.println("DVD Player turned OFF");
    }
}

class Projector {
    public void on() {
        System.out.println("Projector turned ON");
    }
    public void off() {
        System.out.println("Projector turned OFF");
    }
}

class SoundSystem {
    public void on() {
        System.out.println("Sound system turned ON");
    }
    public void setVolume(int level) {
        System.out.println("Sound volume set to " + level);
    }
    public void off() {
        System.out.println("Sound system turned OFF");
    }
}

class HomeTheaterFacade {
    private DVDPlayer dvdPlayer;
    private Projector projector;
    private SoundSystem soundSystem;

    public HomeTheaterFacade(DVDPlayer dvd, Projector proj, SoundSystem sound) {
        this.dvdPlayer = dvd;
        this.projector = proj;
        this.soundSystem = sound;
    }

    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        projector.on();
        soundSystem.on();
        soundSystem.setVolume(5);
        dvdPlayer.on();
        dvdPlayer.play(movie);
    }

    public void endMovie() {
        System.out.println("Shutting down the movie theater...");
        dvdPlayer.off();
        soundSystem.off();
        projector.off();
    }
}

public class MovieFacadeMain {
    public static void main(String[] args) {
        DVDPlayer dvd = new DVDPlayer();
        Projector projector = new Projector();
        SoundSystem sound = new SoundSystem();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(dvd, projector, sound);

        homeTheater.watchMovie("Inception");
        System.out.println("------");
        homeTheater.endMovie();
    }
}
