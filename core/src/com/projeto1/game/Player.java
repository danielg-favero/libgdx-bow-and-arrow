package com.projeto1.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class Player implements InputProcessor {
    float x = 0;
    float y = 0;
    boolean isUpPressed = false;
    boolean isDownPressed = false;
    float speed = 10.0f;
    Array<Arrow> arrows;
    Texture arrowTexture;
    SpriteBatch batch;
    Texture playerSprite;
    TextureRegion playerTexture;
    ArrowController arrowController;


    public void create(SpriteBatch batch) {
        playerSprite = new Texture("shot_1.png");
        playerTexture = new TextureRegion(playerSprite, 128, 0, 128, 128);
        arrowTexture = new Texture("arrow.png");
        new ArrowController(batch, arrowTexture);

        this.batch = batch;
    }

    public void render() {
        batch.begin();
        batch.draw(playerTexture, x, y);
        batch.end();

        if(isUpPressed && y < Gdx.graphics.getHeight() - speed) {
            y += speed;
        } else if(isDownPressed && y >= 0) {
            y -= speed;
        }

        ArrowController.ref.render(Gdx.graphics.getDeltaTime());
    }

    @Override
    public boolean keyDown(int keycode) {
        if(keycode == Input.Keys.W) {
            isUpPressed = true;
        } else if (keycode == Input.Keys.S) {
            isDownPressed = true;
        } else if (keycode == Input.Keys.SPACE) {
            ArrowController.ref.init(90, y + 10);
        }

        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        if(keycode == Input.Keys.W) {
            isUpPressed = false;
        } else if (keycode == Input.Keys.S) {
            isDownPressed = false;
        }

        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
       return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
