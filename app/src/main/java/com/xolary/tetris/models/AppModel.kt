package com.xolary.tetris.models

import android.graphics.Point
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
}