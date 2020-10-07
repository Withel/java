package com.thewithel.rain.graphics;

public class Sprite {

    public final int SIZE;
    private int x, y;                       //coordinates of our sprite
    public int[] pixels;
    private SpriteSheet sheet;

    //makes new static instance of Sprite called grass, every instance has uniqe variables, because non of them is static
    //when we acces sprite.grass pixels we load apropirate texture into a pixel array, when Sprite.grass.pixels it refers
    //to apropriate pixels
    // X - WIDTH, Y - HEIGHT

    public static Sprite grass = new Sprite(16,0,0, SpriteSheet.tiles);          //this is the line of code that will create Sprite
    public static Sprite voidSprite = new Sprite(16, 0x169BC7);          //tile which will be rendered when something will go wrong, instead of null we return voidTile
    public static Sprite rockTile = new Sprite(16, 2, 2, SpriteSheet.tiles);
    public static Sprite flower = new Sprite(16,1,0, SpriteSheet.tiles);
    public static Sprite rock = new Sprite(16,2,0, SpriteSheet.tiles);


    //position is divided by 2 because size is multiply by 2 (look constructor)
    public static Sprite playerUp = new Sprite (32, 0, 7, SpriteSheet.tiles);
    public static Sprite playerDown = new Sprite (32, 0, 4, SpriteSheet.tiles);
    public static Sprite playerLeft = new Sprite (32, 0, 5, SpriteSheet.tiles);
    public static Sprite playerRight = new Sprite (32, 0, 6, SpriteSheet.tiles);
    //FOR ANIMATION :D
    public static Sprite playerUp1 = new Sprite (32, 1, 7, SpriteSheet.tiles);
    public static Sprite playerUp2 = new Sprite (32, 2, 7, SpriteSheet.tiles);

    public static Sprite playerDown1 = new Sprite (32, 1, 4, SpriteSheet.tiles);
    public static Sprite playerDown2 = new Sprite (32, 2, 4, SpriteSheet.tiles);

    public static Sprite playerLeft1 = new Sprite (32, 1, 5, SpriteSheet.tiles);
    public static Sprite playerLeft2 = new Sprite (32, 2, 5, SpriteSheet.tiles);

    public static Sprite playerRight1 = new Sprite (32, 1, 6, SpriteSheet.tiles);
    public static Sprite playerRight2 = new Sprite (32, 2, 6, SpriteSheet.tiles);

    //for my purpose
    public static Sprite red = new Sprite(16,15,15, SpriteSheet.tiles);
    public static Sprite black = new Sprite(16,14,15, SpriteSheet.tiles);

    public Sprite(int size, int x, int y, SpriteSheet sheet){
        SIZE = size;
        pixels = new int[SIZE*SIZE];
        this.x = x * size;
        this.y = y * size;
        this.sheet = sheet;
        load();
    }

    public Sprite(int size, int colour){
        SIZE = size;
        pixels = new int[SIZE*SIZE];
        setColour(colour);
    }

    private void setColour(int colour){
        for(int i=0; i<SIZE*SIZE; i++){
            pixels[i] = colour;
        }
    }


    //load method is just reading spritesheet, its finding coordinate of Sprite that we want to use, and then it scans,
    //every pixel of this sheet and loads it into object GENIALNE KURWA
    private void load(){
        for(int y =0;y<SIZE; y++){
            for(int x=0;x<SIZE; x++){
                pixels[x+y*SIZE] = sheet.pixels[(x+this.x) +(y+this.y)*sheet.SIZE];
            }
        }
    }
}
