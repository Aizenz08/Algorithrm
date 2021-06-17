/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectalgorithm;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;


/**
 *
 * @author DMX TAN AN
 */
public class numberM {
    public static final int XSIZE = 50;
    public static final int YSIZE = 50;
    private double x = 0;
    private double y = 250;
    private int num = 0;
    private Graphics graph = null;
    private Ellipse2D es;
    
    public Ellipse2D getShape(){
        es = new Ellipse2D.Double(x, y, XSIZE, YSIZE);
        return es;  
    }
    public void setNumber(int num){
        this.num = num;
    }
    public int getNumber(){
        return this.num;
    }
    public void setGraph(Graphics graph){
        this.graph = graph;
    }
    public numberM(){
	this.num=0;
	this.graph=null;
    }
    public numberM(int num){
        this.num = num;
    }        
    public numberM(int num, Graphics graph){
        this.num = num;
        this.graph = graph;
    }
    public static Color COLOR1=Color.CYAN;
    public void draw(){
        if(graph != null){
            Graphics2D gs = (Graphics2D) graph;
            gs.setColor(Color.LIGHT_GRAY);
            gs.fill(getShape());
            Font fnt=new Font("arial", Font.ITALIC|Font.BOLD, 15);
            gs.setFont(fnt);
            gs.setColor(Color.BLACK);
            gs.drawString(num+"", (float)x+18, (float)(y+30));
        }
    }
    public void setX(double x){
	this.x = x;
    }
    public double getX(){
	return this.x;
    }
    public void setY(double y){
	this.y = y;
    }
    public double getY(){
      	return this.y;
    }
    public Ellipse2D getFace(){
	return es;
    }
    public Graphics getGraph(){
	return this.graph;
    }
	
    @Override
    public String toString() {
	// TODO Auto-generated method stub
	return this.num+"";
    }    
            
            
                   
}
