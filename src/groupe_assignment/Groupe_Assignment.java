/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package groupe_assignment;

/**
 *
 * @author Precious
 */
public class Groupe_Assignment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        WaitLine vLine = new WaitLine();
        vLine.simulate(120, 45,35);
        vLine.displayResults(120);
    }
    
}
