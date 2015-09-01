import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JOptionPane;

class NewEditor extends WindowAdapter implements ActionListener,TextListener {
	
int i=0,j=0,ab=0,count1=0;
Frame f;
Dialog f1,f2;
MenuBar mb;
Menu m1,m2,m3;
MenuItem nw,opn,sv,svs,ext,fnd,fndrplc,sum,product,avg,total,median;
TextArea t;
TextField t1,t2,t3,t4;
Button b1,b2,b3,b4,b5,b6,b7,b8;
String s1,s2,s3,s4,s5;
Label l1,l2,l3,l11;
Panel p1,p2,p3,p4;
boolean bol=false,bol1=false;
FileInputStream fin;
FileOutputStream fon;    	    
FileDialog fd=new FileDialog(f,"openfile",FileDialog.LOAD);
FileDialog fd1=new FileDialog(f,"Savefile",FileDialog.SAVE);	

int h=0;
char arr1[],a[];


private void begin()
   
   {
	
	
	f=new Frame();
	
	f.setSize(400,300); 
	
    t=new TextArea();
    t1=new TextField();
   
	mb=new MenuBar();
	m1=new Menu("File");
	m2=new Menu("Tools");
	m3=new Menu("Math");
		
	nw=new MenuItem("New");	
    opn=new MenuItem("Open");		
	sv=new MenuItem("Save");		
	svs=new MenuItem("Save As");	
	ext=new MenuItem("Exit");	
	fnd=new MenuItem("Find");
	fndrplc=new MenuItem("Find & Replace");		
	sum=new MenuItem("Sum");
	product=new MenuItem("Product");
	avg=new MenuItem("Average");
	median=new MenuItem("Median");
	total=new MenuItem("SizeofList");
	
	t.addTextListener(this);
	
	nw.addActionListener(this);	
	opn.addActionListener(this);	
	sv.addActionListener(this);	
	svs.addActionListener(this);	
	ext.addActionListener(this);
	
	fnd.addActionListener(this);					
	fndrplc.addActionListener(this);
	
	sum.addActionListener(this);
	product.addActionListener(this);
	avg.addActionListener(this);
	median.addActionListener(this);
	total.addActionListener(this);
					
	m1.add(nw);
	m1.add(opn);	
	m1.add(sv);
	m1.add(svs);
	m1.addSeparator();
	m1.add(ext);
	
	m2.add(fnd);	
	m2.add(fndrplc);
	
	m3.add(sum);
	m3.add(product);
	m3.add(avg);
	m3.add(median);
	m3.add(total);	
	
	mb.add(m1);
	mb.add(m2);
	mb.add(m3);
	
	 f.setMenuBar(mb);
	 f.add(t);
	
	 f.setVisible(true);
	
	f.addWindowListener(this);
	
	
}

public void actionPerformed(ActionEvent e){
	
	String str=e.getActionCommand();
	int ch; String s=""; 
	
try{
	
	
	    if(str.equals("New"))
	    {
	    	    if(!(t.getText().isEmpty())){
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
	    	    	f2.setVisible(true);
	    	    }else{
	    	    f.dispose();
	    	      this.begin(); 
	    	    }
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
    								b2=new Button("CANCEL");
    								b3=new Button("REPLACE");    									
    								f1.add(l1); 								
    								f1.add(t2);
    								f1.add(l3);	
    								f1.add(t3);
    								f1.add(b3);
    								f1.add(b2);   								
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
    									s4=s4.replace("\\s","");
    									ab=s4.indexOf(s3);
    									h=ab+arr1.length;
    									t.select(ab,h);
    									f.toFront();							
    								}
    								
    								
    								
    								if(str.equals("REPLACE"))
    								{
    									
    									
    									if(count1==0)
    									{
    									
    									String s1=t2.getText();
    									String s2=t.getText();
    									String s3=t3.getText();
    									if(s3.isEmpty() || s1.isEmpty())
    										JOptionPane.showMessageDialog(null,"Give the keywords to search and replace???");   					
    									else
    									{
    										
    										arr1=s1.toCharArray();
        							 		a=s2.toCharArray();
        									s2 = s2.replace("\n", "");
        									s2=s2.replace("\\s","");
        									ab=s2.indexOf(s1);
        									h=ab+arr1.length;
        								
        									t.replaceRange(s3, ab, h);
        									JOptionPane.showMessageDialog(null,"text replaced");
        									f.toFront();
        									f1.setVisible(false);
    										f1.dispose();
        															    									    										
    									}
    									count1=1;
    								    }
    								}
    								
    						    								
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
    	       
    						if(str.equals("Sum")){
    							int totalsum = 0;
    							ArrayList<Integer> numlist = prepareNumlist();
    							if(numlist.size()>0){
    							for(int i=0;i<numlist.size();i++){
    								totalsum += numlist.get(i);
    								
    							}
    							JOptionPane.showMessageDialog(null,"Total Sum is: "+totalsum);
    						}else {
    							
    						  totalsum=0;}
    						}
	
    						if(str.equals("Product")){
    							long totalproduct = 1;
    						    ArrayList<Integer> numlist = prepareNumlist();
    							if(numlist.size()>0){
    						    for(int i=0;i<numlist.size();i++){
    								totalproduct *= numlist.get(i);
    								
    							}
    						    JOptionPane.showMessageDialog(null,"Total Product is: "+totalproduct);
    							}else{
    								
    								totalproduct=0;
    							}
    							
    						}
    						
    						if(str.equals("Average")){
    							int total = 0,avg=0;;
    							ArrayList<Integer> numlist = prepareNumlist();
    						 if(numlist.size()>0){
    							for(int i=0;i<numlist.size();i++){
    								total += numlist.get(i);
    							}
    							avg = total / numlist.size(); 
    						   }
    						 else{
    							 avg=0;
    							 
    						 }
    							JOptionPane.showMessageDialog(null,"Average is: "+avg);
    						}
    						
    						if(str.equals("Median")){
    							int median=0;
    									
    							ArrayList<Integer> numlist = prepareNumlist();
    							if(numlist.size()>0){    							
    							Collections.sort(numlist);
    							median = numlist.get(numlist.size() / 2);
    							}else{
    								median=0;
    							}
    							JOptionPane.showMessageDialog(null,"Median is: "+median);
    						}
    						
    						if(str.equals("SizeofList")){
    									
    							ArrayList<Integer> numlist = prepareNumlist();
    							JOptionPane.showMessageDialog(null,"Total Size is: "+numlist.size());
    						}

}

catch(IOException e1)
           {
           	e1.getMessage();
           } 

}

private ArrayList<Integer> prepareNumlist() {
	String S = t.getText();
	String[] num = S.split("[\\r\\n]+");
	
	ArrayList<Integer> Intnum = new ArrayList<Integer>();

    if(num.length >0) {
	
    try{
 
    	 for(String k:num){
		
	    	Intnum.add(Integer.parseInt(k)); 
	   }

    	
	
    }catch(Exception e){
		
		JOptionPane.showMessageDialog(null,"Wrong input for Math functions "+e.getMessage());
		 Intnum.clear(); 
	}
 }
    return Intnum;
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
		
		NewEditor ed=new NewEditor();
		ed.begin();
	}

}
