package component;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.util.Random;

import javafx.event.EventHandler;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;

public class Dice extends Pane{
	private ImageView diceImageView ; 
	private boolean isDisable;
	private int rolling ;
//	private final String bigDice ;
//	private final String dice1 ; 
//	private final String dice2 ; 
//	private final String dice3 ; 
//	private final String dice4 ; 
//	private final String dice5 ; 
//	private final String dice6 ; 
	public Dice() {
//		bigDice = ClassLoader.getSystemResource("image/Bigdice.png").toString();
//		dice1 = ClassLoader.getSystemResource("image/dice1.png").toString();
//		dice2 = ClassLoader.getSystemResource("image/dice2.png").toString();
//		dice3 = ClassLoader.getSystemResource("image/dice3.png").toString();
//		dice4 = ClassLoader.getSystemResource("image/dice4.png").toString();
//		dice5 = ClassLoader.getSystemResource("image/dice5.png").toString();
//		dice6 = ClassLoader.getSystemResource("image/dice6.png").toString();
		diceImageView = new ImageView();
		diceImageView.setFitHeight(100);
		diceImageView.setFitWidth(100);
		String imgPath = ClassLoader.getSystemResource("image/Bigdice.png").toString();
		
		this.diceImageView = new ImageView(new Image(imgPath));

		this.getChildren().add(diceImageView);
		this.isDisable = false ;
		setPrefHeight(100);
		setPrefWidth(100);
		setMinHeight(100);
		setMinHeight(100);
		
		this.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				onClickHandler();
			}
			
		});
	}
	

	protected void onClickHandler() {
		// TODO Auto-generated method stub
		Random random = new Random();
		Thread thread = new Thread() {
			public void run () {
				System.out.println("Thread Running");
				try {
					for (int i = 0 ; i < 15 ; i++) {
						File file = new File("image/Dice"+ (random.nextInt(6)+1)+".png");
						diceImageView.setImage(new Image(file.toURI().toString()));
						Thread.sleep(50);
					}
					isDisable = true ;
				} catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		};
		thread.start();
	}




	public int getRolling() {
		return rolling;
	}

	public void setRolling(int rolling) {
		this.rolling = rolling;
	}
	
	
}