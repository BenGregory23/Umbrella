package com.umbrella.game.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.umbrella.game.manager.GameManager;

public class DisplayPlayer {
    private SpriteBatch batch;
    private Texture cycleTexture;
    private int widthTexture;
    private  int heightTexture;
    private int nbFrames;
    private Player player;

    private TextureRegion[] animationFrames;
    private Animation<TextureRegion> animation;

    private float elapsedTime;


    public DisplayPlayer(Texture cycleTexture, int widthTexture, int heightTexture, int nbFrames){
        this.cycleTexture = cycleTexture;
        this.widthTexture = widthTexture;
        this.heightTexture = heightTexture;
        this.nbFrames = nbFrames;
        player = GameManager.getInstance().getPlayer();
        batch = new SpriteBatch();
    }

    public void splitTexture(){
        TextureRegion[][] tmpFrames = TextureRegion.split(cycleTexture, widthTexture, heightTexture);
        animationFrames = new TextureRegion[nbFrames];

        int index = 0;

        for(int i =0; i < nbFrames/2; i++){
            for(int j = 0; j < nbFrames/2; j++){
                animationFrames[index++] = tmpFrames[j][i];
            }
        }

        animation = new Animation(1f/4f, animationFrames);
    }

    public void animate(){
        elapsedTime += Gdx.graphics.getDeltaTime();
        batch.begin();
        batch.draw(animation.getKeyFrame(elapsedTime, true), player.getX(), player.getY() );
        batch.end();
    }
}
