package org.example.models

enum class GiftType(val letter: String){
    EXTENDED("E"),
    BALLS("B"),
    SLOW("S"),
    FAST("F"),
    GLUE("G"),
    CANCEL("C")
}

data class Gift(val x: Int = 0, val y: Int = 0, val deltaY: Int = 1, val type: GiftType, val active: Boolean = false)

fun generateGifsInRandomBricks(bricks: List<Brick>) :List<Brick>{
    val availableGifts = GiftType.entries + GiftType.entries + GiftType.CANCEL + GiftType.CANCEL + GiftType.CANCEL + GiftType.CANCEL + GiftType.CANCEL
    val bricksMutableList = bricks.toMutableList()

    availableGifts.forEach {
        val randomIndex = (0 until bricks.size).random()
        bricksMutableList[randomIndex] = bricks[randomIndex].copy(gift = Gift(type = it))
    }

    return bricksMutableList.toList()
}