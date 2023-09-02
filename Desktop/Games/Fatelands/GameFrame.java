import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GameFrame{
   Font sceneFont = new Font("Times New Roman", Font.ITALIC, 20);
   Font mainFont = new Font("Times New Roman", Font.BOLD, 20);
   Font storyFont = new Font("Times New Roman", Font.BOLD, 25);
   ImageIcon nextIcon = new ImageIcon("next.png");
   JButton next = new JButton(nextIcon); 
   
   public GameFrame(){
      JFrame game= new JFrame("Fateland's Hero");
      game.setSize(1600,1000);
      game.setVisible(true);
      game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //introduce user to game
      ImageIcon landscape = new ImageIcon("landscape.png");
      JLabel intro= new JLabel("<html><font color=white>There once was a great hero of Fatelands, but the land soon fell back into chaos.<br/><br/><br/> Who could save the people from the chaos that has returned?</font></html>",landscape, SwingConstants.CENTER);
      intro.setFont(storyFont);
      intro.setHorizontalTextPosition(JLabel.CENTER);
      intro.setVerticalTextPosition(JLabel.CENTER);
      game.add(intro);
      next.addActionListener(this);
      //ask for user info & set user info
      JTextField namePrompt = new JTextField("Hero, what is your name? ",50);
      game.add(namePrompt);
      //playerName = namePrompt.getText();
   }
   
   public void setForest(){ 
      ImageIcon forest = new ImageIcon("forest.png");
      JLabel forestScene= new JLabel("<html><font color=white>Forest</font></html>", forest, SwingConstants.CENTER);
      forestScene.setHorizontalTextPosition(JLabel.CENTER);
      forestScene.setVerticalTextPosition(JLabel.CENTER);
      forestScene.setFont(sceneFont);
      game.remove(intro);
      game.add(forestScene);
   }
   public void setDesert(){ 
      ImageIcon desert = new ImageIcon("desert.jpg");
      JLabel desertScene= new JLabel("Desert", desert, SwingConstants.CENTER);
      desertScene.setHorizontalTextPosition(JLabel.CENTER);
      desertScene.setVerticalTextPosition(JLabel.CENTER);
      desertScene.setFont(sceneFont);
      game.remove(intro);
      game.add(desertScene);
   }
   public void setCourt(){ 
      ImageIcon court = new ImageIcon("court.png");
      JLabel courtScene= new JLabel("Fairy Court", court, SwingConstants.CENTER);
      courtScene.setHorizontalTextPosition(JLabel.CENTER);
      courtScene.setVerticalTextPosition(JLabel.CENTER);
      courtScene.setFont(sceneFont);
      game.remove(intro);
      game.add(courtScene);
   }
   public void setCity(){ 
      ImageIcon city = new ImageIcon("city.png");
      JLabel cityScene= new JLabel("Overlord's City", city, SwingConstants.CENTER);
      cityScene.setHorizontalTextPosition(JLabel.CENTER);
      cityScene.setVerticalTextPosition(JLabel.CENTER);
      cityScene.setFont(sceneFont);
      game.remove(intro);
      game.add(cityScene);
    }
    public void setGod(){ 
      ImageIcon gods = new ImageIcon("god.png");
      JLabel godScene= new JLabel("Lair of Gods & Goddesses", gods, SwingConstants.CENTER);
      godScene.setHorizontalTextPosition(JLabel.CENTER);
      godScene.setVerticalTextPosition(JLabel.CENTER);
      godScene.setFont(sceneFont);
      game.remove(intro);
      game.add(godScene);
    }


}