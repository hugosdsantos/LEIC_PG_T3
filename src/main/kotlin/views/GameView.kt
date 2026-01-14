package org.example.views

import org.example.models.*
import pt.isel.canvas.ESCAPE_CODE
import pt.isel.canvas.WHITE
import pt.isel.canvas.YELLOW


fun gameStart() {
    val racket = Racket()
    val bricks = listOf(
        Brick(x = 0, y = 0, type = BrickType.GREEN, hitCounter = 0),
        Brick(x = 0, y = 15, type = BrickType.RED, hitCounter = 0),
        Brick(x = 0, y = 30, type = BrickType.GREEN, hitCounter = 0),
        Brick(x = 0, y = 45, type = BrickType.RED, hitCounter = 0),
        Brick(x = 0, y = 60, type = BrickType.GREEN, hitCounter = 0),
        Brick(x = 0, y = 75, type = BrickType.RED, hitCounter = 0),
        Brick(x = 0, y = 90, type = BrickType.GREEN, hitCounter = 0),
        Brick(x = 0, y = 105, type = BrickType.RED, hitCounter = 0),
        Brick(x = 0, y = 120, type = BrickType.GREEN, hitCounter = 0),
        Brick(x = 0, y = 135, type = BrickType.RED, hitCounter = 0),
        Brick(x = 0, y = 150, type = BrickType.GREEN, hitCounter = 0),
        Brick(x = 0, y = 165, type = BrickType.RED, hitCounter = 0),
        Brick(x = 0, y = 180, type = BrickType.GREEN, hitCounter = 0),
        Brick(x = 0, y = 195, type = BrickType.RED, hitCounter = 0),
        Brick(x = 0, y = 210, type = BrickType.GREEN, hitCounter = 0),
        Brick(x = 0, y = 225, type = BrickType.RED, hitCounter = 0),
        Brick(x = 0, y = 240, type = BrickType.GREEN, hitCounter = 0),
        Brick(x = 0, y = 255, type = BrickType.RED, hitCounter = 0),
        Brick(x = 0, y = 270, type = BrickType.GREEN, hitCounter = 0),
        Brick(x = 0, y = 285, type = BrickType.RED, hitCounter = 0),
        Brick(x = 0, y = 300, type = BrickType.GREEN, hitCounter = 0),
        Brick(x = 0, y = 315, type = BrickType.RED, hitCounter = 0),
        Brick(x = 0, y = 330, type = BrickType.GREEN, hitCounter = 0),
        Brick(x = 0, y = 345, type = BrickType.RED, hitCounter = 0),
        Brick(x = 0, y = 360, type = BrickType.GREEN, hitCounter = 0),
        Brick(x = 0, y = 375, type = BrickType.RED, hitCounter = 0),
        Brick(x = 0, y = 390, type = BrickType.GREEN, hitCounter = 0),
        Brick(x = 0, y = 405, type = BrickType.RED, hitCounter = 0),
        Brick(x = 0, y = 420, type = BrickType.GREEN, hitCounter = 0),
        Brick(x = 0, y = 435, type = BrickType.RED, hitCounter = 0),
        Brick(x = 0, y = 450, type = BrickType.GREEN, hitCounter = 0),
        Brick(x = 0, y = 465, type = BrickType.RED, hitCounter = 0),
        Brick(x = 0, y = 480, type = BrickType.GREEN, hitCounter = 0),
        Brick(x = 0, y = 495, type = BrickType.RED, hitCounter = 0),
        Brick(x = 0, y = 510, type = BrickType.GREEN, hitCounter = 0),
        Brick(x = 0, y = 525, type = BrickType.RED, hitCounter = 0),
        Brick(x = 0, y = 540, type = BrickType.GREEN, hitCounter = 0),
        Brick(x = 0, y = 555, type = BrickType.RED, hitCounter = 0),
        Brick(x = 0, y = 570, type = BrickType.GREEN, hitCounter = 0),
        Brick(x = 0, y = 585, type = BrickType.RED, hitCounter = 0),
        Brick(x = 0, y = 600, type = BrickType.GREEN, hitCounter = 0),
        Brick(x = WIDTH - BRICK_WIDTH, y = 0, type = BrickType.GREEN, hitCounter = 0),
        Brick(x = WIDTH - BRICK_WIDTH, y = 15, type = BrickType.RED, hitCounter = 0),
        Brick(x = WIDTH - BRICK_WIDTH, y = 30, type = BrickType.GREEN, hitCounter = 0),
        Brick(x = WIDTH - BRICK_WIDTH, y = 45, type = BrickType.RED, hitCounter = 0),
        Brick(x = WIDTH - BRICK_WIDTH, y = 60, type = BrickType.GREEN, hitCounter = 0),
        Brick(x = WIDTH - BRICK_WIDTH, y = 75, type = BrickType.RED, hitCounter = 0),
        Brick(x = WIDTH - BRICK_WIDTH, y = 90, type = BrickType.GREEN, hitCounter = 0),
        Brick(x = WIDTH - BRICK_WIDTH, y = 105, type = BrickType.RED, hitCounter = 0),
        Brick(x = WIDTH - BRICK_WIDTH, y = 120, type = BrickType.GREEN, hitCounter = 0),
        Brick(x = WIDTH - BRICK_WIDTH, y = 135, type = BrickType.RED, hitCounter = 0),
        Brick(x = WIDTH - BRICK_WIDTH, y = 150, type = BrickType.GREEN, hitCounter = 0),
        Brick(x = WIDTH - BRICK_WIDTH, y = 165, type = BrickType.RED, hitCounter = 0),
        Brick(x = WIDTH - BRICK_WIDTH, y = 180, type = BrickType.GREEN, hitCounter = 0),
        Brick(x = WIDTH - BRICK_WIDTH, y = 195, type = BrickType.RED, hitCounter = 0),
        Brick(x = WIDTH - BRICK_WIDTH, y = 210, type = BrickType.GREEN, hitCounter = 0),
        Brick(x = WIDTH - BRICK_WIDTH, y = 225, type = BrickType.RED, hitCounter = 0),
        Brick(x = WIDTH - BRICK_WIDTH, y = 240, type = BrickType.GREEN, hitCounter = 0),
        Brick(x = WIDTH - BRICK_WIDTH, y = 255, type = BrickType.RED, hitCounter = 0),
        Brick(x = WIDTH - BRICK_WIDTH, y = 270, type = BrickType.GREEN, hitCounter = 0),
        Brick(x = WIDTH - BRICK_WIDTH, y = 285, type = BrickType.RED, hitCounter = 0),
        Brick(x = WIDTH - BRICK_WIDTH, y = 300, type = BrickType.GREEN, hitCounter = 0),
        Brick(x = WIDTH - BRICK_WIDTH, y = 315, type = BrickType.RED, hitCounter = 0),
        Brick(x = WIDTH - BRICK_WIDTH, y = 330, type = BrickType.GREEN, hitCounter = 0),
        Brick(x = WIDTH - BRICK_WIDTH, y = 345, type = BrickType.RED, hitCounter = 0),
        Brick(x = WIDTH - BRICK_WIDTH, y = 360, type = BrickType.GREEN, hitCounter = 0),
        Brick(x = WIDTH - BRICK_WIDTH, y = 375, type = BrickType.RED, hitCounter = 0),
        Brick(x = WIDTH - BRICK_WIDTH, y = 390, type = BrickType.GREEN, hitCounter = 0),
        Brick(x = WIDTH - BRICK_WIDTH, y = 405, type = BrickType.RED, hitCounter = 0),
        Brick(x = WIDTH - BRICK_WIDTH, y = 420, type = BrickType.GREEN, hitCounter = 0),
        Brick(x = WIDTH - BRICK_WIDTH, y = 435, type = BrickType.RED, hitCounter = 0),
        Brick(x = WIDTH - BRICK_WIDTH, y = 450, type = BrickType.GREEN, hitCounter = 0),
        Brick(x = WIDTH - BRICK_WIDTH, y = 465, type = BrickType.RED, hitCounter = 0),
        Brick(x = WIDTH - BRICK_WIDTH, y = 480, type = BrickType.GREEN, hitCounter = 0),
        Brick(x = WIDTH - BRICK_WIDTH, y = 495, type = BrickType.RED, hitCounter = 0),
        Brick(x = WIDTH - BRICK_WIDTH, y = 510, type = BrickType.GREEN, hitCounter = 0),
        Brick(x = WIDTH - BRICK_WIDTH, y = 525, type = BrickType.RED, hitCounter = 0),
        Brick(x = WIDTH - BRICK_WIDTH, y = 540, type = BrickType.GREEN, hitCounter = 0),
        Brick(x = WIDTH - BRICK_WIDTH, y = 555, type = BrickType.RED, hitCounter = 0),
        Brick(x = WIDTH - BRICK_WIDTH, y = 570, type = BrickType.GREEN, hitCounter = 0),
        Brick(x = WIDTH - BRICK_WIDTH, y = 585, type = BrickType.RED, hitCounter = 0),
        Brick(x = WIDTH - BRICK_WIDTH, y = 600, type = BrickType.GREEN, hitCounter = 0),
    )

    val ball = Ball(x = 277.0, y = 150.0, deltaX = -3, deltaY = -2, weight = 1.0, stuck = false)

    var game = Game(
        racket = racket,
        bricks = bricks,
        balls = listOf(ball)
    )

    arena.onTimeProgress(period = TIME_TICK_MLS) {
        arena.erase()

        if (!game.isGameOver()) game = game.progressGame() else drawFinishText()
        drawGame(game)
    }

    arena.onMouseMove { me ->
        game = adjustHorizontalCordForStuckBall(game, mouseX = me.x)
    }

    arena.onMouseDown { me ->
        if (me.down && game.lives > 0) {
            if (game.balls.isEmpty()) {
                game = game.newBall()
                game = game.loseLife()
            } else {
                if (game.isGameOver() && game.level < gameLevels.size) {
                    game = game.newLevel()
                } else {
                    game = unstuckBalls(game)
                }
            }
        }
    }

    arena.onKeyPressed {
        if (it.code == ESCAPE_CODE) arena.close()
        if (it.code == KEY_X_CODE) {
            game = game.copy(racket = game.racket.toggleStickiness())
            println("sticky ${game.racket.sticky}")
        }

        if (it.code == KEY_F_CODE) {
            game = game.copy(balls = giftFastBalls(game.balls))
            println("fast balls ${game.balls.first().weight}")
        }

        if (it.code == KEY_S_CODE) {
            game = game.copy(balls = giftSlowBalls(game.balls))
            println("slow balls ${game.balls.first().weight}")
        }

        if (it.code == KEY_D_CODE) {
            game = game.copy(balls = giftDuplicateBall(game.balls))
            println("duplicate balls")
        }

        if (it.code == KEY_E_CODE) {
            game = game.copy(racket = giftExtendedRacket(game.racket))
            println("extended racket")
        }

        if (it.code == KEY_C_CODE) {
            game = giftCancelEffects(game)
            println("cancel")
        }

    }
}


