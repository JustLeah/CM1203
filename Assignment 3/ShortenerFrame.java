/*
 * Name: Henry Riches
 * Student number: c1426527
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JDialog;
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.*;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ShortenerFrame extends JFrame {
    // This class is only a starting point. You may wish to add members and 
    // fields to complete the implementation of this class as per the
    // question on the assignment sheet.
    
    // Constants
    private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HEIGHT = 260;
    
    // Instance variables -- GUI components
    private JPanel panel;
    private JLabel instructionLabel;
    private JTextArea inputArea;
    private JTextArea outputArea;
    private JButton shortenButton;
    private JButton pasteButton;
    
    // Constructor
    public ShortenerFrame(){
        super();
        
        //
        // Set up the frame
        setSize( FRAME_WIDTH, FRAME_HEIGHT );
        setResizable(false);
        setTitle("Super awesome text shortener!");
        
        //
        // Set up the panel and layout manager
        panel = new JPanel();
        GridLayout grid = new GridLayout( 0, 1 );  // a one-column layout
        panel.setLayout( grid );
        
        add( panel );  // add panel to the JFrame

        //
        // Set up and add components
        instructionLabel = new JLabel( "Enter text in the field below and click 'Shorten'" );
        panel.add( instructionLabel );
        
        inputArea = new JTextArea();
        inputArea.setLineWrap(true);
        panel.add( inputArea );
        
        pasteButton = new JButton( "Paste from Clipboard" );
        pasteButton.addActionListener(new ActionListener() 
            {
              public void actionPerformed(ActionEvent e){
                    inputArea.setText(getStringFromClipboard());
                }
            });

        panel.add(pasteButton);

        shortenButton = new JButton( "Shorten" );
        shortenButton.addActionListener(new ActionListener()
            {
              public void actionPerformed(ActionEvent e){
                    String inputText = inputArea.getText();
                    //Create a new instance of the Shortener Object
                    try{
                        Shortener guiShort = new Shortener();
                        String shortMsg = guiShort.shortenMessage(inputText); 
                        outputArea.setText(shortMsg);
                    }
                    catch(FileNotFoundException ex){
                        outputArea.setText("The abbreviation file can't be found!");
                    }
                    catch(IOException ex){
                        System.out.println (ex.toString());
                    }
                   
                }
            });
        panel.add( shortenButton );
                
        outputArea = new JTextArea();
        outputArea.setLineWrap(true);
        outputArea.setEditable(false);
        panel.add( outputArea );
    }
     public static String getStringFromClipboard() {
            Transferable clipboard = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
            try {
                if (clipboard != null && clipboard.isDataFlavorSupported(DataFlavor.stringFlavor)){
                    String copiedText = (String) clipboard.getTransferData(DataFlavor.stringFlavor);
                    return copiedText;
                }
            } catch (UnsupportedFlavorException e) {
                System.out.println("Clipboard content flavor is not supported " + e.getMessage());
            } catch (IOException e) {
                System.out.println("Something went Pete Tong! - " + e.getMessage());
            }
            return null;
          }

}

