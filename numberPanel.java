package projectalgorithm;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.JSlider;


public class numberPanel extends JPanel implements MouseListener{
    private static final long serialVersionUID = 1L;
    private int time = 8;
    private boolean isIncrease = true;
    
    public int Timer(){
        return time;
    }
    
    public void setTimer(int time){
        this.time = time;
    }
    
    ArrayList<numberM> arr = new ArrayList<numberM>();
    public void addNumber(numberM number){
        arr.add(number);
    }
    public void deleteArrays(){
        arr.clear();
        f = -1;
    }
    public void addNum(int num){
        arr.clear();
        Random ran = new Random();
        for(int i = 0; i < num; i++){
            numberM number = new numberM(ran.nextInt(100), getGraphics());
            number.setX(i*numberM.YSIZE);
            number.setY(getBounds().getHeight()/numberM.YSIZE);
            addNumber(number);
        }
    }
    private int f = -1;
    public void addNum2(int num2){
        numberM number = new numberM(num2, getGraphics());
        addNumber(number);
        f++;
        number.setX(f*numberM.YSIZE);
        number.setY(getBounds().getHeight()/numberM.YSIZE);
    }
    public numberPanel(){
        arr = new ArrayList<numberM>();
        addMouseListener(this);
        
    }
    
    @Override
    protected void paintComponent(Graphics arg0){
        super.paintComponent(arg0);
        Graphics2D g2 = (Graphics2D) arg0;
        for(int i = 0; i < arr.size(); i++){
            numberM number = arr.get(i);
            number.setGraph(arg0);
            number.draw();
        }
    }
    public void printInfor()
	{
		for(numberM number:arr)
		{
			System.out.println(number.getNumber() +"(x:"+number.getX() +",y:"+number.getY()+")");
		}
	}

