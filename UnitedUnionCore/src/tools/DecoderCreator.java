package tools;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class DecoderCreator extends Application{
	public static final double VERSIONID=1.0;
	
	
	@Override
	public void start(Stage stage) throws Exception {
		Button create=new Button("CREATE!");

		StackPane root=new StackPane();
		
		root.getChildren().add(create);
		
		stage.setTitle("DecoderCreator Version: "+VERSIONID);
		stage.setScene(new Scene(root,500,550));
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}

}
