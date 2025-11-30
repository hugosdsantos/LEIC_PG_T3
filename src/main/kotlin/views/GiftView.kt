package org.example.views

import org.example.models.Gift
import org.example.models.arena
import pt.isel.canvas.BLACK
import pt.isel.canvas.WHITE

const val GIFT_CIRCLE_RADIUS:Int = 10

fun Gift.drawGift(){
    arena.drawCircle(xCenter = this.x, yCenter =  this.y + GIFT_CIRCLE_RADIUS, GIFT_CIRCLE_RADIUS, color = this.type.color)
    arena.drawCircle(xCenter = this.x, yCenter =  this.y + GIFT_CIRCLE_RADIUS, GIFT_CIRCLE_RADIUS, color = BLACK, 1)
    arena.drawText(x = this.x - 3, y = this.y + GIFT_CIRCLE_RADIUS + 3, txt = this.type.letter, color = WHITE, fontSize = 12)
}