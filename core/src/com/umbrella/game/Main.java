package com.umbrella.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.umbrella.game.client.maps.GameMap;
import com.umbrella.game.manager.GameManager;
import com.umbrella.game.object.GameObject;
import com.umbrella.game.client.maps.MapRenderer;
import com.umbrella.game.utils.tasks.InputThread;
import com.umbrella.game.utils.tasks.ThreadsManager;


public class Main extends ApplicationAdapter {
	GameObject go;
	ThreadsManager tasksManager;
	MapRenderer mapRenderer;
	GameMap gameMap;
	
	@Override
	public void create () {
		go = new GameObject("test", new Texture("badlogic.jpg"));
		tasksManager = new ThreadsManager(new InputThread());

		gameMap = new GameMap(40, 23);
		gameMap.generateRandom();
		mapRenderer = new MapRenderer(gameMap);
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		mapRenderer.render();
		GameManager.getInstance().gameLoop();
		//go.render();
	}
	
	@Override
	public void dispose () {
		mapRenderer.dispose();

		go.dispose();
	}
}
