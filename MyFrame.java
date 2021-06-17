/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectalgorithm;



import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



/**
 *
 * @author DMX TAN AN
 */
public class MyFrame extends JFrame{
    private static final long serialVersionUID = 1L;
    public MyFrame(){
        firstFrame();
        
    }
    public void firstFrame(){
        JPanel p = new JPanel(new GridBagLayout());
        JLabel labelName = new JLabel("Which one do you want?");
        JButton okButton = new JButton("OK");
        JFrame combo1 = new JFrame();
        JComboBox c1 = new JComboBox(new String []{"Random Numbers", "Insert Numbers"});
        GridBagConstraints constr = new GridBagConstraints();
        constr.anchor = GridBagConstraints.WEST;
        constr.insets = new Insets(10,10,10,10);
        constr.gridx = 0;
        constr.gridy = 0;
        p.add(labelName, constr);
        constr.gridx = 1;
        p.add(c1, constr);
        constr.gridx = 2;
        constr.gridy = 0;
        constr.gridwidth = 2;
        constr.anchor = GridBagConstraints.CENTER;
        p.add(okButton, constr);
        p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Choice!"));
        combo1.add(p);
        combo1.pack();
        combo1.setVisible(true);
        combo1.setLocationRelativeTo(null);
        combo1.setDefaultCloseOperation(EXIT_ON_CLOSE);
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n = c1.getSelectedIndex();
                switch(n){
                    case 0:
                        FrameSecond unt1 = new FrameSecond();
                        break;
                    case 1:
                        FrameThird unt2 = new FrameThird();
                        break;
                }
            }
        });
    }
   
}
