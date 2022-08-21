package com.xolary.tetris.models

import android.graphics.Point
import com.xolary.tetris.constans.CellConstants
import com.xolary.tetris.constans.FieldConstants
import com.xolary.tetris.helper.array2dOfByte
import com.xolary.tetris.storage.AppPreferences

class AppModel {
    // Текущий счёт
    var score: Int = 0

    // Доступ к SharedPreferences
    private var preferences: AppPreferences? = null

    // Текущий игровой блок
    var currentBlock: Block? = null

    // Текущее состояние игры
    var currentState: String = Statuses.AWAITING_START.name

    // Двумерный массив - игровое поле
    private var field: Array<ByteArray> = array2dOfByte(
        FieldConstants.ROW_COUNT.value,
        FieldConstants.COLUMN_COUNT.value
    )

    // Состояния статуса
    enum class Statuses {
        AWAITING_START, ACTIVE, INACTIVE, OVER
    }

    // Состояния движения
    enum class Motions {
        LEFT, RIGHT, DOWN, ROTATE
    }

    fun setPreferences(preferences: AppPreferences?) {
        this.preferences = preferences
    }

    fun getCellStatus(row: Int, column: Int): Byte? {
        return field[row][column]
    }

    private fun setCellStatus(row: Int, column: Int, status: Byte?) {
        if (status != null) {
            field[row][column] = status
        }
    }

    fun isGameOver(): Boolean {
        return currentState == Statuses.OVER.name
    }

    fun isGameActive(): Boolean {
        return currentState == Statuses.ACTIVE.name
    }

    fun isGameAwaitingStart(): Boolean {
        return currentState == Statuses.AWAITING_START.name
    }

    // Увеличение количества очков и обновление рекорда
    private fun boostScore() {
        score += 10
        if (score > preferences?.getHighScore() as Int)
            preferences?.saveHighScore(score)
    }

    // Создание нового экземпляра блока
    private fun generateNextBlock() {
        currentBlock = Block.createBlock()
    }

    private fun validTransaction(position: Point, shape: Array<ByteArray>): Boolean {
        if (position.y < 0 || position.x < 0) {
            return false
        } else if (position.y + shape.size > FieldConstants.ROW_COUNT.value) {
            return false
        } else if (position.x + shape[0].size > FieldConstants.COLUMN_COUNT.value) {
            return false
        } else {
            for (i in 0 until shape.size) {
                for (j in 0 until shape[i].size) {
                    val y = position.y + i
                    val x = position.x + j
                    if (CellConstants.EMPTY.value != shape[i][j] &&
                        CellConstants.EMPTY.value != field[y][x]) {
                        return false
                    }
                }
            }
        }
        return true
    }
}