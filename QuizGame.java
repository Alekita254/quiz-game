// this is a simple game to just check how one knows me

import java.awt.*;
import static java.awt.Font.BOLD;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;


public class QuizGame {
    
    public static void main(String args[]) {
    Quiz q = new Quiz();    // TODO code application logic here
    }
}
class Quiz implements ActionListener {
    
    Question question = new Question();
    JLabel label;
    JRadioButton rb1,rb2, rb3,rb4;
    int count = 0,q;
    private int right = 0, wrong = 0;
    String selected = "";
    
    Quiz () {
        JFrame frame = new JFrame( "How Do You Know Me!!");
        frame.setSize(500,500);
        frame.setLocation(200, 100);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c=frame.getContentPane();
        c.setBackground(Color.CYAN);
        frame.setResizable(false);

        Font font = new Font("",BOLD,17);
        Font font1 = new Font("",BOLD,20);


        label = new JLabel();
        label.setForeground(Color.BLUE);
        label.setFont(font1);
        label.setBounds(100,10,300,50);
        frame.add(label);

        rb1 = new JRadioButton();
        rb1.setBounds(100,50,200,50);
        frame.add(rb1);

        rb2 = new JRadioButton();
        rb2.setBounds(100,110,200,50);
        frame.add(rb2);

        rb3 = new JRadioButton();
        rb3.setBounds(100, 170, 200, 50);
        frame.add(rb3);

        rb4 = new JRadioButton();
        rb4.setBounds(100, 230, 200, 50);
        frame.add(rb4);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
        bg.add(rb3);
        bg.add(rb4);

        JButton next = new JButton("NEXT");
        next.setBounds(100, 300, 100, 50);
        frame.add(next);
        frame.setVisible(true);

        JButton check =  new JButton("CHECK");
        check.setBounds(300,300,100,50);
        frame.add(check);
        frame.setVisible(true);

        rb1.setFont(font);
        rb2.setFont(font);
        rb3.setFont(font);
        rb3.setFont(font);

        rb1.setForeground(Color.ORANGE);
        rb2.setForeground(Color.RED);
        rb3.setForeground(Color.black);
        rb4.setForeground(Color.lightGray);

        rb1.setBackground(Color.CYAN);
        rb2.setBackground(Color.CYAN);
        rb3.setBackground(Color.CYAN);
        rb4.setBackground(Color.CYAN);


        next.addActionListener(this);
        check.addActionListener(this);

        Random r = new Random();
        q = r.nextInt(4);

        label.setText(question.getQuestion()[q]);
        rb1.setText(question.getAnswer1(q));
        rb2.setText(question.getAnswer2(q));
        rb3.setText(question.getAnswer3(q));
        rb4.setText(question.getAnswer4(q));
    }

    @Override
    public void actionPerformed(ActionEvent ie){
        count++;

        if (ie.getActionCommand().equals("NEXT")){
            Random r = new Random();
            q = r.nextInt(4);

            label.setText(question.getQuestion()[q]);
            rb1.setText(question.getAnswer1(q));
            rb2.setText(question.getAnswer2(q));
            rb3.setText(question.getAnswer3(q));
            rb4.setText(question.getAnswer4(q));

        }
        if(ie.getActionCommand().equals("CHECK")){
            String ans = question.getRightAns()[q];

            if(rb1.isSelected()){
                selected = rb1.getText();
                rb1.setSelected(false);
            }
            else if(rb2.isSelected()){
                selected = rb2.getText();
                rb2.setSelected(false);
            }
            else if(rb3.isSelected()){
                selected = rb3.getText();
                rb3.setSelected(false);
            }
            else if(rb4.isSelected()){
                selected = rb4.getText();
                rb4.setSelected(false);
            }

            if(selected.equals(ans)){
                JOptionPane.showMessageDialog(null,"Right Answer Seems you know me");
            }
            else {
                JOptionPane.showMessageDialog(null, "OOPS!! Wrong Answer");

            }
        }
    }

}
class Question{
    private String question []
    = { "What is my name ?",
        "What im good at?",
        "Which month was i born?",
        "which course do i take?",
        "Whats your role then ?"

    };
    private String rightAns [] 
    = {"Alex Murimi",
        "Software Development",
        "march",
        "computer science",
        "Guest"};
    private String answer[][] = { {"Alem Kariuki","Alex Murimi","Alex Kariuki","Alem"},
        {"gaming", "Software Development","Joking","nothing"},
        {"march","january","july","december"},
        { "Education","music","arts","computer science"},
        {"Guest","Helper","user","no role"}};

        public String [] getRightAns(){
            return rightAns;
        }

        public void setRightAns(String[] rightAns){
            this.rightAns = rightAns;
        }

        public String[] getQuestion(){
            return question;
        }

        public void setQuestion(String[] question){
            this.question = question;
        }

        public String getAnswer1(int a){
            String answer1 = answer[a][0];
            return answer1;
        }


        public String getAnswer2(int a){
            String answer2 = answer[a][1];
            return answer2;
        }

        public String getAnswer3(int a){
            String answer3 = answer[a][2];
            return answer3;
        }

        public String getAnswer4 (int a){
        
            String answer4 = answer[a][3];
            return answer4;
            
        }

        public void setAnswer(String[][] answer){
            this.answer = answer;
        }
}