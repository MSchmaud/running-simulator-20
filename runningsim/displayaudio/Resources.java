package us.mschmaud.runningsim.displayaudio;

import java.awt.Font;
import java.awt.image.BufferedImage;
import us.mschmaud.runningsim.utils.Tools;

/**
 * 
 * @author Michael Schmauderer
 *
 */

public class Resources {

	private static final int WIDTH = 32, HEIGHT = 32, IMG_BTN_WIDTH = 192, IMG_BTN_HEIGHT = 64;
	public static BufferedImage spritesheet, dirt, grass, stone, border, wood, woodFloor, water, stoneFloor, optScreen, backgr, helpScreen;
	public static BufferedImage jamirbb, jamirbg, jamirbr, jamirpb, jamirpg, jamirpr, jamirwb, jamirwg, jamirwr;
	public static BufferedImage joebb, joebg, joebr, joepb, joepg, joepr, joewb, joewg, joewr;
	public static BufferedImage karenbb, karenbg, karenbr, karenpb, karenpg, karenpr, karenwb, karenwg, karenwr;
	public static BufferedImage jadabb, jadabg, jadabr, jadapb, jadapg, jadapr, jadawb, jadawg, jadawr;
	public static BufferedImage zombiew, zombieb, zombieg, zombiep, fastZombie;
	public static BufferedImage txtBtn;
	public static BufferedImage[] titleScreen, play, options, quit, resume;
	
	public static BufferedImage coinSheet, coffeeSheet;
	public static BufferedImage[] coin, coffee;
	
	public static BufferedImage[] zombiewDown, zombiewUp, zombiewLeft, zombiewRight;
	public static BufferedImage[] zombiebDown, zombiebUp, zombiebLeft, zombiebRight;
	public static BufferedImage[] zombiegDown, zombiegUp, zombiegLeft, zombiegRight;
	public static BufferedImage[] zombiepDown, zombiepUp, zombiepLeft, zombiepRight;
	public static BufferedImage[] fastZombieDown, fastZombieUp, fastZombieLeft, fastZombieRight;
	
	public static BufferedImage spawnerOff, spawnerOn;
	public static BufferedImage[] spawner;
	
	public static BufferedImage[] jamirbbDown, jamirbbUp, jamirbbLeft, jamirbbRight;
	public static BufferedImage[] jamirbgDown, jamirbgUp, jamirbgLeft, jamirbgRight;
	public static BufferedImage[] jamirbrDown, jamirbrUp, jamirbrLeft, jamirbrRight;
	public static BufferedImage[] jamirpbDown, jamirpbUp, jamirpbLeft, jamirpbRight;
	public static BufferedImage[] jamirpgDown, jamirpgUp, jamirpgLeft, jamirpgRight;
	public static BufferedImage[] jamirprDown, jamirprUp, jamirprLeft, jamirprRight;
	public static BufferedImage[] jamirwbDown, jamirwbUp, jamirwbLeft, jamirwbRight;
	public static BufferedImage[] jamirwgDown, jamirwgUp, jamirwgLeft, jamirwgRight;
	public static BufferedImage[] jamirwrDown, jamirwrUp, jamirwrLeft, jamirwrRight;
	
	public static BufferedImage[] joebbDown, joebbUp, joebbLeft, joebbRight;
	public static BufferedImage[] joebgDown, joebgUp, joebgLeft, joebgRight;
	public static BufferedImage[] joebrDown, joebrUp, joebrLeft, joebrRight;
	public static BufferedImage[] joepbDown, joepbUp, joepbLeft, joepbRight;
	public static BufferedImage[] joepgDown, joepgUp, joepgLeft, joepgRight;
	public static BufferedImage[] joeprDown, joeprUp, joeprLeft, joeprRight;
	public static BufferedImage[] joewbDown, joewbUp, joewbLeft, joewbRight;
	public static BufferedImage[] joewgDown, joewgUp, joewgLeft, joewgRight;
	public static BufferedImage[] joewrDown, joewrUp, joewrLeft, joewrRight;
	
	public static BufferedImage[] karenbbDown, karenbbUp, karenbbLeft, karenbbRight;
	public static BufferedImage[] karenbgDown, karenbgUp, karenbgLeft, karenbgRight;
	public static BufferedImage[] karenbrDown, karenbrUp, karenbrLeft, karenbrRight;
	public static BufferedImage[] karenpbDown, karenpbUp, karenpbLeft, karenpbRight;
	public static BufferedImage[] karenpgDown, karenpgUp, karenpgLeft, karenpgRight;
	public static BufferedImage[] karenprDown, karenprUp, karenprLeft, karenprRight;
	public static BufferedImage[] karenwbDown, karenwbUp, karenwbLeft, karenwbRight;
	public static BufferedImage[] karenwgDown, karenwgUp, karenwgLeft, karenwgRight;
	public static BufferedImage[] karenwrDown, karenwrUp, karenwrLeft, karenwrRight;
	
	public static BufferedImage[] jadabbDown, jadabbUp, jadabbLeft, jadabbRight;
	public static BufferedImage[] jadabgDown, jadabgUp, jadabgLeft, jadabgRight;
	public static BufferedImage[] jadabrDown, jadabrUp, jadabrLeft, jadabrRight;
	public static BufferedImage[] jadapbDown, jadapbUp, jadapbLeft, jadapbRight;
	public static BufferedImage[] jadapgDown, jadapgUp, jadapgLeft, jadapgRight;
	public static BufferedImage[] jadaprDown, jadaprUp, jadaprLeft, jadaprRight;
	public static BufferedImage[] jadawbDown, jadawbUp, jadawbLeft, jadawbRight;
	public static BufferedImage[] jadawgDown, jadawgUp, jadawgLeft, jadawgRight;
	public static BufferedImage[] jadawrDown, jadawrUp, jadawrLeft, jadawrRight;
	
	public static Font txtBtnFont, smTxtBtnFont, infoFont, alertFont, scoresFont;
	
	public static String hitSound, coinSound, deathSound, drinkSound;
	
