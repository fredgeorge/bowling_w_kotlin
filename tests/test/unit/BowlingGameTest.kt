import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import game.*
import game.BowlingGame
import org.junit.jupiter.api.Assertions.*

/*
 * Copyright (c) 2019 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

// Ensures bowling games scored correctly
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
internal class BowlingGameTest {
    private val game = BowlingGame()

    @Test internal fun `all gutter balls`() {
        roll(0.pins * 20)
        assertEquals(0, game.score())
    }

    @Test internal fun `few equal pins`() {
        roll(4.pins * 20)
        assertEquals(80, game.score())
    }

    @Test internal fun `few different pins w no strikes or spares`() {
        roll(3.pins * 10)
        roll(2.pins * 6)
        roll(4.pins * 4)
        assertEquals(58, game.score())
    }

    @Test internal fun `initial strike`() {
        roll(10.pins)
        roll(4.pins * 18)
        assertEquals(90, game.score())
    }

    @Test internal fun `perfect game`() {
        roll(10.pins * 12)
        assertEquals(300, game.score())
    }

    @Test internal fun `strike on last frame`() {
        roll(0.pins * 18)
        roll(10.pins)
        roll(4.pins * 2)
        assertEquals(18, game.score())
    }

    @Test internal fun `consecutive strikes mid-game`() {
        roll(0.pins * 10)
        roll(10.pins * 2)
        roll(4.pins * 6)
        assertEquals(24 + 18 + 4*6, game.score())
    }

    private fun roll(bowlResult: BowlResult) = roll(listOf(bowlResult))

    private fun roll(bowlResults: List<BowlResult>) = game.roll(bowlResults)
}