import org.example.models.BALL_RADIUS
import org.example.models.BRICK_HEIGHT
import org.example.models.BRICK_WIDTH
import org.example.models.Ball
import org.example.models.Brick
import org.example.models.BrickType
import org.example.models.Collision
import org.example.models.MAX_DELTA_Y
import org.example.models.checkBrickCollision
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class CollisionTests {

    @Test
    fun `bola colide por cima do brick`() {
        val ball = Ball(x = 81.5, y = 98.0, deltaX = -1, deltaY = 2, mass = 1.5, stuck = false)
        val brick = Brick(x = 64, y = 105, type = BrickType.GREEN, hitCounter = 0, gift = null)

        assertEquals(Collision.VERTICAL, checkBrickCollision(ball, brick))
    }

    @Test
    fun `bola colide por cima do brick2`() {
        val brick = Brick(x = 288, y = 60, type = BrickType.MAGENTA, hitCounter = 0)
        val ball = Ball(
            x = 300.0,
            y = 60.0 - BALL_RADIUS + 1,
            deltaX = 0,
            deltaY = 2,
            mass = 1.0,
            stuck = false
        )

        assertEquals(Collision.VERTICAL, checkBrickCollision(ball, brick))
    }

    @Test
    fun `bola colide por baixo do brick`() {
        val brick = Brick(x = 288, y = 60, type = BrickType.WHITE, hitCounter = 0)
        val ball = Ball(
            x = 300.0,
            y = 60.0 + BRICK_HEIGHT + BALL_RADIUS - 1,
            deltaX = 0,
            deltaY = -2,
            mass = 1.0,
            stuck = false
        )

        assertEquals(Collision.VERTICAL, checkBrickCollision(ball, brick))
    }

    @Test
    fun `bola colide na lateral esquerda do brick`() {
        val brick = Brick(x = 288, y = 60, type = BrickType.WHITE, hitCounter = 0)
        val ball = Ball(
            x = 288.0 - BALL_RADIUS + 1,
            y = 70.0,
            deltaX = 2,
            deltaY = 0,
            mass = 1.0,
            stuck = false
        )

        assertEquals(Collision.HORIZONTAL, checkBrickCollision(ball, brick))
    }

    @Test
    fun `bola colide na lateral direita do brick`() {
        val brick = Brick(x = 288, y = 60, type = BrickType.WHITE, hitCounter = 0)
        val ball = Ball(
            x = 288.0 + BRICK_WIDTH + BALL_RADIUS - 1,
            y = 70.0,
            deltaX = -2,
            deltaY = 0,
            mass = 1.0,
            stuck = false
        )

        assertEquals(Collision.HORIZONTAL, checkBrickCollision(ball, brick))
    }

    @Test
    fun `bola colide no canto superior esquerdo do brick`() {
        val brick = Brick(x = 288, y = 60, type = BrickType.MAGENTA, hitCounter = 0)
        val ball = Ball(
            x = 288.0 - 4,
            y = 60.0 - 4,
            deltaX = 2,
            deltaY = -2,
            mass = 1.0,
            stuck = false
        )

        assertEquals(Collision.HORIZONTAL, checkBrickCollision(ball, brick))
    }

    @Test
    fun `bola colide no canto inferior direito do brick`() {
        val brick = Brick(x = 288, y = 60, type = BrickType.WHITE, hitCounter = 0)
        val ball = Ball(
            x = 288.0 + BRICK_WIDTH + BALL_RADIUS - 3,
            y = 60.0 + BRICK_HEIGHT + BALL_RADIUS - 3,
            deltaX = -2,
            deltaY = 2,
            mass = 1.0,
            stuck = false
        )

        assertEquals(Collision.HORIZONTAL, checkBrickCollision(ball, brick))
    }


    @Test
    fun `bola colide no canto inferior direito do brick mas a subir`() {
        val brick = Brick(x = 288, y = 60, type = BrickType.WHITE, hitCounter = 0)
        val ball = Ball(
            x = 288.0 + BRICK_WIDTH + BALL_RADIUS - 3,
            y = 60.0 + BRICK_HEIGHT + BALL_RADIUS - 3,
            deltaX = -2,
            deltaY = -2,
            mass = 1.0,
            stuck = false
        )

        assertEquals(Collision.BOTH, checkBrickCollision(ball, brick))
    }

    @Test
    fun `bola longe do brick nao colide`() {
        val brick = Brick(x = 288, y = 60, type = BrickType.WHITE, hitCounter = 0)
        val ball = Ball(
            x = 100.0,
            y = 100.0,
            deltaX = 1,
            deltaY = 1,
            mass = 1.0,
            stuck = false
        )

        assertEquals(Collision.NONE, checkBrickCollision(ball, brick))
    }

    @Test
    fun `bola apenas tangente ao brick conta como colisao`() {
        val brick = Brick(x = 288, y = 60, type = BrickType.WHITE, hitCounter = 0)
        val ball = Ball(
            x = 288.0 - BALL_RADIUS,
            y = 70.0,
            deltaX = 1,
            deltaY = 0,
            mass = 1.0,
            stuck = false
        )

        assertEquals(Collision.HORIZONTAL, checkBrickCollision(ball, brick))
    }


    // Testes para canto superior esquerdo
    @Test
    fun `bola colide no canto superior esquerdo do brick vindo da direita para cima`() {
        val brick = Brick(x = 288, y = 60, type = BrickType.WHITE, hitCounter = 0)
        val ball = Ball(
            x = 288.0 - BALL_RADIUS + 3,
            y = 60.0 - BALL_RADIUS + 3,
            deltaX = 2,  // Direita
            deltaY = -2, // Para cima
            mass = 1.0,
            stuck = false
        )

        assertEquals(Collision.HORIZONTAL, checkBrickCollision(ball, brick))
    }

    @Test
    fun `bola colide no canto superior esquerdo do brick vindo da direita para baixo`() {
        val brick = Brick(x = 288, y = 60, type = BrickType.WHITE, hitCounter = 0)
        val ball = Ball(
            x = 288.0 - BALL_RADIUS + 3,
            y = 60.0 - BALL_RADIUS + 3,
            deltaX = 2,  // Direita
            deltaY = 2,  // Para baixo
            mass = 1.0,
            stuck = false
        )

        assertEquals(Collision.BOTH, checkBrickCollision(ball, brick))
    }

    @Test
    fun `bola colide no canto superior esquerdo do brick vindo da esquerda para baixo`() {
        val brick = Brick(x = 288, y = 60, type = BrickType.WHITE, hitCounter = 0)
        val ball = Ball(
            x = 288.0 - BALL_RADIUS + 3,
            y = 60.0 - BALL_RADIUS + 3,
            deltaX = -2, // Esquerda
            deltaY = 2,  // Para baixo
            mass = 1.0,
            stuck = false
        )

        assertEquals(Collision.VERTICAL, checkBrickCollision(ball, brick))
    }

    @Test
    fun `bola colide no canto superior esquerdo do brick vindo da esquerda para cima`() {
        val brick = Brick(x = 288, y = 60, type = BrickType.WHITE, hitCounter = 0)
        val ball = Ball(
            x = 288.0 - BALL_RADIUS + 3,
            y = 60.0 - BALL_RADIUS + 3,
            deltaX = -2, // Esquerda
            deltaY = -2, // Para cima
            mass = 1.0,
            stuck = false
        )

        assertEquals(Collision.NONE, checkBrickCollision(ball, brick))
    }

    // Testes para canto superior direito
    @Test
    fun `bola colide no canto superior direito do brick vindo da direita para baixo`() {
        val brick = Brick(x = 288, y = 60, type = BrickType.WHITE, hitCounter = 0)
        val ball = Ball(
            x = 288.0 + BRICK_WIDTH + BALL_RADIUS - 3,
            y = 60.0 - BALL_RADIUS + 3,
            deltaX = 2,  // Direita
            deltaY = 2,  // Para baixo
            mass = 1.0,
            stuck = false
        )

        assertEquals(Collision.VERTICAL, checkBrickCollision(ball, brick))
    }

    @Test
    fun `bola colide no canto superior direito do brick vindo da direita para cima`() {
        val brick = Brick(x = 288, y = 60, type = BrickType.WHITE, hitCounter = 0)
        val ball = Ball(
            x = 288.0 + BRICK_WIDTH + BALL_RADIUS - 3,
            y = 60.0 - BALL_RADIUS + 3,
            deltaX = 2,  // Direita
            deltaY = -2, // Para cima
            mass = 1.0,
            stuck = false
        )

        assertEquals(Collision.NONE, checkBrickCollision(ball, brick))
    }

    @Test
    fun `bola colide no canto superior direito do brick vindo da esquerda para baixo`() {
        val brick = Brick(x = 288, y = 60, type = BrickType.WHITE, hitCounter = 0)
        val ball = Ball(
            x = 288.0 + BRICK_WIDTH + BALL_RADIUS - 3,
            y = 60.0 - BALL_RADIUS + 3,
            deltaX = -2, // Esquerda
            deltaY = 2,  // Para baixo
            mass = 1.0,
            stuck = false
        )

        assertEquals(Collision.BOTH, checkBrickCollision(ball, brick))
    }

    @Test
    fun `bola colide no canto superior direito do brick vindo da esquerda para cima`() {
        val brick = Brick(x = 288, y = 60, type = BrickType.WHITE, hitCounter = 0)
        val ball = Ball(
            x = 288.0 + BRICK_WIDTH + BALL_RADIUS - 3,
            y = 60.0 - BALL_RADIUS + 3,
            deltaX = -2, // Esquerda
            deltaY = -2, // Para cima
            mass = 1.0,
            stuck = false
        )

        assertEquals(Collision.HORIZONTAL, checkBrickCollision(ball, brick))
    }

    // Testes para canto inferior esquerdo
    @Test
    fun `bola colide no canto inferior esquerdo do brick vindo da esquerda para cima`() {
        val brick = Brick(x = 288, y = 60, type = BrickType.WHITE, hitCounter = 0)
        val ball = Ball(
            x = 288.0 - BALL_RADIUS + 3,
            y = 60.0 + BRICK_HEIGHT + BALL_RADIUS - 3,
            deltaX = -2, // Esquerda
            deltaY = -2, // Para cima
            mass = 1.0,
            stuck = false
        )

        assertEquals(Collision.VERTICAL, checkBrickCollision(ball, brick))
    }

    @Test
    fun `bola colide no canto inferior esquerdo do brick vindo da esquerda para baixo`() {
        val brick = Brick(x = 288, y = 60, type = BrickType.WHITE, hitCounter = 0)
        val ball = Ball(
            x = 288.0 - BALL_RADIUS + 3,
            y = 60.0 + BRICK_HEIGHT + BALL_RADIUS - 3,
            deltaX = -2, // Esquerda
            deltaY = 2,  // Para baixo
            mass = 1.0,
            stuck = false
        )

        assertEquals(Collision.NONE, checkBrickCollision(ball, brick))
    }

    @Test
    fun `bola colide no canto inferior esquerdo do brick vindo da direita para cima`() {
        val brick = Brick(x = 288, y = 60, type = BrickType.WHITE, hitCounter = 0)
        val ball = Ball(
            x = 288.0 - BALL_RADIUS + 3,
            y = 60.0 + BRICK_HEIGHT + BALL_RADIUS - 3,
            deltaX = 2,  // Direita
            deltaY = -2, // Para cima
            mass = 1.0,
            stuck = false
        )

        assertEquals(Collision.BOTH, checkBrickCollision(ball, brick))
    }

    @Test
    fun `bola colide no canto inferior esquerdo do brick vindo da direita para baixo`() {
        val brick = Brick(x = 288, y = 60, type = BrickType.WHITE, hitCounter = 0)
        val ball = Ball(
            x = 288.0 - BALL_RADIUS + 3,
            y = 60.0 + BRICK_HEIGHT + BALL_RADIUS - 3,
            deltaX = 2,  // Direita
            deltaY = 2,  // Para baixo
            mass = 1.0,
            stuck = false
        )

        assertEquals(Collision.HORIZONTAL, checkBrickCollision(ball, brick))
    }

    // Testes para canto inferior direito
    @Test
    fun `bola colide no canto inferior direito do brick vindo da esquerda para cima`() {
        val brick = Brick(x = 288, y = 60, type = BrickType.WHITE, hitCounter = 0)
        val ball = Ball(
            x = 288.0 + BRICK_WIDTH + BALL_RADIUS - 3,
            y = 60.0 + BRICK_HEIGHT + BALL_RADIUS - 3,
            deltaX = -2, // Esquerda
            deltaY = -2, // Para cima
            mass = 1.0,
            stuck = false
        )

        assertEquals(Collision.BOTH, checkBrickCollision(ball, brick))
    }

    @Test
    fun `bola colide no canto inferior direito do brick vindo da esquerda para baixo`() {
        val brick = Brick(x = 288, y = 60, type = BrickType.WHITE, hitCounter = 0)
        val ball = Ball(
            x = 288.0 + BRICK_WIDTH + BALL_RADIUS - 3,
            y = 60.0 + BRICK_HEIGHT + BALL_RADIUS - 3,
            deltaX = -2, // Esquerda
            deltaY = 2,  // Para baixo
            mass = 1.0,
            stuck = false
        )

        assertEquals(Collision.HORIZONTAL, checkBrickCollision(ball, brick))
    }

    @Test
    fun `bola colide no canto inferior direito do brick vindo da direita para cima`() {
        val brick = Brick(x = 288, y = 60, type = BrickType.WHITE, hitCounter = 0)
        val ball = Ball(
            x = 288.0 + BRICK_WIDTH + BALL_RADIUS - 3,
            y = 60.0 + BRICK_HEIGHT + BALL_RADIUS - 3,
            deltaX = 2,  // Direita
            deltaY = -2, // Para cima
            mass = 1.0,
            stuck = false
        )

        assertEquals(Collision.VERTICAL, checkBrickCollision(ball, brick))
    }

    @Test
    fun `bola colide no canto inferior direito do brick vindo da direita para baixo`() {
        val brick = Brick(x = 288, y = 60, type = BrickType.WHITE, hitCounter = 0)
        val ball = Ball(
            x = 288.0 + BRICK_WIDTH + BALL_RADIUS - 3,
            y = 60.0 + BRICK_HEIGHT + BALL_RADIUS - 3,
            deltaX = 2,  // Direita
            deltaY = 2,  // Para baixo
            mass = 1.0,
            stuck = false
        )

        assertEquals(Collision.NONE, checkBrickCollision(ball, brick))
    }

    // Testes para casos limítrofes
    @Test
    fun `bola quase colidindo no canto superior esquerdo retorna NONE`() {
        val brick = Brick(x = 288, y = 60, type = BrickType.WHITE, hitCounter = 0)
        val ball = Ball(
            x = 288.0 - BALL_RADIUS - 5,  // Fora do alcance
            y = 60.0 - BALL_RADIUS - 5,
            deltaX = 2,
            deltaY = 2,
            mass = 1.0,
            stuck = false
        )

        assertEquals(Collision.NONE, checkBrickCollision(ball, brick))
    }

    @Test
    fun `bola colide exatamente na borda do canto superior direito`() {
        val brick = Brick(x = 288, y = 60, type = BrickType.WHITE, hitCounter = 0)
        val ball = Ball(
            x = 288.0 + BRICK_WIDTH + BALL_RADIUS,
            y = 60.0,
            deltaX = -2,
            deltaY = 2,
            mass = 1.0,
            stuck = false
        )

        // Este teste pode variar dependendo da implementação
        assertEquals(Collision.BOTH, checkBrickCollision(ball, brick))
    }

    // Teste para colisão com bola "presa" (não deve colidir)
    @Test
    fun `bola colide com o canto, retorna BOTH`() {
        val brick = Brick(x = 288, y = 60, type = BrickType.WHITE, hitCounter = 0)
        val ball = Ball(
            x = 288.0 - BALL_RADIUS + 3,
            y = 60.0 - BALL_RADIUS + 3,
            deltaX = 2,
            deltaY = 2,
            mass = 1.0
        )

        assertEquals(Collision.BOTH, checkBrickCollision(ball, brick))
    }

    // Teste para verificar diferentes tipos de brick
    @Test
    fun `bola colide no canto de brick de tipo diferente`() {
        val brick = Brick(x = 288, y = 60, type = BrickType.RED, hitCounter = 1)
        val ball = Ball(
            x = 288.0 - BALL_RADIUS + 3,
            y = 60.0 - BALL_RADIUS + 3,
            deltaX = 2,
            deltaY = 2,
            mass = 1.0,
            stuck = false
        )

        // O tipo de brick não deve afetar a deteção de colisão
        assertEquals(Collision.BOTH, checkBrickCollision(ball, brick))
    }

    // Teste para ângulos muito rasantes
    @Test
    fun `bola colide em angulo muito raso no canto inferior direito`() {
        val brick = Brick(x = 288, y = 60, type = BrickType.WHITE, hitCounter = 0)
        val ball = Ball(
            x = 288.0 + BRICK_WIDTH + BALL_RADIUS - 0.5,
            y = 60.0 + BRICK_HEIGHT + BALL_RADIUS - 0.5,
            deltaX = -1,  // Movimento quase horizontal
            deltaY = -MAX_DELTA_Y,  // Movimento vertical forte
            mass = 1.0,
            stuck = false
        )

        assertEquals(Collision.NONE, checkBrickCollision(ball, brick))
    }


    @Test
    fun `bola colide exatamente no meio de dois tijolos adjacentes horizontalmente`() {
        val brick1 = Brick(x = 100, y = 60, type = BrickType.WHITE)
        val brick2 = Brick(x = 100 + BRICK_WIDTH, y = 60, type = BrickType.WHITE)

        // Bola posicionada exatamente na junção entre os dois
        val ball = Ball(
            x = 100.0 + BRICK_WIDTH,
            y = 60.0 - BALL_RADIUS + 1,
            deltaX = 0,
            deltaY = 2
        )

        // A colisão deve ser VERTICAL (bateu no topo de ambos)
        assertEquals(Collision.VERTICAL, checkBrickCollision(ball, brick1))
        assertEquals(Collision.VERTICAL, checkBrickCollision(ball, brick2))
    }

    @Test
    fun `bola passa num buraco estreito entre dois tijolos sem colidir`() {
        val brickLeft = Brick(x = 0, y = 100, type = BrickType.WHITE)
        val brickRight = Brick(x = 100, y = 100, type = BrickType.WHITE)
        // Se a largura entre eles for > raio*2, a bola deve passar

        val ball = Ball(
            x = 75.0, // Supondo que este X está no vazio entre eles
            y = 100.0,
            deltaX = 0,
            deltaY = 5
        )

        assertEquals(Collision.NONE, checkBrickCollision(ball, brickLeft))
        assertEquals(Collision.NONE, checkBrickCollision(ball, brickRight))
    }

    @Test
    fun `bola a andar rapidamente calha demasiado "dentro" do tijolo deve retornar colisão vertical devido ao seu movimento`() {
        val brick = Brick(x = 192, y = 45, type = BrickType.GOLD, hitCounter = 2, gift = null)
        val ball = Ball(x = 201.5, y = 41.0, deltaX = -6, deltaY = 4, mass = 1.5, stuck = false)

        val collision = checkBrickCollision(ball, brick)
        assertTrue(collision == Collision.VERTICAL)
    }
}

