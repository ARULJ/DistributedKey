/*
 * ftpwindow.java
 *
 * Created on March 19, 2008, 11:05 AM
 */

package distributedkey;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;
import java.net.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
/**
 *
 * @author  Ganesh Karthick.R
 */
public class ftpwindow extends javax.swing.JFrame implements Runnable {
    boolean isfilesending;
    member mfrom;
    member mto;
    Object onmbrs[];
    JFileChooser jfc;
    String fname;
    send s;
    member me;
    long filesize;
    Thread t;
    /** Creates new form ftpwindow */
    public ftpwindow() {
        initComponents();
    }
     public ftpwindow(boolean isfilesending,member mfrom,member me,send s,Object onmbrs[],String fname,long filesize) {
        initComponents();
        this.isfilesending=isfilesending;
        this.mfrom=mfrom;
        this.s=s;
        this.me=me;
        t=new Thread(this);
        jprgbar.setBorderPainted(true);
        jprgbar.setStringPainted(true);
        jprgbar.setValue(0);
        jprgbar.setIndeterminate(false);
        jprgbar.setMinimum(0);
        jprgbar.setMaximum(100);
        jfc=new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        this.setTitle("FILE TRANSER:"+me.getname());
        if(isfilesending)
        {   
         this.onmbrs=onmbrs;
         String stmp;
         for(int i=0;i<onmbrs.length;i++)
         {
             stmp=(String)onmbrs[i];
             jcmbdest.addItem(stmp);
         }
         jcmbdest.setEditable(false);
         jcmbdest.setVisible(true);
         jbtnsend.setVisible(true);
         jbtnreceive.setVisible(false);
         jbtnreceive.setVisible(false);
         jLabel2.setVisible(true);
         jbtnopenfile.setVisible(true);
         jbtnrejectfile.setVisible(false);
        }
        else
        {
            jbtnsend.setVisible(false);
            jcmbdest.setVisible(false);
            this.fname=fname;
            this.filesize=filesize;
            jLabel2.setVisible(false);
            jbtnopenfile.setVisible(false);
            jbtnrejectfile.setVisible(true);
        }
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jprgbar = new javax.swing.JProgressBar();
        jbtnopenfile = new javax.swing.JButton();
        jtxtfilepath = new javax.swing.JTextField();
        jbtnsend = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jbtnreceive = new javax.swing.JButton();
        jbtnrejectfile = new javax.swing.JButton();
        jcmbdest = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(distributedkey.DistributedKeyApp.class).getContext().getResourceMap(ftpwindow.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), resourceMap.getString("jPanel1.border.title"))); // NOI18N
        jPanel1.setName("jPanel1"); // NOI18N

        jprgbar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jprgbar.setName("jprgbar"); // NOI18N
        jprgbar.setStringPainted(true);

        jbtnopenfile.setText(resourceMap.getString("jbtnopenfile.text")); // NOI18N
        jbtnopenfile.setName("jbtnopenfile"); // NOI18N
        jbtnopenfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnopenfileActionPerformed(evt);
            }
        });

        jtxtfilepath.setText(resourceMap.getString("jtxtfilepath.text")); // NOI18N
        jtxtfilepath.setName("jtxtfilepath"); // NOI18N

        jbtnsend.setText(resourceMap.getString("jbtnsend.text")); // NOI18N
        jbtnsend.setName("jbtnsend"); // NOI18N
        jbtnsend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnsendActionPerformed(evt);
            }
        });

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jbtnreceive.setText(resourceMap.getString("jbtnreceive.text")); // NOI18N
        jbtnreceive.setName("jbtnreceive"); // NOI18N
        jbtnreceive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnreceiveActionPerformed(evt);
            }
        });

        jbtnrejectfile.setText(resourceMap.getString("jbtnrejectfile.text")); // NOI18N
        jbtnrejectfile.setName("jbtnrejectfile"); // NOI18N
        jbtnrejectfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnrejectfileActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jprgbar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 409, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(jtxtfilepath, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(jbtnopenfile))))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jbtnreceive)
                        .add(66, 66, 66)
                        .add(jbtnsend)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 81, Short.MAX_VALUE)
                        .add(jbtnrejectfile)
                        .add(15, 15, 15))
                    .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 91, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 32, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jbtnopenfile, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 33, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jtxtfilepath, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 32, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(27, 27, 27)
                .add(jprgbar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 32, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jbtnreceive, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 31, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jbtnrejectfile, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 32, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jbtnsend, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 32, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(65, 65, 65))
        );

        jcmbdest.setName("jcmbdest"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(27, 27, 27)
                .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 63, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 40, Short.MAX_VALUE)
                .add(jcmbdest, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 266, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(105, 105, 105))
            .add(layout.createSequentialGroup()
                .add(19, 19, 19)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(34, 34, 34)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jcmbdest, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 218, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnopenfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnopenfileActionPerformed
        // TODO add your handling code here:
        int returnVal =jfc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION)
        {
          fname=jfc.getSelectedFile().getPath();
          jtxtfilepath.setText(fname);
        }
        
    }//GEN-LAST:event_jbtnopenfileActionPerformed
public void setdetails(member mfrom,String fname,long filesize)
{
    this.mfrom=mfrom;
    this.fname=fname;
    this.filesize=filesize;
    jtxtfilepath.setEditable(false);
    jtxtfilepath.setText("Receive File "+fname+" from "+mfrom.getid()+"?");
}
 public String getstring(byte b[],int len)
{
    return new String(b,0,len);
}
    private void jbtnsendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnsendActionPerformed
        // TODO add your handling code here:
        if(t.isAlive())
        {
            t.stop();
            t=null;
            t=new Thread(this);
        }
        t.start(); 
        
    }//GEN-LAST:event_jbtnsendActionPerformed
