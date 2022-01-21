package com.umbrella.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.umbrella.game.utils.tasks.InputThread;
import com.umbrella.game.utils.tasks.ThreadsManager;

public class Main extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	ThreadsManager tasksManager;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("img/damn.jpeg");
		tasksManager = new ThreadsManager(new InputThread());
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(img, 0, 0, 700,500);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
