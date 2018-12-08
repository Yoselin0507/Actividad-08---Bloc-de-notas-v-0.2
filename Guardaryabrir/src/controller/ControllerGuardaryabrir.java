package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import model.ModelGuardaryabrir;
import view.ViewGuardaryabrir;

public class ControllerGuardaryabrir implements ActionListener
{
    private final ModelGuardaryabrir modelGuardaryabrir;
    private final ViewGuardaryabrir viewGuardaryabrir;

    public ControllerGuardaryabrir(ViewGuardaryabrir viewGuardaryabrir, ModelGuardaryabrir modelGuardaryabrir)    
    {
        this.viewGuardaryabrir = viewGuardaryabrir;
        this.modelGuardaryabrir = modelGuardaryabrir;
        viewGuardaryabrir.Jmi_abrir.addActionListener(this);
        viewGuardaryabrir.Jmi_guardar.addActionListener(this);
        initView();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==viewGuardaryabrir.Jmi_abrir){
            JFileChooser file=new JFileChooser(); //Crea el objeto para el filechooser
            file.showOpenDialog(null); //Carga la ventana de dialogo y encuentra la ruta donde almacenamos el archivo 
            modelGuardaryabrir.setPath(""+file.getSelectedFile()); //obtiene la ruta del archivo y la pasa al modelo
            modelGuardaryabrir.readFile(modelGuardaryabrir.getPath()); //abre el archivo obteniendo la ruta desde el modelo
            viewGuardaryabrir.Jta_txt.setText(modelGuardaryabrir.getMessage()); //muestra el contenido en el JTextArea
        }else if(e.getSource()==viewGuardaryabrir.Jmi_guardar){
            JFileChooser file=new JFileChooser(); 
            file.showSaveDialog(null);
            modelGuardaryabrir.setPath(""+file.getSelectedFile());
            modelGuardaryabrir.setMessage(viewGuardaryabrir.Jta_txt.getText());
            modelGuardaryabrir.writeFile(modelGuardaryabrir.getPath(), modelGuardaryabrir.getMessage());
        }
    }
    private void initView() 
    {
        viewGuardaryabrir.setTitle("Archivo");
        viewGuardaryabrir.setResizable(false);
        viewGuardaryabrir.setLocationRelativeTo(null);
        viewGuardaryabrir.setVisible(true);
    }
}