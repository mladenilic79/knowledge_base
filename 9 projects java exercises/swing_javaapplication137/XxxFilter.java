
package swingRepository.javaapplication137;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

public class XxxFilter implements KeyListener {
    
    @Override
    public void keyTyped(KeyEvent e){}
    @Override
    public void keyPressed(KeyEvent e){}
    @Override
    public void keyReleased(KeyEvent e){
        
        JTextField tf = (JTextField)e.getSource();
        
        String currentText = tf.getText();
        
        if(currentText.toLowerCase().contains("xxx")){
            
            currentText = currentText.replaceAll("xxx|XXX", "");
            
            tf.setText(currentText);
        }
    }
}