	public static void loadResources() {
		// Sounds
		hitSound = "assets/sounds/hit.wav";
		coinSound = "assets/sounds/coin.wav";
		deathSound = "assets/sounds/death.wav";
		drinkSound = "assets/sounds/drink.wav";
		
		// Tiles
		spritesheet = Tools.loadImage("assets/textures/sprites.png");
		dirt = spritesheet.getSubimage((IMG_BTN_WIDTH*2), 0, WIDTH, HEIGHT);
		grass = spritesheet.getSubimage((IMG_BTN_WIDTH*2)+WIDTH, 0, WIDTH, HEIGHT);
		stone = spritesheet.getSubimage((IMG_BTN_WIDTH*2)+(WIDTH*2), 0, WIDTH, HEIGHT);
		water = spritesheet.getSubimage((IMG_BTN_WIDTH*2)+(WIDTH*3), 0, WIDTH, HEIGHT);
		woodFloor = spritesheet.getSubimage((IMG_BTN_WIDTH*2)+(WIDTH*4), 0, WIDTH, HEIGHT);
		border = spritesheet.getSubimage((IMG_BTN_WIDTH*6)+(WIDTH*5), 0, WIDTH, HEIGHT);
		stoneFloor = spritesheet.getSubimage((IMG_BTN_WIDTH*6)+(WIDTH*6), 0, WIDTH, HEIGHT);
		wood = spritesheet.getSubimage((IMG_BTN_WIDTH*6)+(WIDTH*7), 0, WIDTH, HEIGHT);
		
		// Item sheets
		coinSheet = Tools.loadImage("assets/items/[RS20] Coin.png");
		coffeeSheet = Tools.loadImage("assets/items/[RS20] Coffee.png");
		
		// Mob sheets
		spawnerOff = Tools.loadImage("assets/mobs/spawner/[RS20] Spawner-1.png.png");
		spawnerOn = Tools.loadImage("assets/mobs/spawner/[RS20] Spawner-2.png.png");
		zombiew = Tools.loadImage("assets/mobs/zombie/[RS20] Zombie white.png");
		zombieb = Tools.loadImage("assets/mobs/zombie/[RS20] Zombie blue.png");
		zombieg = Tools.loadImage("assets/mobs/zombie/[RS20] Zombie green.png");
		zombiep = Tools.loadImage("assets/mobs/zombie/[RS20] Zombie pink.png");
		fastZombie = Tools.loadImage("assets/mobs/fastZombie/[RS20] Fast Zombie.png");
		
		// Player sheets
		jamirbb = Tools.loadImage("assets/characters/jamir/blue/blue/[RS20] Jamir blue blue.png");
		jamirbg = Tools.loadImage("assets/characters/jamir/blue/gold/[RS20] Jamir blue gold.png");
		jamirbr = Tools.loadImage("assets/characters/jamir/blue/red/[RS20] Jamir blue red.png");
		jamirpb = Tools.loadImage("assets/characters/jamir/pink/blue/[RS20] Jamir pink blue.png");
		jamirpg = Tools.loadImage("assets/characters/jamir/pink/gold/[RS20] Jamir pink gold.png");
		jamirpr = Tools.loadImage("assets/characters/jamir/pink/red/[RS20] Jamir pink red.png");
		jamirwb = Tools.loadImage("assets/characters/jamir/white/blue/[RS20] Jamir white blue.png");
		jamirwg = Tools.loadImage("assets/characters/jamir/white/gold/[RS20] Jamir white gold.png");
		jamirwr = Tools.loadImage("assets/characters/jamir/white/red/[RS20] Jamir white red.png");
		//-----------------------------------------------------------------------------------------
		joebb = Tools.loadImage("assets/characters/joe/blue/blue/[RS20] Joe blue blue.png");
		joebg = Tools.loadImage("assets/characters/joe/blue/gold/[RS20] Joe blue gold.png");
		joebr = Tools.loadImage("assets/characters/joe/blue/red/[RS20] Joe blue red.png");
		joepb = Tools.loadImage("assets/characters/joe/pink/blue/[RS20] Joe pink blue.png");
		joepg = Tools.loadImage("assets/characters/joe/pink/gold/[RS20] Joe pink gold.png");
		joepr = Tools.loadImage("assets/characters/joe/pink/red/[RS20] Joe pink red.png");
		joewb = Tools.loadImage("assets/characters/joe/white/blue/[RS20] Joe white blue.png");
		joewg = Tools.loadImage("assets/characters/joe/white/gold/[RS20] Joe white gold.png");
		joewr = Tools.loadImage("assets/characters/joe/white/red/[RS20] Joe white red.png");
		//-----------------------------------------------------------------------------------------
		jadabb = Tools.loadImage("assets/characters/jada/blue/blue/[RS20] Jada blue blue.png");
		jadabg = Tools.loadImage("assets/characters/jada/blue/gold/[RS20] Jada blue gold.png");
		jadabr = Tools.loadImage("assets/characters/jada/blue/red/[RS20] Jada blue red.png");
		jadapb = Tools.loadImage("assets/characters/jada/pink/blue/[RS20] Jada pink blue.png");
		jadapg = Tools.loadImage("assets/characters/jada/pink/gold/[RS20] Jada pink gold.png");
		jadapr = Tools.loadImage("assets/characters/jada/pink/red/[RS20] Jada pink red.png");
		jadawb = Tools.loadImage("assets/characters/jada/white/blue/[RS20] Jada white blue.png");
		jadawg = Tools.loadImage("assets/characters/jada/white/gold/[RS20] Jada white gold.png");
		jadawr = Tools.loadImage("assets/characters/jada/white/red/[RS20] Jada white red.png");
		//-----------------------------------------------------------------------------------------
		karenbb = Tools.loadImage("assets/characters/karen/blue/blue/[RS20] Karen blue blue.png");
		karenbg = Tools.loadImage("assets/characters/karen/blue/gold/[RS20] Karen blue gold.png");
		karenbr = Tools.loadImage("assets/characters/karen/blue/red/[RS20] Karen blue red.png");
		karenpb = Tools.loadImage("assets/characters/karen/pink/blue/[RS20] Karen pink blue.png");
		karenpg = Tools.loadImage("assets/characters/karen/pink/gold/[RS20] Karen pink gold.png");
		karenpr = Tools.loadImage("assets/characters/karen/pink/red/[RS20] Karen pink red.png");
		karenwb = Tools.loadImage("assets/characters/karen/white/blue/[RS20] Karen white blue.png");
		karenwg = Tools.loadImage("assets/characters/karen/white/gold/[RS20] Karen white gold.png");
		karenwr = Tools.loadImage("assets/characters/karen/white/red/[RS20] Karen white red.png");
		
		// Fonts
		txtBtnFont = new Font("Verdana", Font.BOLD, 40);
		smTxtBtnFont = new Font("Verdana", Font.BOLD, 35);
		alertFont = new Font("Verdana", Font.BOLD, 20);
		infoFont = new Font("Verdana", Font.BOLD, 30);
		scoresFont = new Font("Verdana", Font.PLAIN, 30);
		
		// Buttons
		txtBtn = spritesheet.getSubimage((IMG_BTN_WIDTH*6)+(WIDTH*8), 0, IMG_BTN_WIDTH, IMG_BTN_HEIGHT);
		
		play = new BufferedImage[2];
		play[0] = spritesheet.getSubimage(0, 0, IMG_BTN_WIDTH, IMG_BTN_HEIGHT);
		play[1] = spritesheet.getSubimage(IMG_BTN_WIDTH, 0, IMG_BTN_WIDTH, IMG_BTN_HEIGHT);
		
		options = new BufferedImage[2];
		options[0] = spritesheet.getSubimage((IMG_BTN_WIDTH*2)+(WIDTH*5), 0, IMG_BTN_WIDTH, IMG_BTN_HEIGHT);
		options[1] = spritesheet.getSubimage((IMG_BTN_WIDTH*3)+(WIDTH*5), 0, IMG_BTN_WIDTH, IMG_BTN_HEIGHT);
		
		quit = new BufferedImage[2];
		quit[0] = spritesheet.getSubimage((IMG_BTN_WIDTH*4)+(WIDTH*5), 0, IMG_BTN_WIDTH, IMG_BTN_HEIGHT);
		quit[1] = spritesheet.getSubimage((IMG_BTN_WIDTH*5)+(WIDTH*5), 0, IMG_BTN_WIDTH, IMG_BTN_HEIGHT);
		
		// Backgrounds
		titleScreen = new BufferedImage[2];
		titleScreen[0] = Tools.loadImage("assets/textures/screens/title0.png");
		titleScreen[1] = Tools.loadImage("assets/textures/screens/title1.png");
		
		backgr = Tools.loadImage("assets/textures/screens/back.png");
		optScreen = Tools.loadImage("assets/textures/screens/optScreen.png");
		helpScreen = Tools.loadImage("assets/textures/screens/help.png");
		
		// Items ---------------------------------------------------------------
		
		// Coin
		coin = new BufferedImage[8];
		coin[0] = coinSheet.getSubimage(0, 0, WIDTH, HEIGHT);
		coin[1] = coinSheet.getSubimage(WIDTH, 0, WIDTH, HEIGHT);
		coin[2] = coinSheet.getSubimage(WIDTH*2, 0, WIDTH, HEIGHT);
		coin[3] = coinSheet.getSubimage(0, HEIGHT, WIDTH, HEIGHT);
		coin[4] = coinSheet.getSubimage(WIDTH, HEIGHT, WIDTH, HEIGHT);
		coin[5] = coinSheet.getSubimage(WIDTH*2, HEIGHT, WIDTH, HEIGHT);
		coin[6] = coinSheet.getSubimage(0, HEIGHT*2, WIDTH, HEIGHT);
		coin[7] = coinSheet.getSubimage(WIDTH, HEIGHT*2, WIDTH, HEIGHT);
		
		// Coffee
		coffee = new BufferedImage[8];
		coffee[0] = coffeeSheet.getSubimage(0, 0, WIDTH, HEIGHT);
		coffee[1] = coffeeSheet.getSubimage(WIDTH, 0, WIDTH, HEIGHT);
		coffee[2] = coffeeSheet.getSubimage(WIDTH*2, 0, WIDTH, HEIGHT);
		coffee[3] = coffeeSheet.getSubimage(0, HEIGHT, WIDTH, HEIGHT);
		coffee[4] = coffeeSheet.getSubimage(WIDTH, HEIGHT, WIDTH, HEIGHT);
		coffee[5] = coffeeSheet.getSubimage(WIDTH*2, HEIGHT, WIDTH, HEIGHT);
		coffee[6] = coffeeSheet.getSubimage(0, HEIGHT*2, WIDTH, HEIGHT);
		coffee[7] = coffeeSheet.getSubimage(WIDTH, HEIGHT*2, WIDTH, HEIGHT);
		
		// Mobs ----------------------------------------------------------------
		
		// Spawner
		spawner = new BufferedImage[2];
		spawner[0] = spawnerOff;
		spawner[1] = spawnerOn;
		
		// White Zombie
		zombiewDown = new BufferedImage[3];
		zombiewDown[0] = zombiew.getSubimage(WIDTH, 0, WIDTH, HEIGHT);
		zombiewDown[1] = zombiew.getSubimage(0, 0, WIDTH, HEIGHT);
		zombiewDown[2] = zombiew.getSubimage(WIDTH*2, 0, WIDTH, HEIGHT);
		
		zombiewUp = new BufferedImage[2];
		zombiewUp[0] = zombiew.getSubimage(0, HEIGHT, WIDTH, HEIGHT);
		zombiewUp[1] = zombiew.getSubimage(WIDTH, HEIGHT, WIDTH, HEIGHT);
		
		zombiewLeft = new BufferedImage[2];
		zombiewLeft[0] = zombiew.getSubimage(WIDTH*2, HEIGHT, WIDTH, HEIGHT);
		zombiewLeft[1] = zombiew.getSubimage(0, HEIGHT*2, WIDTH, HEIGHT);
		
		zombiewRight = new BufferedImage[2];
		zombiewRight[0] = zombiew.getSubimage(WIDTH, HEIGHT*2, WIDTH, HEIGHT);
		zombiewRight[1] = zombiew.getSubimage(WIDTH*2, HEIGHT*2, WIDTH, HEIGHT);
		
		// Blue Zombie
		zombiebDown = new BufferedImage[3];
		zombiebDown[0] = zombieb.getSubimage(WIDTH, 0, WIDTH, HEIGHT);
		zombiebDown[1] = zombieb.getSubimage(0, 0, WIDTH, HEIGHT);
		zombiebDown[2] = zombieb.getSubimage(WIDTH*2, 0, WIDTH, HEIGHT);
		
		zombiebUp = new BufferedImage[2];
		zombiebUp[0] = zombieb.getSubimage(0, HEIGHT, WIDTH, HEIGHT);
		zombiebUp[1] = zombieb.getSubimage(WIDTH, HEIGHT, WIDTH, HEIGHT);
		
		zombiebLeft = new BufferedImage[2];
		zombiebLeft[0] = zombieb.getSubimage(WIDTH*2, HEIGHT, WIDTH, HEIGHT);
		zombiebLeft[1] = zombieb.getSubimage(0, HEIGHT*2, WIDTH, HEIGHT);
		
		zombiebRight = new BufferedImage[2];
		zombiebRight[0] = zombieb.getSubimage(WIDTH, HEIGHT*2, WIDTH, HEIGHT);
		zombiebRight[1] = zombieb.getSubimage(WIDTH*2, HEIGHT*2, WIDTH, HEIGHT);
		
		// Green Zombie
		zombiegDown = new BufferedImage[3];
		zombiegDown[0] = zombieg.getSubimage(WIDTH, 0, WIDTH, HEIGHT);
		zombiegDown[1] = zombieg.getSubimage(0, 0, WIDTH, HEIGHT);
		zombiegDown[2] = zombieg.getSubimage(WIDTH*2, 0, WIDTH, HEIGHT);
		
		zombiegUp = new BufferedImage[2];
		zombiegUp[0] = zombieg.getSubimage(0, HEIGHT, WIDTH, HEIGHT);
		zombiegUp[1] = zombieg.getSubimage(WIDTH, HEIGHT, WIDTH, HEIGHT);
		
		zombiegLeft = new BufferedImage[2];
		zombiegLeft[0] = zombieg.getSubimage(WIDTH*2, HEIGHT, WIDTH, HEIGHT);
		zombiegLeft[1] = zombieg.getSubimage(0, HEIGHT*2, WIDTH, HEIGHT);
		
		zombiegRight = new BufferedImage[2];
		zombiegRight[0] = zombieg.getSubimage(WIDTH, HEIGHT*2, WIDTH, HEIGHT);
		zombiegRight[1] = zombieg.getSubimage(WIDTH*2, HEIGHT*2, WIDTH, HEIGHT);
		
		// Pink Zombie
		zombiepDown = new BufferedImage[3];
		zombiepDown[0] = zombiep.getSubimage(WIDTH, 0, WIDTH, HEIGHT);
		zombiepDown[1] = zombiep.getSubimage(0, 0, WIDTH, HEIGHT);
		zombiepDown[2] = zombiep.getSubimage(WIDTH*2, 0, WIDTH, HEIGHT);
		
		zombiepUp = new BufferedImage[2];
		zombiepUp[0] = zombiep.getSubimage(0, HEIGHT, WIDTH, HEIGHT);
		zombiepUp[1] = zombiep.getSubimage(WIDTH, HEIGHT, WIDTH, HEIGHT);
		
		zombiepLeft = new BufferedImage[2];
		zombiepLeft[0] = zombiep.getSubimage(WIDTH*2, HEIGHT, WIDTH, HEIGHT);
		zombiepLeft[1] = zombiep.getSubimage(0, HEIGHT*2, WIDTH, HEIGHT);
		
		zombiepRight = new BufferedImage[2];
		zombiepRight[0] = zombiep.getSubimage(WIDTH, HEIGHT*2, WIDTH, HEIGHT);
		zombiepRight[1] = zombiep.getSubimage(WIDTH*2, HEIGHT*2, WIDTH, HEIGHT);
		
		// Fast Zombie
		fastZombieDown = new BufferedImage[3];
		fastZombieDown[0] = fastZombie.getSubimage(WIDTH, 0, WIDTH, HEIGHT);
		fastZombieDown[1] = fastZombie.getSubimage(0, 0, WIDTH, HEIGHT);
		fastZombieDown[2] = fastZombie.getSubimage(WIDTH*2, 0, WIDTH, HEIGHT);
		
		fastZombieUp = new BufferedImage[2];
		fastZombieUp[0] = fastZombie.getSubimage(0, HEIGHT, WIDTH, HEIGHT);
		fastZombieUp[1] = fastZombie.getSubimage(WIDTH, HEIGHT, WIDTH, HEIGHT);
		
		fastZombieLeft = new BufferedImage[2];
		fastZombieLeft[0] = fastZombie.getSubimage(WIDTH*2, HEIGHT, WIDTH, HEIGHT);
		fastZombieLeft[1] = fastZombie.getSubimage(0, HEIGHT*2, WIDTH, HEIGHT);
		
		fastZombieRight = new BufferedImage[2];
		fastZombieRight[0] = fastZombie.getSubimage(WIDTH, HEIGHT*2, WIDTH, HEIGHT);
		fastZombieRight[1] = fastZombie.getSubimage(WIDTH*2, HEIGHT*2, WIDTH, HEIGHT);
		
		
		// Players -------------------------------------------------------------
		
		// Jamir: Blue shirt, blue shoes
		jamirbbDown = new BufferedImage[3];
		jamirbbDown[0] = jamirbb.getSubimage(WIDTH, 0, WIDTH, HEIGHT);
		jamirbbDown[1] = jamirbb.getSubimage(0, 0, WIDTH, HEIGHT);
		jamirbbDown[2] = jamirbb.getSubimage(WIDTH*2, 0, WIDTH, HEIGHT);
		
		jamirbbUp = new BufferedImage[2];
		jamirbbUp[0] = jamirbb.getSubimage(0, HEIGHT, WIDTH, HEIGHT);
		jamirbbUp[1] = jamirbb.getSubimage(WIDTH, HEIGHT, WIDTH, HEIGHT);
		
		jamirbbLeft = new BufferedImage[2];
		jamirbbLeft[0] = jamirbb.getSubimage(WIDTH*2, HEIGHT, WIDTH, HEIGHT);
		jamirbbLeft[1] = jamirbb.getSubimage(0, HEIGHT*2, WIDTH, HEIGHT);
		
		jamirbbRight = new BufferedImage[2];
		jamirbbRight[0] = jamirbb.getSubimage(WIDTH, HEIGHT*2, WIDTH, HEIGHT);
		jamirbbRight[1] = jamirbb.getSubimage(WIDTH*2, HEIGHT*2, WIDTH, HEIGHT);
		
		// Jamir: Blue shirt, gold shoes
		jamirbgDown = new BufferedImage[3];
		jamirbgDown[0] = jamirbg.getSubimage(WIDTH, 0, WIDTH, HEIGHT);
		jamirbgDown[1] = jamirbg.getSubimage(0, 0, WIDTH, HEIGHT);
		jamirbgDown[2] = jamirbg.getSubimage(WIDTH*2, 0, WIDTH, HEIGHT);
		
		jamirbgUp = new BufferedImage[2];
		jamirbgUp[0] = jamirbg.getSubimage(0, HEIGHT, WIDTH, HEIGHT);
		jamirbgUp[1] = jamirbg.getSubimage(WIDTH, HEIGHT, WIDTH, HEIGHT);
		
		jamirbgLeft = new BufferedImage[2];
		jamirbgLeft[0] = jamirbg.getSubimage(WIDTH*2, HEIGHT, WIDTH, HEIGHT);
		jamirbgLeft[1] = jamirbg.getSubimage(0, HEIGHT*2, WIDTH, HEIGHT);
		
		jamirbgRight = new BufferedImage[2];
		jamirbgRight[0] = jamirbg.getSubimage(WIDTH, HEIGHT*2, WIDTH, HEIGHT);
		jamirbgRight[1] = jamirbg.getSubimage(WIDTH*2, HEIGHT*2, WIDTH, HEIGHT);
		
		// Jamir: Blue shirt, red shoes
		jamirbrDown = new BufferedImage[3];
		jamirbrDown[0] = jamirbr.getSubimage(WIDTH, 0, WIDTH, HEIGHT);
		jamirbrDown[1] = jamirbr.getSubimage(0, 0, WIDTH, HEIGHT);
		jamirbrDown[2] = jamirbr.getSubimage(WIDTH*2, 0, WIDTH, HEIGHT);
		
		jamirbrUp = new BufferedImage[2];
		jamirbrUp[0] = jamirbr.getSubimage(0, HEIGHT, WIDTH, HEIGHT);
		jamirbrUp[1] = jamirbr.getSubimage(WIDTH, HEIGHT, WIDTH, HEIGHT);
		
		jamirbrLeft = new BufferedImage[2];
		jamirbrLeft[0] = jamirbr.getSubimage(WIDTH*2, HEIGHT, WIDTH, HEIGHT);
		jamirbrLeft[1] = jamirbr.getSubimage(0, HEIGHT*2, WIDTH, HEIGHT);
		
		jamirbrRight = new BufferedImage[2];
		jamirbrRight[0] = jamirbr.getSubimage(WIDTH, HEIGHT*2, WIDTH, HEIGHT);
		jamirbrRight[1] = jamirbr.getSubimage(WIDTH*2, HEIGHT*2, WIDTH, HEIGHT);
		
		// Jamir: Pink shirt, blue shoes
		jamirpbDown = new BufferedImage[3];
		jamirpbDown[0] = jamirpb.getSubimage(WIDTH, 0, WIDTH, HEIGHT);
		jamirpbDown[1] = jamirpb.getSubimage(0, 0, WIDTH, HEIGHT);
		jamirpbDown[2] = jamirpb.getSubimage(WIDTH*2, 0, WIDTH, HEIGHT);
		
		jamirpbUp = new BufferedImage[2];
		jamirpbUp[0] = jamirpb.getSubimage(0, HEIGHT, WIDTH, HEIGHT);
		jamirpbUp[1] = jamirpb.getSubimage(WIDTH, HEIGHT, WIDTH, HEIGHT);
		
		jamirpbLeft = new BufferedImage[2];
		jamirpbLeft[0] = jamirpb.getSubimage(WIDTH*2, HEIGHT, WIDTH, HEIGHT);
		jamirpbLeft[1] = jamirpb.getSubimage(0, HEIGHT*2, WIDTH, HEIGHT);
		
		jamirpbRight = new BufferedImage[2];
		jamirpbRight[0] = jamirpb.getSubimage(WIDTH, HEIGHT*2, WIDTH, HEIGHT);
		jamirpbRight[1] = jamirpb.getSubimage(WIDTH*2, HEIGHT*2, WIDTH, HEIGHT);
		
		// Jamir: Pink shirt, gold shoes
		jamirpgDown = new BufferedImage[3];
		jamirpgDown[0] = jamirpg.getSubimage(WIDTH, 0, WIDTH, HEIGHT);
		jamirpgDown[1] = jamirpg.getSubimage(0, 0, WIDTH, HEIGHT);
		jamirpgDown[2] = jamirpg.getSubimage(WIDTH*2, 0, WIDTH, HEIGHT);
		
		jamirpgUp = new BufferedImage[2];
		jamirpgUp[0] = jamirpg.getSubimage(0, HEIGHT, WIDTH, HEIGHT);
		jamirpgUp[1] = jamirpg.getSubimage(WIDTH, HEIGHT, WIDTH, HEIGHT);
		
		jamirpgLeft = new BufferedImage[2];
		jamirpgLeft[0] = jamirpg.getSubimage(WIDTH*2, HEIGHT, WIDTH, HEIGHT);
		jamirpgLeft[1] = jamirpg.getSubimage(0, HEIGHT*2, WIDTH, HEIGHT);
		
		jamirpgRight = new BufferedImage[2];
		jamirpgRight[0] = jamirpg.getSubimage(WIDTH, HEIGHT*2, WIDTH, HEIGHT);
		jamirpgRight[1] = jamirpg.getSubimage(WIDTH*2, HEIGHT*2, WIDTH, HEIGHT);
		
		// Jamir: Pink shirt, red shoes
		jamirprDown = new BufferedImage[3];
		jamirprDown[0] = jamirpr.getSubimage(WIDTH, 0, WIDTH, HEIGHT);
		jamirprDown[1] = jamirpr.getSubimage(0, 0, WIDTH, HEIGHT);
		jamirprDown[2] = jamirpr.getSubimage(WIDTH*2, 0, WIDTH, HEIGHT);
		
		jamirprUp = new BufferedImage[2];
		jamirprUp[0] = jamirpr.getSubimage(0, HEIGHT, WIDTH, HEIGHT);
		jamirprUp[1] = jamirpr.getSubimage(WIDTH, HEIGHT, WIDTH, HEIGHT);
		
		jamirprLeft = new BufferedImage[2];
		jamirprLeft[0] = jamirpr.getSubimage(WIDTH*2, HEIGHT, WIDTH, HEIGHT);
		jamirprLeft[1] = jamirpr.getSubimage(0, HEIGHT*2, WIDTH, HEIGHT);
		
		jamirprRight = new BufferedImage[2];
		jamirprRight[0] = jamirpr.getSubimage(WIDTH, HEIGHT*2, WIDTH, HEIGHT);
		jamirprRight[1] = jamirpr.getSubimage(WIDTH*2, HEIGHT*2, WIDTH, HEIGHT);
		
		// Jamir: White shirt, blue shoes
		jamirwbDown = new BufferedImage[3];
		jamirwbDown[0] = jamirwb.getSubimage(WIDTH, 0, WIDTH, HEIGHT);
		jamirwbDown[1] = jamirwb.getSubimage(0, 0, WIDTH, HEIGHT);
		jamirwbDown[2] = jamirwb.getSubimage(WIDTH*2, 0, WIDTH, HEIGHT);
		
		jamirwbUp = new BufferedImage[2];
		jamirwbUp[0] = jamirwb.getSubimage(0, HEIGHT, WIDTH, HEIGHT);
		jamirwbUp[1] = jamirwb.getSubimage(WIDTH, HEIGHT, WIDTH, HEIGHT);
		
		jamirwbLeft = new BufferedImage[2];
		jamirwbLeft[0] = jamirwb.getSubimage(WIDTH*2, HEIGHT, WIDTH, HEIGHT);
		jamirwbLeft[1] = jamirwb.getSubimage(0, HEIGHT*2, WIDTH, HEIGHT);
		
		jamirwbRight = new BufferedImage[2];
		jamirwbRight[0] = jamirwb.getSubimage(WIDTH, HEIGHT*2, WIDTH, HEIGHT);
		jamirwbRight[1] = jamirwb.getSubimage(WIDTH*2, HEIGHT*2, WIDTH, HEIGHT);
		
		// Jamir: White shirt, gold shoes
		jamirwgDown = new BufferedImage[3];
		jamirwgDown[0] = jamirwg.getSubimage(WIDTH, 0, WIDTH, HEIGHT);
		jamirwgDown[1] = jamirwg.getSubimage(0, 0, WIDTH, HEIGHT);
		jamirwgDown[2] = jamirwg.getSubimage(WIDTH*2, 0, WIDTH, HEIGHT);
		
		jamirwgUp = new BufferedImage[2];
		jamirwgUp[0] = jamirwg.getSubimage(0, HEIGHT, WIDTH, HEIGHT);
		jamirwgUp[1] = jamirwg.getSubimage(WIDTH, HEIGHT, WIDTH, HEIGHT);
		
		jamirwgLeft = new BufferedImage[2];
		jamirwgLeft[0] = jamirwg.getSubimage(WIDTH*2, HEIGHT, WIDTH, HEIGHT);
		jamirwgLeft[1] = jamirwg.getSubimage(0, HEIGHT*2, WIDTH, HEIGHT);
		
		jamirwgRight = new BufferedImage[2];
		jamirwgRight[0] = jamirwg.getSubimage(WIDTH, HEIGHT*2, WIDTH, HEIGHT);
		jamirwgRight[1] = jamirwg.getSubimage(WIDTH*2, HEIGHT*2, WIDTH, HEIGHT);
		
		// Jamir: White shirt, red shoes
		jamirwrDown = new BufferedImage[3];
		jamirwrDown[0] = jamirwr.getSubimage(WIDTH, 0, WIDTH, HEIGHT);
		jamirwrDown[1] = jamirwr.getSubimage(0, 0, WIDTH, HEIGHT);
		jamirwrDown[2] = jamirwr.getSubimage(WIDTH*2, 0, WIDTH, HEIGHT);
		
		jamirwrUp = new BufferedImage[2];
		jamirwrUp[0] = jamirwr.getSubimage(0, HEIGHT, WIDTH, HEIGHT);
		jamirwrUp[1] = jamirwr.getSubimage(WIDTH, HEIGHT, WIDTH, HEIGHT);
		
		jamirwrLeft = new BufferedImage[2];
		jamirwrLeft[0] = jamirwr.getSubimage(WIDTH*2, HEIGHT, WIDTH, HEIGHT);
		jamirwrLeft[1] = jamirwr.getSubimage(0, HEIGHT*2, WIDTH, HEIGHT);
		
		jamirwrRight = new BufferedImage[2];
		jamirwrRight[0] = jamirwr.getSubimage(WIDTH, HEIGHT*2, WIDTH, HEIGHT);
		jamirwrRight[1] = jamirwr.getSubimage(WIDTH*2, HEIGHT*2, WIDTH, HEIGHT);
		
		// -------------------------------------------------------------------------
		
		// Joe: Blue shirt, blue shoes
		joebbDown = new BufferedImage[3];
		joebbDown[0] = joebb.getSubimage(WIDTH, 0, WIDTH, HEIGHT);
		joebbDown[1] = joebb.getSubimage(0, 0, WIDTH, HEIGHT);
		joebbDown[2] = joebb.getSubimage(WIDTH*2, 0, WIDTH, HEIGHT);
		
		joebbUp = new BufferedImage[2];
		joebbUp[0] = joebb.getSubimage(0, HEIGHT, WIDTH, HEIGHT);
		joebbUp[1] = joebb.getSubimage(WIDTH, HEIGHT, WIDTH, HEIGHT);
		
		joebbLeft = new BufferedImage[2];
		joebbLeft[0] = joebb.getSubimage(WIDTH*2, HEIGHT, WIDTH, HEIGHT);
		joebbLeft[1] = joebb.getSubimage(0, HEIGHT*2, WIDTH, HEIGHT);
		
		joebbRight = new BufferedImage[2];
		joebbRight[0] = joebb.getSubimage(WIDTH, HEIGHT*2, WIDTH, HEIGHT);
		joebbRight[1] = joebb.getSubimage(WIDTH*2, HEIGHT*2, WIDTH, HEIGHT);
		
		// Joe: Blue shirt, gold shoes
		joebgDown = new BufferedImage[3];
		joebgDown[0] = joebg.getSubimage(WIDTH, 0, WIDTH, HEIGHT);
		joebgDown[1] = joebg.getSubimage(0, 0, WIDTH, HEIGHT);
		joebgDown[2] = joebg.getSubimage(WIDTH*2, 0, WIDTH, HEIGHT);
		
		joebgUp = new BufferedImage[2];
		joebgUp[0] = joebg.getSubimage(0, HEIGHT, WIDTH, HEIGHT);
		joebgUp[1] = joebg.getSubimage(WIDTH, HEIGHT, WIDTH, HEIGHT);
		
		joebgLeft = new BufferedImage[2];
		joebgLeft[0] = joebg.getSubimage(WIDTH*2, HEIGHT, WIDTH, HEIGHT);
		joebgLeft[1] = joebg.getSubimage(0, HEIGHT*2, WIDTH, HEIGHT);
		
		joebgRight = new BufferedImage[2];
		joebgRight[0] = joebg.getSubimage(WIDTH, HEIGHT*2, WIDTH, HEIGHT);
		joebgRight[1] = joebg.getSubimage(WIDTH*2, HEIGHT*2, WIDTH, HEIGHT);
		
		// Joe: Blue shirt, red shoes
		joebrDown = new BufferedImage[3];
		joebrDown[0] = joebr.getSubimage(WIDTH, 0, WIDTH, HEIGHT);
		joebrDown[1] = joebr.getSubimage(0, 0, WIDTH, HEIGHT);
		joebrDown[2] = joebr.getSubimage(WIDTH*2, 0, WIDTH, HEIGHT);
		
		joebrUp = new BufferedImage[2];
		joebrUp[0] = joebr.getSubimage(0, HEIGHT, WIDTH, HEIGHT);
		joebrUp[1] = joebr.getSubimage(WIDTH, HEIGHT, WIDTH, HEIGHT);
		
		joebrLeft = new BufferedImage[2];
		joebrLeft[0] = joebr.getSubimage(WIDTH*2, HEIGHT, WIDTH, HEIGHT);
		joebrLeft[1] = joebr.getSubimage(0, HEIGHT*2, WIDTH, HEIGHT);
		
		joebrRight = new BufferedImage[2];
		joebrRight[0] = joebr.getSubimage(WIDTH, HEIGHT*2, WIDTH, HEIGHT);
		joebrRight[1] = joebr.getSubimage(WIDTH*2, HEIGHT*2, WIDTH, HEIGHT);
		
		// Joe: Pink shirt, blue shoes
		joepbDown = new BufferedImage[3];
		joepbDown[0] = joepb.getSubimage(WIDTH, 0, WIDTH, HEIGHT);
		joepbDown[1] = joepb.getSubimage(0, 0, WIDTH, HEIGHT);
		joepbDown[2] = joepb.getSubimage(WIDTH*2, 0, WIDTH, HEIGHT);
		
		joepbUp = new BufferedImage[2];
		joepbUp[0] = joepb.getSubimage(0, HEIGHT, WIDTH, HEIGHT);
		joepbUp[1] = joepb.getSubimage(WIDTH, HEIGHT, WIDTH, HEIGHT);
		
		joepbLeft = new BufferedImage[2];
		joepbLeft[0] = joepb.getSubimage(WIDTH*2, HEIGHT, WIDTH, HEIGHT);
		joepbLeft[1] = joepb.getSubimage(0, HEIGHT*2, WIDTH, HEIGHT);
		
		joepbRight = new BufferedImage[2];
		joepbRight[0] = joepb.getSubimage(WIDTH, HEIGHT*2, WIDTH, HEIGHT);
		joepbRight[1] = joepb.getSubimage(WIDTH*2, HEIGHT*2, WIDTH, HEIGHT);
		
		// Joe: Pink shirt, gold shoes
		joepgDown = new BufferedImage[3];
		joepgDown[0] = joepg.getSubimage(WIDTH, 0, WIDTH, HEIGHT);
		joepgDown[1] = joepg.getSubimage(0, 0, WIDTH, HEIGHT);
		joepgDown[2] = joepg.getSubimage(WIDTH*2, 0, WIDTH, HEIGHT);
		
		joepgUp = new BufferedImage[2];
		joepgUp[0] = joepg.getSubimage(0, HEIGHT, WIDTH, HEIGHT);
		joepgUp[1] = joepg.getSubimage(WIDTH, HEIGHT, WIDTH, HEIGHT);
		
		joepgLeft = new BufferedImage[2];
		joepgLeft[0] = joepg.getSubimage(WIDTH*2, HEIGHT, WIDTH, HEIGHT);
		joepgLeft[1] = joepg.getSubimage(0, HEIGHT*2, WIDTH, HEIGHT);
		
		joepgRight = new BufferedImage[2];
		joepgRight[0] = joepg.getSubimage(WIDTH, HEIGHT*2, WIDTH, HEIGHT);
		joepgRight[1] = joepg.getSubimage(WIDTH*2, HEIGHT*2, WIDTH, HEIGHT);
		
		// Joe: Pink shirt, red shoes
		joeprDown = new BufferedImage[3];
		joeprDown[0] = joepr.getSubimage(WIDTH, 0, WIDTH, HEIGHT);
		joeprDown[1] = joepr.getSubimage(0, 0, WIDTH, HEIGHT);
		joeprDown[2] = joepr.getSubimage(WIDTH*2, 0, WIDTH, HEIGHT);
		
		joeprUp = new BufferedImage[2];
		joeprUp[0] = joepr.getSubimage(0, HEIGHT, WIDTH, HEIGHT);
		joeprUp[1] = joepr.getSubimage(WIDTH, HEIGHT, WIDTH, HEIGHT);
		
		joeprLeft = new BufferedImage[2];
		joeprLeft[0] = joepr.getSubimage(WIDTH*2, HEIGHT, WIDTH, HEIGHT);
		joeprLeft[1] = joepr.getSubimage(0, HEIGHT*2, WIDTH, HEIGHT);
		
		joeprRight = new BufferedImage[2];
		joeprRight[0] = joepr.getSubimage(WIDTH, HEIGHT*2, WIDTH, HEIGHT);
		joeprRight[1] = joepr.getSubimage(WIDTH*2, HEIGHT*2, WIDTH, HEIGHT);
		
		// Joe: White shirt, blue shoes
		joewbDown = new BufferedImage[3];
		joewbDown[0] = joewb.getSubimage(WIDTH, 0, WIDTH, HEIGHT);
		joewbDown[1] = joewb.getSubimage(0, 0, WIDTH, HEIGHT);
		joewbDown[2] = joewb.getSubimage(WIDTH*2, 0, WIDTH, HEIGHT);
		
		joewbUp = new BufferedImage[2];
		joewbUp[0] = joewb.getSubimage(0, HEIGHT, WIDTH, HEIGHT);
		joewbUp[1] = joewb.getSubimage(WIDTH, HEIGHT, WIDTH, HEIGHT);
		
		joewbLeft = new BufferedImage[2];
		joewbLeft[0] = joewb.getSubimage(WIDTH*2, HEIGHT, WIDTH, HEIGHT);
		joewbLeft[1] = joewb.getSubimage(0, HEIGHT*2, WIDTH, HEIGHT);
		
		joewbRight = new BufferedImage[2];
		joewbRight[0] = joewb.getSubimage(WIDTH, HEIGHT*2, WIDTH, HEIGHT);
		joewbRight[1] = joewb.getSubimage(WIDTH*2, HEIGHT*2, WIDTH, HEIGHT);
		
		// Joe: White shirt, gold shoes
		joewgDown = new BufferedImage[3];
		joewgDown[0] = joewg.getSubimage(WIDTH, 0, WIDTH, HEIGHT);
		joewgDown[1] = joewg.getSubimage(0, 0, WIDTH, HEIGHT);
		joewgDown[2] = joewg.getSubimage(WIDTH*2, 0, WIDTH, HEIGHT);
		
		joewgUp = new BufferedImage[2];
		joewgUp[0] = joewg.getSubimage(0, HEIGHT, WIDTH, HEIGHT);
		joewgUp[1] = joewg.getSubimage(WIDTH, HEIGHT, WIDTH, HEIGHT);
		
		joewgLeft = new BufferedImage[2];
		joewgLeft[0] = joewg.getSubimage(WIDTH*2, HEIGHT, WIDTH, HEIGHT);
		joewgLeft[1] = joewg.getSubimage(0, HEIGHT*2, WIDTH, HEIGHT);
		
		joewgRight = new BufferedImage[2];
		joewgRight[0] = joewg.getSubimage(WIDTH, HEIGHT*2, WIDTH, HEIGHT);
		joewgRight[1] = joewg.getSubimage(WIDTH*2, HEIGHT*2, WIDTH, HEIGHT);
		
		// Joe: White shirt, red shoes
		joewrDown = new BufferedImage[3];
		joewrDown[0] = joewr.getSubimage(WIDTH, 0, WIDTH, HEIGHT);
		joewrDown[1] = joewr.getSubimage(0, 0, WIDTH, HEIGHT);
		joewrDown[2] = joewr.getSubimage(WIDTH*2, 0, WIDTH, HEIGHT);
		
		joewrUp = new BufferedImage[2];
		joewrUp[0] = joewr.getSubimage(0, HEIGHT, WIDTH, HEIGHT);
		joewrUp[1] = joewr.getSubimage(WIDTH, HEIGHT, WIDTH, HEIGHT);
		
		joewrLeft = new BufferedImage[2];
		joewrLeft[0] = joewr.getSubimage(WIDTH*2, HEIGHT, WIDTH, HEIGHT);
		joewrLeft[1] = joewr.getSubimage(0, HEIGHT*2, WIDTH, HEIGHT);
		
		joewrRight = new BufferedImage[2];
		joewrRight[0] = joewr.getSubimage(WIDTH, HEIGHT*2, WIDTH, HEIGHT);
		joewrRight[1] = joewr.getSubimage(WIDTH*2, HEIGHT*2, WIDTH, HEIGHT);
		
		// -------------------------------------------------------------------------
		
		// karen: Blue shirt, blue shoes
		karenbbDown = new BufferedImage[3];
		karenbbDown[0] = karenbb.getSubimage(WIDTH, 0, WIDTH, HEIGHT);
		karenbbDown[1] = karenbb.getSubimage(0, 0, WIDTH, HEIGHT);
		karenbbDown[2] = karenbb.getSubimage(WIDTH*2, 0, WIDTH, HEIGHT);
		
		karenbbUp = new BufferedImage[2];
		karenbbUp[0] = karenbb.getSubimage(0, HEIGHT, WIDTH, HEIGHT);
		karenbbUp[1] = karenbb.getSubimage(WIDTH, HEIGHT, WIDTH, HEIGHT);
		
		karenbbLeft = new BufferedImage[2];
		karenbbLeft[0] = karenbb.getSubimage(WIDTH*2, HEIGHT, WIDTH, HEIGHT);
		karenbbLeft[1] = karenbb.getSubimage(0, HEIGHT*2, WIDTH, HEIGHT);
		
		karenbbRight = new BufferedImage[2];
		karenbbRight[0] = karenbb.getSubimage(WIDTH, HEIGHT*2, WIDTH, HEIGHT);
		karenbbRight[1] = karenbb.getSubimage(WIDTH*2, HEIGHT*2, WIDTH, HEIGHT);
		
		// karen: Blue shirt, gold shoes
		karenbgDown = new BufferedImage[3];
		karenbgDown[0] = karenbg.getSubimage(WIDTH, 0, WIDTH, HEIGHT);
		karenbgDown[1] = karenbg.getSubimage(0, 0, WIDTH, HEIGHT);
		karenbgDown[2] = karenbg.getSubimage(WIDTH*2, 0, WIDTH, HEIGHT);
		
		karenbgUp = new BufferedImage[2];
		karenbgUp[0] = karenbg.getSubimage(0, HEIGHT, WIDTH, HEIGHT);
		karenbgUp[1] = karenbg.getSubimage(WIDTH, HEIGHT, WIDTH, HEIGHT);
		
		karenbgLeft = new BufferedImage[2];
		karenbgLeft[0] = karenbg.getSubimage(WIDTH*2, HEIGHT, WIDTH, HEIGHT);
		karenbgLeft[1] = karenbg.getSubimage(0, HEIGHT*2, WIDTH, HEIGHT);
		
		karenbgRight = new BufferedImage[2];
		karenbgRight[0] = karenbg.getSubimage(WIDTH, HEIGHT*2, WIDTH, HEIGHT);
		karenbgRight[1] = karenbg.getSubimage(WIDTH*2, HEIGHT*2, WIDTH, HEIGHT);
		
		// karen: Blue shirt, red shoes
		karenbrDown = new BufferedImage[3];
		karenbrDown[0] = karenbr.getSubimage(WIDTH, 0, WIDTH, HEIGHT);
		karenbrDown[1] = karenbr.getSubimage(0, 0, WIDTH, HEIGHT);
		karenbrDown[2] = karenbr.getSubimage(WIDTH*2, 0, WIDTH, HEIGHT);
		
		karenbrUp = new BufferedImage[2];
		karenbrUp[0] = karenbr.getSubimage(0, HEIGHT, WIDTH, HEIGHT);
		karenbrUp[1] = karenbr.getSubimage(WIDTH, HEIGHT, WIDTH, HEIGHT);
		
		karenbrLeft = new BufferedImage[2];
		karenbrLeft[0] = karenbr.getSubimage(WIDTH*2, HEIGHT, WIDTH, HEIGHT);
		karenbrLeft[1] = karenbr.getSubimage(0, HEIGHT*2, WIDTH, HEIGHT);
		
		karenbrRight = new BufferedImage[2];
		karenbrRight[0] = karenbr.getSubimage(WIDTH, HEIGHT*2, WIDTH, HEIGHT);
		karenbrRight[1] = karenbr.getSubimage(WIDTH*2, HEIGHT*2, WIDTH, HEIGHT);
		
		// karen: Pink shirt, blue shoes
		karenpbDown = new BufferedImage[3];
		karenpbDown[0] = karenpb.getSubimage(WIDTH, 0, WIDTH, HEIGHT);
		karenpbDown[1] = karenpb.getSubimage(0, 0, WIDTH, HEIGHT);
		karenpbDown[2] = karenpb.getSubimage(WIDTH*2, 0, WIDTH, HEIGHT);
		
		karenpbUp = new BufferedImage[2];
		karenpbUp[0] = karenpb.getSubimage(0, HEIGHT, WIDTH, HEIGHT);
		karenpbUp[1] = karenpb.getSubimage(WIDTH, HEIGHT, WIDTH, HEIGHT);
		
		karenpbLeft = new BufferedImage[2];
		karenpbLeft[0] = karenpb.getSubimage(WIDTH*2, HEIGHT, WIDTH, HEIGHT);
		karenpbLeft[1] = karenpb.getSubimage(0, HEIGHT*2, WIDTH, HEIGHT);
		
		karenpbRight = new BufferedImage[2];
		karenpbRight[0] = karenpb.getSubimage(WIDTH, HEIGHT*2, WIDTH, HEIGHT);
		karenpbRight[1] = karenpb.getSubimage(WIDTH*2, HEIGHT*2, WIDTH, HEIGHT);
		
		// karen: Pink shirt, gold shoes
		karenpgDown = new BufferedImage[3];
		karenpgDown[0] = karenpg.getSubimage(WIDTH, 0, WIDTH, HEIGHT);
		karenpgDown[1] = karenpg.getSubimage(0, 0, WIDTH, HEIGHT);
		karenpgDown[2] = karenpg.getSubimage(WIDTH*2, 0, WIDTH, HEIGHT);
		
		karenpgUp = new BufferedImage[2];
		karenpgUp[0] = karenpg.getSubimage(0, HEIGHT, WIDTH, HEIGHT);
		karenpgUp[1] = karenpg.getSubimage(WIDTH, HEIGHT, WIDTH, HEIGHT);
		
		karenpgLeft = new BufferedImage[2];
		karenpgLeft[0] = karenpg.getSubimage(WIDTH*2, HEIGHT, WIDTH, HEIGHT);
		karenpgLeft[1] = karenpg.getSubimage(0, HEIGHT*2, WIDTH, HEIGHT);
		
		karenpgRight = new BufferedImage[2];
		karenpgRight[0] = karenpg.getSubimage(WIDTH, HEIGHT*2, WIDTH, HEIGHT);
		karenpgRight[1] = karenpg.getSubimage(WIDTH*2, HEIGHT*2, WIDTH, HEIGHT);
		
		// karen: Pink shirt, red shoes
		karenprDown = new BufferedImage[3];
		karenprDown[0] = karenpr.getSubimage(WIDTH, 0, WIDTH, HEIGHT);
		karenprDown[1] = karenpr.getSubimage(0, 0, WIDTH, HEIGHT);
		karenprDown[2] = karenpr.getSubimage(WIDTH*2, 0, WIDTH, HEIGHT);
		
		karenprUp = new BufferedImage[2];
		karenprUp[0] = karenpr.getSubimage(0, HEIGHT, WIDTH, HEIGHT);
		karenprUp[1] = karenpr.getSubimage(WIDTH, HEIGHT, WIDTH, HEIGHT);
		
		karenprLeft = new BufferedImage[2];
		karenprLeft[0] = karenpr.getSubimage(WIDTH*2, HEIGHT, WIDTH, HEIGHT);
		karenprLeft[1] = karenpr.getSubimage(0, HEIGHT*2, WIDTH, HEIGHT);
		
		karenprRight = new BufferedImage[2];
		karenprRight[0] = karenpr.getSubimage(WIDTH, HEIGHT*2, WIDTH, HEIGHT);
		karenprRight[1] = karenpr.getSubimage(WIDTH*2, HEIGHT*2, WIDTH, HEIGHT);
		
		// karen: White shirt, blue shoes
		karenwbDown = new BufferedImage[3];
		karenwbDown[0] = karenwb.getSubimage(WIDTH, 0, WIDTH, HEIGHT);
		karenwbDown[1] = karenwb.getSubimage(0, 0, WIDTH, HEIGHT);
		karenwbDown[2] = karenwb.getSubimage(WIDTH*2, 0, WIDTH, HEIGHT);
		
		karenwbUp = new BufferedImage[2];
		karenwbUp[0] = karenwb.getSubimage(0, HEIGHT, WIDTH, HEIGHT);
		karenwbUp[1] = karenwb.getSubimage(WIDTH, HEIGHT, WIDTH, HEIGHT);
		
		karenwbLeft = new BufferedImage[2];
		karenwbLeft[0] = karenwb.getSubimage(WIDTH*2, HEIGHT, WIDTH, HEIGHT);
		karenwbLeft[1] = karenwb.getSubimage(0, HEIGHT*2, WIDTH, HEIGHT);
		
		karenwbRight = new BufferedImage[2];
		karenwbRight[0] = karenwb.getSubimage(WIDTH, HEIGHT*2, WIDTH, HEIGHT);
		karenwbRight[1] = karenwb.getSubimage(WIDTH*2, HEIGHT*2, WIDTH, HEIGHT);
		
		// karen: White shirt, gold shoes
		karenwgDown = new BufferedImage[3];
		karenwgDown[0] = karenwg.getSubimage(WIDTH, 0, WIDTH, HEIGHT);
		karenwgDown[1] = karenwg.getSubimage(0, 0, WIDTH, HEIGHT);
		karenwgDown[2] = karenwg.getSubimage(WIDTH*2, 0, WIDTH, HEIGHT);
		
		karenwgUp = new BufferedImage[2];
		karenwgUp[0] = karenwg.getSubimage(0, HEIGHT, WIDTH, HEIGHT);
		karenwgUp[1] = karenwg.getSubimage(WIDTH, HEIGHT, WIDTH, HEIGHT);
		
		karenwgLeft = new BufferedImage[2];
		karenwgLeft[0] = karenwg.getSubimage(WIDTH*2, HEIGHT, WIDTH, HEIGHT);
		karenwgLeft[1] = karenwg.getSubimage(0, HEIGHT*2, WIDTH, HEIGHT);
		
		karenwgRight = new BufferedImage[2];
		karenwgRight[0] = karenwg.getSubimage(WIDTH, HEIGHT*2, WIDTH, HEIGHT);
		karenwgRight[1] = karenwg.getSubimage(WIDTH*2, HEIGHT*2, WIDTH, HEIGHT);
		
		// karen: White shirt, red shoes
		karenwrDown = new BufferedImage[3];
		karenwrDown[0] = karenwr.getSubimage(WIDTH, 0, WIDTH, HEIGHT);
		karenwrDown[1] = karenwr.getSubimage(0, 0, WIDTH, HEIGHT);
		karenwrDown[2] = karenwr.getSubimage(WIDTH*2, 0, WIDTH, HEIGHT);
		
		karenwrUp = new BufferedImage[2];
		karenwrUp[0] = karenwr.getSubimage(0, HEIGHT, WIDTH, HEIGHT);
		karenwrUp[1] = karenwr.getSubimage(WIDTH, HEIGHT, WIDTH, HEIGHT);
		
		karenwrLeft = new BufferedImage[2];
		karenwrLeft[0] = karenwr.getSubimage(WIDTH*2, HEIGHT, WIDTH, HEIGHT);
		karenwrLeft[1] = karenwr.getSubimage(0, HEIGHT*2, WIDTH, HEIGHT);
		
		karenwrRight = new BufferedImage[2];
		karenwrRight[0] = karenwr.getSubimage(WIDTH, HEIGHT*2, WIDTH, HEIGHT);
		karenwrRight[1] = karenwr.getSubimage(WIDTH*2, HEIGHT*2, WIDTH, HEIGHT);
		
		// -------------------------------------------------------------------------
		
		// jada: Blue shirt, blue shoes
		jadabbDown = new BufferedImage[3];
		jadabbDown[0] = jadabb.getSubimage(WIDTH, 0, WIDTH, HEIGHT);
		jadabbDown[1] = jadabb.getSubimage(0, 0, WIDTH, HEIGHT);
		jadabbDown[2] = jadabb.getSubimage(WIDTH*2, 0, WIDTH, HEIGHT);
		
		jadabbUp = new BufferedImage[2];
		jadabbUp[0] = jadabb.getSubimage(0, HEIGHT, WIDTH, HEIGHT);
		jadabbUp[1] = jadabb.getSubimage(WIDTH, HEIGHT, WIDTH, HEIGHT);
		
		jadabbLeft = new BufferedImage[2];
		jadabbLeft[0] = jadabb.getSubimage(WIDTH*2, HEIGHT, WIDTH, HEIGHT);
		jadabbLeft[1] = jadabb.getSubimage(0, HEIGHT*2, WIDTH, HEIGHT);
		
		jadabbRight = new BufferedImage[2];
		jadabbRight[0] = jadabb.getSubimage(WIDTH, HEIGHT*2, WIDTH, HEIGHT);
		jadabbRight[1] = jadabb.getSubimage(WIDTH*2, HEIGHT*2, WIDTH, HEIGHT);
		
		// jada: Blue shirt, gold shoes
		jadabgDown = new BufferedImage[3];
		jadabgDown[0] = jadabg.getSubimage(WIDTH, 0, WIDTH, HEIGHT);
		jadabgDown[1] = jadabg.getSubimage(0, 0, WIDTH, HEIGHT);
		jadabgDown[2] = jadabg.getSubimage(WIDTH*2, 0, WIDTH, HEIGHT);
		
		jadabgUp = new BufferedImage[2];
		jadabgUp[0] = jadabg.getSubimage(0, HEIGHT, WIDTH, HEIGHT);
		jadabgUp[1] = jadabg.getSubimage(WIDTH, HEIGHT, WIDTH, HEIGHT);
		
		jadabgLeft = new BufferedImage[2];
		jadabgLeft[0] = jadabg.getSubimage(WIDTH*2, HEIGHT, WIDTH, HEIGHT);
		jadabgLeft[1] = jadabg.getSubimage(0, HEIGHT*2, WIDTH, HEIGHT);
		
		jadabgRight = new BufferedImage[2];
		jadabgRight[0] = jadabg.getSubimage(WIDTH, HEIGHT*2, WIDTH, HEIGHT);
		jadabgRight[1] = jadabg.getSubimage(WIDTH*2, HEIGHT*2, WIDTH, HEIGHT);
		
		// jada: Blue shirt, red shoes
		jadabrDown = new BufferedImage[3];
		jadabrDown[0] = jadabr.getSubimage(WIDTH, 0, WIDTH, HEIGHT);
		jadabrDown[1] = jadabr.getSubimage(0, 0, WIDTH, HEIGHT);
		jadabrDown[2] = jadabr.getSubimage(WIDTH*2, 0, WIDTH, HEIGHT);
		
		jadabrUp = new BufferedImage[2];
		jadabrUp[0] = jadabr.getSubimage(0, HEIGHT, WIDTH, HEIGHT);
		jadabrUp[1] = jadabr.getSubimage(WIDTH, HEIGHT, WIDTH, HEIGHT);
		
		jadabrLeft = new BufferedImage[2];
		jadabrLeft[0] = jadabr.getSubimage(WIDTH*2, HEIGHT, WIDTH, HEIGHT);
		jadabrLeft[1] = jadabr.getSubimage(0, HEIGHT*2, WIDTH, HEIGHT);
		
		jadabrRight = new BufferedImage[2];
		jadabrRight[0] = jadabr.getSubimage(WIDTH, HEIGHT*2, WIDTH, HEIGHT);
		jadabrRight[1] = jadabr.getSubimage(WIDTH*2, HEIGHT*2, WIDTH, HEIGHT);
		
		// jada: Pink shirt, blue shoes
		jadapbDown = new BufferedImage[3];
		jadapbDown[0] = jadapb.getSubimage(WIDTH, 0, WIDTH, HEIGHT);
		jadapbDown[1] = jadapb.getSubimage(0, 0, WIDTH, HEIGHT);
		jadapbDown[2] = jadapb.getSubimage(WIDTH*2, 0, WIDTH, HEIGHT);
		
		jadapbUp = new BufferedImage[2];
		jadapbUp[0] = jadapb.getSubimage(0, HEIGHT, WIDTH, HEIGHT);
		jadapbUp[1] = jadapb.getSubimage(WIDTH, HEIGHT, WIDTH, HEIGHT);
		
		jadapbLeft = new BufferedImage[2];
		jadapbLeft[0] = jadapb.getSubimage(WIDTH*2, HEIGHT, WIDTH, HEIGHT);
		jadapbLeft[1] = jadapb.getSubimage(0, HEIGHT*2, WIDTH, HEIGHT);
		
		jadapbRight = new BufferedImage[2];
		jadapbRight[0] = jadapb.getSubimage(WIDTH, HEIGHT*2, WIDTH, HEIGHT);
		jadapbRight[1] = jadapb.getSubimage(WIDTH*2, HEIGHT*2, WIDTH, HEIGHT);
		
		// jada: Pink shirt, gold shoes
		jadapgDown = new BufferedImage[3];
		jadapgDown[0] = jadapg.getSubimage(WIDTH, 0, WIDTH, HEIGHT);
		jadapgDown[1] = jadapg.getSubimage(0, 0, WIDTH, HEIGHT);
		jadapgDown[2] = jadapg.getSubimage(WIDTH*2, 0, WIDTH, HEIGHT);
		
		jadapgUp = new BufferedImage[2];
		jadapgUp[0] = jadapg.getSubimage(0, HEIGHT, WIDTH, HEIGHT);
		jadapgUp[1] = jadapg.getSubimage(WIDTH, HEIGHT, WIDTH, HEIGHT);
		
		jadapgLeft = new BufferedImage[2];
		jadapgLeft[0] = jadapg.getSubimage(WIDTH*2, HEIGHT, WIDTH, HEIGHT);
		jadapgLeft[1] = jadapg.getSubimage(0, HEIGHT*2, WIDTH, HEIGHT);
		
		jadapgRight = new BufferedImage[2];
		jadapgRight[0] = jadapg.getSubimage(WIDTH, HEIGHT*2, WIDTH, HEIGHT);
		jadapgRight[1] = jadapg.getSubimage(WIDTH*2, HEIGHT*2, WIDTH, HEIGHT);
		
		// jada: Pink shirt, red shoes
		jadaprDown = new BufferedImage[3];
		jadaprDown[0] = jadapr.getSubimage(WIDTH, 0, WIDTH, HEIGHT);
		jadaprDown[1] = jadapr.getSubimage(0, 0, WIDTH, HEIGHT);
		jadaprDown[2] = jadapr.getSubimage(WIDTH*2, 0, WIDTH, HEIGHT);
		
		jadaprUp = new BufferedImage[2];
		jadaprUp[0] = jadapr.getSubimage(0, HEIGHT, WIDTH, HEIGHT);
		jadaprUp[1] = jadapr.getSubimage(WIDTH, HEIGHT, WIDTH, HEIGHT);
		
		jadaprLeft = new BufferedImage[2];
		jadaprLeft[0] = jadapr.getSubimage(WIDTH*2, HEIGHT, WIDTH, HEIGHT);
		jadaprLeft[1] = jadapr.getSubimage(0, HEIGHT*2, WIDTH, HEIGHT);
		
		jadaprRight = new BufferedImage[2];
		jadaprRight[0] = jadapr.getSubimage(WIDTH, HEIGHT*2, WIDTH, HEIGHT);
		jadaprRight[1] = jadapr.getSubimage(WIDTH*2, HEIGHT*2, WIDTH, HEIGHT);
		
		// jada: White shirt, blue shoes
		jadawbDown = new BufferedImage[3];
		jadawbDown[0] = jadawb.getSubimage(WIDTH, 0, WIDTH, HEIGHT);
		jadawbDown[1] = jadawb.getSubimage(0, 0, WIDTH, HEIGHT);
		jadawbDown[2] = jadawb.getSubimage(WIDTH*2, 0, WIDTH, HEIGHT);
		
		jadawbUp = new BufferedImage[2];
		jadawbUp[0] = jadawb.getSubimage(0, HEIGHT, WIDTH, HEIGHT);
		jadawbUp[1] = jadawb.getSubimage(WIDTH, HEIGHT, WIDTH, HEIGHT);
		
		jadawbLeft = new BufferedImage[2];
		jadawbLeft[0] = jadawb.getSubimage(WIDTH*2, HEIGHT, WIDTH, HEIGHT);
		jadawbLeft[1] = jadawb.getSubimage(0, HEIGHT*2, WIDTH, HEIGHT);
		
		jadawbRight = new BufferedImage[2];
		jadawbRight[0] = jadawb.getSubimage(WIDTH, HEIGHT*2, WIDTH, HEIGHT);
		jadawbRight[1] = jadawb.getSubimage(WIDTH*2, HEIGHT*2, WIDTH, HEIGHT);
		
		// jada: White shirt, gold shoes
		jadawgDown = new BufferedImage[3];
		jadawgDown[0] = jadawg.getSubimage(WIDTH, 0, WIDTH, HEIGHT);
		jadawgDown[1] = jadawg.getSubimage(0, 0, WIDTH, HEIGHT);
		jadawgDown[2] = jadawg.getSubimage(WIDTH*2, 0, WIDTH, HEIGHT);
		
		jadawgUp = new BufferedImage[2];
		jadawgUp[0] = jadawg.getSubimage(0, HEIGHT, WIDTH, HEIGHT);
		jadawgUp[1] = jadawg.getSubimage(WIDTH, HEIGHT, WIDTH, HEIGHT);
		
		jadawgLeft = new BufferedImage[2];
		jadawgLeft[0] = jadawg.getSubimage(WIDTH*2, HEIGHT, WIDTH, HEIGHT);
		jadawgLeft[1] = jadawg.getSubimage(0, HEIGHT*2, WIDTH, HEIGHT);
		
		jadawgRight = new BufferedImage[2];
		jadawgRight[0] = jadawg.getSubimage(WIDTH, HEIGHT*2, WIDTH, HEIGHT);
		jadawgRight[1] = jadawg.getSubimage(WIDTH*2, HEIGHT*2, WIDTH, HEIGHT);
		
		// jada: White shirt, red shoes
		jadawrDown = new BufferedImage[3];
		jadawrDown[0] = jadawr.getSubimage(WIDTH, 0, WIDTH, HEIGHT);
		jadawrDown[1] = jadawr.getSubimage(0, 0, WIDTH, HEIGHT);
		jadawrDown[2] = jadawr.getSubimage(WIDTH*2, 0, WIDTH, HEIGHT);
		
		jadawrUp = new BufferedImage[2];
		jadawrUp[0] = jadawr.getSubimage(0, HEIGHT, WIDTH, HEIGHT);
		jadawrUp[1] = jadawr.getSubimage(WIDTH, HEIGHT, WIDTH, HEIGHT);
		
		jadawrLeft = new BufferedImage[2];
		jadawrLeft[0] = jadawr.getSubimage(WIDTH*2, HEIGHT, WIDTH, HEIGHT);
		jadawrLeft[1] = jadawr.getSubimage(0, HEIGHT*2, WIDTH, HEIGHT);
		
		jadawrRight = new BufferedImage[2];
		jadawrRight[0] = jadawr.getSubimage(WIDTH, HEIGHT*2, WIDTH, HEIGHT);
		jadawrRight[1] = jadawr.getSubimage(WIDTH*2, HEIGHT*2, WIDTH, HEIGHT);
		
	}
	
}
