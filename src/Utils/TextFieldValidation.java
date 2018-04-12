/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author nessrine
 */
public class TextFieldValidation {
    public static boolean TextFieldNotEmpty(TextField tf)
    {
        boolean p=false; 
        if(tf.getText().length()!=0||!tf.getText().isEmpty())
        {
            p=true;
        }
        return p;
    }
     public static boolean TextFieldNotEmpty(TextField tf,Label b,String Errormessage)
    {
        boolean p=true; 
        String mesg=null; 
  
        if(!TextFieldNotEmpty(tf))
        {
            p=false;
            mesg=Errormessage;
          

        }
        b.setText(mesg);
        return p;
    }
             public static boolean TextFieldNumber(TextField tf)
    {
        boolean p=false; 
        if(tf.getText().matches("([0-9]+(\\.[0-9]+)?)+"))
        {
            p=true;
        }
        return p;
    }
             public static boolean TextFieldNumber(TextField tf,Label b,String Errormessage)
    {
        boolean p=true; 
        String mesg=null; 
       

        if(!TextFieldNumber(tf))
        {
            p=true;
            mesg=Errormessage;
 

        }
        b.setText(mesg);
        return p;
}
}
