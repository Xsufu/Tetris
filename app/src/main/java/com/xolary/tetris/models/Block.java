package com.xolary.tetris.models;

import android.graphics.Color;
import android.graphics.Point;

import java.util.Random;

public class Block {
    private int shapeIndex;
    private int frameNumber;
    private BlockColor color;
    private Point position;

    private Block(int shapeIndex, BlockColor blockColor) {
        this.frameNumber = 0;
        this.shapeIndex = shapeIndex;
        this.color = blockColor;
        this.position = new Point(FieldConstants.COLUMN_COUNT.getValue() / 2, 0);
    }

    // Функция создания блока
    public static Block createBlock() {
        // Экземпляр класс Random
        Random random = new Random();
        // Выбираем случайную форму из списка
        int shapeIndex = random.nextInt(Shape.values().length);
        // Выбираем случайный цвет для блока
        BlockColor blockColor = BlockColor.values()
                [random.nextInt(BlockColor.values().length)];

        // Создаём блок с указанными параметрами
        Block block = new Block(shapeIndex, blockColor);
        // Задаём его стартовую позицию
        block.position.x = block.position.x - Shape.values()
                [shapeIndex].getStartPosition();
        return block;
    }

    public enum BlockColor {
        PINK(Color.rgb(255, 105, 180), (byte) 2),
        GREEN(Color.rgb(0, 188, 0), (byte) 3),
        ORANGE(Color.rgb(255, 140, 0), (byte) 4),
        YELLOW(Color.rgb(255, 255, 0), (byte) 5),
        CYAN(Color.rgb(0, 255, 255), (byte) 6);

        BlockColor(int rgbValue, byte value) {
            this.rgbValue = rgbValue;
            this.byteValue = value;
        }

        private final int rgbValue;
        private final byte byteValue;
    }
}
