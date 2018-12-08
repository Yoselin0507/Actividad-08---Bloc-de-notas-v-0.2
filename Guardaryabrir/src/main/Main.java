package main;

import view.ViewGuardaryabrir;
import model.ModelGuardaryabrir;
import controller.ControllerGuardaryabrir;

public class Main {
    private static ViewGuardaryabrir viewGuardaryabrir;
    private static ModelGuardaryabrir modelGuardaryabrir;
    private static ControllerGuardaryabrir controllerGuardaryabrir;
    
    public static void main(String[] args)
    {
        viewGuardaryabrir = new ViewGuardaryabrir();
        modelGuardaryabrir = new ModelGuardaryabrir();
        controllerGuardaryabrir = new ControllerGuardaryabrir(viewGuardaryabrir, modelGuardaryabrir);
    }
}