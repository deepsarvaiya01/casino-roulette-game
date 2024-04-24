import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.*;

class SignUp extends JFrame{
    JTextField t1,t2;
    JButton b1;
    JLabel l1,l2,l3,l5,l6;

    SignUp(){
       
     setLayout(null);
     JPanel backgroundPanel = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();

            // Set the opacity (transparency) level
            float opacity = 0.75f; // Adjust this value (0.0f for fully transparent, 1.0f for fully opaque)

            // Create an AlphaComposite instance with the specified opacity
            AlphaComposite alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity);

            // Set the composite for the Graphics2D object
            g2d.setComposite(alphaComposite);

            // Draw the background image with the specified opacity
            ImageIcon backgroundImg = new ImageIcon("loginPageImage.jpg");
            g2d.drawImage(backgroundImg.getImage(), 0, 0, getWidth(), getHeight(), this);

            g2d.dispose(); // Dispose of the Graphics2D object
        }
    };
    backgroundPanel.setBounds(0, 0, 500, 250);
   

    //  ImageIcon img= new ImageIcon("login.jpg");
    //  l6=new JLabel("",img,JLabel.CENTER);
    //  l6.setBounds(0,0,500,300);
    //  add(l6);
    
    t1=new JTextField();
    t2=new JPasswordField();

    b1= new JButton("Submit");
    l2 = new JLabel("Username:");
    l2.setFont(new Font("Blackadder ITC",Font.BOLD,25));
    l2.setForeground(Color.orange);


    l3 = new JLabel("Password:");
    l3.setFont(new Font("Blackadder ITC",Font.BOLD,25));
    l3.setForeground(Color.orange);



    t1.setBounds(190,50,120,30);
    t2.setBounds(190,100,120,30);
    b1.setBounds(200,150,80,30);
    l2.setBounds(70,50,120,30);
    l3.setBounds(70,100,120,30);

    
    b1.addActionListener(new ActionListener(){

        public void actionPerformed(ActionEvent ae){
            try{
               String username = t1.getText();
               String password = t2.getText();
                    // String   sql = `INSERT INTO users (username, password) VALUES (${username}, ${password})`;

                    String JDBC_URL = "jdbc:mysql://localhost:3306/roulettegame";
                    String USERNAME = "root";
                    String PASSWORD = "***********";
                    Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
          
                       Statement statement = connection.createStatement();
                       String sql = "INSERT INTO users (username, password, coins) VALUES (?, ?, ?)";

                       // Creating PreparedStatement
                       PreparedStatement statement1 = connection.prepareStatement(sql);
           
                       // Setting parameters
                       statement1.setString(1, username);
                       statement1.setString(2, password);
                       statement1.setInt(3, 1000);
                       // Executing the query
                       int rowsInserted = statement1.executeUpdate();
                       if (rowsInserted > 0) {
                           System.out.println("A new user was inserted successfully!");
                           JOptionPane.showMessageDialog(null,"Registration Completed");
                     dispose();
                       }
                       // Closing resources
                       statement.close();
                       connection.close();
                statement.execute(sql);

            System.out.println(" created successfully.");
             
            // FileWriter fw=new FileWriter("login.txt",true);
            // fw.write(t1.getText()+" "+t2.getText()+"\n");
            // fw.close();
            // JFrame f=new JFrame();
            
            // JOptionPane.showMessageDialog(f,"Registration Completed");
            // dispose();

            }
            catch(Exception e){}
    }});

    add(t1);
    add(t2);
    add(b1);
    add(l3);
    add(l2); 
    add(backgroundPanel);
    }
}

class Login extends JFrame{

    JTextField t1,t2;
    JButton b1,b2,b3;
    JLabel l1,l2,l3,l4,l5,l6;  
    
