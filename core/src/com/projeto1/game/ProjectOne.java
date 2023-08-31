package com.projeto1.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.Gdx;

public class ProjectOne extends ApplicationAdapter {
	SpriteBatch batch;


	Player player;

	@Override
	public void create () {
		batch = new SpriteBatch();

		player = new Player();
		Gdx.input.setInputProcessor(player);

		player.create(batch);
	}

	@Override
	public void render () {
		ScreenUtils.clear(200, 242, 250, 1);
		player.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
