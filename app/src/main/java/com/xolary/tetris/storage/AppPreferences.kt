package com.xolary.tetris.storage

import android.content.Context
import android.content.SharedPreferences

class AppPreferences(ctx: Context) {
    var data: SharedPreferences = ctx.getSharedPreferences("APP_PREFERENCES", Context.MODE_PRIVATE)

    // Сохранение рекорда в память
    fun saveHighScore(highScore: Int) {
        data.edit().putInt("HIGH_SCORE", highScore).apply()
    }

    // Получение рекорда
    fun getHighScore(): Int {
        return data.getInt("HIGH_SCORE", 0)
    }

    // Сброс рекорда
    fun clearHighScore() {
        data.edit().putInt("HIGH_SCORE", 0).apply()
    }
}