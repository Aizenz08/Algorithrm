/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectalgorithm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author DMX TAN AN
 */
enum SORTTYPE1{Ascending_Order, Decreasing_Order};
public class FrameThird extends JFrame{
    private static final long serialVersionUID = 1L;
    public static SORTTYPE1 SortType;
    numberPanel pnCenter = null;
    JTextField txtNumber = null;
    private int k = 0;
    private int time = 8;
    public FrameThird(){
        ThirdFrame();
    }
     public void ThirdFrame(){
        JFrame combo3 = new JFrame();
        Container con = getContentPane();
        con.setLayout(new BorderLayout());
        JPanel pnNorth=new JPanel();
	con.add(pnNorth,BorderLayout.NORTH);
	JPanel pnNothBorder=new JPanel();
	pnNothBorder.setLayout(new BoxLayout(pnNothBorder, BoxLayout.Y_AXIS));
        JPanel pnLine1 = new JPanel();
        pnLine1.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel lblNumber = new JLabel("Number of:");
        txtNumber = new JTextField(3);
        JButton insertButton = new JButton("Insert");
        pnLine1.add(lblNumber);
        pnLine1.add(txtNumber);
        pnLine1.add(insertButton);
        
        
        JPanel pnLine2 = new JPanel();
        pnLine2.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel lblSort = new JLabel("Sort in:");
        final JComboBox c2 = new JComboBox(new String[]{"Ascending Order", "Decreasing Order"});
        JButton startButton = new JButton("Start");
        pnLine2.add(lblSort);
        pnLine2.add(c2);
        pnLine2.add(startButton);
        
        JPanel pnLine3 = new JPanel();
        pnLine3.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel lblSpeed = new JLabel("Speed");
        JSlider slspd = new JSlider();
        slspd.setOrientation(SwingConstants.HORIZONTAL);
        slspd.setBounds(267, 21, 244, 50);
        slspd.setMaximum(8);
        slspd.setMinimum(1);
        slspd.setValue(5);
        pnLine3.add(lblSpeed);
        pnLine3.add(slspd);
        
        JButton pauseButton = new JButton("||");
        pauseButton.setBounds(52, 192, 120, 25);
        pnLine3.add(pauseButton);
        
        JPanel pnLine0 = new JPanel();
        pnLine0.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel lblName = new JLabel("Heap Sort");
        pnLine0.add(lblName);
        lblName.setFont(new Font(lblName.getFont().getName(), lblName.getFont().getStyle(), 30));
        lblName.setForeground(Color.WHITE);
        
        pnNothBorder.add(pnLine0);
        pnNothBorder.add(pnLine1);
        pnNothBorder.add(pnLine2);
        pnNothBorder.add(pnLine3);
        pnLine0.setBackground(Color.DARK_GRAY);
        pnLine1.setBackground(Color.LIGHT_GRAY);
        pnLine2.setBackground(Color.GRAY);
        pnLine3.setBackground(Color.WHITE);
        
        con.add(pnNothBorder, BorderLayout.NORTH);
        pnCenter = new numberPanel();
        con.add(pnCenter,BorderLayout.CENTER);
        
        combo3.add(con);
        combo3.setSize(1920,1080);
        combo3.setTitle("Insert Numbers");
        combo3.setVisible(true);
        combo3.setLocationRelativeTo(null);
        combo3.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawNumber();
                k++;
            }
        });
        
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n1 = c2.getSelectedIndex();
                switch(n1){
                    case 0:
                        SortType = SORTTYPE1.Ascending_Order;
                        break;
                    case 1:
                        SortType = SORTTYPE1.Decreasing_Order;
                        break;
                }
                panelRunnable2 run = new panelRunnable2(pnCenter);
                Thread th = new Thread(run);
                th.start();
            }
        });
        
        slspd.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                time = 18 - slspd.getValue() * 2;
                pnCenter.setTimer(time);
            }
        });
        
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnCenter.deleteArrays();
                
            }
        });
        
        txtNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt){
                    if(k == 15){
                            JOptionPane.showMessageDialog(rootPane, "Xin lỗi, Bạn đã nhập vượt quá số lần cho phép. Max array(15)");
                            txtNumber.setText("");
                    }
                
            }
            
        });
    }
    
    
    public void drawNumber(){
        int num = Integer.parseInt(txtNumber.getText());
        numberM.COLOR1=Color.CYAN;
	pnCenter.addNum2(num);
	pnCenter.repaint();
    }
    
}
