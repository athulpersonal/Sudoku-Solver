/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import static javafx.scene.input.KeyCode.T;

/**
 *
 * @author Athul
 */
public class FXMLDocumentController implements Initializable {
   

  
    @FXML
    private List<JFXTextField> box ;
    @FXML
    private JFXButton btn_solve;

    @FXML
    private JFXButton btn_clear;
    @FXML
    private Label error;
    
    @FXML
    void clearSudoku(ActionEvent event) 
    {
        error.setVisible(false);
        for(JFXTextField clear:box)
        {  
            clear.setText("");
            clear.setStyle("-fx-background-color:#81D4FA");
        }
            
    }
     @FXML
    void solveSudoku(ActionEvent event)
    {
                 error.setVisible(false);
                String s;
                boolean valid_input=true;
                int[][] input=new int[9][9];
                for(int i=0,k=0;i<9;++i)
                {
                  for(int j=0;j<9;++j,++k)
                  {
                      s=box.get(k).getText();
                      if(s.equals(""))
                      {
                          input[i][j]=0;
                          box.get(k).setStyle("-fx-background-color:#CDDC39");
                      }
                      else if(s.length()==1)//check single digit
                      {    
                          try{
                              input[i][j]=Integer.parseInt(s);
                              box.get(k).setStyle("-fx-background-color:#FF9800");
                          }
                          catch(Exception e)
                          {
                              valid_input=false;
                          }
                      }
                      else
                      {
                          valid_input=false;
                      }
                  }
                } 
                if(valid_input)
                {
                    Task<Integer> backgroundTask = new Task<Integer>() {
                         @Override
                         protected Integer call() throws Exception {
                             return null;
                         }

                         @Override
                         public void run() {
                             sud sudoku=new sud();
                                sudoku.solveSudoku(input);
                                setResult(input);
                         }
                    };
    Thread backgroundThread = new Thread(backgroundTask);
                    backgroundThread.start();
                }
                else 
                    error.setVisible(true);
         
    }
    void setResult(int[][] output)
    {
        boolean valid_output=true;
        for(int i=0,k=0;i<9&&valid_output;++i)
      {
          for(int j=0;j<9&&valid_output;++j,++k)
          {
              if(output[i][j]>=1&&output[i][j]<=9)
                box.get(k).setText(String.valueOf(output[i][j]));
              else
                  valid_output=false;
          }
      }
        if(!valid_output)
             error.setVisible(true);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        for(JFXTextField input:box)
        {
            input.setStyle("-fx-background-color:#81D4FA");
        }
        error.setVisible(false);
    }    
    
}
