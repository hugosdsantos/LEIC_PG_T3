package org.example.models

import org.example.views.gameStart
import pt.isel.canvas.*

enum class ENVIRONMENT {
    DEBUG,
    PROD
}

val runningENVIRONMENT = ENVIRONMENT.DEBUG

fun main() {
    onStart {
        println("START")
        gameStart()
    }

    onFinish {
        println("FINISH")
    }
}