    public synchronized void moveLocation(numberM nb1, int x, int y){
        printInfor();
        double x1 = nb1.getX();
        double y1 = nb1.getY();
        try{
            if(x1 < x && y1 < y){
                    int k = 0;
                    while(nb1.getY() < y){
                        k++;
                        nb1.setY(y1 + k);
                        Thread.sleep(time);
                        repaint();
                    }
              
                    k = 0;
                    while(nb1.getX() < x){
                        k++;
                        nb1.setX(x1 + k);
                        Thread.sleep(time);
                        repaint();
                    }
         
            }else if(x1 >= x && y1 < y){
                    int i = 0;
                    while(nb1.getY() < y){
                        i++;
                        nb1.setY(y1 + i);
                        Thread.sleep(time);
                        repaint();
                    }
                    i =0;
                    while(nb1.getX() > x){
                        i++;
                        nb1.setX(x1 - i);
                        Thread.sleep(time);
                        repaint();
                    }
            }else if(x1 < x && y1 >= y){
                    int j = 0;
                    while(nb1.getY() > y){
                        j++;
                        nb1.setY(y1 - j);
                        Thread.sleep(time);
                        repaint();
                    }
                    j = 0;
                    while(nb1.getX() < x){
                        j++;
                        nb1.setX(x1 + j);
                        Thread.sleep(time);
                        repaint();
                    }
            }else if(x1 >= x && y1 >= y){
                    int m = 0;
                    while(nb1.getY() > y){
                        m++;
                        nb1.setY(y1 - m);
                        Thread.sleep(time);
                        repaint();
                    }
                    m = 0;
                    while(nb1.getX() > x){
                        m++;
                        nb1.setX(x1 - m);
                        Thread.sleep(time);
                        repaint();
                    }
            }
        }catch(InterruptedException e){
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
    
    public void heapLocationInit(){
        
        int i, j = 0;
        int row = 1;
        int maxirow = 0;
        int n = arr.size();
        int [] xi = {700, 430, 970, 295, 565, 835, 1105, 195, 395, 465, 665, 735, 935, 1005, 1205}; 
        int [] yi = {70,200, 300, 500};
       
            numberM number1 = arr.get(0);
            moveLocation(number1, xi[0], yi[0]);
            for (i = 0; i <= (n - 1) / 2; i ++) {
                if (i > maxirow) {
                    row ++;
                    maxirow = maxirow * 2 + 2;
                }
                j = i * 2 + 1;
                while (j <= i * 2 + 2 && j < n) {
                    if (j == i * 2 + 1) {
                        numberM number2 = arr.get(j);
                        moveLocation(number2, xi[j], yi[row]);   
                    } else {
                        numberM number3 = arr.get(j);
                        moveLocation(number3, xi[j], yi[row]);
                    }
                    j++;
                }
            }
            printInfor();
            System.out.println("----------");
            repaint();
        
        
    }
    
    public synchronized void swapInHeap(numberM number1, numberM number2){
        double x1 = number1.getX();
        double y1 = number1.getY();
        double x2 = number2.getX();
        double y2 = number2.getY();
        
        try{
            int k = 0;
            
            while(number2.getY() > y1){
                
                    k++;
                    number1.setY(y1 + k);
                    number2.setY(y2 - k);
                    Thread.sleep(time);
                    repaint();
                
            }
            k = 0;
            while(number1.getY() < y2){
                k++;
                number1.setY(y1 - k);
                number2.setY(y2 + k);
            }
            if(x2 < x1){
                k = 0;
                while(number2.getX() < x1){
                    k++;
                    number1.setX(x1 - k);
                    number2.setX(x2 + k);
                    Thread.sleep(time);
                    repaint();
                }
            }else{
                k = 0;
                while(number2.getX() > x1){
                    k++;
                    number1.setX(x1 + k);
                    number2.setX(x2 - k);
                    Thread.sleep(time);
                    repaint();
                }
            }
            
        }catch(InterruptedException e){
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
    
    public void swapHeapEnd(numberM nb1, numberM nb2, int xend){
        moveLocation(nb1, xend, 600);
        moveLocation(nb2, 700, 70);
    }
    
    
    
    public void Shift(int l, int r){
        int i, j;
        i = l;
        j = 2 * i + 1;
        numberM nb1 = arr.get(i);
        if(isIncrease){
            while(j <= r){
                
                if(j < r){
                    numberM n2 = arr.get(j + 1);
                    numberM n2b = arr.get(j);
                    if(n2b.getNumber() < n2.getNumber()){
                        j++;
                        
                    }
                }
                
                numberM n2c = arr.get(j);
                if(n2c.getNumber() <= nb1.getNumber()){
                    return;
                }
                else{
                    numberM nb2 = arr.get(i);
                    numberM nb3 = arr.get(j);
                    swapInHeap(nb2, nb3);
                    numberM nt1 = nb1;
                    nb1 = n2c;
                    n2c = nt1;
                    arr.set(i, nb1);
                    arr.set(j, n2c);
                    i = j;
                    j = i * 2 + 1;
                    nb1 = arr.get(i);
                    arr.set(i, nb1);
                    
                }
            }
        }else{
            while(j <= r){
                
                if(j < r){
                    numberM n2 = arr.get(j + 1);
                    numberM n2b = arr.get(j);
                    if(n2b.getNumber() > n2.getNumber()){
                        j++;
                        
                    }
                }
                
                numberM n2c = arr.get(j);
                if(n2c.getNumber() >= nb1.getNumber()){
                    return;
                }
                else{
                    numberM nb2 = arr.get(i);
                    numberM nb3 = arr.get(j);
                    swapInHeap(nb2, nb3);
                    numberM nt1 = nb1;
                    nb1 = n2c;
                    n2c = nt1;
                    arr.set(i, nb1);
                    arr.set(j, n2c);
                    i = j;
                    j = i * 2 + 1;
                    nb1 = arr.get(i);
                    
                }
            }
        }
    }
    
    public void createHeap(){
        int l;
        int n = arr.size();
        l = n / 2 - 1;
        while(l >= 0){
            Shift(l, n - 1);
            l--;
        }
    }
    
    public synchronized void HeapSortWithIncrease(){
        try{
            int r;
            int num = arr.size();
            int xend = ((int) ((18 - num) * 0.5) * 70) + 100 + (num - 1) * 70;
            heapLocationInit();
            createHeap();
            r = num - 1;
            while(r > 0){
                numberM nb1 = arr.get(0);
                numberM nb2 = arr.get(r);
                swapHeapEnd(nb1, nb2, xend);
                numberM tmp = nb1;
                nb1 = nb2;
                nb2 = tmp;
                
                arr.set(0, nb1);
                arr.set(r, nb2);
                xend -= 70;
                r--;
                if( r > 0){
                    Shift(0, r);
                }
            }
            numberM nb1 = arr.get(0);
            swapHeapEnd(nb1, null, xend);
            repaint();
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
     public synchronized void HeapSortWithDecrease(){
        try{
            isIncrease = false;
            int r;
            int num = arr.size();
            int xend = ((int) ((18 - num) * 0.5) * 70) + 100 + (num - 1) * 70;
            heapLocationInit();
            createHeap();
            r = num - 1;
            while(r > 0){
                numberM nb1 = arr.get(0);
                numberM nb2 = arr.get(r);
                swapHeapEnd(nb1, nb2, xend);
                numberM tmp = nb1;
                nb1 = nb2;
                nb2 = tmp;
                
                arr.set(0, nb1);
                arr.set(r, nb2);
                xend -= 70;
                r--;
                if( r > 0){
                    Shift(0, r);
                }
            }
            numberM nb1 = arr.get(0);
            swapHeapEnd(nb1, null, xend);
            repaint();
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        for(numberM number : arr){
            boolean b= number.getFace().contains(e.getPoint().getX(), e.getPoint().getY());
			if(b==true)
				{
					System.out.println(b+" - " + number);
					Graphics2D g=(Graphics2D)number.getGraph();
					g.setColor(Color.YELLOW);
					g.fill(number.getFace());
					this.repaint(number.getFace().getBounds());
				}
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}