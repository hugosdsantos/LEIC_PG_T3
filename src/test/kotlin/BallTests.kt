import org.example.models.*
import org.example.models.Brick
import org.junit.jupiter.api.Test
import kotlin.collections.listOf
import kotlin.test.assertEquals

class BallTests {

    @Test
    fun ballCollidingHorizontallyWithMultipleBrick() {

        val brick1 = Brick(x = 288, y = 105, type = BrickType.GREEN, hitCounter = 0)
        val brick2 = Brick(x = 288, y = 90, type = BrickType.RED, hitCounter = 0)


        val ball = Ball(x = 283.0, y = 97.0, deltaX = 3, deltaY = -2, weight = 1.0, stuck = false)

        assertEquals(Collision.NONE, checkBrickCollision(ball, brick1))
        assertEquals(Collision.HORIZONTAL, checkBrickCollision(ball, brick2))

    }

    @Test
    fun ballCollidingWithMultipleBrick() {
        val bricks = listOf(
            Brick(x = 288, y = 150, type = BrickType.WHITE, hitCounter = 0),
            Brick(x = 288, y = 135, type = BrickType.ORANGE, hitCounter = 0),
            Brick(x = 288, y = 120, type = BrickType.CYAN, hitCounter = 0),
            Brick(x = 288, y = 105, type = BrickType.GREEN, hitCounter = 0),
            Brick(x = 288, y = 90, type = BrickType.RED, hitCounter = 0),
            Brick(x = 288, y = 75, type = BrickType.BLUE, hitCounter = 0),
            Brick(x = 288, y = 45, type = BrickType.YELLOW, hitCounter = 0),
        )

        val ball = Ball(x = 283.0, y = 65.0, deltaX = 0, deltaY = -2, weight = 1.0, stuck = false)

        bricks.forEach {
            assertEquals(Collision.NONE, checkBrickCollision(ball, it))
        }
    }

    @Test
    fun ballCollidingWithBrick() {
        val brick = Brick(x = 288, y = 60, type = BrickType.MAGENTA, hitCounter = 0)
        val ball = Ball(x = 283.0, y = 65.0, deltaX = 0, deltaY = -2, weight = 1.0, stuck = false)

        assertEquals(Collision.VERTICAL, checkBrickCollision(ball, brick))

    }

    @Test
    fun totalSumOfPointsFromHitsBricksShouldBeCorrect() {
        val bricks = listOf<Brick>(
            Brick(100, 200, BrickType.YELLOW, 0),
            Brick(100, 200, BrickType.YELLOW, 0),
            Brick(100, 200, BrickType.MAGENTA, 1),
            Brick(100, 200, BrickType.MAGENTA, 1),
            Brick(100, 200, BrickType.MAGENTA, 1),
        )

        val points = sumPoints(bricks)

        assertEquals(BrickType.MAGENTA.points * 3, points)
    }
}
