import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javazoom.jl.player.Player;


public class MP3 {
    private AudioHandling     audio;
    private String            filename;
    private Player            player;
    
    private final String node1 ="C:/Users/Mohsin Anees/Documents/NetBeansProjects/Piano/Notes/Click on any Key to Hear the Note - Keyboard Chords_27.mp3";
    private final String node2 ="C:/Users/Mohsin Anees/Documents/NetBeansProjects/Piano/Notes/Click on any Key to Hear the Note - Keyboard Chords_26.mp3";
    private final String node3 ="C:/Users/Mohsin Anees/Documents/NetBeansProjects/Piano/Notes/Click on any Key to Hear the Note - Keyboard Chords_25.mp3";
    private final String node4 ="C:/Users/Mohsin Anees/Documents/NetBeansProjects/Piano/Notes/Click on any Key to Hear the Note - Keyboard Chords_24.mp3";
    private final String node5 ="C:/Users/Mohsin Anees/Documents/NetBeansProjects/Piano/Notes/Click on any Key to Hear the Note - Keyboard Chords_13.mp3";
    private final String node6 ="C:/Users/Mohsin Anees/Documents/NetBeansProjects/Piano/Notes/Click on any Key to Hear the Note - Keyboard Chords_14.mp3";
    private final String node7 ="C:/Users/Mohsin Anees/Documents/NetBeansProjects/Piano/Notes/Click on any Key to Hear the Note - Keyboard Chords_15.mp3";
    private final String node8 ="C:/Users/Mohsin Anees/Documents/NetBeansProjects/Piano/Notes/Click on any Key to Hear the Note - Keyboard Chords_16.mp3";
    private final String node9 ="C:/Users/Mohsin Anees/Documents/NetBeansProjects/Piano/Notes/Click on any Key to Hear the Note - Keyboard Chords_17.mp3";
    private final String node10="C:/Users/Mohsin Anees/Documents/NetBeansProjects/Piano/Notes/Click on any Key to Hear the Note - Keyboard Chords_18.mp3";
    private final String node11="C:/Users/Mohsin Anees/Documents/NetBeansProjects/Piano/Notes/Click on any Key to Hear the Note - Keyboard Chords_19.mp3";
    private final String node12="C:/Users/Mohsin Anees/Documents/NetBeansProjects/Piano/Notes/Click on any Key to Hear the Note - Keyboard Chords_20.mp3";        

    public MP3(AudioHandling a)
    {
        audio=a;
      
    }

    public void Nodes(int nod)
    {
        if     (nod==1) { filename=node1;}
        else if(nod==2) { filename=node2;}
        else if(nod==3) { filename=node3;}
        else if(nod==4) { filename=node4;}
        else if(nod==5) { filename=node5;}
        else if(nod==6) { filename=node6;}
        else if(nod==7) { filename=node7;}
        else if(nod==8) { filename=node8;}
        else if(nod==9) { filename=node9;}
        else if(nod==10){ filename=node10;}
        else if(nod==11){ filename=node11;}
        else if(nod==12){ filename=node12;}
       
    }

    // play the MP3 file
    public void play(int nod) 
    {
        
        Nodes(nod);
        
        try {
            FileInputStream fis     = new FileInputStream(filename);
            BufferedInputStream bis = new BufferedInputStream(fis);
            player = new Player(bis);
            player.play();
        }
        catch (Exception e) {
            System.out.println("Problem playing file " + filename);
            System.out.println(e);
        }
        
        audio.setMelody(nod);

        
    }
    
    public void rplay(String filename) 
    {
        List<Integer> read=new ArrayList();
        
        try
        { 
        
            read=audio.Reader(filename);
            
            
            for(int i=0;i<read.size();i++)
            {
               
                play(read.get(i));
            }
        
        }
        catch(FileNotFoundException e)
        {
          System.out.println(e);
        }
        
        
    }    
        
       
    
    /**
     *
     */
    public void LastPlay()
    {
        List<Integer> arr=audio.getMelody();
        for(int i=0;i<arr.size();i++)
        {
          
            play(arr.get(i));
        } 
    }
}
