/**
 * This class is our entry point for the program. Purposefully named "main" so new eyes
 * may easily find the main method's location and what it calls.
 
 */

package s4927945;

import javax.swing.SwingUtilities;

public class Main
{

  
    // ---------------------------------------------------------------------------------
    /**
     * Provides an entry point to our program (in a thread-safe manner?)
     *
     * @param args String array of arguments?
     */
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new Menus();
            }
        });
    }
}
