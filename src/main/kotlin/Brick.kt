package org.example

import kotlin.math.abs

const val BRICK_HEIGHT = 15
const val BRICK_WIDTH = 32

const val TopMarginBricks = BRICK_HEIGHT * 3
const val LeftMarginBricks = BRICK_WIDTH
const val RightMarginBricks = BRICK_WIDTH
const val SINGLE_HIT = 1
const val DOUBLE_HIT = 1
const val INDESTRUCTIBLE = 0
const val ORANGE_COLOR = 0xF59827
const val SILVER_COLOR = 0x999999
const val GOLD_COLOR = 0xF59827

const val BRICK_HORIZONTAL_DETECTION_OFFSET = MAX_DELTA_X
const val BRICK_VERTICAL_DETECTION_OFFSET = MAX_DELTA_Y

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

fun checkBrickHorizontalCollision(ball: Ball, brick: Brick): Collision {
    if (ball.y + BALL_RADIUS in brick.y..brick.y + BRICK_HEIGHT) {
        if (ball.x + BALL_RADIUS + abs(ball.deltaX) in brick.x..brick.x + BRICK_WIDTH) {
            return Collision.HORIZONTAL
        } else if (ball.x - BALL_RADIUS - abs(ball.deltaX) in brick.x..brick.x + BRICK_WIDTH) {
            return Collision.HORIZONTAL
        }
    }
    return Collision.NONE
}

fun checkBrickVerticalCollision(ball: Ball, brick: Brick): Collision {
    if (ball.x + BALL_RADIUS in brick.x..brick.x + BRICK_WIDTH) {
        if (ball.y + BALL_RADIUS + abs(ball.deltaY) in brick.y..brick.y + BRICK_HEIGHT) {
            return Collision.VERTICAL
        } else if (ball.y - BALL_RADIUS - abs(ball.deltaY) in brick.y..brick.y + BRICK_HEIGHT) {
            return Collision.VERTICAL
        }
    }
    return Collision.NONE
}

fun checkBrickCollision(ball: Ball, brick: Brick): Collision {

    // ponto mais próximo dentro do retângulo
    val nearestX = ball.x.coerceIn(brick.x, brick.x + BRICK_WIDTH)
    val nearestY = ball.y.coerceIn(brick.y, brick.y + BRICK_HEIGHT)

    // diferença até ao centro da bola
    val dx = ball.x - nearestX
    val dy = ball.y - nearestY

    // se distância < raio → colisão
    if (dx * dx + dy * dy <= BALL_RADIUS * BALL_RADIUS) {

        return if (abs(dx) > abs(dy))
            Collision.HORIZONTAL   // bateu nas laterais
        else
            Collision.VERTICAL     // bateu em cima/baixo
    }

    return Collision.NONE
}