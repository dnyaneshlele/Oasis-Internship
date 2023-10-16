import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.script.*;

class calci extends JFrame implements ActionListener
{
	int Fr_width=400;
	int Fr_height=300;
	int Fr_x=170;
	int Fr_y=110;
JTextField t1;
boolean editable=true;
JPanel Panel1;
JPanel Panel2;

calci()
{
	Container cp=getContentPane();
	cp.setLayout(new FlowLayout());

	Panel1=new JPanel();
	Panel1.setLayout(new FlowLayout());

	Panel2=new JPanel();
		Panel2.setLayout(new GridLayout(5,4,5,6));


	String caption[]={"7","8","9","/","4","5","6","*","1","2","3","-","0",".","=","+"};
	t1=new JTextField();
	t1.setFont(new Font ("Times new Roman",Font.PLAIN,14));
	t1.setBackground(Color.white);
	t1.setBorder(BorderFactory.createLineBorder (Color.black));
	t1.setPreferredSize(new Dimension(90,110));
	t1.addActionListener(this);
	Panel1.add(t1);
	cp.add(Panel1);

	for(String c: caption)
	{
		JButton but=new JButton(c);
		but.addActionListener(this);
		Panel2.add(but);
	}

	cp.add(Panel2);
	setTitle("Calculator");
	setResizable(false);
	setSize(Fr_width,Fr_height);
	setLocation(Fr_x,Fr_y);
	setVisible(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
}



void Accept(String txt)
{
	if(editable)
	t1.setText(t1.getText()+txt);

	else
	{
		t1.setText(txt);
		editable=true;
	}
}

void display()
{
	double n=0.0d;
	try
	{
	ScriptEngineManager mgr =new 	ScriptEngineManager();
	ScriptEngine  eng= mgr.getEngineByName("JavaScript");
	t1.setText(eng.eval(t1.getText()).toString());
}


catch(ScriptException Se)
{
  t1.setText("Syntax Error");
}
editable=false;
}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() instanceof JButton)
		{
			JButton chk=(JButton)
			e.getSource();
			if(chk.getText()=="=")
			display();
			else
			Accept(chk.getText());
		}
		else
		display();
	}

	public static void main(String[] args)
	{
		new calci();
	}
}