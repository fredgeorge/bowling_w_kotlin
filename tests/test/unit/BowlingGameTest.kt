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
    
    private fun roll(bowl: Bowl) = roll(listOf(bowl))

    private fun roll(bowls: List<Bowl>) = game.roll(bowls)
}