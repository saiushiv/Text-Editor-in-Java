import java.io.*;
import java.awt.*;
import java.awt.event.*;

class editor extends WindowAdapter implements ActionListener,TextListener
{
int i=0,j,k,x,ab=0;
Frame f;
Dialog f1,f2;
MenuBar mb;
Menu m1,m2;
MenuItem nw,opn,sv,svs,ext,fnd,fndrplc;
TextArea t;
TextField t1,t2,t3,t4;
Button b1,b2,b3,b4,b5,b6,b7,b8;
String s1,s2,string="",s3,s4,s5;
Label l1,l2,l3,l11;;
Panel p1,p2,p3,p4;
boolean bol=false,bol1=false;
FileInputStream fin;
FileOutputStream fon;    	    
FileDialog fd=new FileDialog(f,"openfile",FileDialog.LOAD);
FileDialog fd1=new FileDialog(f,"Savefile",FileDialog.SAVE);	
int h=0;
	char arr1[],a[];


public editor()
   
   {
	
	
	f=new Frame();
	
	f.setSize(400,300); 
	
    t=new TextArea();
   t1=new TextField();
   
	
	
	
	mb=new MenuBar();
	m1=new Menu("File");
	m2=new Menu("Tools");
	
	
	nw=new MenuItem("New");	
    opn=new MenuItem("Open");		
	sv=new MenuItem("Save");		
	svs=new MenuItem("Save As");	
	ext=new MenuItem("Exit");	
	fnd=new MenuItem("Find");	
	fndrplc=new MenuItem("Find & Replace");		
	
	
	t.addTextListener(this);
		
	nw.addActionListener(this);	
	opn.addActionListener(this);	
	sv.addActionListener(this);	
	svs.addActionListener(this);	
	ext.addActionListener(this);
	fnd.addActionListener(this);					
	fndrplc.addActionListener(this);
	
	
					
						
	m1.add(nw);
	m1.add(opn);	
	m1.add(sv);
	m1.add(svs);
	m1.addSeparator();
	m1.add(ext);
	m2.add(fnd);	
	m2.add(fndrplc);
	mb.add(m1);
	mb.add(m2);	
     f2=new Dialog(f,"Editor",false);
    f2.setSize(400,100);
    f2.setLayout(new FlowLayout());
	l11=new Label("the text in Editor has changed. Do u want to save the changes?");
	b6=new Button("yes");
    b7=new Button("no");
    b8=new Button("cancel");
    b6.addActionListener(this);    
    b7.addActionListener(this);
    b8.addActionListener(this);
	f2.add(l11);	
    f2.add(b6);
    f2.add(b7);
    f2.add(b8);
	
		
	 f.setMenuBar(mb);
	 f.add(t);
	 
	 
	 f.setVisible(true);
	
	f.addWindowListener(this);
	
	
}

public void actionPerformed(ActionEvent e){
	
	String str=e.getActionCommand();
	int ch; String s=""; String scp="";
	
try{
	
	
	    if(str.equals("New"))
	    {
	    	    if(bol1);
	    	    else
	    	    f2.setVisible(true);
	           //t.setText(null);
	         bol=false;
	    }
	    
	    
	    if(str.equals("Open"))
        {
               
               fd.setVisible(true);
               s1=fd.getDirectory()+fd.getFile();
               t1.setText(s1);
     
               fin=new FileInputStream(s1);  
   
    	       while((ch=fin.read())!=-1)  
               {         	
         	        s=s+((char)ch+"");    	
                    
               } 
               	
     	            t.setText(s);
     	            fin.close();
     	       	bol=true;   
     	       		
     	           
     
        }
        
        if(str.equals("Save"))
        {
              	
        	
        		if(fd1.getFile()!=null || bol)
   					{}	
   				    else
   					{
   						fd1.setVisible(true);
   						s1=fd1.getDirectory()+fd1.getFile();
   					    bol=true;
   					    
   						
        	        
   					}
   				 
             	
             t1.setText(s1);        	
             fon=new FileOutputStream(t1.getText());
             char arr[]=new char[5000];
     	     s2=t.getText(); 
     	     arr=s2.toCharArray(); 
             for(int i=0;i<arr.length;i++)
             {	
                 fon.write(arr[i]);
             }	   
           	    	
                  bol1=true;
        	
              	   
           	       fon.close();		
        }
        
        
         if(str.equals("Save As")||str.equals("yes"))
         {
         	 
         	if(str.equals("Save As"))
         	bol1=true;
         	else
         	{
         	
            bol1=false;
            t.setText(null);
            }
         	 
             fd1.setVisible(true);
             s1=fd1.getDirectory()+fd1.getFile();
             t1.setText(s1);
       	    
        	
             fon=new FileOutputStream(t1.getText());
             char arr[]=new char[5000];
     	     s2=t.getText(); 
     	     arr=s2.toCharArray(); 
             for(int i=0;i<arr.length;i++)
             {	
                 fon.write(arr[i]);
             }	   
           	     fon.close();
                 
                 f2.setVisible(false);
        }
        
        
        
        
        if(str.equals("Exit"))
        {
            f.setVisible(false);
            f.dispose();
            System.exit(1);
        } 
       	
       	
       	if(str.equals("Find"))
       	{
	
    
                                f1=new Dialog(f,"FIND",false);
    							f1.setSize(200,200);
    							f1.setLayout(new FlowLayout());
    							l1=new Label("Find :  ");
    							f1.add(l1);
    							t2=new TextField(20);
    							f1.add(t2);
    							b1=new Button("FIND");
    							b2=new Button("CANCEL");
    							f1.add(b1);
    							f1.add(b2);
    							b1.addActionListener(this);
    							b2.addActionListener(this);
    							f1.setVisible(true);
    							f1.addWindowListener(this);
    							i=0;	
       	}
       	
       	
       	
       	
       	if(str.equals("Find & Replace"))
       	{
       		                        f1=new Dialog(f,"FIND & REPLACE",false);
    								f1.setSize(200,300);
    								f1.setLayout(new FlowLayout());
    								l1=new Label("Find :  ");
    								
    								l3=new Label("Replace with??  :  "); 
    								t2=new TextField(20);  
    								t3=new TextField(20);
    								b1=new Button("NEXT");
    								b2=new Button("CANCEL");
    								b3=new Button("REPLACE");    									
    								f1.add(l1); 								
    								f1.add(t2);
    								f1.add(l3);	
    								f1.add(t3);
    								f1.add(b1);
    								f1.add(b3);
    								f1.add(b2);   								
    								b1.addActionListener(this);
    								b3.addActionListener(this);
    								b2.addActionListener(this);    							
    								f1.setVisible(true);
    								f1.addWindowListener(this);
    							i=1;
       	}
       	
       	
       	
       	             if(str.equals("FIND"))
    								{
    								  
    									s3=t2.getText();
    									
    									s4=t.getText();
    									arr1=s3.toCharArray();
    									a=s4.toCharArray();
    									s4 = s4.replace("\n", "");
    									s4=s4.replace(" ","");
    									ab=s4.indexOf(s3,h);
    									h=ab+arr1.length;
    									t.select(ab,h);
    									f.toFront();							
    								}
    								
    								
    								
    								if(s.equals("REPLACE"))
    								{
    									
    									
    									if(count1==0)
    									{
    									
    									String s1=t2.getText();
    									String s2=t.getText();
    									String s3=t1.getText();
    									if(s3==null)
    										t1.setText("Give the keyword to search???");   					
    									if(s1==null)
    										t2.setText("Give the keyword to replace???");
    									else
    									{
    										k=t.getSelectionStart();
    										x=t.getSelectionEnd();
    										int q=0;
    										for(int x=0;x<i;x++)
    									{
    										if(s2.charAt(x)=='\r')
    											q++;
    									}    									

    										System.out.println(k+"   "+x);
    										t.replaceText(s1,k-q,x-q);    										    									    										
    									}
    									count1=1;
    								    }
    								}
    								
    									/*if(str.equals("REPLACE"))
    								{   
    									s4=t.getText();
    									s3=t2.getText();  									
    									s5=t3.getText();
    								s4 = s4.replace("\n", "");
    									ab=s4.indexOf(s3,h);
    									arr1=s3.toCharArray();
    									h=ab+arr1.length;
    							
    									t.replaceText(s5,ab,h);
    									i++;
    									f.toFront();
    								}*/
    								
    								
    								
    									if(str.equals("CANCEL"))
    									{
    										i=0;
    										f1.setVisible(false);
    										f1.dispose();
    									}
    									
    						if(str.equals("no"))
    						{
    						  t.setText(null);
    						  f2.setVisible(false);
    						}	
    						if(str.equals("cancel"))
    						f2.setVisible(false);		
    				
    								
    								
    								
    								
    								
                             
	
}

catch(IOException e1)
           {
           	e1.getMessage();
           } 

}





public void textValueChanged(TextEvent e1){}
	
	              
	              
	              
	               
	               
	               
	


 public void windowClosing(WindowEvent w)
    {
    	Window wn=w.getWindow();
    	wn.setVisible(false);
    	wn.dispose();
    	if(w.getSource()==f)
    		System.exit(1);
    }



	public static void main(String args[]){
		
		editor ed=new editor();
	}

}