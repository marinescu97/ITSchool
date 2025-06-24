package session_31_DesignPattern;

class SistemLumini{
    public void stingeLumina(){
        System.out.println("Luminile s-au stins");
    }
}

class SistemAudio{
    public void pornesteBoxe(){
        System.out.println("Sistemul audio a fost pornit");
    }
}

class SistemVideo{
    public void videoPornit(){
        System.out.println("Videoproiectorul a pornit");
    }
}

class HomeCinemaFacade{
    private final SistemLumini sistemLumini;
    private final SistemAudio sistemAudio;
    private final SistemVideo sistemVideo;

    public HomeCinemaFacade() {
        this.sistemLumini = new SistemLumini();
        this.sistemAudio = new SistemAudio();
        this.sistemVideo = new SistemVideo();
    }

    public void pornesteFilm(){
        sistemLumini.stingeLumina();
        sistemAudio.pornesteBoxe();
        sistemVideo.videoPornit();
    }
}

public class Facade {
    public static void main(String[] args) {
        HomeCinemaFacade facade = new HomeCinemaFacade();
        facade.pornesteFilm();
    }
}
