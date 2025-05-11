# FILE-HANDLING-UTILITY

"COMPANY": CODTECH IT SOLUTIONS

"NAME": HINAL ANIL MISTRY

"INTERN ID": CT04DK953

"DOMAIN": JAVA PROGRAMMING

"DURATION": 4 WEEKS

"MENTOR": NEELA SANTHOSH

##DESCRIPTION##

Task 1: File Handling utility  

This task is performed using the ‘Eclipse IDE for Java Developers - 2025-03’ .

FileOpr class is a java swing application which allows the user to perform basic operations with text files like reading, writing, and editing them through a graphical interface. The user interface is equipped with various buttons as well as text components so that even those users who do not want to use the command line or even a terminal can easily use it.  

The title of the program window (JFrame) is “File Handling” where the content is organized using BorderLayout. For example, in the upper part (p1) there is a label as well as a text field (pathField) which is not editable and shows the path of the currently selected file and the center part of the window contains a JTextArea (ContentBox) which is wrapped in a JScrollPane so as to show the content of a file and allow scrolling within it for easy access. At the bottom (p2) there are three buttons: Open/Read File, Write to a File, and Modify File or do all of the above.  

Using the Open/Read File button, the user can select and browse a file using JFileChooser. Once the file is selected, the application will read the content of the file line by line and show it in the ContentBox which as the name suggests is a non-editable textbox. This content box is non-editable in so as to prevent changes been done to this content. The user however has to confirm removing changes and enabling modifications to set changes.

The Write to a File button prompts the user to enter a new filename using JOptionPane.showInputDialog(). The user-provided filename either contains or does not contain the “.txt” file extension. Once the dialog has been confirmed, BufferedWriter will be used to write the contents of ContentBox to the file. This option enables the user to create a file and write content into it. The program does, however, show a dialog box to confirm that the user wants to actually perform the writing operation. The content is then written, the confirmation dialog is cleared, the area returned to standby for use.

Note: In order to Write the Content onto the File Follow the following Steps:
• Type the Desired Text in the TextArea i,e ContentBox.
• Then Click on the “Write to File” Button.
• A Confirmation Box will Appear , Select the Desired option.
• If the OK_OPTION is the choice, then and only then the Content will be Written in the File.

Through the use of the Modify File button, a user can edit a file that has already been opened. If a user has already started editing a text file, their changes will be saved after clicking the Modify File button. Clicking this button will replace everything in the file with content received in ContentBox. A confirmation dialog box ensures that the user does not overwrite important information. The modification is performed with PrintWriter, while the file path comes from saved selectedFilePath.

Note: To modify the contents within the File, follow the following steps:
• Using the “Open/Read File” option, Open the File.
• In the TextArea named ContentBox, Edit the Text as required.
• Click the “Modify File”. 
• A Confirmation Box will Appear, Choose the desired option.
• The Content in the File will be changed only if OK_OPTION is selected.

Exception handling within the program ensures there are no problems within file not found, null references, or input and output streams. If a file operation fails, a descriptive alert will be issued through JOptionPane.showMessageDialog ().

The softer pastel interface colors as well as the styled buttons significantly enhance the user's experience and aesthetics of the system. The pastel light purple and pastel gray contribute to an elegant clean look. The buttons have white texts on purple backgrounds, which enhance visibility. It is also important to note that all major operations are provided and clearly labelled.

To conclude, this Swing application offers the user both an educational and functional tool which allows the user to learn the basics of file handling through a graphical interface. This application serves as an example on how to combine input from the user, file input output (I/O), and event handling in one well structured desktop application. 

## Output of the Layout
![Image](https://github.com/user-attachments/assets/9260f1ac-c11f-4405-ac34-8f16eb8e8548)

##The Open/Read Button
![Image](https://github.com/user-attachments/assets/3dd5ea55-f0bd-4dde-ae58-a08125de2f21)

##The Write Button

##The Modify Button

