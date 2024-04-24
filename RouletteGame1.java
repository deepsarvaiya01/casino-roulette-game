import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// import java.io.BufferedReader;
// import java.io.FileReader;
// import java.io.FileWriter;
// import java.nio.Buffer;
import javax.sound.sampled.*;
// import javax.swing.*;
// import java.awt.event.*;
// import javax.sound.sampled.*;
import java.io.*;

 class RouletteGame1 extends JFrame {
    
    private JFrame settingsFrame;  // Reference to the settings JFrame
    private Clip clip;              // Clip object for playing audio
    private boolean musicPlaying = true;   // Flag to track music state


    private void createSettingsFrame() {
        settingsFrame = new JFrame("Settings");
        settingsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // Close settings on X

        // Create a button to toggle music on/off
        JButton musicButton = new JButton(musicPlaying ? "Mute Music" : "Play Music");
        musicButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (musicPlaying) {
                    clip.stop();
                    musicPlaying = false;
                    musicButton.setText("Play Music");
                } else {
                    clip.start();
                    musicPlaying = true;
                    clip.loop(Clip.LOOP_CONTINUOUSLY);
                    musicButton.setText("Mute Music");
                }
            }
        });
        settingsFrame.add(musicButton);

        settingsFrame.pack();
        settingsFrame.setLocationRelativeTo(this);  // Position settings near main JFrame
        settingsFrame.setVisible(true);
    }

    private void stopMusic() {
        if (clip != null && clip.isOpen() && clip.isRunning()) {
            clip.stop();
        }
    }
    
    private void playMusic() {
        try {
            // Replace "path/to/your/music.mp3" with the actual path to your music file
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File("HomePageMusic.wav"));
            AudioFormat format = ais.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(ais);

            // Use Clip.LOOP_CONTINUOUS (corrected import) to loop music playback
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error playing music: " + e.getMessage());
        }
    }

     RouletteGame1(String uname,String coins) {
        
        JButton btn1 = new JButton();
        JButton btn2 = new JButton("Button 2");
        JButton btn3 = new JButton("Button 3");
        JButton btn4 = new JButton("Button 4");
        JButton btn5 = new JButton("Bet on 1 No.");
        JButton rtable2 = new JButton("Bet on Set");
        JButton rtable3 = new JButton("Bet on types");
        JButton rtable4 = new JButton("Bet on Column");
        JButton rtable5 = new JButton("Bet on 6 No.");
        JButton btn6 = new JButton("Button 6");
        JButton btn7 = new JButton("Button 7");

        // Create labels
        JLabel label1 = new JLabel("Rules");
        JLabel label2 = new JLabel("Settings");
        JLabel label3 = new JLabel("About Us");
        JLabel label4 = new JLabel("Log Out");
        JLabel label6 = new JLabel(uname);
        // System.out.println(this.username);
        JLabel label7 = new JLabel(coins);

        label1.setFont(new Font("",Font.BOLD,12));
        label1.setForeground(Color.orange);
        label2.setFont(new Font("",Font.BOLD,12));
        label2.setForeground(Color.orange);
        label3.setFont(new Font("",Font.BOLD,12));
        label3.setForeground(Color.orange);
        label4.setFont(new Font("",Font.BOLD,12));
        label4.setForeground(Color.orange);
        label6.setFont(new Font("",Font.BOLD,12));
        label6.setForeground(Color.orange);
        label7.setFont(new Font("",Font.BOLD,12));
        label7.setForeground(Color.orange);

        
        setLayout(null);

        btn1.setBounds(410, 10, 30, 30);
        btn2.setBounds(470, 10, 30, 30);
        btn3.setBounds(530, 10, 30, 30);
        btn4.setBounds(520, 310, 50, 30); 
        btn5.setBounds(100, 140, 120, 30);
        rtable2.setBounds(250, 140, 120, 30);

        rtable3.setBounds(400, 140, 120, 30);

        rtable4.setBounds(200, 200, 120, 30);
        rtable5.setBounds(350, 200, 120, 30);
        btn6.setBounds(20, 10, 33, 20); 
        btn7.setBounds(20, 32, 33, 20); 

        label1.setBounds(410, 39, btn1.getPreferredSize().width, 20);
        label2.setBounds(464, 39, btn2.getPreferredSize().width, 20);
        label3.setBounds(522, 39, btn3.getPreferredSize().width, 20);
        label4.setBounds(523, 340, btn4.getPreferredSize().width, 20);
        label6.setBounds(60, 10, 100, 20);
        label7.setBounds(60, 32, 100, 20);

        ImageIcon icon1 = new ImageIcon("rules.jpg");
        ImageIcon icon2 = new ImageIcon("setting.jpg");
        ImageIcon icon3 = new ImageIcon("about.jpg"); 
        ImageIcon icon4 = new ImageIcon("logout.jpg"); 
        ImageIcon icon6 = new ImageIcon("player.jpg");
        ImageIcon icon7 = new ImageIcon("coins.jpg");

                int btnWidth1 = btn1.getWidth();
                int btnHeight1 = btn1.getHeight();
                Image scaledImage1 = icon1.getImage().getScaledInstance(btnWidth1, btnHeight1, Image.SCALE_SMOOTH);
                ImageIcon scaledIcon1 = new ImageIcon(scaledImage1);
                btn1.setIcon(scaledIcon1);

                // int btnWidth2 = btn2.getWidth();
                // int btnHeight2 = btn2.getHeight();
                // int btnWidth2 = btn2.getWidth();
                // int btnHeight2 = btn2.getHeight();
                Image scaledImage2 = icon2.getImage().getScaledInstance(30, 28, Image.SCALE_SMOOTH);
                ImageIcon scaledIcon2 = new ImageIcon(scaledImage2);
                btn2.setMargin(new Insets(0, 14, 0, 0));
                btn2.setIcon(scaledIcon2);

                // int btnWidth3 = btn3.getWidth();
                // int btnHeight3 = btn3.getHeight();
                Image scaledImage3 = icon3.getImage().getScaledInstance(32, 30, Image.SCALE_SMOOTH);
                ImageIcon scaledIcon3 = new ImageIcon(scaledImage3);
                btn3.setMargin(new Insets(0, 14, 0, 0));

                btn3.setIcon(scaledIcon3);

                // int btnWidth4 = btn4.getWidth();
                // int btnHeight4 = btn4.getHeight();
                Image scaledImage4 = icon4.getImage().getScaledInstance(70, 33, Image.SCALE_SMOOTH);
                ImageIcon scaledIcon4 = new ImageIcon(scaledImage4);
                btn4.setIcon(scaledIcon4);

                int btnWidth6 = btn6.getWidth();
                int btnHeight6 = btn6.getHeight();
                Image scaledImage6 = icon6.getImage().getScaledInstance(btnWidth6, btnHeight6, Image.SCALE_SMOOTH);
                ImageIcon scaledIcon6 = new ImageIcon(scaledImage6);
                btn6.setMargin(new Insets(0, 14, 0, 0));

                btn6.setIcon(scaledIcon6);

                int btnWidth7 = btn7.getWidth();
                int btnHeight7 = btn7.getHeight();
                Image scaledImage7 = icon7.getImage().getScaledInstance(btnWidth7, btnHeight7, Image.SCALE_SMOOTH);
                ImageIcon scaledIcon7 = new ImageIcon(scaledImage7);
                btn7.setMargin(new Insets(0, 14, 0, 0));

                btn7.setIcon(scaledIcon7);
        // btn1.setIcon(icon1);
        // btn2.setIcon(icon2);
        // btn3.setIcon(icon3);
        // btn4.setIcon(icon4);

        add(btn1);
        add(btn2);
        add(btn3);
        add(btn4);
        add(btn5);
        add(btn6);
        add(btn7);

        add(rtable2);
        add(rtable3);
        add(rtable4);
        add(rtable5);
        add(label1);
        add(label2);
        add(label3);
        add(label4);
        add(label6);
        add(label7);
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null ," 1.  The default bet amount for each round of the game is set at 50 coins. \n  2.  The game continues until the player decides to quit or runs out of coins." );

            //     3.  If the number the player bets on matches the number the roulette wheel lands on after spinning, the player wins. 
            //     4.  When a player wins, they receive a payout of 36 times the amount of their bet.
            //     5.  If the number the player bets on does not match the number the roulette wheel lands on, the player loses their bet amount.
            //     6.  The game continues until the player decides to quit or runs out of coins.
            }
        });
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createSettingsFrame();
            }
        });
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null ,"Deep Sarvaiya \nHarsh Parekh \nDharmi Sindhav \nWe collaberatly have made this project using Java Swing , Awt and MySql Database." );
            }
        });

          btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stopMusic();
                // LoginDemo.Login();

                Login l = new Login();
                l.setTitle("Roulette Game(Login Page)");
                l.setBounds(400,200,500,250);
                l.setVisible(true);
                dispose();
            }
        });

        btn5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stopMusic();
                RTable r1 = new RTable(uname,coins);
                r1.setTitle("Roulette Table");
                r1.setSize(1350, 750);
                r1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                r1.setLocationRelativeTo(null);
                dispose();
            }
        });
      

        rtable2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stopMusic();
                RTable2 r = new RTable2(uname,coins);
                r.setTitle("Roulette Table");
                r.setSize(1350, 750);
                r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                r.setLocationRelativeTo(null);
                dispose();
            }
        });

        rtable3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stopMusic();
                RTable3 r2 = new RTable3(uname,coins);
            r2.setTitle("Roulette Table");
            r2.setSize(1350, 750);
            r2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            r2.setLocationRelativeTo(null);
            dispose();
            }
        });
        rtable4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stopMusic();
                RTable4 r3 = new RTable4(uname,coins);
            r3.setTitle("Roulette Table");
            r3.setSize(1350, 750);
            r3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            r3.setLocationRelativeTo(null);
            dispose();
            }
        });
        rtable5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stopMusic();
                RTable5 r4 = new RTable5(uname,coins);
            r4.setTitle("Roulette Table");
            r4.setSize(1350, 750);
            r4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            r4.setLocationRelativeTo(null);
            dispose();
            }
        });
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();

                // Set the opacity (transparency) level
                float opacity = 0.8f; // Adjust this value (0.0f for fully transparent, 1.0f for fully opaque)

                // Create an AlphaComposite instance with the specified opacity
                AlphaComposite alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity);

                // Set the composite for the Graphics2D object
                g2d.setComposite(alphaComposite);

                // Draw the background image with the specified opacity
                ImageIcon backgroundImg = new ImageIcon("mainRoulettePage.jpg");
                g2d.drawImage(backgroundImg.getImage(), 0, 0, getWidth(), getHeight(), this);

                g2d.dispose(); // Dispose of the Graphics2D object
            }
        };
        backgroundPanel.setBounds(0, 0, 600, 400);
        add(backgroundPanel);
        playMusic();
        setVisible(true);
    }
}
// class RouletteGame{
//     public static void main(String[] args) {
        
// // RouletteGame1 l=new RouletteGame1();
// //         l.setTitle("Roulette Game");
// //         l.setSize(600, 400); 
// //        l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// //         l.setLocationRelativeTo(null);
//     }
// }
