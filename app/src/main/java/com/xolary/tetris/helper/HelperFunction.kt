package com.xolary.tetris.helper

/**
 * Метод генерирует новый массив с указанными свойствами
 *
 * @param sizeOuter номер строки создаваемого массива
 * @param sizeInner номер столбца сгенерированного массива байтов
 * @return сгенерированный массив
 */
fun array2dOfByte(sizeOuter: Int, sizeInner: Int): Array<ByteArray>
    = Array(sizeOuter) { ByteArray(sizeInner) }