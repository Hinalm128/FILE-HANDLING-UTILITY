import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FileOpr implements ActionListener

{
	private JFrame f;
	private JPanel p1,p2;
	private JLabel filename;
	private JTextField pathField;
	private String selectedFilePath;
	private JTextArea ContentBox;
	private JButton openbtn,wrtbtn,modbtn;
	public  FileOpr()
	{
		//Creating Components and Setting their Style,, color & font.
		f= new JFrame("File Handling");
		f.setLayout(new BorderLayout());
		
		p1 = new JPanel(new FlowLayout());
		p1.setBackground(new Color(211,186,250));
		
		p2 = new JPanel(new GridLayout(1,0));
		
		filename = new JLabel("Selected File : ");
		filename.setForeground(new Color(80, 0, 120));
		
		pathField = new JTextField(25);		
		pathField.setEditable(false);
		pathField.setBackground(new Color(240, 240, 255));
		pathField.setBorder(BorderFactory.createLineBorder(new Color(255,255,255), 1));
		
		ContentBox = new JTextArea(20,30);
		ContentBox.setBackground(new Color(218,218,218));
		
		JScrollPane sp = new JScrollPane(ContentBox);
		
		openbtn= new JButton("Open/Read File");
		openbtn.setBackground(new Color(140, 0, 255));
		openbtn.setForeground(new Color(255, 255, 255));
		openbtn.addActionListener(this);
		
		wrtbtn= new JButton(" Write to a File");
		wrtbtn.setBackground(new Color(140, 0, 255));
		wrtbtn.setForeground(new Color(255, 255, 255));
		wrtbtn.addActionListener(this);
		
		modbtn= new JButton("Modify file");
		modbtn.setBackground(new Color(140, 0, 255));
		modbtn.setForeground(new Color(255, 255, 255));
		modbtn.addActionListener(this);
		
		//Adding the Components to thier respective JPanel.
		p1.add(filename);
		p1.add(pathField);
		
		p2.add(openbtn);
		p2.add(wrtbtn);
		p2.add(modbtn);
		
		//Adding the components to the JFrame.
		f.add(p1,BorderLayout.NORTH);
		f.add(sp,BorderLayout.CENTER);
		f.add(p2,BorderLayout.SOUTH);
		
		f.setSize(400,450);
		f.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		//For Reading the File.
		if(e.getSource()==openbtn)
		{
			JFileChooser jf = new JFileChooser();
			jf.showOpenDialog(null);
			try
			{
				File selectedFile = jf.getSelectedFile();
				
				//If the File is not Selected then show to following Message , else Preform the File Reading Operation. 
				if (selectedFile == null) 
				{
					JOptionPane.showMessageDialog(f, "No file selected to delete.", "Warning", JOptionPane.WARNING_MESSAGE);
					return;
				}
				else
				{
					//Retriving the Path of the Selected Filename & Setting the TextField with the path.
					selectedFilePath=selectedFile.getPath();
					pathField.setText(selectedFilePath);
					
					BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
					String line;
					
					//Reading the content in the Bufferedreader and append it to the TextArea.
					while ((line = reader.readLine()) != null)
					{
						ContentBox.append(line+"\n");
					}
				}
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(f,"Error occured while performing the file operation","Error",JOptionPane.ERROR_MESSAGE);
			}			
		}
		
		//For Writing the file contents 
		//NOTE: For Writing the content in the file , first you need to write the content in the file .. and then click onto the write file button.
		if(e.getSource()==wrtbtn)
		{
			//Taking the input from the user about the file name.
			//Note: It may or may not contain a '.txt' or any extention.
			String writeFileName=JOptionPane.showInputDialog(f,"Enter the name of the file");
			try
			{				
				BufferedWriter bw = new BufferedWriter(new FileWriter(writeFileName));
				
				//Displaying a Confiramtion box to take approval for making the changes.
				int result = JOptionPane.showConfirmDialog(f, "Are you sure... You want to Write text to the File ?","Confirmation",  JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				
				//If the Ok option is selected then... Write the content to the file.
		        if (result == JOptionPane.OK_OPTION) 
		        {
		        	bw.write(ContentBox.getText()+"\n");		            
		        	JOptionPane.showMessageDialog(f,"Content written to the file","Info",JOptionPane.INFORMATION_MESSAGE);
		        	bw.close();
		        } 
		        //else Display a Message box ... that the Content is not writen in the file.
		        else if (result == JOptionPane.CANCEL_OPTION) 
		        {
					JOptionPane.showMessageDialog(f,"Content was not written to the file","Error",JOptionPane.ERROR_MESSAGE);
		        }
		        
		      //After the operation is performed, Clearing the ContentBox.
				ContentBox.setText("");
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(f,"Error occured while performing the file operation","Error",JOptionPane.ERROR_MESSAGE);
				ContentBox.setText("");
			}			
		} 
		
		//For Modifying the file contents 
		//Note: For modifing the content you have to first open a file and then modify the by editing the content ,and the click on modify button.
		if(e.getSource()==modbtn)
		{
			try
			{
				PrintWriter writer = new PrintWriter(new FileWriter(selectedFilePath));
				
				//Displaying a Confiramtion box to take approval for making the changes.
				int result = JOptionPane.showConfirmDialog(f, "Are you sure... You want to modify the text File ?","Confirmation",  JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

				//If the Ok option is selected then... Modify the content of the file.
		        if (result == JOptionPane.OK_OPTION) 
		        {
		        	writer.write(ContentBox.getText());
		        	JOptionPane.showMessageDialog(f,"Contents of the file modified","Info",JOptionPane.INFORMATION_MESSAGE);
		        	writer.close();
		        } 
		        //else Display a Message box ... that the Content is not modify in the file.
		        else if (result == JOptionPane.CANCEL_OPTION) 
		        {
					JOptionPane.showMessageDialog(f,"Content was not Modified to the file","Error",JOptionPane.ERROR_MESSAGE);
		        }
		        
		        //After the operation is performed, Clearing the ContentBox.
				ContentBox.setText("");
				
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(f,"Error occured while performing the file operation","Error",JOptionPane.ERROR_MESSAGE);
				ContentBox.setText("");
			}			
		} 
	}
	
	public static void main(String[] args)
	{
		//Calling the Constructor.
		new FileOpr();
	}
}