    Login(){

        String JDBC_URL = "jdbc:mysql://localhost:3306/roulettegame";
        String USERNAME = "root";
        String PASSWORD = "***********";
       try (
           // Establishing a connection to the database
           Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
           // Creating a statement object
          final Statement statement = connection.createStatement();
       ) {
           // Execute the SQL query to create the table
           // String sql="done";
           // statement.execute(sql);
           System.out.println(" connected");
       } catch (SQLException e) {
           e.printStackTrace();
       }


        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    

        l2= new JLabel();
        l2.setBounds(250,80,100,30);
        add(l2);

        

        t1 = new JTextField(60);
        t2 = new JPasswordField(60);
        b1 = new JButton("Sign In");
        b2 = new JButton("Sign up");
        l3 = new JLabel("Username:");
        l3.setForeground(Color.black);
        l3.setFont(new Font("Blackadder ITC",Font.BOLD,25));
        l3.setForeground(Color.orange);
        l4 = new JLabel("Password:");
        l4.setFont(new Font("Blackadder ITC",Font.BOLD,25));
        l4.setForeground(Color.orange);
        t1.setBounds(155,50,120,30);
        t2.setBounds(155,100,120,30);
        b1.setBounds(100,160,80,30);
        b2.setBounds(210,160,80,30);
        l3.setBounds(40,50,120,30);
        l4.setBounds(40,100,120,30);


        add(t1);
        add(t2);
        add(b1);
        add(b2);
        add(l3);
        add(l4);

        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try {
                    String uname = t1.getText().trim(); // Trim to remove leading and trailing whitespace
                    String pwd = t2.getText().trim();
                    
                    String JDBC_URL = "jdbc:mysql://localhost:3306/roulettegame";
                    String USERNAME = "root";
                    String PASSWORD = "***********";
                    
                    // Establish database connection
                    try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
                        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
                        // Creating PreparedStatement
                        try (PreparedStatement statement = connection.prepareStatement(sql)) {
                            // Setting parameters
                            statement.setString(1, uname);
                            statement.setString(2, pwd);

                            // Executing the query
                            try (ResultSet resultSet = statement.executeQuery()) {
                                // Check if username and password exist in the database
                                if (resultSet.next()) { 
                                    
                                    int coins = resultSet.getInt("coins");
                                    String stringValue1 = String.valueOf(coins);
                                    System.out.println("Coins: " + coins);
                                    JOptionPane.showMessageDialog(null, "Login Successful");
                                    RouletteGame1 l = new RouletteGame1(uname,stringValue1);
                                    l.setTitle("Roulette Game");
                                    l.setSize(600, 400); // Increased size of JFrame
                                    l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                    l.setLocationRelativeTo(null);
                                    l.setVisible(true);
                                    dispose(); // Close the current JFrame
                                } else {
                                    
                                    // Username or password is incorrect
                                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                                }
                            }
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Unexpected error: " + e.getMessage());
                }
             }
        });
            b2.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                        SignUp s = new SignUp();
                        s.setVisible(true);
                        s.setBounds(getBounds());
                }
            });
        
            JPanel backgroundPanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Graphics2D g2d = (Graphics2D) g.create();
    
                    // Set the opacity (transparency) level
                    float opacity = 0.7f; // Adjust this value (0.0f for fully transparent, 1.0f for fully opaque)
    
                    // Create an AlphaComposite instance with the specified opacity
                    AlphaComposite alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity);
    
                    // Set the composite for the Graphics2D object
                    g2d.setComposite(alphaComposite);
    
                    // Draw the background image with the specified opacity
                    ImageIcon backgroundImg = new ImageIcon("loginPageImage1.jpg");
                    g2d.drawImage(backgroundImg.getImage(), 0, 0, getWidth(), getHeight(), this);
    
                    g2d.dispose(); // Dispose of the Graphics2D object
                }
            };
            backgroundPanel.setBounds(0, 0, 500, 250);
            add(backgroundPanel);
    }
}
class LoginDemo{
    public static void main(String[] args){

        Login l = new Login();
        l.setTitle("Roulette Game(Login Page)");
        l.setBounds(400,200,500,250);
        l.setVisible(true);
    }
}