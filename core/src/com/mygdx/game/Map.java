package com.mygdx.game;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Ervok on 06.12.2017.
 */

public class Map extends Actor {

    private int[][] fields;
    Texture tile;
    private int offset;
    private int tile_size;

    public Map() {
        fields = new int[10][10];
        tile = new Texture("sprites/tile.png");
        this.offset=(MyGdxGame.WIDTH-MyGdxGame.HEIGHT)/2;
        this.tile_size=MyGdxGame.HEIGHT/10;
    }

    public void render(Camera cam, SpriteBatch sb){
        sb.setProjectionMatrix(cam.combined);
        sb.begin();

        for (int i=0;i<10;i++ )
            for (int j=0;j<10;j++ )
                if(fields[i][j]==1)
                    sb.draw(tile,j*tile_size+offset,(9-i)*tile_size,tile_size,tile_size);

        sb.end();
    }
    public void setFields(int[][] f){
        for (int i=0;i<10;i++ )
            for (int j=0;j<10;j++ )
                fields[i][j]=f[i][j];
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        for (int i=0;i<10;i++ )
            for (int j=0;j<10;j++ )
                if(fields[i][j]==1)
                    batch.draw(tile,j*tile_size+offset,(9-i)*tile_size,tile_size,tile_size);
    }

    public int[][] getFields() {
        return fields;
    }

    public int getTile_size() {
        return tile_size;
    }

    public int getField(int i, int j) {
        return fields[i][j];
    }

    public int getOffset() {
        return offset;
    }
}
