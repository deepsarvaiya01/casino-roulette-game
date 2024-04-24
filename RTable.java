import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// import java.awt.image.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
// import java.sql.Statement;
import java.sql.PreparedStatement;
// import java.sql.*;
import javax.sound.sampled.*;
// import javax.swing.*;
// import java.awt.event.*;
// import javax.sound.sampled.*;
import java.io.*;
import java.sql.*;



class RTable extends JFrame {
    String roulettegame;
    String rTabelCoins;
    int storedValue = -1; // Initialize with an invalid value
    String newcoins1;
    JLabel label10;
    String[] numbers = {"0", "32", "15", "19", "4", "21", "2", "25", "17", "34", "6", "27",
            "13", "36", "11", "30", "8", "23", "10", "5", "24", "16", "33", "1", "20", "14", "31",
            "9", "22", "18", "29", "7", "28", "12", "35", "3", "26"};
    // String[] numbers = {"1"};
            private int currentIndex = 0;
           private Timer timer1;
           private JFrame settingsFrame;  // Reference to the settings JFrame
           private Clip clip;              // Clip object for playing audio
           private boolean musicPlaying = true;

           public int getCurrentNumber() {
            int numberValue = Integer.parseInt(numbers[currentIndex]);

            return numberValue;
        }
    
        private void stopMusic() {
            if (clip != null && clip.isOpen() && clip.isRunning()) {
                clip.stop();
            }
        }

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
                        musicButton.setText("Mute Music");
                    }
                }
            });
            settingsFrame.add(musicButton);
    
            settingsFrame.pack();
            settingsFrame.setLocationRelativeTo(this);  // Position settings near main JFrame
            settingsFrame.setVisible(true);
        }
        private void playMusic() {
            try {
                // Replace "path/to/your/music.mp3" with the actual path to your music file
                AudioInputStream ais = AudioSystem.getAudioInputStream(new File("GamePage.wav"));
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
    
    void playGif() {   

        JLabel gifLabel;
        ImageIcon gifIcon;
        String gifPath = "sw3.gif";
        gifIcon = new ImageIcon(gifPath);
        gifLabel = new JLabel();
        gifLabel.setIcon(gifIcon);
        gifLabel.setBounds(100, 150, 365, 365);


    //     JLabel l6 = new JLabel();
    //     ImageIcon back_img= new ImageIcon("rwhell.png");
    //    l6=new JLabel("",back_img,JLabel.CENTER);
    //    Image img= back_img.getImage();
    //    Image temp_img=img.getScaledInstance(350,350 ,img.SCALE_SMOOTH);
    //    back_img = new  ImageIcon(temp_img);
    //    l6.setBounds(100,150,350,350);
    //    add(l6);
       

JPanel gifpanel = new JPanel();
gifpanel.setBounds(100, 150, 365, 365);

// gifpanel.add(l6);
// gifpanel.setOpaque(false);
gifpanel.add(gifLabel);
add(gifpanel);

        gifLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gifLabel.setVerticalAlignment(SwingConstants.CENTER);
        
        setVisible(true);

        // Set the timer for 5000 milliseconds (5 seconds)
        Timer timer = new Timer(2300, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Stop the GIF animation after 5 seconds
                gifLabel.setIcon(null);
                ((Timer)e.getSource()).stop(); // Stop the timer
                gifpanel.setVisible(false);
            }
        });
        
        timer.setRepeats(false); // Set to not repeat
        timer.start(); // Start the timer
    }

    RTable(String uname,String coins) {
        rTabelCoins = coins;
        // int intCoins = Integer.parseInt(coins);
        
        System.out.println(coins);
        setLayout(null);
        ImageIcon back_img= new ImageIcon("rwhell1.png");
        JLabel l6 = new JLabel(back_img);
        l6.setBounds(100,155,365,365);
        add(l6);
    //    l6=new JLabel("",back_img,JLabel.CENTER);
    //    Image img= back_img.getImage();
    // //    Image temp_img=img.getScaledInstance(500,500 ,img.SCALE_SMOOTH);
    // //    back_img = new  ImageIcon(temp_img);
    //    l6.setBounds(20,120,500,500);
    //    add(l6);
        

        JLabel resultlabel = new JLabel("Result:");
resultlabel.setBounds(220,525,120,25);
resultlabel.setFont(new Font("Times New Roman",Font.BOLD,25));
resultlabel.setOpaque(true);
add(resultlabel);

    

            timer1 = new Timer(100, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    currentIndex++;
                    if (currentIndex >= numbers.length) {
                        currentIndex = 0;
                    }
                    resultlabel.setText("Result: " + numbers[currentIndex]); 
                    roulettegame = numbers[currentIndex];

                }
            });

            


        // JLabel gifLabel;
        // ImageIcon gifIcon;
        // String gifPath = "C:\\Users\\HP\\Desktop\\java project\\abc.gif";

        JButton button1 = new JButton("3");
        JButton button2 = new JButton("6");
        JButton button3 = new JButton("9");
        JButton button4 = new JButton("12");
        JButton button5 = new JButton("15");
        JButton button6 = new JButton("18");
        JButton button7 = new JButton("21");
        JButton button8 = new JButton("24");
        JButton button9 = new JButton("27");
        JButton button10 = new JButton("30");
        JButton button11= new JButton("33");
        JButton button12 = new JButton("36");
        JButton button13 = new JButton("2");
        JButton button14 = new JButton("5");
        JButton button15 = new JButton("8");
        JButton button16 = new JButton("11");
        JButton button17 = new JButton("14");
        JButton button18 = new JButton("17");
        JButton button19 = new JButton("20");
        JButton button20 = new JButton("23");
        JButton button21 = new JButton("26");
        JButton button22 = new JButton("29");
        JButton button23 = new JButton("32");
        JButton button24 = new JButton("35");
        JButton button25= new JButton("1");
        JButton button26= new JButton("4");
        JButton button27= new JButton("7");
        JButton button28= new JButton("10");
        JButton button29= new JButton("13");
        JButton button30= new JButton("16");
        JButton button31= new JButton("19");
        JButton button32= new JButton("22");
        JButton button33= new JButton("25");
        JButton button34= new JButton("28");
        JButton button35= new JButton("31");
        JButton button36= new JButton("34");
  
        ImageIcon icon2 = new ImageIcon("setting.jpg");
        
        ImageIcon icon3 = new ImageIcon("logout.jpg"); 

        JLabel settingLabel = new JLabel("Settings");
        settingLabel.setFont(new Font("",Font.BOLD,12));
        settingLabel.setForeground(Color.orange);
        settingLabel.setBounds(1191, 84, 60, 20);
        add(settingLabel);

        JLabel Rules = new JLabel("Rules");
        Rules.setFont(new Font("",Font.BOLD,12));
        Rules.setForeground(Color.orange);
        Rules.setBounds(1150, 84, 60, 20);
        add(Rules);


        JLabel back = new JLabel("back");
        back.setFont(new Font("",Font.BOLD,12));
        back.setForeground(Color.orange);
        back.setBounds(1204, 682, 60, 20);
        add(back);

        JLabel betValue = new JLabel("Bet value: 50 Coins");
        betValue.setFont(new Font("",Font.BOLD,20));
        betValue.setForeground(Color.orange);
        betValue.setBounds(700, 210, 200, 25);
        add(betValue);




        JButton logout= new JButton("logout");
        logout.setBounds(1200,640,40,40);
        
        JButton settingButton =new JButton();
        settingButton.setBounds(1200,50,30,30);

        JButton rules =new JButton("rules");
        rules.setBounds(1150,50,30,30);
        // add(rules);

        Image scaledImage2 = icon2.getImage().getScaledInstance(30, 28, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon2 = new ImageIcon(scaledImage2);
        settingButton.setMargin(new Insets(0, 0, 0, 0));
        settingButton.setIcon(scaledIcon2);
        add(settingButton);

        Image scaledImage3 = icon3.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon3 = new ImageIcon(scaledImage3);
        logout.setMargin(new Insets(0, 0, 0, 0));
        logout.setIcon(scaledIcon3);
        add(logout);

        ImageIcon icon1 = new ImageIcon("rules.jpg");


        Image scaledImage1 = icon1.getImage().getScaledInstance(36, 28, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon1 = new ImageIcon(scaledImage1);
        rules.setMargin(new Insets(0, 10, 0, 0));
        rules.setIcon(scaledIcon1);
        add(rules);

        settingButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createSettingsFrame();
            }
        });
        
        JLabel label6 = new JLabel(uname);
        JLabel label7 = new JLabel(rTabelCoins);
        JLabel label8 = new JLabel();
        label8.setBounds(20, 20, 40, 37);
        JLabel label9 = new JLabel();
        label9.setBounds(20, 60, 40, 37);

        ImageIcon icon6 = new ImageIcon("player.jpg");
        ImageIcon icon7 = new ImageIcon("coins.jpg");

        int btnWidth6 = label8.getWidth();
        int btnHeight6 = label8.getHeight();
        Image scaledImage6 = icon6.getImage().getScaledInstance(btnWidth6, btnHeight6, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon6 = new ImageIcon(scaledImage6);
        // label8.setMargin(new Insets(0, 14, 0, 0));

        label8.setIcon(scaledIcon6);

        int btnWidth7 = label9.getWidth();
        int btnHeight7 = label9.getHeight();
        Image scaledImage7 = icon7.getImage().getScaledInstance(btnWidth7, btnHeight7, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon7 = new ImageIcon(scaledImage7);
        // btn7.setMargin(new Insets(0, 14, 0, 0));

        label9.setIcon(scaledIcon7);

       
        add(label8);
        add(label9);
       




        label6.setBounds(65,22,100,30);
        label7.setBounds(65,63,100,30);
        
        label6.setFont(new Font("",Font.BOLD,15));
        label6.setForeground(Color.orange);
        
        label7.setFont(new Font("",Font.BOLD,15));
        label7.setForeground(Color.orange);

        add(label6);
        add(label7);


        label10 = new JLabel();

        label10.setFont(new Font("",Font.BOLD,20));
        label10.setForeground(Color.orange);
        label10.setBounds(750, 400, 300, 25);
        label10.setVisible(false);
        add(label10);

        rules.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null ," 1.  The default bet amount for each round of the game is set at 50 coins. \n 2.  Players have the option to place their bets on any number from 0 to 36. They can choose the number they believe the roulette wheel will land on. \n 3.  If the number the player bets on matches the number the roulette wheel lands on after spinning, the player wins. \n 4.  When a player wins, they receive a payout of 36 times the amount of their bet. \n 5.  If the number the player bets on does not match the number the roulette wheel lands on, the player loses their bet amount. \n 6.  The game continues until the player decides to quit or runs out of coins." );

            //     3.  If the number the player bets on matches the number the roulette wheel lands on after spinning, the player wins. 
            //     4.  When a player wins, they receive a payout of 36 times the amount of their bet.
            //     5.  If the number the player bets on does not match the number the roulette wheel lands on, the player loses their bet amount.
            //     6.  The game continues until the player decides to quit or runs out of coins.
            }
        });
       

        logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String stringValue1 = String.valueOf(coins);
                stopMusic();
                RouletteGame1 l = new RouletteGame1(uname,stringValue1);
                l.setTitle("Roulette Game");
                l.setSize(600, 400); // Increased size of JFrame
                l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                l.setLocationRelativeTo(null);
                l.setVisible(true);

                dispose();
            }
        });

         button1.setBounds(700,250,50,40);
         button2.setBounds(750,250,50,40);
         button3.setBounds(800,250,50,40);
         button4.setBounds(850,250,50,40);
         button5.setBounds(900,250,50,40);
         button6.setBounds(950,250,50,40);
         button7.setBounds(1000,250,50,40);
         button8.setBounds(1050,250,50,40);
         button9.setBounds(1100,250,50,40);
         button10.setBounds(1150,250,50,40);
         button11.setBounds(1200,250,50,40);
         button12.setBounds(1250,250,50,40);
         button13.setBounds(700,290,50,40);
         button14.setBounds(750,290,50,40);
         button15.setBounds(800,290,50,40);
         button16.setBounds(850,290,50,40);
         button17.setBounds(900,290,50,40);
         button18.setBounds(950,290,50,40);
         button19.setBounds(1000,290,50,40);
         button20.setBounds(1050,290,50,40);
         button21.setBounds(1100,290,50,40);
         button22.setBounds(1150,290,50,40);
         button23.setBounds(1200,290,50,40);
         button24.setBounds(1250,290,50,40);
         button25.setBounds(700,330,50,40);
         button26.setBounds(750,330,50,40);
         button27.setBounds(800,330,50,40);
         button28.setBounds(850,330,50,40);
         button29.setBounds(900,330,50,40);
         button30.setBounds(950,330,50,40);
         button31.setBounds(1000,330,50,40);
         button32.setBounds(1050,330,50,40);
         button33.setBounds(1100,330,50,40);
         button34.setBounds(1150,330,50,40);
         button35.setBounds(1200,330,50,40);
         button36.setBounds(1250,330,50,40);

         button1.setForeground(Color.WHITE);
         button2.setForeground(Color.WHITE);
         button3.setForeground(Color.WHITE);
         button4.setForeground(Color.WHITE);
         button5.setForeground(Color.WHITE);
         button6.setForeground(Color.WHITE);
         button7.setForeground(Color.WHITE);
         button8.setForeground(Color.WHITE);
         button9.setForeground(Color.WHITE);
         button10.setForeground(Color.WHITE);
         button11.setForeground(Color.WHITE);
         button12.setForeground(Color.WHITE);
         button13.setForeground(Color.WHITE);
         button14.setForeground(Color.WHITE);
         button15.setForeground(Color.WHITE);
         button16.setForeground(Color.WHITE);
         button17.setForeground(Color.WHITE);
         button18.setForeground(Color.WHITE);
         button19.setForeground(Color.WHITE);
         button20.setForeground(Color.WHITE);
         button21.setForeground(Color.WHITE);
         button22.setForeground(Color.WHITE);
         button23.setForeground(Color.WHITE);
         button24.setForeground(Color.WHITE);
         button25.setForeground(Color.WHITE);
         button26.setForeground(Color.WHITE);
         button27.setForeground(Color.WHITE);
         button28.setForeground(Color.WHITE);
         button29.setForeground(Color.WHITE);
         button30.setForeground(Color.WHITE);
         button31.setForeground(Color.WHITE);
         button32.setForeground(Color.WHITE);
         button33.setForeground(Color.WHITE);
         button34.setForeground(Color.WHITE);
         button35.setForeground(Color.WHITE);
         button36.setForeground(Color.WHITE);

         button1.setBackground(Color.RED);
         button2.setBackground(Color.BLACK);
         button3.setBackground(Color.RED);
         button4.setBackground(Color.RED);
         button5.setBackground(Color.BLACK);
         button6.setBackground(Color.RED);
         button7.setBackground(Color.RED);
         button8.setBackground(Color.BLACK);
         button9.setBackground(Color.RED);
         button10.setBackground(Color.RED);
         button11.setBackground(Color.BLACK);
         button12.setBackground(Color.RED);
         button13.setBackground(Color.BLACK);
         button14.setBackground(Color.RED);
         button15.setBackground(Color.BLACK);
         button16.setBackground(Color.BLACK);
         button17.setBackground(Color.RED);
         button18.setBackground(Color.BLACK);
         button19.setBackground(Color.BLACK);
         button20.setBackground(Color.RED);
         button21.setBackground(Color.BLACK);
         button22.setBackground(Color.BLACK);
         button23.setBackground(Color.RED);
         button24.setBackground(Color.BLACK);
         button25.setBackground(Color.RED);
         button26.setBackground(Color.BLACK);
         button27.setBackground(Color.RED);
         button28.setBackground(Color.BLACK);
         button29.setBackground(Color.BLACK);
         button30.setBackground(Color.RED);
         button31.setBackground(Color.BLACK);
         button32.setBackground(Color.BLACK);
         button33.setBackground(Color.RED);
         button34.setBackground(Color.RED);
         button35.setBackground(Color.BLACK);
         button36.setBackground(Color.RED);
         
        add(button1);
        add(button2);
        add(button3);
        add(button4);
        add(button5);
        add(button6);
        add(button7);
        add(button8);
        add(button9);
        add(button10);
        add(button11);
        add(button12);
        add(button13);
        add(button14);
        add(button15);
        add(button16);
        add(button17);
        add(button17);
        add(button18);
        add(button19);
        add(button20);
        add(button21);
        add(button22);
        add(button23);
        add(button24);
        add(button25);        
        add(button26);
        add(button27);
        add(button28);
        add(button29);
        add(button30);
        add(button31);
        add(button32);
        add(button33);
        add(button34);
        add(button35);
        add(button36);
        button1.addActionListener(new MyActionListener2(3));
        button2.addActionListener(new MyActionListener2(6));
        button3.addActionListener(new MyActionListener2(9));
        button4.addActionListener(new MyActionListener2(12));
        button5.addActionListener(new MyActionListener2(15));
        button6.addActionListener(new MyActionListener2(18));
        button7.addActionListener(new MyActionListener2(21));
        button8.addActionListener(new MyActionListener2(24));
        button9.addActionListener(new MyActionListener2(27));
        button10.addActionListener(new MyActionListener2(30));
        button11.addActionListener(new MyActionListener2(33));
        button12.addActionListener(new MyActionListener2(36));
        button13.addActionListener(new MyActionListener2(2));
        button14.addActionListener(new MyActionListener2(5));
        button15.addActionListener(new MyActionListener2(8));
        button16.addActionListener(new MyActionListener2(11));
        button17.addActionListener(new MyActionListener2(14));
        button18.addActionListener(new MyActionListener2(17));
        button19.addActionListener(new MyActionListener2(20));
        button20.addActionListener(new MyActionListener2(23));
        button21.addActionListener(new MyActionListener2(26));
        button22.addActionListener(new MyActionListener2(29));
        button23.addActionListener(new MyActionListener2(32));
        button24.addActionListener(new MyActionListener2(35));
        button25.addActionListener(new MyActionListener2(1));
        button26.addActionListener(new MyActionListener2(4));
        button27.addActionListener(new MyActionListener2(7));
        button28.addActionListener(new MyActionListener2(10));
        button29.addActionListener(new MyActionListener2(13));
        button30.addActionListener(new MyActionListener2(16));
        button31.addActionListener(new MyActionListener2(19));
        button32.addActionListener(new MyActionListener2(22));
        button33.addActionListener(new MyActionListener2(25));
        button34.addActionListener(new MyActionListener2(28));
        button35.addActionListener(new MyActionListener2(31));
        button36.addActionListener(new MyActionListener2(34));


        JButton betSpin = new JButton("bet & spin");
        betSpin.setBounds(1000, 500, 120, 30);
        add(betSpin);

        // ActionListener for "bet & spin" button
        betSpin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                playGif();

                Random random = new Random();
                int spinTimes = random.nextInt(10) + 20; // Random number of spins between 20 and 30
                timer1.setInitialDelay(100);
                timer1.setDelay(100);
                timer1.setRepeats(true);
                timer1.start();
                betSpin.setEnabled(false);
        
                Timer stopTimer = new Timer(spinTimes * 100, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        timer1.stop();
                     if (storedValue != -1) {
                        
                    String stringValue1 = String.valueOf(storedValue);
                    


                    try {
                        
                        String JDBC_URL = "jdbc:mysql://localhost:3306/roulettegame";
                        String USERNAME = "root";
                        String PASSWORD = "**************";
                        
                        // Establish database connection
                        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
                            String sql = "SELECT * FROM users WHERE username = ?";
                            // Creating PreparedStatement
                            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                                // Setting parameters
                                statement.setString(1, uname);
    
                                // Executing the query
                                try (ResultSet resultSet = statement.executeQuery()) {
                                    // Check if username and password exist in the database
                                    if (resultSet.next()) { 
                                        

                                        int coins = resultSet.getInt("coins");
                                        rTabelCoins =String.valueOf(coins);
                                        // String stringValue1 = String.valueOf(coins);
                                        System.out.println("RTabelCoins: " + rTabelCoins);
                                        
                                    } 
                                }
                            }
                        }
                    } catch (SQLException sqlException) {
                        JOptionPane.showMessageDialog(null, "Database error: " + sqlException.getMessage());
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(null, "Unexpected error: " + exception.getMessage());
                    }
                    

