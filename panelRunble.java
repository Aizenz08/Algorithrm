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

public class panelRunble implements Runnable {

	private numberPanel nbPanel=null;
	public panelRunble(numberPanel pn)
	{
		this.nbPanel = pn;
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(!Thread.currentThread().isInterrupted())
				{
					switch(FrameSecond.SortType){
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
		}
	}

}

