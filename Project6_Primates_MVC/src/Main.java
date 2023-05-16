import ControllerFolder.Controller;
import Sanctuary.Sanctuary;
import ViewFolder.JFrameView;

public class Main {
    public static void main(String[] args) {
        Sanctuary model = new Sanctuary();
        JFrameView view = new JFrameView();
        Controller controller = new Controller(model, view);
        view.show();
        controller.initialize();
    }
}