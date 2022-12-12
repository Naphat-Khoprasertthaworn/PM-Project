package component;

import entity.base.Monster;
import entity.base.Unit;
import javafx.event.EventHandler;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import logic.GameLogic;

public class UnitCard extends VBox {
	
	private final String pointerImageURL = "pointer.png";
	private final String blankUnitURL = "blankUnit.png";
	private Unit unit;
	private ProgressBar healthBar;
	private ImageView unitImage;
	
	public UnitCard() {
		
		String imgPath = ClassLoader.getSystemResource(blankUnitURL).toString();
		String pointerPath = ClassLoader.getSystemResource(pointerImageURL).toString();
		unitImage = new ImageView(new Image(imgPath));
		
		ImageView pointerImage = new ImageView(new Image(pointerPath));
		
		healthBar = new ProgressBar(100);
		
		this.getChildren().add(pointerImage);
		this.getChildren().add(unitImage);
		this.getChildren().add(healthBar);
		
		this.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			public void handle(MouseEvent arg0) {
				onClickHandler();
			}
		});
	}
	
	public void update(Unit u) {
		this.unit = u;
		String imgPath = ClassLoader.getSystemResource(u.getImagePath()).toString();
		
		unitImage.setImage(new Image(imgPath)); 
		
	}
	
	public void updateHealthBar() {
		if(unit == null) {
			return;
		}
		healthBar.setProgress( (unit.getHealth()*100) /unit.getMaxHealth() );
	}
	
	
	public void onClickHandler() {
		if(unit instanceof Monster) {
			GameLogic.getInstance().setTargetedMonster(this.unit);
		}else if(unit instanceof Unit) {
			GameLogic.getInstance().setTargetedHero(this.unit);
		}
	}
	
}