public void setmembers(Object om[])
{
         onmbrs=om;
         String stmp;
         jcmbdest.removeAllItems();
         for(int i=0;i<onmbrs.length;i++)
         {
             stmp=(String)onmbrs[i];
             jcmbdest.addItem(stmp);
         }
}
public void run()
{
    if(!isfilesending)
    {
     try{
         String fsave="";   
         boolean filereceived=false;   
         
         int returnVal = jfc.showSaveDialog(this);
         if (returnVal == JFileChooser.APPROVE_OPTION)
           fsave=jfc.getSelectedFile().getPath();
         else  
         {
              JOptionPane.showMessageDialog(this,"Try Accepting again,Error Occurred while Saving File..!!","Distributed Key",1);
              return;
         }
         int progress=0,len;
         long received=0;
         jprgbar.setBorderPainted(true);
         jprgbar.setStringPainted(true);
         byte buffer[]=new byte[1024];
         Socket cli=null;
         FileOutputStream fout=new FileOutputStream(fsave);
         cli=new Socket(mfrom.getip(),mfrom.getport());
         InputStream in=cli.getInputStream();
         OutputStream out=cli.getOutputStream();
         out.write("FTPREPLY:YES".getBytes());
         out.flush();
         jprgbar.setString("Received "+String.valueOf(progress)+"%");
         jbtnreceive.setEnabled(false);
         while(true)
         {
             len=in.read(buffer);
             received+=len;
             progress=(int)(received*100/filesize);
             jprgbar.setString("Received "+String.valueOf(progress)+"%");
             if(new String(buffer,0,len).equalsIgnoreCase("EOF"))
             {
               filereceived=true;  
               break;
             }
             fout.write(buffer);
         }
             fout.flush();
             cli.close();
             if(filereceived)
                 JOptionPane.showMessageDialog(this,"File Transfer Complete..!!!","Distributed Key",1);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        jbtnreceive.setEnabled(true);
    }
    else
    {
        try{
         boolean filetransferred=false;   
         String to,cmd;
         int progress=0,len;
         ServerSocket ser=null;
         filesize=(new File(fname)).length();
         long transferred=0;
         if(jcmbdest.getItemCount()==0)
         {
           JOptionPane.showMessageDialog(this,"No Item Selected...!!!","Distributed Key",2);
         }
         to=(String)jcmbdest.getSelectedItem();
         cmd="FTP:"+mfrom.getid()+":"+fname+":"+String.valueOf(filesize);
         s.sendmsg(cmd,to,false);
         byte buffer[]=new byte[1024];
         jtxtfilepath.setText(fname);
         FileInputStream fin=new FileInputStream(fname);
         ser=new ServerSocket(mfrom.getport(),1,mfrom.getip());
         Socket cli=ser.accept();
         InputStream in=cli.getInputStream();
         OutputStream out=cli.getOutputStream();
         len=in.read(buffer);
         if(getstring(buffer,len).equals("FTPREPLY:YES"))
         {
             jbtnsend.setEnabled(false);
             jprgbar.setString("Sent "+String.valueOf(progress)+"%");
             while(fin.read(buffer)!=-1)
             {
                 progress=(int)(transferred*100/filesize);
                 jprgbar.setValue(progress);
                 jprgbar.setString("Sent "+String.valueOf(progress)+"%");
                 out.write(buffer);
                 transferred+=buffer.length;
                 filetransferred=true;
             }
             out.write("EOF".getBytes());
             jprgbar.setValue(100);
             jprgbar.setString("Sent 100%");
             cli.close();
             ser.close();
             fin.close();
             if(filetransferred)
                 JOptionPane.showMessageDialog(this,"File Transfer Complete..!!!","Distributed Key",1);
             
         }
         else 
         {
              JOptionPane.showMessageDialog(this,"File Sending Request has Rejected by "+to+" ..!!","Distributed Key",2);
              cli.close();
              ser.close();
              fin.close();
         }
        }
        catch(ConnectException ex)
        {
            JOptionPane.showMessageDialog(this,"File Sending Request has Rejected..!!","Distributed Key",2);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        jbtnsend.setEnabled(true);
    }
}
    private void jbtnreceiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnreceiveActionPerformed
        // TODO add your handling code here:
      if(t.isAlive())
        {
            t.stop();
            t=null;
            t=new Thread(this);
        }
        t.start(); 
    }//GEN-LAST:event_jbtnreceiveActionPerformed

    private void jbtnrejectfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnrejectfileActionPerformed
        // TODO add your handling code here:
        try{
         Socket cli=new Socket(mfrom.getip(),mfrom.getport());
         InputStream in=cli.getInputStream();
         OutputStream out=cli.getOutputStream();
         out.write("FTPREPLY:NO".getBytes());
         out.flush();
         out.close();
        }
          catch(Exception ex)
        {
            ex.printStackTrace();
        }
        this.setVisible(false);
    }//GEN-LAST:event_jbtnrejectfileActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ftpwindow().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtnopenfile;
    private javax.swing.JButton jbtnreceive;
    private javax.swing.JButton jbtnrejectfile;
    private javax.swing.JButton jbtnsend;
    private javax.swing.JComboBox jcmbdest;
    private javax.swing.JProgressBar jprgbar;
    private javax.swing.JTextField jtxtfilepath;
    // End of variables declaration//GEN-END:variables
    
}
