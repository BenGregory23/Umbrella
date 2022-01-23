package com.umbrella.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.umbrella.game.manager.GameManager;
import com.umbrella.game.object.GameObject;
import com.umbrella.game.client.maps.GameMap;
import com.umbrella.game.utils.tasks.InputThread;
import com.umbrella.game.utils.tasks.ThreadsManager;

public class Main extends ApplicationAdapter {
	SpriteBatch batch;
	GameObject go;
	ThreadsManager tasksManager;
	GameMap gameMap;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		go = new GameObject("test", new Texture("badlogic.jpg"));
		tasksManager = new ThreadsManager(new InputThread());
		GameManager.getInstance();

		gameMap = new GameMap(new int[10][10]);
	}

	@Override
	public void render () {

		ScreenUtils.clear(1, 0, 0, 1);
		gameMap.render();

		GameManager.getInstance();
		GameManager.getInstance().getUserInput().input();
		batch.begin();
		batch.draw(GameManager.getInstance().getPlayer().getTexture(), (float) GameManager.getInstance().getPlayer().getX(), (float) GameManager.getInstance().getPlayer().getY());
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
