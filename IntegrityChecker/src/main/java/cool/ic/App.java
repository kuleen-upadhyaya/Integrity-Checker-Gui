package cool.ic;

import javax.swing.SwingUtilities;

import cool.ic.ui.IntegrityCheckerWindow;

public class App 
{
    public static void main( String[] args )
    {
    	SwingUtilities.invokeLater(new Runnable ()
    	{
			public void run() 
			{
		        IntegrityCheckerWindow.start();
			}
    	});
    }
}