/*
* Desenha no canvas o número de pontos adquiridos durante o jogo no momento*/
fun drawGamePoints(points: Int) {
    arena.drawText(
        x = WIDTH / 2,
        y = BALL_COUNTER_YCORD,
        txt = points.toString(),
        color = WHITE,
        fontSize = BALL_COUNT_FONTSIZE
    )
}

/*
* Desenha o jogo no canvas, que inclui desenhar a raquete, bolas e o contador de bolas em jogo
* */
fun drawGame(game: Game) {

    val glueCounter = game.activeGifts
        .filter { it.type == GiftType.GLUE }
        .fold(0) { sum, elem -> sum + elem.useCount }

    drawRacket(racket = game.racket, glueCounter)
    drawBalls(ballsList = game.balls)
    drawGamePoints(points = game.points)
    drawBricks(bricks = game.bricks)
    drawLives(lives = game.lives)
    drawActiveGifts(activeGifts = game.giftsOnScreen)
}

fun drawActiveGifts(activeGifts: List<Gift>) {
    activeGifts.forEach { it.drawGift() }
}

fun drawLives(lives: Int) {
    drawBalls(generateLives(lives))
}

fun drawFinishText() {
    arena.drawText(WIDTH - 100, LIVES_Y_POSITION, "FINISHED!", YELLOW, 16)
}
