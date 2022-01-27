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
	ThreadsManager tasksManager;
	MapRenderer mapRenderer;
	GameMap gameMap;
	
	@Override
	public void create () {

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
	}
	
	@Override
	public void dispose () {
		mapRenderer.dispose();
	}
}
