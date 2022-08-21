package com.xolary.tetris.models

import android.graphics.Point
import com.xolary.tetris.constans.FieldConstants
import com.xolary.tetris.helper.array2dOfByte
import com.xolary.tetris.storage.AppPreferences

class AppModel {
    enum class Statuses {
        AWAITING_RESTART, ACTIVE, INACTIVE, OVER
    }

    enum class Motions {
        LEFT, RIGHT, DOWN, ROTATE
    }
}