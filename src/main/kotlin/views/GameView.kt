package org.example.views

import org.example.models.*
import pt.isel.canvas.BLACK
import pt.isel.canvas.ESCAPE_CODE
import pt.isel.canvas.WHITE



fun gameStart() {
    var game = Game(bricks = generateInitialBricksLayout(bricksLayout), balls = listOf(generateRandomBall()))

    arena.onTimeProgress(period = TIME_TICK_MLS) {
        arena.erase()
        game = game.progressGame()
        drawGame(game)
    }

    arena.onMouseMove { me ->
        game = adjustHorizontalCordForStuckBall(game, me.x)
    }

    arena.onMouseDown { me ->
        if (me.down) {
            game = unstuckBalls(game)
        }
    }

    arena.onKeyPressed {
        if (it.code == ESCAPE_CODE) arena.close()
        if (it.code == KEY_S_CODE) {
            game = game.copy(racket = game.racket.toggleStickiness())
            println("sticky ${game.racket.sticky}")
        }
    }
}


fun Game.progressGame(): Game {
    val bricks = clearBrokenBricks(this.bricks, this.balls)
    val points = sumPoints(bricks)
    val updatedBalls = handleGameBallsBehaviour(balls = this.balls, racket = this.racket, bricks = this.bricks)

    val filteredBricks = bricks.filter { !it.isBroken() }
    if (!this.balls.isEmpty() && updatedBalls.isEmpty()) arena.close()

    return copy(bricks = filteredBricks, balls = updatedBalls, points = this.points + points)
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
    drawRacket(racket = game.racket)
    drawBalls(ballsList = game.balls)
    drawGamePoints(game.points)
    drawBricks(bricks = game.bricks)
    drawLives(lives = game.lives)
}

fun drawLives(lives: Int) {
    drawBalls(generateLives(lives))
}
