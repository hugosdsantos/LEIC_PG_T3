package org.example

import pt.isel.canvas.BLACK
import pt.isel.canvas.Canvas
import pt.isel.canvas.ESCAPE_CODE
import pt.isel.canvas.WHITE

const val WIDTH = BRICK_WIDTH * 13
const val HEIGHT = 600
const val BACKGROUND_COLOR = BLACK

const val CANVAS_INVALID_POS_OFFSET = 10
const val TIME_TICK_MLS = 10

enum class Collision {
    HORIZONTAL,
    VERTICAL,
    BOTH,
    NONE
}

enum class DIRECTIONS(val value: Int) {
    DOWN(value = 1),
    UP(value = -1),
}

data class Area(val width: Int = WIDTH, val height: Int = HEIGHT)
data class Game(
    val area: Area = Area(),
    val balls: List<Ball> = emptyList(),
    val racket: Racket = Racket(),
    val bricks: List<Brick> = emptyList()
)

val arena = Canvas(WIDTH, HEIGHT, BACKGROUND_COLOR)

fun gameStart() {
    var game = Game(bricks = generateInitialBricksLayout(bricksLayout), balls = listOf(generateRandomBall()))

    arena.onTimeProgress(period = TIME_TICK_MLS) {
        arena.erase()
        val updatedBalls = handleGameBallsBehaviour(balls = game.balls, racket = game.racket, bricks = game.bricks)

        if (!game.balls.isEmpty() && updatedBalls.isEmpty()) arena.close()
        game = game.copy(balls = updatedBalls)
        drawGame(game)
    }

    arena.onMouseMove { me ->
        game = game.copy(racket = game.racket.moveTo(to = me.x))
    }

    arena.onKeyPressed {
        if (it.code == ESCAPE_CODE) arena.close()
    }
}

/*
* Desenha as bolas em jogo no canvas
* */
fun drawBalls(ballsList: List<Ball>) {
    ballsList.forEach { arena.drawCircle(xCenter = it.x, yCenter = it.y, radius = BALL_RADIUS, color = BALL_COLOR) }
}

/*
* Desenha no canvas o número de bolas em jogo no momento*/
fun drawBallsCounter(balls: List<Ball>) {
    arena.drawText(
        x = WIDTH / 2,
        y = BALL_COUNTER_YCORD,
        txt = balls.size.toString(),
        color = WHITE,
        fontSize = BALL_COUNT_FONTSIZE
    )
}

/*
* A cada step do jogo, remove as bolas fora de jogo, verifica as colisões e atualiza os movimentos das bolas para serem desenhadas novamente.
* */
fun handleGameBallsBehaviour(balls: List<Ball>, racket: Racket, bricks: List<Brick>): List<Ball> {
    //val filteredBalls = filterallsOutOfBounds(balls = balls)
    val newBallsUpdated =
        balls.map { checkAndUpdateBallMovementAfterCollision(ball = it, racket = racket, bricks) }
    val ballsMoved = updateBallsMovement(balls = newBallsUpdated)
    return ballsMoved
}

/*
* Filtra a lista de bolas de jogo removendo as que estão fora dos limites de jogo
* */
fun filterBallsOutOfBounds(balls: List<Ball>) = balls.filter { !it.isOutOfBounds() }

/*
* Verifica a colisão de cada bola e atualiza a velocidade e movimento de cada uma
* */
fun checkAndUpdateBallMovementAfterCollision(ball: Ball, racket: Racket, bricks: List<Brick>) =
    updateBallMovementAfterCollision(
        ball = ball,
        racket = racket,
        racketCollision = ball.isCollidingWithRacket(racket = racket),
        areaCollision = ball.isCollidingWithArea(),
        brickCollision = ball.checkBricksCollision(bricks)
    )

fun drawBricks(bricks: List<Brick>) {
    val BRICK_STROKE_OFFSET_ADJUSTMENT = 2
    bricks.forEach {
        arena.drawRect(
            x = it.x,
            y = it.y,
            width = BRICK_WIDTH,
            height = BRICK_HEIGHT,
            color = it.type.color
        )
        arena.drawRect(
            x = it.x + BRICK_STROKE_OFFSET_ADJUSTMENT,
            y = it.y + BRICK_STROKE_OFFSET_ADJUSTMENT,
            width = BRICK_WIDTH - BRICK_STROKE_OFFSET_ADJUSTMENT,
            height = BRICK_HEIGHT - BRICK_STROKE_OFFSET_ADJUSTMENT,
            color = BLACK,
            thickness = 2
        )
    }
}

fun generateWallBricks(): List<Brick> {
    var lista: List<Brick> = emptyList()
    for (x in LeftMarginBricks * 4..WIDTH - RightMarginBricks * 4 step BRICK_WIDTH) {
        for (y in TopMarginBricks..TopMarginBricks + BRICK_HEIGHT * 3 step BRICK_HEIGHT + 2) {
            lista = lista + Brick(x, y, BrickType.entries.random())
        }
    }
    return lista
}

fun generateInitialBricksLayout(layout: List<BricksColumn>): List<Brick> {
    var lista: List<Brick> = emptyList()
    var y = TopMarginBricks * 3
    var x = 0
    var initialX = 0
    var columnSize = 0

    for (column in layout) {
        column.rows.forEach {
            columnSize = it.bricks.size
            it.bricks.forEach {
                x += BRICK_WIDTH
                lista = lista + Brick(x, y, it)
            }
            y += BRICK_HEIGHT
            x = initialX
        }
        initialX += BRICK_WIDTH * (columnSize + 1)
        x = initialX
        y = TopMarginBricks * 3
    }

    return lista;
}

/*
* Desenha o jogo no canvas, que inclui desenhar a raquete, bolas e o contador de bolas em jogo
* */
fun drawGame(game: Game) {
    drawRacket(racket = game.racket)
    drawBalls(ballsList = game.balls)
    drawBallsCounter(balls = game.balls)
    drawBricks(bricks = game.bricks)
}
