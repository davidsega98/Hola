package controller;

import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;

public class Music implements Runnable  {

    private String locationFile = "data/music/";
    private Clip music;
    private LinkedList<String> playlist ;
    private Clip sound;
    private int numClip = 0;
    private boolean musicOn = true;
    private Controller controller;
    private boolean soundNow = false;
    private boolean changeMusic = true;

    public Music(Controller controller){
        this.controller = controller;


    }
    public void run() {
        try {

            playlist = new LinkedList<>();
            loadPlaylist();
        } catch (IOException e) {

        }

        try {
            music = AudioSystem.getClip();

        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        while (true) {
            if (!controller.getSoundNow()) {
                if (controller.getActualLayout() == 1) {
                    if(changeMusic == false){
                        music.close();
                        changeMusic = true;
                    }

                    if (!music.isOpen()&& !controller.duringThread()) {
                        runMusic(new File("data/LogInTheme.wav"));
                    }
                } else {
                    try{
                        if(sound.isOpen()){
                            sound.close();
                        }
                    }catch (Exception e){

                    }

                    if(!music.isOpen()){
                        changeMusic = false;
                               /* try {

                                   //
                                    // System.out.println(music.isActive());
                                } catch (Exception e) {

                                }*/
                        if(numClip == (playlist.size())){
                            numClip = 0;
                        }
                        runMusic(new File(playlist.get(numClip)));
                    }else{
                        if(!changeMusic) {
                            music.addLineListener(new LineListener() {
                                @Override
                                public void update(LineEvent event) {
                                    if (event.getType() == LineEvent.Type.STOP) {
                                        event.getLine().close();
                                        music.close();
                                        changeMusic = false;
                                    }
                                }

                            });
                        }else{
                            changeMusic = false;
                        }
                    }
                }
            } else {
                if(music.isOpen()) {
                    music.close();
                    runSound(new File("data/sounds/Laser.wav"));
                }

            }
            if(controller.getCloseSound()){
                sound.close();
                controller.setCloseSound(false);
            }
        }
    }


    public void loadPlaylist() throws FileNotFoundException {
        File file = new File("data/music/");
        if (file.exists()) {
            File[] ficheros = file.listFiles();
            for (int i = 0; i < ficheros.length; i++) {
                String s = new String(ficheros[i].getName());
                playlist.add("data/music/"+s);
            }

        } else {
            throw new FileNotFoundException("No se ha encontrado el fichero");

        }
    }
    public void turnOffVolume(){
        FloatControl gainControl =
                (FloatControl) music.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(-59.0f);
    }
    public void turnOnVolume(){
        FloatControl gainControl =
                (FloatControl) music.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(6.0f);
    }
    public void runMusic(File file) {
        try {

            music = AudioSystem.getClip();
            AudioInputStream ais = AudioSystem.getAudioInputStream(file);
            music.open(ais);

            if(controller.getActualLayout() != 1) {
                music.loop(0);
                numClip++;
            }else{
                music.loop(Clip.LOOP_CONTINUOUSLY);
            }
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e1) {
            e1.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }

    }

    public void runSound(File file) {
        try {
            sound = AudioSystem.getClip();
            AudioInputStream ais = AudioSystem.getAudioInputStream(file);
            sound.open(ais);
            sound.loop(Clip.LOOP_CONTINUOUSLY);

        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e1) {
            e1.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }

    }
    public void stopMusic() {
        music.close();
    }
    public boolean startPlaylist(){
        return true;
    }

    public LinkedList<String> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(LinkedList<String> playlist) {
        this.playlist = playlist;
    }

    public int getNumClip() {
        return numClip;
    }

    public void setNumClip(int numClip) {
        this.numClip = numClip;
    }
}


