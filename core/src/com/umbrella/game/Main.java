package com.umbrella.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.umbrella.game.object.GameObject;
import com.umbrella.game.client.maps.GameMap;
import com.umbrella.game.utils.tasks.InputThread;
import com.umbrella.game.utils.tasks.ThreadsManager;

public class Main extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	GameObject go;
	ThreadsManager tasksManager;
	GameMap gameMap;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		go = new GameObject("test", new Texture("badlogic.jpg"));
		tasksManager = new ThreadsManager(new InputThread());

		gameMap = new GameMap(new int[2][2]);
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		gameMap.render();
		batch.begin();
		batch.draw(go.getTexture(), 0,0,100,100);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
