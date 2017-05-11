package personnages;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Bienvenue extends Application {
	
	
    
    // sert a récuperer les valeurs de configuration
    
    FileReader flux;
	BufferedReader fichier;
	Properties p = new Properties();
	
	// scene ia
	Scene sceneIA;
	
	
	VBox configIA = new VBox();
	HBox plateauIA = new HBox();
	Label plateauLabelIA = new Label("Plateau");
	Label tailleLabelIA = new Label("Taille");
	Label ObstaclesLabelIA = new Label("Obstacles");
	Label equipe1IA = new Label("Equipe 1:");
	Label  equipe2IA = new Label("   IA:");
	TextField tailleSaisieIA = new TextField();
	TextField obstacleSaisieIA = new TextField();
	HBox selectorIA = new HBox();
	HBox labelEquipeIA = new HBox();
	
	HBox configTireurIA = new HBox();
	Label tireurname1IA = new Label(" Tireur");
	
	Label tireur1nbIA = new Label();
	Button bmoinsT1IA = new Button();
	Button bplusT1IA = new Button();
	
	
	HBox configPiegeurIA = new HBox();
	Label piegeurname1IA = new Label("Piegeur");
	
	Label piegeur1nbIA = new Label();
	Button bmoinsP1IA = new Button();
	Button bplusP1IA = new Button();
	
	
	HBox configCharIA = new HBox();
	Label charname1IA = new Label("   Char");
	
	Label char1nbIA = new Label();
	
	Button bmoinsC1IA = new Button();
	Button bplusC1IA = new Button();

	
	
	Slider tailleSelIA = new Slider();
	Slider obstacleSelIA = new Slider();
	
	Button jouerConfIA = new Button("Jouer");
	
	int nbT1IA;
	
	int nbP1IA;
	
	
	int nbC1IA;
	
	
	final int maxRobotIA = 5;
	int totalrobot1IA = 0;
	
	
	int obstaclesIA;
	int HxLIA;
	
	Label facile = new Label("Facile");
	Label moyen = new Label("Moyen");
	Label difficile = new Label("Difficile");
	
	CheckBox iaFacile = new CheckBox();
	CheckBox iaMoyen = new CheckBox();
	CheckBox iaDur = new CheckBox();
	
	HBox equipeIA = new HBox();
	
	
	
	
	
    
    // les différentes scenes
    Scene Scenerules;
	Scene scene;
	Scene configuration;
    
    // scene configuration
	VBox config = new VBox();
	HBox plateau = new HBox();
	Label plateauLabel = new Label("Plateau");
	Label tailleLabel = new Label("Taille");
	Label ObstaclesLabel = new Label("Obstacles");
	Label equipe1 = new Label("Equipe 1:");
	Label equipe2 = new Label("Equipe 2:");
	
	TextField tailleSaisie = new TextField();
	TextField obstacleSaisie = new TextField();
	HBox selector = new HBox();
	HBox labelEquipe = new HBox();
	
	HBox configTireur = new HBox();
	Label tireurname1 = new Label(" Tireur");
	
	Label tireur1nb = new Label();
	Label tireur2nb = new Label();
	Button bmoinsT1 = new Button();
	Button bplusT1 = new Button();
	Button bmoinsT2 = new Button();
	Button bplusT2 = new Button();
	
	HBox configPiegeur = new HBox();
	Label piegeurname1 = new Label("Piegeur");
	
	Label piegeur1nb = new Label();
	Label piegeur2nb = new Label();
	Button bmoinsP1 = new Button();
	Button bplusP1 = new Button();
	Button bmoinsP2 = new Button();
	Button bplusP2 = new Button();
	
	HBox configChar = new HBox();
	Label charname1 = new Label("   Char");
	
	Label char1nb = new Label();
	Label char2nb = new Label();
	Button bmoinsC1 = new Button();
	Button bplusC1 = new Button();
	Button bmoinsC2 = new Button();
	Button bplusC2 = new Button();
	
	
	Slider tailleSel = new Slider();
	Slider obstacleSel = new Slider();
	CheckBox ia = new CheckBox("IA");
	Button jouerConf = new Button("Jouer");
	
	int nbT1;
	int nbT2;
	
	int nbP1;
	int nbP2;
	
	int nbC1;
	int nbC2;
	
	int totalrobot1 = 0;
	int totalrobot2 = 0;
	
	int obstacles;
	int HxL;
	
	final int maxRobot = 5;
	HBox equipe = new HBox();
	
	
	// scene bienvenue
	VBox vbox= new VBox();
	VBox vBoxA = new VBox();
	HBox logo = new HBox();
	Region espace = new Region();
	Label credit = new Label("Developpé par ALT+F4 Team");
	Button jouer = new Button("Jouer");
	Button jouerIA = new Button("Joueur VS IA");
	Button regles = new Button("Règles");
	
	//scene regle
	HBox main = new HBox();
	VBox text = new VBox();
	VBox bouton = new VBox();
	Button retour = new Button("Retour");
	final String rulesString = " Les pays s'affrontent en faisant combattre des robots sur un plateau. \n Le jeu se déroule tour par tour, une équipe est choisie aléatoirement pour commencer la partie. \n Au départ les robots se trouvent dans leur base respective. \n A chaque tour de jeu, chaque équipe choisit un de ses robots pour réaliser une action (déplacement ou attaque). \n Une équipe ne peut pas passer son tour, tant qu'un de ses robots possède assez d'énergie pour réaliser \n une action elle doit jouer. \n Au cours de la partie chaque équipe doit conserver au moins un robot hors de sa base. \n La partie se termine dès qu'une des deux équipes ne possède plus de robot vivant.";

	// sert a changer la scene
	Stage global;
	

	
	
	public class onClickButton implements EventHandler <ActionEvent> {

		
		public void handle(ActionEvent event) {
			
			totalrobot1 = nbT1 + nbC1 + nbP1;
			totalrobot2 = nbT2 + nbC2 + nbP2;
			totalrobot1IA = nbT1IA + nbC1IA + nbP1IA;
			
			// changement de scene selon le bouton activé
			
			
			
			if(event.getTarget().equals(jouer)){
				
				global.setHeight(900);
				global.setWidth(800);
				global.setResizable(false);
				global.setScene(configuration);
				global.getIcons().add(new Image("file:image/icon.jpeg"));
				global.setTitle("Configuration");
				
				
				
			}
			if(event.getTarget().equals(regles)){
				
				global.setScene(Scenerules);
				global.setResizable(false);
				global.setTitle("Règles");
				global.getIcons().add(new Image("file:image/icon.jpeg"));
				
			}
			if(event.getTarget().equals(retour)){
				
				global.setScene(scene);
				global.setResizable(false);
				global.setTitle("Virtual Wars");
				global.getIcons().add(new Image("file:image/icon.jpeg"));
				
			}
			
			// bouton + ou - configuration des equipes
			if(event.getTarget().equals(bmoinsT1) && nbT1 > 0){
				nbT1 = nbT1 -1;
				tireur1nb.setText(nbT1 + "");
			}
			
			if(event.getTarget().equals(bmoinsT1IA) && nbT1IA > 0){
				nbT1IA = nbT1IA -1;
				tireur1nbIA.setText(nbT1IA + "");
			}
			
			if(event.getTarget().equals(bmoinsT2) && nbT2 > 0){
				nbT2 = nbT2 -1;
				tireur2nb.setText(nbT2 + "");
				
				
			}
			if(event.getTarget().equals(bplusT1) && totalrobot1 < maxRobot){
				nbT1 = nbT1 +1;
				tireur1nb.setText(nbT1 + "");
			}
			if(event.getTarget().equals(bplusT1IA) && totalrobot1IA < maxRobot){
				nbT1IA = nbT1IA +1;
				tireur1nbIA.setText(nbT1IA + "");
			}
			
			if(event.getTarget().equals(bplusT2) && totalrobot2 < maxRobot){
				nbT2 = nbT2 +1;
				tireur2nb.setText(nbT2 + "");
				
				
				
			}
			
			if(event.getTarget().equals(bmoinsP1) && nbP1 > 0){
				nbP1 = nbP1 - 1;
				piegeur1nb.setText(nbP1 + "");
							
			}
			
			if(event.getTarget().equals(bmoinsP1IA) && nbP1IA > 0){
				nbP1IA = nbP1IA - 1;
				piegeur1nbIA.setText(nbP1IA + "");
							
			}
			
			if(event.getTarget().equals(bmoinsP2) && nbP2 > 0){
				nbP2 = nbP2 -1;
				piegeur2nb.setText(nbP2 + "");
				
			}
			if(event.getTarget().equals(bplusP1) && totalrobot1 < maxRobot){
				nbP1 = nbP1 + 1;
				piegeur1nb.setText(nbP1 + "");
							
			}
			if(event.getTarget().equals(bplusP1IA) && totalrobot1IA < maxRobot){
				nbP1IA = nbP1IA + 1;
				piegeur1nbIA.setText(nbP1IA + "");
							
			}
			if(event.getTarget().equals(bplusP2) && totalrobot2 < maxRobot){
				nbP2 = nbP2 + 1;
				piegeur2nb.setText(nbP2 + "");
				
			}
			
			
			if(event.getTarget().equals(bmoinsC1) && nbC1 > 0){
				nbC1 = nbC1 -1;
				char1nb.setText(nbC1 + "");
				
			}
			if(event.getTarget().equals(bmoinsC1IA) && nbC1IA > 0){
				nbC1IA = nbC1IA -1;
				char1nbIA.setText(nbC1IA + "");
				
			}
			
			if(event.getTarget().equals(bmoinsC2) && nbC2 > 0){
				
				nbC2 = nbC2 -1;
				char2nb.setText(nbC2 + "");
				
			}
			if(event.getTarget().equals(bplusC1) && totalrobot1 < maxRobot){
				nbC1 = nbC1 + 1;
				char1nb.setText(nbC1 + "");
				
			}
			if(event.getTarget().equals(bplusC1IA) && totalrobot1IA < maxRobot){
				nbC1IA = nbC1IA + 1;
				char1nbIA.setText(nbC1IA + "");
				
			}
			
			if(event.getTarget().equals(bplusC2) && totalrobot2 < maxRobot){
				
				nbC2 = nbC2  +1;
				char2nb.setText(nbC2 + "");
				
			}
			if(event.getTarget().equals(jouerIA)){
				
				global.setScene(sceneIA);
				global.setHeight(900);
				global.setWidth(800);
				global.setResizable(false);
				global.setTitle("Configuration");
				global.getIcons().add(new Image("file:image/icon.jpeg"));
				
			}
			if(event.getTarget().equals(iaFacile)){
				
				iaDur.setSelected(false);
				iaMoyen.setSelected(false);
				
			}
			if(event.getTarget().equals(iaMoyen)){
				
				iaFacile.setSelected(false);
				iaDur.setSelected(false);
				
			}
			if(event.getTarget().equals(iaDur)){
				
				iaFacile.setSelected(false);
				iaMoyen.setSelected(false);
				
			}
			if(event.getTarget().equals(jouerConf)){
				
				try{
					
					PrintWriter print;
					flux = new FileReader("ressources/configuration.properties");
					print = new PrintWriter("ressources/configuration.properties");
					fichier = new BufferedReader(flux);
					p.load(flux);
					
					
					p.setProperty("equipe1.tireur", nbT1 + "");
					p.setProperty("equipe1.piegeur", nbP1 + "");
					p.setProperty("equipe1.char", nbC1 + "");
					
					p.setProperty("equipe2.tireur", nbT2 + "");
					p.setProperty("equipe2.piegeur", nbP2 + "");
					p.setProperty("equipe2.char", nbC2 + "");
					
					p.setProperty("plateau.hauteur", HxL + "");
					p.setProperty("plateau.largeur", HxL + "");
					p.setProperty("plateau.obstacle", obstacles + "");
					
					for(String mot : p.stringPropertyNames()){
						
						//System.out.println(mot +" = "+ p.getProperty(mot));
						print.print(mot +"="+p.getProperty(mot) + "\n");
					}
					
					flux.close();
					print.close();
					fichier.close();
				 
					
				}catch (Exception e){
					
				}
				
			
				
				 Platform.exit();
				 Platform.setImplicitExit(false);
				 //System.exit(0);
				 
				 
			}
	if(event.getTarget().equals(jouerConfIA)){
				
				try{
					
					PrintWriter print;
					flux = new FileReader("ressources/configuration.properties");
					print = new PrintWriter("ressources/configuration.properties");
					fichier = new BufferedReader(flux);
					p.load(flux);
					
					
					p.setProperty("equipe1.tireur", nbT1IA + "");
					p.setProperty("equipe1.piegeur", nbP1IA + "");
					p.setProperty("equipe1.char", nbC1IA + "");
					
					p.setProperty("ia.facile", iaFacile.isSelected() + "");
					p.setProperty("ia.moyen", iaMoyen.isSelected() + "");
					p.setProperty("ia.difficile", iaDur.isSelected() + "");
					
					p.setProperty("equipe2.tireur", "0");
					p.setProperty("equipe2.piegeur", "0");
					p.setProperty("equipe2.char","0");
					
					
					
					
					p.setProperty("plateau.hauteur", HxL + "");
					p.setProperty("plateau.largeur", HxL + "");
					p.setProperty("plateau.obstacle", obstacles + "");
					
					for(String mot : p.stringPropertyNames()){
						
						//System.out.println(mot +" = "+ p.getProperty(mot));
						print.print(mot +"="+p.getProperty(mot) + "\n");
					}
					
					flux.close();
					print.close();
					fichier.close();
				 
					
				}catch (Exception e){
					
				}
				
			
				
				 Platform.exit();
				 Platform.setImplicitExit(false);
				 //System.exit(0);
				 
				 
			}
			
			// action du bouton jouer
			
		}
	}
	
	public class sliderAction implements EventHandler <MouseEvent>{

	
		public void handle(MouseEvent event) {
			
			
			// slider
		
			tailleSaisie.setText((int)tailleSel.getValue() + "");
			HxL = (int)tailleSel.getValue();
			obstacleSaisie.setText((int)obstacleSel.getValue() + "");
			obstacles = (int)obstacleSel.getValue();
			
		
		}
		
	}
	
	public class sliderActionIA implements EventHandler <MouseEvent>{

		
		public void handle(MouseEvent event) {
			
			//lol
			
			tailleSaisieIA.setText((int)tailleSelIA.getValue() + "");
			HxL = (int)tailleSelIA.getValue();
			obstacleSaisieIA.setText((int)obstacleSelIA.getValue() + "");
			obstacles = (int)obstacleSelIA.getValue();
						
		}
		
	}
	
	
	public void start(Stage stage) throws Exception {
		
		
		
		
		
		// recuperation du stage..
		global = stage;
		stage.getIcons().add(new Image("file:image/icon.jpeg"));
		// scene bienvenue
		Region espace2 = new Region();
		credit.setTextFill(Color.WHITE);
		stage.setResizable(false);
		stage.setTitle("Virtual Wars");
		stage.setHeight(400);
		stage.setWidth(800);
		logo.setPadding(new Insets(25,15,15,205));
		Image ImgLogo = new Image("File:image/logoihm.png");
		logo.getChildren().add(new ImageView(ImgLogo));
		espace.setPadding(new Insets(0,10,10,10));
		espace2.setPadding(new Insets(0,10,10,10));
		
		jouer.setPadding(new Insets(10,115,10,115));
		jouerIA.setPadding(new Insets(10,92,10,92));
		regles.setPadding(new Insets(10,110,10,110));
		credit.setPadding(new Insets(80,46,100,46));
		vBoxA.setPadding(new Insets(95,150,250,270));
		vbox.getChildren().addAll(logo,vBoxA);
		vBoxA.getChildren().addAll(jouer,espace,jouerIA,espace2,regles,credit);
		Image  bg = new Image("File:image/bg.png");
		vbox.setBackground(new Background(new BackgroundImage(bg,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, null, null)));
		jouer.addEventFilter(ActionEvent.ACTION, new onClickButton());
		regles.addEventFilter(ActionEvent.ACTION, new onClickButton());
		jouerIA.addEventFilter(ActionEvent.ACTION, new onClickButton());
		
		scene = new Scene(vbox);
		
		
		
		
		// scene regle
		text.setPadding(new Insets(120,90,90,60));
		Text rules = new Text(rulesString);
		rules.setFill(Color.WHITE);
		Image  bgR = new Image("File:image/bgR.png");
		main.setBackground(new Background(new BackgroundImage(bgR,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, null, null)));
		bouton.getChildren().add(retour);
		retour.setPadding(new Insets(10,100,10,100));
		bouton.setPadding(new Insets(30,220,10,220));
		text.getChildren().addAll(rules,bouton);
		main.getChildren().addAll(text);
		retour.addEventFilter(ActionEvent.ACTION, new onClickButton());
				
		Scenerules = new Scene(main);
		
		
		
		
		// scene configuration
		plateauLabel.setPadding(new Insets(15,15,15,370));
		Region espaceTitre = new Region();
		espaceTitre.setPadding(new Insets(20,5,5,5));
		plateauLabel.setTextFill(Color.WHITE);
		tailleLabel.setPadding(new Insets(5,15,15,50));
		tailleLabel.setTextFill(Color.WHITE);
		tailleSel.setMin(5);
		tailleSel.setMax(40);
		tailleSel.setPadding(new Insets(5,20,20,20));
		
		
		
		
		ObstaclesLabel.setPadding(new Insets(5,20,20,20));
		ObstaclesLabel.setTextFill(Color.WHITE);
		obstacleSel.setMin(0);
		obstacleSel.setMax(100);
		obstacleSel.setPadding(new Insets(5,20,20,20));
		
		Region espaceSlider = new Region();
		Region espaceBouton = new Region();
		Region petitEspace = new Region(); 
		espaceBouton.setPadding(new Insets(15,210,15,15));
		espaceSlider.setPadding(new Insets(15,350,15,15));
		petitEspace.setPadding(new Insets(15,85,15,15));
		equipe1.setPadding(new Insets(5,5,5,140));
		equipe1.setTextFill(Color.WHITE);
		equipe2.setTextFill(Color.WHITE);
		equipe2.setPadding(new Insets(5,5,5,445));
		labelEquipe.getChildren().addAll(equipe1,equipe2);
		
		tailleSaisie.setText((int)tailleSel.getValue() + "");
		tailleSaisie.setEditable(false);
		obstacleSaisie.setText((int)obstacleSel.getValue() + "");
		obstacleSaisie.setEditable(false);
		
		tailleSel.addEventHandler(MouseEvent.MOUSE_DRAGGED, new sliderAction());
		tailleSel.addEventHandler(MouseEvent.MOUSE_RELEASED, new sliderAction());

		obstacleSel.addEventHandler(MouseEvent.MOUSE_DRAGGED, new sliderAction());
		obstacleSel.addEventHandler(MouseEvent.MOUSE_RELEASED, new sliderAction());
		
		HBox buttonT1 = new HBox(3);
		HBox buttonT2 =  new HBox(3);
		VBox tireur1 = new VBox();
		VBox tireur2 = new VBox();
		buttonT1.getChildren().addAll(bmoinsT1, bplusT1);
		buttonT2.getChildren().addAll(bmoinsT2, bplusT2);
		
		tireur1nb.setText("0");
		tireur2nb.setText("0");
		tireur1nb.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		tireur1nb.setStyle("-fx-background-color: beige;" + " -fx-alignment: center;" + " -fx-font: 30px Verdana;");
		tireur2nb.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		tireur2nb.setStyle("-fx-background-color: beige;" + " -fx-alignment: center;" + " -fx-font: 30px Verdana;");
		bmoinsT1.setText(" - ");
		bplusT1.setText(" + ");
		bmoinsT2.setText(" - ");
		bplusT2.setText(" + ");
		
		tireur1.getChildren().addAll(tireur1nb, buttonT1);
		tireur2.getChildren().addAll(tireur2nb,buttonT2);
		Region espaceTireur = new Region();
		espaceTireur.setPadding(new Insets(15,425,15,15));
		configTireur.setPadding(new Insets(15,15,15,135));
		configTireur.getChildren().addAll(tireur1,espaceTireur,tireur2);
		
		
		HBox buttonP1 = new HBox(3);
		HBox buttonP2 =  new HBox(3);
		VBox piegeur1 = new VBox();
		VBox piegeur2 = new VBox();
		buttonP1.getChildren().addAll(bmoinsP1, bplusP1);
		buttonP2.getChildren().addAll(bmoinsP2, bplusP2);
		
		piegeur1nb.setText("0");
		piegeur2nb.setText("0");
		piegeur1nb.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		piegeur1nb.setStyle("-fx-background-color: beige;" + " -fx-alignment: center;" + " -fx-font: 30px Verdana;");
		piegeur2nb.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		piegeur2nb.setStyle("-fx-background-color: beige;" + " -fx-alignment: center;" + " -fx-font: 30px Verdana;");
		bmoinsP1.setText(" - ");
		bplusP1.setText(" + ");
		bmoinsP2.setText(" - ");
		bplusP2.setText(" + ");
		
		piegeur1.getChildren().addAll(piegeur1nb, buttonP1);
		piegeur2.getChildren().addAll(piegeur2nb,buttonP2);
		Region espacePiegeur = new Region();
		espacePiegeur.setPadding(new Insets(15,425,15,15));
		configPiegeur.setPadding(new Insets(15,15,15,135));
		configPiegeur.getChildren().addAll(piegeur1,espacePiegeur,piegeur2);
		
		HBox buttonC1 = new HBox(3);
		HBox buttonC2 =  new HBox(3);
		VBox char1 = new VBox();
		VBox char2 = new VBox();
		buttonC1.getChildren().addAll(bmoinsC1, bplusC1);
		buttonC2.getChildren().addAll(bmoinsC2, bplusC2);
		
		char1nb.setText("0");
		char2nb.setText("0");
		char1nb.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		char1nb.setStyle("-fx-background-color: beige;" + " -fx-alignment: center;" + " -fx-font: 30px Verdana;");
		char2nb.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		char2nb.setStyle("-fx-background-color: beige;" + " -fx-alignment: center;" + " -fx-font: 30px Verdana;");
		bmoinsC1.setText(" - ");
		bplusC1.setText(" + ");
		bmoinsC2.setText(" - ");
		bplusC2.setText(" + ");
		
		tireurname1.setPadding(new Insets(15,15,15,370));
		tireurname1.setTextFill(Color.WHITE);
		piegeurname1.setPadding(new Insets(15,15,15,370));
		piegeurname1.setTextFill(Color.WHITE);
		charname1.setPadding(new Insets(15,15,15,370));
		charname1.setTextFill(Color.WHITE);
		
		
		
		char1.getChildren().addAll(char1nb, buttonC1);
		char2.getChildren().addAll(char2nb,buttonC2);
		Region espaceChar = new Region();
		espaceChar.setPadding(new Insets(15,425,15,15));
		configChar.setPadding(new Insets(15,15,15,135));
		configChar.getChildren().addAll(char1,espaceChar,char2);
		
		VBox play = new VBox();
		Region espaceJouer = new Region();
		jouerConf.setPadding(new Insets(10,90,10,90));
		espaceJouer.setPadding(new Insets(0,10,0,10));
		play.setPadding(new Insets(20,10,10,290));
		play.getChildren().addAll(espaceJouer,jouerConf);
		
		Image bgconf = new Image("File:image/bgconf.jpg");
		config.setBackground(new Background(new BackgroundImage(bgconf,BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, null, null)));
		
		bmoinsT1.addEventFilter(ActionEvent.ACTION, new onClickButton());
		bplusT1.addEventFilter(ActionEvent.ACTION, new onClickButton());
		bmoinsT2.addEventFilter(ActionEvent.ACTION, new onClickButton());
		bplusT2.addEventFilter(ActionEvent.ACTION, new onClickButton());
		
		bmoinsP1.addEventFilter(ActionEvent.ACTION, new onClickButton());
		bplusP1.addEventFilter(ActionEvent.ACTION, new onClickButton());
		bmoinsP2.addEventFilter(ActionEvent.ACTION, new onClickButton());
		bplusP2.addEventFilter(ActionEvent.ACTION, new onClickButton());
		
		bmoinsC1.addEventFilter(ActionEvent.ACTION, new onClickButton());
		bplusC1.addEventFilter(ActionEvent.ACTION, new onClickButton());
		bmoinsC2.addEventFilter(ActionEvent.ACTION, new onClickButton());
		bplusC2.addEventFilter(ActionEvent.ACTION, new onClickButton());
		jouerConf.addEventFilter(ActionEvent.ACTION, new onClickButton());
		
		selector.getChildren().addAll(petitEspace,tailleSel,espaceSlider,obstacleSel);
		
		plateau.getChildren().addAll(tailleLabel,tailleSaisie,espaceBouton,ObstaclesLabel,obstacleSaisie);
		
		config.getChildren().addAll(plateauLabel,espaceTitre,plateau,selector,labelEquipe,tireurname1,configTireur,piegeurname1,configPiegeur,charname1,configChar,play);
		configuration = new Scene(config);
		
		
		// scene ia
		
		plateauLabelIA.setPadding(new Insets(15,15,15,370));
		Region espaceTitreIA = new Region();
		espaceTitreIA.setPadding(new Insets(20,5,5,5));
		plateauLabelIA.setTextFill(Color.WHITE);
		tailleLabelIA.setPadding(new Insets(5,15,15,50));
		tailleLabelIA.setTextFill(Color.WHITE);
		tailleSelIA.setMin(5);
		tailleSelIA.setMax(40);
		tailleSelIA.setPadding(new Insets(5,20,20,20));
		
		
		
		
		ObstaclesLabelIA.setPadding(new Insets(5,20,20,20));
		ObstaclesLabelIA.setTextFill(Color.WHITE);
		obstacleSelIA.setMin(0);
		obstacleSelIA.setMax(100);
		obstacleSelIA.setPadding(new Insets(5,20,20,20));
		
		Region espaceSliderIA = new Region();
		Region espaceBoutonIA = new Region();
		Region petitEspaceIA = new Region(); 
		espaceBoutonIA.setPadding(new Insets(15,210,15,15));
		espaceSliderIA.setPadding(new Insets(15,350,15,15));
		petitEspaceIA.setPadding(new Insets(15,85,15,15));
		equipe1IA.setPadding(new Insets(5,5,5,140));
		equipe1IA.setTextFill(Color.WHITE);
		equipe2IA.setTextFill(Color.WHITE);
		equipe2IA.setPadding(new Insets(5,5,5,445));
		labelEquipeIA.getChildren().addAll(equipe1IA,equipe2IA);
		
		tailleSaisieIA.setText((int)tailleSelIA.getValue() + "");
		tailleSaisieIA.setEditable(false);
		obstacleSaisieIA.setText((int)obstacleSelIA.getValue() + "");
		obstacleSaisieIA.setEditable(false);
		
		tailleSelIA.addEventHandler(MouseEvent.MOUSE_DRAGGED, new sliderActionIA());
		tailleSelIA.addEventHandler(MouseEvent.MOUSE_RELEASED, new sliderActionIA());

		obstacleSelIA.addEventHandler(MouseEvent.MOUSE_DRAGGED, new sliderActionIA());
		obstacleSelIA.addEventHandler(MouseEvent.MOUSE_RELEASED, new sliderActionIA());
		
		HBox buttonT1IA = new HBox(3);
		HBox buttonT2IA =  new HBox(3);
		VBox tireur1IA = new VBox();
		VBox tireur2IA = new VBox();
		buttonT1IA.getChildren().addAll(bmoinsT1IA, bplusT1IA);
		
		
		tireur1nbIA.setText("0");
		
		tireur1nbIA.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		tireur1nbIA.setStyle("-fx-background-color: beige;" + " -fx-alignment: center;" + " -fx-font: 30px Verdana;");
		
		bmoinsT1IA.setText(" - ");
		bplusT1IA.setText(" + ");
		
		
		tireur1IA.getChildren().addAll(tireur1nbIA, buttonT1IA);
		
		Region espaceTireurIA = new Region();
		espaceTireurIA.setPadding(new Insets(15,415,15,15));
		configTireurIA.setPadding(new Insets(15,15,15,135));
		configTireurIA.getChildren().addAll(tireur1IA,espaceTireurIA,facile,iaFacile);
		
		
		HBox buttonP1IA = new HBox(3);
		HBox buttonP2IA =  new HBox(3);
		VBox piegeur1IA = new VBox();
		VBox piegeur2IA = new VBox();
		buttonP1IA.getChildren().addAll(bmoinsP1IA, bplusP1IA);
		
		piegeur1nbIA.setText("0");
		
		piegeur1nbIA.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		piegeur1nbIA.setStyle("-fx-background-color: beige;" + " -fx-alignment: center;" + " -fx-font: 30px Verdana;");
		
		bmoinsP1IA.setText(" - ");
		bplusP1IA.setText(" + ");
		
		
		piegeur1IA.getChildren().addAll(piegeur1nbIA, buttonP1IA);
		
		Region espacePiegeurIA = new Region();
		espacePiegeurIA.setPadding(new Insets(15,415,15,15));
		configPiegeurIA.setPadding(new Insets(15,15,15,135));
		configPiegeurIA.getChildren().addAll(piegeur1IA,espacePiegeurIA,moyen,iaMoyen);
		
		HBox buttonC1IA = new HBox(3);
		HBox buttonC2IA =  new HBox(3);
		VBox char1IA = new VBox();
		VBox char2IA = new VBox();
		buttonC1IA.getChildren().addAll(bmoinsC1IA, bplusC1IA);
		
		
		char1nbIA.setText("0");
		char1nbIA.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		char1nbIA.setStyle("-fx-background-color: beige;" + " -fx-alignment: center;" + " -fx-font: 30px Verdana;");
		
		
		bmoinsC1IA.setText(" - ");
		bplusC1IA.setText(" + ");
		facile.setTextFill(Color.WHITE);		
		moyen.setTextFill(Color.WHITE);
		difficile.setTextFill(Color.WHITE);
		
		tireurname1IA.setPadding(new Insets(15,15,15,145));
		tireurname1IA.setTextFill(Color.WHITE);
		piegeurname1IA.setPadding(new Insets(15,15,15,145));
		piegeurname1IA.setTextFill(Color.WHITE);
		charname1IA.setPadding(new Insets(15,15,15,145));
		charname1IA.setTextFill(Color.WHITE);
		
		
		
		char1IA.getChildren().addAll(char1nbIA, buttonC1IA);
		
		Region espaceCharIA = new Region();
		espaceCharIA.setPadding(new Insets(15,415,15,15));
		configCharIA.setPadding(new Insets(15,15,15,135));
		configCharIA.getChildren().addAll(char1IA,espaceCharIA,difficile,iaDur);
		
		VBox playIA = new VBox();
		Region espaceJouerIA = new Region();
		jouerConfIA.setPadding(new Insets(10,90,10,90));
		espaceJouerIA.setPadding(new Insets(0,10,0,10));
		playIA.setPadding(new Insets(20,10,10,290));
		playIA.getChildren().addAll(espaceJouerIA,jouerConfIA);
		
		Image bgconfIA = new Image("File:image/bgconf.jpg");
		configIA.setBackground(new Background(new BackgroundImage(bgconfIA,BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, null, null)));
		
		bmoinsT1IA.addEventFilter(ActionEvent.ACTION, new onClickButton());
		bplusT1IA.addEventFilter(ActionEvent.ACTION, new onClickButton());
		
				
		bmoinsP1IA.addEventFilter(ActionEvent.ACTION, new onClickButton());
		bplusP1IA.addEventFilter(ActionEvent.ACTION, new onClickButton());
		
		
		
		bmoinsC1IA.addEventFilter(ActionEvent.ACTION, new onClickButton());
		bplusC1IA.addEventFilter(ActionEvent.ACTION, new onClickButton());
		
		
		jouerConfIA.addEventFilter(ActionEvent.ACTION, new onClickButton());
		
		iaFacile.addEventFilter(ActionEvent.ACTION, new onClickButton());
		iaMoyen.addEventFilter(ActionEvent.ACTION, new onClickButton());
		iaDur.addEventFilter(ActionEvent.ACTION, new onClickButton());
		
		
		
		
		selectorIA.getChildren().addAll(petitEspaceIA,tailleSelIA,espaceSliderIA,obstacleSelIA);
		
		plateauIA.getChildren().addAll(tailleLabelIA,tailleSaisieIA,espaceBoutonIA,ObstaclesLabelIA,obstacleSaisieIA);
		
		configIA.getChildren().addAll(plateauLabelIA,espaceTitreIA,plateauIA,selectorIA,labelEquipeIA,tireurname1IA,configTireurIA,piegeurname1IA,configPiegeurIA,charname1IA,configCharIA,playIA);
		sceneIA = new Scene(configIA);
		
		
	
		
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
		    @Override
		    public void handle(WindowEvent event) {
		        try {
					stop();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		});
		
		
		// utile au lancement
		stage.setScene(scene);
		stage.show();
		
	
	}
	
	public static void main(String[] args){
		Application.launch(args);
		
	}

		

	}
