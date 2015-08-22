/*
    QueryConnector - Attach a query to a Calc document
    Copyright (C) 2013 Enrico Giuseppe Messina

    This library is free software; you can redistribute it and/or
    modify it under the terms of the GNU Lesser General Public
    License as published by the Free Software Foundation; either
    version 2.1 of the License, or (at your option) any later version.

    This library is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
    Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public
    License along with this library; if not, write to the Free Software
    Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */
package com.meserico.queryconnector;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.MessageFormat;
import java.util.ResourceBundle;
import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.UIManager;

/**
 *
 * @author Enrico Messina
 */
public class JExtDialog extends JDialog {

    private ResourceBundle resourceBundle;
    
    /**
     * Creates new form JExtDialog
     */
    public JExtDialog(Dialog parent, boolean modal) {
        super(parent, modal);
        try{
            if(OS.isUnix())
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
            else
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch(Exception ex){}
        initComponents();
        resourceBundle = ResourceBundle.getBundle("com/meserico/queryconnector/languages");
        this.setIconImage(this.getDefaultIcon());
    }
    
    /**
     * Creates new form JExtDialog
     */
    public JExtDialog() {
        this((Dialog) null, false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    protected String tr(String key){
        return resourceBundle.getString(key);
    }
    
    protected String tr(String key, Object... args){
        return MessageFormat.format(resourceBundle.getString(key), args);
    }
    
    protected void centerOnScreen(){
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int x_pos = (dim.width - this.getWidth())/2;
        int y_pos = (dim.height - this.getHeight())/2;
        this.setLocation(x_pos, y_pos);
    }
    
    public Image getImage(String resourceName){
        try{
            return ImageIO.read(this.getClass().getResourceAsStream(resourceName));
        }catch(Exception ex){
            ExceptionDialog.show(this, ex);
            return null;
        }
    }
    
    public final Image getDefaultIcon(){
        return getImage("/com/meserico/queryconnector/queryconnector.png");
    }
    
    protected String exceptionToString(Exception ex){
        try{
            StringWriter writer = new StringWriter();
            PrintWriter print = new PrintWriter(writer);
            ex.printStackTrace(print);
            print.flush(); writer.flush();
            String exceptionString = writer.toString();
            writer.close(); print.close();
            return exceptionString;
        }catch(Exception ex1){
            throw new RuntimeException(ex1);
        }
    }
}
