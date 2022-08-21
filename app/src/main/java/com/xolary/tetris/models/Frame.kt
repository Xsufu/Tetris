package com.xolary.tetris.models

import com.xolary.tetris.helper.array2dOfByte

// Width - необходимая ширина генерируемого фрейма
class Frame(private val width: Int) {
    val data: ArrayList<ByteArray> = ArrayList()

    // Обрабатывает строку, преобразуя каждый отдельный символ
    // в байтовое представление и добавляет
    // байтовое представление в байтовый массив
    fun addRow(byteStr: String): Frame {
        val row = ByteArray(byteStr.length)

        for (index in byteStr.indices) {
            row[index] = "${byteStr[index]}".toByte()
        }

        data.add(row)
        return this
    }

    // Преобразует список массива данных в байтовый массив
    fun as2dByteArray(): Array<ByteArray> {
        val bytes = array2dOfByte(data.size, width)
        return data.toArray(bytes)
    }
}