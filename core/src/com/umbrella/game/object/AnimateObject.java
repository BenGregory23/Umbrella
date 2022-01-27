package com.umbrella.game.object;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.umbrella.game.player.Player;

public class AnimateObject {
    private SpriteBatch batch;
    private Texture cycleTextureX;
    private Texture cycleTextureY;
    private int widthTexture;
    private int heightTexture;
    private int nbFrames;
    private boolean flip = false;
    private Player player;

    private TextureRegion[] animationFramesX;
    private Animation<TextureRegion> animationX;

    private TextureRegion[] animationFramesY;
    private Animation<TextureRegion> animationY;

    private float elapsedTime;

    public AnimateObject(Texture cycleTextureX, Texture cycleTextureY, int widthTexture, int heigthTexture, int nbFrames, Player player){
        this.cycleTextureX = cycleTextureX;
        this.cycleTextureY = cycleTextureY;
        batch = new SpriteBatch();
        this.widthTexture = widthTexture;
        this.heightTexture = heigthTexture;
        this.nbFrames = nbFrames;
        this.player = player;
    }

    public void splitTexture(){
        //pour l'axe X
        TextureRegion[][] tmpFrames = TextureRegion.split(cycleTextureX,widthTexture, heightTexture);
        animationFramesX = new TextureRegion[nbFrames];
        int index = 0;

        for(int i =0; i < nbFrames/2; i++){
            for(int j = 0; j < nbFrames/2; j++){
                animationFramesX[index++] = tmpFrames[j][i];
            }
        }

        animationX = new Animation(1f/4f, animationFramesX);

        //pour l'axe y
        tmpFrames = TextureRegion.split(cycleTextureY,widthTexture, heightTexture);
        animationFramesY = new TextureRegion[nbFrames];
        index = 0;

        for(int i =0; i < nbFrames/2; i++){
            for(int j = 0; j < nbFrames/2; j++){
                animationFramesY[index++] = tmpFrames[j][i];
            }
        }

        animationY = new Animation(1f/4f, animationFramesY);

    }

    public void animateX(boolean left){
        elapsedTime += Gdx.graphics.getDeltaTime();
        batch.begin();
        batch.draw( animationX.getKeyFrame(elapsedTime, true),  player.getX(), player.getY(), left ? -widthTexture : widthTexture, heightTexture);
        batch.end();

    }

    public void animateY(){
        elapsedTime += Gdx.graphics.getDeltaTime();
        batch.begin();
        batch.draw( animationY.getKeyFrame(elapsedTime, true), player.getX(), player.getY());
        batch.end();
    }

    public void flip(){
            flip = !flip;
    }
}
