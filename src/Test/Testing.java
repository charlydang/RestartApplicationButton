package Test;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Container;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Testing {
	

	public static void main(String[] args) throws IOException{
		System.out.println("Charly Dang Test");
		JFrame frame = new JFrame();
		
		
		
        // Set's the window to be "always on top"
        frame.setAlwaysOnTop( true );
        frame.setUndecorated(true);
        frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        frame.setLocationByPlatform( true );
        JButton start=new JButton("Start");
        JButton quit=new JButton("Quit");
        JButton refresh=new JButton("Restart");
        JPanel contentPane = new JPanel();
        contentPane.add(start);// w w w .ja v a2s . co  m
        contentPane.add(refresh);
        contentPane.add(quit);
        
        start.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
					startHostessClient();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });
        
        quit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
					stopHostessClient();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });
        
        refresh.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
        			stopHostessClient();
					TimeUnit.SECONDS.sleep(1);
					
					startHostessClient();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		
        		
        	}
        });
        
        frame.add(contentPane);
        frame.pack();
        
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
        Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
        int x = (int) rect.getMaxX() - frame.getWidth();
        int y = (int) rect.getMaxY() - frame.getHeight();
        System.out.println(x+"  "+y);
        frame.setLocation(x/2, y);
        frame.setVisible(true);

        

	}
	
	

	public static void startHostessClient() throws IOException {
		try {
			Runtime.getRuntime().exec("cmd /c start C:\\CPB\\HostessClientWorkaround\\start.bat" );
			TimeUnit.SECONDS.sleep(1);
			 try {
		            Runtime.getRuntime().exec("taskkill /f /im cmd.exe") ;
		        } catch (Exception f) {
		            f.printStackTrace();  
		        }
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public static void stopHostessClient() throws IOException {
		try {
			Runtime.getRuntime().exec("cmd /c start C:\\CPB\\HostessClientWorkaround\\stop.bat");
			TimeUnit.SECONDS.sleep(1);
			try {
		            Runtime.getRuntime().exec("taskkill /f /im cmd.exe") ;
		        } catch (Exception g) {
		            g.printStackTrace();  
		        }
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public static void refreshHostessClient() throws IOException {
		Runtime.
		   getRuntime().
		   exec("cmd /c start C:\\CPB\\HostessClientWorkaround\\refresh.bat");
	}
	
}





