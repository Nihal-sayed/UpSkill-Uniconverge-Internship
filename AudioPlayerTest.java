/*import java.io.File;
import java.io.IOException;
import java.net.URL;
import javazoom.jl.player.Player;*/

public class AudioPlayerTest extends javax.swing.JFrame {
 
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//String audioPath = "";
	MP3 mp3 = null;
    /** Creates new form AudioPlayerTest */
    public AudioPlayerTest(String filename) {
        initComponents();
        //audioPath = "/home/anthony/Music/MoodyLoop.wav";
       // initAudioPlayer(audioPath);
        System.out.println(filename);
    	mp3 = new MP3(filename);
    }
 
  /*  private void initAudioPlayer(String pathname) {
        try {
            URL url = new File(pathname).toURI().toURL();
            audioPlayer = Manager.createRealizedPlayer(url);
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (NoPlayerException ex) {
            ex.printStackTrace();
        } catch (CannotRealizeException ex) {
            ex.printStackTrace();
        }
    }*/
 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
 
        mainPanel = new javax.swing.JPanel();
        PlayButton = new javax.swing.JButton();
        PauseButton = new javax.swing.JButton();
        StopButton = new javax.swing.JButton();
        
 
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
 
        PlayButton.setText("Play");
        PlayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayButtonActionPerformed(evt);
            }
        });
 
        PauseButton.setText("Pause");
        PauseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PauseButtonActionPerformed(evt);
            }
        });
 
        StopButton.setText("Stop");
        StopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StopButtonActionPerformed(evt);
            }
        });
 
        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
               .addComponent(PlayButton)
                .addGap(27, 27, 27)
                .addComponent(PauseButton)
                .addGap(18, 18, 18)
                .addComponent(StopButton)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PlayButton)
                    .addComponent(PauseButton)
                    .addComponent(StopButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
 
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
 
        pack();
    }// </editor-fold>
 
    private void PlayButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        mp3.play();
    }
 
    private void PauseButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    	mp3.Pause();
       
    }
 
    private void StopButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    	 mp3.close();
    }
 
    /**
    * @param args the command line arguments
    */
 /*   public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AudioPlayerTest().setVisible(true);
            }
        });
    }*/
 
    // Variables declaration - do not modify
    private javax.swing.JButton PauseButton;
    private javax.swing.JButton PlayButton;
    private javax.swing.JButton StopButton;
    private javax.swing.JPanel mainPanel;
    
    // End of variables declaration
}
