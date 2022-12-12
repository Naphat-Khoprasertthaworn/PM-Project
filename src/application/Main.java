package application;

import java.util.ArrayList;
import java.util.Scanner;

import javax.management.Notification;

import org.junit.platform.launcher.Launcher;

import entity.base.Unit;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import logic.GameLogic;
import sound.SoundManager;

//public class Main extends Application  {
public class Main  extends Application{
	private static Scanner keyBoard;
//	private static boolean isGameActive;
//	private static boolean isCombatMode;
//	private static boolean isHeroTurn;
//	private static boolean isStageFail;
//	private static boolean isStageClear;
//	private static int heroOrder;
	
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/gui/MenuScene.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Progmeth-project");
			primaryStage.setResizable(false);
			SoundManager.setCurrentBGM("audio/MenuBGM.wav",0.1);
			primaryStage.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	
	
//	public static void main(String[] args) {
//		
//		
//		keyBoard = new Scanner(System.in);
//		
//		while(true){
//			System.out.println("=============================");
//			System.out.println("Welcome to");
//			System.out.println("Overdue! All You Can Rush");
//			System.out.println("=============================");
//			System.out.println("What are you doing?");
//			System.out.println("1) Start Game");
//			System.out.println("2) Quit");
//			System.out.println("=============================");
//			int results = getChoice();
//			
//			if(results==1) {
//				//System.out.println("=============================");
//				startGame();
//			}else if(results==2){
//				break;
//			}else {
//				System.out.println("Invalid Input, Terminate the game.");
//				break;
//			}
//		}
//	}
	
//	public static int getChoice() {
//		System.out.print(">> ");
//		String input = keyBoard.nextLine();
//		try{
//			return Integer.parseInt(input);
//		}catch(NumberFormatException e){
//            return -1;
//        }
//	}
	
	
//	public static void startGame() {
//		//System.out.println("check this");
//		isGameActive = true;
//		GameLogic.getInstance().newGame();
//		startStage();
//	}
//	
//	public static void startStage() {
//		int ni = GameLogic.getInstance().rollDice();
//		Boolean isBossStage = GameLogic.getInstance().setDistance( GameLogic.getInstance().getDistance() + ni);
//		System.out.println( "distance NOW : "+GameLogic.getInstance().getDistance() );
//		
//		if(isBossStage) {
//			GameLogic.getInstance().generateBossStage();
//		}else {
//			GameLogic.getInstance().generateMonsters();
//		}
//		
//		GameLogic.getInstance().startStage();
//		isStageClear = false;
//		isStageFail = false;
//		isCombatMode = true;
//		heroOrder = 0;
//		//playerTurn();
//		GameLogic.getInstance().setCurrentHero( GameLogic.getInstance().getHeros().get(heroOrder) );
//	}
//	
//	public static void heroAction() {
//		//ArrayList<Unit> heros = GameLogic.getInstance().getHeros();
//		if(heroOrder > 2) {
//			heroOrder = 0;
//			monsterTurn();
//			return;
//		}
//		
//		updateStageGame();
//		if(isStageClear) {
//			startStage();
//			return;
//		}
//		
//		heroOrder++;
//		
//		Unit heroUnit;
//		while(heroOrder<3) {
//			heroUnit = GameLogic.getInstance().getHeros().get(heroOrder);
//			if(heroUnit.isAlive()) {
//				break;
//			}
//			else {
//				heroOrder++;
//			}
//		}
//		if(heroOrder > 2) {
//			heroOrder = 0;
//			monsterTurn();
//			return;
//		}
//		
//		
//		GameLogic.getInstance().setCurrentHero( GameLogic.getInstance().getHeros().get(heroOrder) );
//		
//	}
//	
//	public static void monsterTurn() {
//		ArrayList<Unit> monsters = GameLogic.getInstance().getMonsters();
//		Unit monster;
//		for(int i = 0;i<monsters.size();i++) {
//			
//			monster = GameLogic.getInstance().getUnitByPosition(i,monsters);
//			if(!monster.isAlive()) {
//				continue;
//			}
//			
//			monster.useSkill(null);
//			updateStageGame();
//			if(isStageFail) {
//				isGameActive = false;
//				return;
//			}
//			
//		}
//		
//		GameLogic.getInstance().countdownGame();
//	}
//
//	
//	
//	public static void updateStageGame() {
//		isStageClear = GameLogic.getInstance().stageClear();
//		isStageFail = GameLogic.getInstance().stageFail();
//	}
//	
//	public static void collectItem() {
//		GameLogic.getInstance().generateItemDrop();
//	//System.out.println("is work");
//	//GameLogic.getInstance().showInventory();
//	//System.out.println("is2 work");
//	}
	
	
//	public static void playerTurn() {
//	System.out.println( "* * * * * * * * * * * * PLAYER TURN *  * * * * * * * * * **" );
//	ArrayList<Unit> heros = GameLogic.getInstance().getHeros();
//	Unit hero;
//	for(int i = 0;i<heros.size();i++) {
//		showCombat();
//		hero = GameLogic.getInstance().getUnitByPosition(i,heros);
//		isHeroTurn = true;
//		
//		System.out.println( "|| "+hero.getName() + " Turn ||" );
//		
//		if(!hero.isAlive()) {
//			continue;
//		}
//		
//		while(isHeroTurn) {
//			int order = getChoice();
//			if(hero.getSkills().get(order).readySkill()) {
//				hero.useSkill(null); // <- fix this later
//				GameLogic.getInstance().updateTargetPointer();
//				isHeroTurn = false;
//			}else {
//				System.out.println("skill is not ready");
//			}
//			
//		}
//		updateStageGame();
//		if(isStageClear || isStageFail) {
//			return;
//		}
//		
//	}
//	
//}
	

	
	
//	public static void startGame() {
//		isGameActive = true;
//		GameLogic.getInstance().newGame();
//		
//		while(isGameActive) {
//			int ni = GameLogic.getInstance().rollDice();
//			Boolean isBossStage = GameLogic.getInstance().setDistance( GameLogic.getInstance().getDistance() + ni);
//			System.out.println( "distance NOW : "+GameLogic.getInstance().getDistance() );
//			if(isBossStage) {
//				GameLogic.getInstance().generateBossStage();
//			}else {
//				GameLogic.getInstance().generateMonsters();
//			}
//			GameLogic.getInstance().startStage();
//			isStageClear = false;
//			isStageFail = false;
//			isCombatMode = true;
//			while(isCombatMode) {
//				playerTurn();
//				monsterTurn();
//				GameLogic.getInstance().countdownGame();
//				if(isStageClear) {
//					GameLogic.getInstance().resetUnits();
//					if(isBossStage) {
//						System.err.println("GAME END !!! You WIN");
//						isGameActive = false;
//						return;
//					}
//					collectItem();
//					break;
//				}else if(isStageFail) {
//					isGameActive = false;
//					GameLogic.getInstance().resetUnits();
//					System.out.println("You died");
//					return;
//				}
//			}
//		}
//	}
//	

//	
//	public static void showCombat() {
//		System.out.println("======================== Monsters =========================");
//		ArrayList<Unit> monsters = GameLogic.getInstance().getMonsters();
//		ArrayList<Unit> heros = GameLogic.getInstance().getHeros();
//		for(int i = 0;i<monsters.size();i++) {
//			System.out.println("---------------------------- "+ monsters.get(i).getPosition() +" ----------------------------" );
//			System.out.println( monsters.get(i) );
//			System.out.println("------------------------- Skills --------------------------" );
//			System.out.println( monsters.get(i).getSkills() );
//		}
//		System.out.println("========================== Heros ==========================");
//		for(int i = 0;i<heros.size();i++) {
//			System.out.println("---------------------------- "+ heros.get(i).getPosition() +" ----------------------------" );
//			System.out.println( heros.get(i) );
//			System.out.println("------------------------- Skills --------------------------" );
//			System.out.println( heros.get(i).getSkills() );
//		}
//	}
//	
//	
//	
//	public static void playerTurn() {
//		System.out.println( "* * * * * * * * * * * * PLAYER TURN *  * * * * * * * * * **" );
//		ArrayList<Unit> heros = GameLogic.getInstance().getHeros();
//		Unit hero;
//		for(int i = 0;i<heros.size();i++) {
//			showCombat();
//			hero = GameLogic.getInstance().getUnitByPosition(i,heros);
//			isHeroTurn = true;
//			
//			System.out.println( "|| "+hero.getName() + " Turn ||" );
//			
//			if(!hero.isAlive()) {
//				continue;
//			}
//			
//			while(isHeroTurn) {
//				int order = getChoice();
//				if(hero.getSkills().get(order).readySkill()) {
//					hero.useSkill(null); // <- fix this later
//					GameLogic.getInstance().updateTargetPointer();
//					isHeroTurn = false;
//				}else {
//					System.out.println("skill is not ready");
//				}
//				
//			}
//			updateStageGame();
//			if(isStageClear || isStageFail) {
//				return;
//			}
//			
//		}
//		
//	}
//	
//	public static void monsterTurn() {
//		System.out.println( "* * * * * * * * * * * * MONSTER TURN * * * * * * * * * * **" );
//		ArrayList<Unit> monsters = GameLogic.getInstance().getMonsters();
//		Unit monster;
//		for(int i = 0;i<monsters.size();i++) {
//			
//			monster = GameLogic.getInstance().getUnitByPosition(i,monsters);
//			if(!monster.isAlive()) {
//				continue;
//			}
//			showCombat();
//			monster.useSkill(null);
//			updateStageGame();
//			if(isStageClear || isStageFail) {
//				return;
//			}
//			
//		}
//
//	}
//	
//	public static void collectItem() {
//		GameLogic.getInstance().generateItemDrop();
//		//System.out.println("is work");
//		GameLogic.getInstance().showInventory();
//		//System.out.println("is2 work");
//	}
}
