package component;

import java.util.ArrayList;

import org.junit.Ignore;

import entity.base.Monster;
import entity.base.Skill;
import entity.base.Unit;
import gui.CombatController;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import logic.GameLogic;

public class SkillCard extends VBox{
	private Skill skill;
	private Text name;
	private Text textSkill;
	private Text cdSkill;
	private final String blankSkillURL = "image/overwatch-logo.png";
	//private Background bg;
	private ImageView imgView;
	
	public SkillCard() {
		name = new Text();
		name.setFill(Color.WHITE);
		textSkill = new Text();
		textSkill.setWrappingWidth(80);
		textSkill.setFill(Color.WHITE);
		cdSkill = new Text();
		cdSkill.setFill(Color.WHITE);
		
		
		String imgPath = ClassLoader.getSystemResource( blankSkillURL ).toString();
		
		imgView = new ImageView(imgPath);
		imgView.setFitWidth(100);
		imgView.setFitHeight(100);
		
		VBox textBox = new VBox();
		textBox.getChildren().addAll(name,cdSkill,textSkill);
		this.setMargin(textBox, new Insets(10,0,0,0));
		this.getChildren().add(imgView);		
		this.getChildren().add(textBox);
//		this.getChildren().add(cdSkill);
//		this.getChildren().add(textSkill);
		this.setMargin( this.imgView,new Insets(10,0,0,0) );
		this.setBackground( new Background( new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)) );
//		this.name.setTextAlignment(TextAlignment.CENTER);
//		
//		this.cdSkill.setTextAlignment(TextAlignment.CENTER);
//		this.textSkill.setTextAlignment(TextAlignment.CENTER);
		this.name.setFont(Font.font("verdana", FontWeight.EXTRA_BOLD , FontPosture.REGULAR, 10));
		this.cdSkill.setFont(Font.font("verdana", FontWeight.LIGHT , FontPosture.REGULAR, 10));
		this.textSkill.setFont(Font.font("verdana", FontWeight.LIGHT, FontPosture.REGULAR, 10));
		
		
		
		this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));
		this.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			public void handle(MouseEvent arg0) {
				onClickHandler();
			}
		});
		

		
	}
	
	
	public void updateSkillCard(Skill s) {
		this.skill = s;
		this.name.setText(s.getName());
		this.cdSkill.setText("Cooldown : "+s.getInCombatCd() + "/" + s.getCd());
		this.textSkill.setText("> "+s.getText());
		String imgPath = ClassLoader.getSystemResource( s.getImagePath() ).toString();
		imgView.setImage(new Image(imgPath));

	}
	
	public void onClickHandler() {
		if(!GameLogic.getInstance().isGameActive) {
			System.out.println("game END");
			return;
		}
		if(GameLogic.getInstance().stageClear() || GameLogic.getInstance().stageFail()) {
			System.out.println("Roll dice !!");
			return;
		}
		if(GameLogic.getInstance().animationRunning) {
			return;
		}
		
		
		if(this.skill == null) {
			return;
		}
		if(this.skill.readySkill()==false) {
			System.out.println("i am cd");
		}else {
			
			Unit unit = GameLogic.getInstance().getCurrentHero();
			unit.useSkill(this.skill);
			if( unit instanceof Monster ) {
			    for( Node unitCard :GameLogic.getInstance().getCombatController().getCombatDisplay().getMonsterCardBox().getChildren() ) {
			    	if ( ((UnitCard)unitCard).getUnit() == unit ) {
			    		((UnitCard)unitCard).attackAnimation();
			    		break;
			    	}
			    }
				
			}else {
				for( Node unitCard :GameLogic.getInstance().getCombatController().getCombatDisplay().getHeroesCardBox().getChildren() ) {
			    	if ( ((UnitCard)unitCard).getUnit() == unit ) {
			    		((UnitCard)unitCard).attackAnimation();
			    		break;
			    	}
			    }
			}
			//GameLogic.getInstance().getCombatController().getCombatDisplay().get
			
			GameLogic.getInstance().updateTargetPointer();
			GameLogic.getInstance().getCombatController().getCombatDisplay().updateCombatDisplay();
			GameLogic.heroAction();
		
			GameLogic.getInstance().getCombatController().getSkillPane().updateState();
			GameLogic.getInstance().getCombatController().getCombatDisplay().updatePointer();
		}

		
	}
	
	
	
}
