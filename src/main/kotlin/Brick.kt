package org.example

const val BRICK_HEIGHT = 15
const val BRICK_WIDTH = 32

const val TopMarginBricks = BRICK_HEIGHT * 3
const val LeftMarginBricks = BRICK_WIDTH
const val RightMarginBricks = BRICK_WIDTH
const val SINGLE_HIT = 1;
const val DOUBLE_HIT = 1;
const val INDESTRUCTIBLE = 0;
const val ORANGE_COLOR = 0xF59827;
const val SILVER_COLOR = 0x999999;
const val GOLD_COLOR = 0xF59827;

enum class BrickType(val points: Int, val hits: Int, val color: Int) {
    WHITE(points = 1, hits = SINGLE_HIT, color = pt.isel.canvas.WHITE),
    ORANGE(points = 2, hits = SINGLE_HIT, color = ORANGE_COLOR),
    CYAN(points = 3, hits = SINGLE_HIT, color = pt.isel.canvas.CYAN),
    GREEN(points = 4, hits = SINGLE_HIT, color = pt.isel.canvas.GREEN),
    RED(points = 6, hits = SINGLE_HIT, color = pt.isel.canvas.RED),
    BLUE(points = 7, hits = SINGLE_HIT, color = pt.isel.canvas.BLUE),
    MAGENTA(points = 8, hits = SINGLE_HIT, color = pt.isel.canvas.MAGENTA),
    YELLOW(points = 9, hits = SINGLE_HIT, color = pt.isel.canvas.YELLOW),
    SILVER(points = 0, hits = DOUBLE_HIT, color = SILVER_COLOR),
    GOLD(points = 0, hits = INDESTRUCTIBLE, color = GOLD_COLOR),
}

data class Brick(val x: Int, val y: Int, val type: BrickType, val hitCounter: Int = 0)

