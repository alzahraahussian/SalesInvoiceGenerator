package model;
import exceptions.FileNotFound;
import exceptions.WrongFileFormat;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOperations extends JFrame  implements ActionListener {
    private JTextArea textArea;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem open;
    private JMenuItem save;
    private JMenuItem exit;
    private JTable table;
    //Create Object from Invoice Header and Line
    InvoiceHeader invoiceHeader=new InvoiceHeader();
    InvoiceLine invoiceLine=new InvoiceLine();

    public FileOperations() throws HeadlessException {
    }

    public FileOperations (String title){
             super(title);
             // Declaration
                textArea =new JTextArea();
                menuBar=new JMenuBar();
                menu=new JMenu("File");
                open=new JMenuItem("Read File",'R');
                open.addActionListener(this);
                open.setActionCommand("R");
                open.setAccelerator(KeyStroke.getKeyStroke('R', KeyEvent.CTRL_DOWN_MASK));

                save=new JMenuItem("Save File",'S');
                save.addActionListener(this);
                save.setActionCommand("S");
                save.setAccelerator(KeyStroke.getKeyStroke('S', KeyEvent.CTRL_DOWN_MASK));


                exit=new JMenuItem("Exit",'X');
                exit.addActionListener(this);
                exit.setActionCommand("X");
                exit.setAccelerator(KeyStroke.getKeyStroke('X', KeyEvent.CTRL_DOWN_MASK));
                // GUI
                setJMenuBar(menuBar);
                menuBar.add(textArea);
                menuBar.add( menu);
                menu.add(open);
                menu.add(save);
                menu.addSeparator();
                menu.add(exit);
                add(new JScrollPane(textArea));
                //Setting
                setSize(400,500);
                setLocation(300,200);
                setDefaultCloseOperation(EXIT_ON_CLOSE);
            }
    public static void main(String [] args){

        new FileOperations("FileOperations").setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
                switch (e.getActionCommand()){
                   case "R":
                       try {
                           try {
                               readFile();
                           } catch (FileNotFound ex) {
                               throw new RuntimeException(ex);
                           }
                       } catch (WrongFileFormat ex) {
                           throw new RuntimeException(ex);
                       } catch (IOException ex) {
                           throw new RuntimeException(ex);
                       }
                       break;

                    case "S":
                        try {

                            saveFile();
                        } catch (FileNotFound ex) {
                            throw new RuntimeException(ex);
                        } catch (FileNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                        catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        break;
                    case "X":
                        System.exit(0);
                        break;
                }
    }
    private void readFile() throws WrongFileFormat,IOException,FileNotFound{

                JFileChooser browse = new JFileChooser();
                FileNameExtensionFilter filterCsv = new FileNameExtensionFilter(
                        "CSV Files Only", "csv");
                browse.setFileFilter(filterCsv);
                int value = browse.showOpenDialog(FileOperations.this);
                FileInputStream file=null;
                String path = browse.getSelectedFile().getPath();
                try {
                   // String pathFile ="E:\\Java\\salesInvoiceGenerator\\src\\file";
                     file = new FileInputStream(path);
                    int size = file.available();
                    byte[] b = new byte[size];
                    file.read(b);
                    textArea.setText(new String(b));
                    if (value == JFileChooser.APPROVE_OPTION){
                        System.out.println(browse.getSelectedFile().getName());
                      }
                }catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }catch (IOException e) {
                    e.printStackTrace();
                }finally {try{file.close();}catch (IOException e){}
                }
               }
    private void saveFile() throws FileNotFound,IOException{

                JFileChooser browse =new JFileChooser();
                 FileNameExtensionFilter filterCsv = new FileNameExtensionFilter(
                "CSV Files Only", "csv");
                 browse.setFileFilter(filterCsv);
                 browse.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int result= browse.showSaveDialog(FileOperations.this);
                if(result == JFileChooser.APPROVE_OPTION){
                    String path = browse.getSelectedFile().getPath();
                    FileOutputStream writingFile =null;
                    String filename = "File.csv";
                    if( Integer.toString(result)  == filename){
                try {
                    writingFile = new FileOutputStream(path);
                    byte[] buffer = textArea.getText().getBytes();
                    writingFile.write(buffer);
                    } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    } catch (IOException e) {
                    e.printStackTrace();
                  } finally {try{writingFile .close();}catch (IOException e){}
                }
                }}

    }

}