int abc=Integer.parseInt(roulettegame);
int def=Integer.parseInt(stringValue1);
                    if (abc == def)
                     {
                        System.out.println(true);
                        int a=Integer.parseInt(rTabelCoins);

                        System.err.println("before"+a);
                        a=(a-50)+(50*36);
                        System.err.println("after"+a);
                       
                        newcoins1=String.valueOf(a);
                        // coins=newcoins1;
                        try {
                            String JDBC_URL = "jdbc:mysql://localhost:3306/roulettegame";
                            String USERNAME = "root";
                            String PASSWORD = "**************";
                            
                            // Establish database connection
                            try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
                                int newCoins = a; // Assuming adding 10 coins for each login
                                String updateSql = "UPDATE users SET coins = ? WHERE username = ?";
                                try (PreparedStatement updateStatement = connection.prepareStatement(updateSql)) {
                                    updateStatement.setInt(1, newCoins);
                                    updateStatement.setString(2, uname);
                                    updateStatement.executeUpdate();
                                }

                                label7.setText(String.valueOf(newCoins));
                                // dispose();
                            }
                        } catch (SQLException sqlException) {
                            JOptionPane.showMessageDialog(null, "Database error: " + sqlException.getMessage());
                        } catch (Exception exception) {
                            JOptionPane.showMessageDialog(null, "Unexpected error: " + exception.getMessage());
                        }
                        


                        
                        JOptionPane.showMessageDialog(null, "congratulations "+"\nYou Win 1800 Coins"+"\nYour Selected No: "+ storedValue +"\nThe No. appered in Whell:" +roulettegame+"\nBoth Numbers are matched");
                    } else {
                        int a=Integer.parseInt(rTabelCoins);
                        System.err.println("before"+a);
                        a=a-50;
                        System.err.println("after"+a);
                        // label7.setText(rTabelCoins);
                        newcoins1=String.valueOf(a);
                        try {
                            String JDBC_URL = "jdbc:mysql://localhost:3306/roulettegame";
                            String USERNAME = "root";
                            String PASSWORD = "**************";
                            
                            // Establish database connection
                            try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
                                int newCoins = a; // Assuming adding 10 coins for each login
                                String updateSql = "UPDATE users SET coins = ? WHERE username = ?";
                                try (PreparedStatement updateStatement = connection.prepareStatement(updateSql)) {
                                    updateStatement.setInt(1, newCoins);
                                    updateStatement.setString(2, uname);
                                    updateStatement.executeUpdate();
                                }
                                label7.setText(String.valueOf(newCoins));
                                // dispose();
                            }
                        } catch (SQLException sqlException) {
                            JOptionPane.showMessageDialog(null, "Database error: " + sqlException.getMessage());
                        } catch (Exception exception) {
                            JOptionPane.showMessageDialog(null, "Unexpected error: " + exception.getMessage());
                        }
                        JOptionPane.showMessageDialog(null, "Sorry "+"\nYou lose 50 Coins"+"\nYour Selected No: "+storedValue +"\nThe No. appered in Whell:" +roulettegame+"\nBoth Numbers are not matched");
                    }                        

                } else {
                    System.out.println("Please select a number first.");
                }
                        betSpin.setEnabled(true);
                    }
                });
                
                stopTimer.setRepeats(false);
                stopTimer.start();

                // JLabel label7 = new JLabel(rTabelCoins);
               
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
                ImageIcon backgroundImg = new ImageIcon("rbg.jpg");
                g2d.drawImage(backgroundImg.getImage(), 0, 0, getWidth(), getHeight(), this);
                setOpaque(false);
                g2d.dispose(); // Dispose of the Graphics2D object
            }
        };
        backgroundPanel.setBounds(0, 0, 1350, 750);
        add(backgroundPanel);

        playMusic();
        setVisible(true);
    }


}

class MyActionListener2 implements ActionListener {
    private int myParameter;

    public MyActionListener2(int parameter) {
        myParameter = parameter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        RTable rTable = (RTable) button.getTopLevelAncestor();
        rTable.storedValue = myParameter;
       
        System.out.println("Selected value: " + myParameter);
        
        rTable.label10.setText("Your Selected Number is:"+String.valueOf(rTable.storedValue));
        rTable.label10.setVisible(true);



    }
}
