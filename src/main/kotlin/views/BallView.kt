package org.example.views

import org.example.models.BALL_COLOR
import org.example.models.BALL_RADIUS
import org.example.models.Ball
import org.example.models.arena


/*
* Desenha as bolas em jogo no canvas
* */
fun drawBalls(ballsList: List<Ball>) {
    ballsList.forEach { arena.drawCircle(xCenter = it.x, yCenter = it.y, radius = BALL_RADIUS, color = BALL_COLOR) }
}
