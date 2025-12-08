package org.example.views

import org.example.ENVIRONMENT
import org.example.models.BRICK_HEIGHT
import org.example.models.BRICK_STROKE_OFFSET_ADJUSTMENT
import org.example.models.BRICK_WIDTH
import org.example.models.Brick
import org.example.models.arena
import org.example.runningENVIRONMENT
import pt.isel.canvas.BLACK


fun drawBricks(bricks: List<Brick>) {
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
            width = BRICK_WIDTH - BRICK_STROKE_OFFSET_ADJUSTMENT * 2,
            height = BRICK_HEIGHT - BRICK_STROKE_OFFSET_ADJUSTMENT * 2,
            color = BLACK,
            thickness = 2
        )

        if (it.gift != null) {
            if(runningENVIRONMENT == ENVIRONMENT.DEBUG){
                arena.drawText(
                    x = it.x + BRICK_WIDTH / 2 - 4,
                    y = it.y + BRICK_HEIGHT - 4,
                    txt = it.gift.type.letter,
                    color = BLACK,
                    fontSize = 10
                )
            }
           /* val giftSideWidth = 4
            arena.drawRect(
                x = it.x + BRICK_WIDTH / 2,
                y = it.y + BRICK_HEIGHT / 2 - 3,
                width = giftSideWidth,
                height = giftSideWidth,
                color = it.gift.type.color,
            )*/

        }

    }
}