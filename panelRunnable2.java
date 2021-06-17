/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectalgorithm;

/**
 *
 * @author DMX TAN AN
 */
public class panelRunnable2 implements Runnable{
    private numberPanel nbPanel=null;
    public panelRunnable2(numberPanel pn)
	{
		this.nbPanel = pn;
		
	}
    @Override
    public void run() {
                try {
			while(!Thread.currentThread().isInterrupted())
				{
					switch(FrameThird.SortType){
                                            case Ascending_Order:
                                                nbPanel.HeapSortWithIncrease();
                                                break;
                                            case Decreasing_Order:
                                                nbPanel.HeapSortWithDecrease();
                                                break;
                                        }
					Thread.sleep(1000);
                                        break;
					
				}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    }
    
}
