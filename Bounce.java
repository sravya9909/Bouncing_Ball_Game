import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
public class Bounce extends Applet implements Runnable
 {
	int x = 1;
	int y = 1;
	Thread t;
	boolean bouncing;
	boolean testOutput = true;
	Button b1 = new Button("Start");
	Button b2 = new Button("Stop");
	public void init()
	 {
		b1.addActionListener(new B1());
		b2.addActionListener(new B2());
		add(b1);
		add(b2);
		r = new Rectangle(30,50,20,20);
		t = new Thread(this);
		t.start();
		bouncing = true;
	}
public void paint(Graphics g)
 {
	if (bouncing) 
		g.setColor(Color.blue);
	else 
		g.setColor(Color.blue);
		g.fillOval(r.x,r.y,r.width,r.height);
	if (testOutput)
		System.out.println ("x = " + r.x + " y = " + r.y + " bouncing = " + bouncing);
}
class B1 implements ActionListener
 {
	public void actionPerformed(ActionEvent e)
	 {
		t.resume();
		bouncing = true;
		getAppletContext().showStatus("Left Clicked");//start
	}
}
class B2 implements ActionListener
 {
	public void actionPerformed(ActionEvent e)
	 {
		if (!bouncing)
		System.exit(1);
		t.suspend();
		bouncing = false;
		x *= -1;
		getAppletContext().showStatus("Right Clicked");//stop
	}
}
public void update(Graphics g) 
{
	Image offScreenImage = createImage(getSize().width, getSize().height);
	paint(offScreenImage.getGraphics());
	g.drawImage(offScreenImage,0,0, null);
}
public void run() 
{
	while (true)
	 { 
		// Thread performs endless loop
		r.x += x;
		r.y += y;
		if (r.x>= getSize().width || r.x < 0)
		 {
			x *= -1;
		}
		if (r.y>= getSize().height || r.y < 50)//ball bounces until the coordinate of y reaches 50 and again starts bouncing from beginning---it can be of any value
 		{ 
			
			y *= -1;
		}
		repaint();
		try
		 {
			Thread.currentThread().sleep(2);
		}
		catch (Exception e)
 		{
		}
	}
}
private Rectangle r;
public boolean mouseDown(Event e)
 {
	return true;
}
public boolean mouseUp(Event e)
 {
	return true;
}
}
/*<applet code="Bounce" width="300" height="300">
</applet>*/