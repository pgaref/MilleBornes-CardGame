package game.deck;

import game.Cards.Card;
import game.Player.Player;
import game.master.Deck;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DeckTest {

	private Deck d;
	@Before
	public void setUp() throws Exception {
		this.d  = new Deck("test1", "test2");
		
	}

	@Test
	public final void testDeck() {
		
		Assert.assertEquals(d.getP1().getName(), "test1" );
		Assert.assertEquals(d.getP2().getName(), "test2");
	}

	@Test
	public final void testInitAllCards() {
		ArrayList<Card> list = this.d.initAllCards();
		Assert.assertEquals(list.size(),106);
		
	}

	@Test
	public final void testGetDrawCards() {
		this.d.initAllCards();
		Assert.assertNotEquals(this.d.getDrawCards().cards.isEmpty(), true);
	}

	@Test
	public final void testSetDrawCards() {
		this.d.initAllCards();
		this.d.setDrawCards(null);
		Assert.assertEquals(this.d.getDrawCards(), null);
	}

	@Test
	public final void testGetDiscardCards() {
		this.d.initAllCards();
		Assert.assertEquals(this.d.getDiscardCards().cards.isEmpty(), true);
	}

	@Test
	public final void testSetDiscardCards() {
		this.d.initAllCards();
		this.d.setDiscardCards(null);
		Assert.assertEquals(this.d.getDiscardCards(), null);
	}

	@Test
	public final void testGetP1() {
		Assert.assertEquals(this.d.getP1().getName(), "test1");
	}

	@Test
	public final void testSetP1() {
		this.d.setP1(new Player("tmp"));
		Assert.assertEquals(this.d.getP1().getName(), "tmp");
		
	}

	@Test
	public final void testGetP2() {
		Assert.assertEquals(this.d.getP2().getName(), "test2");
	}

	@Test
	public final void testSetP2() {
		this.d.setP2(new Player("tmp"));
		Assert.assertEquals(this.d.getP2().getName(), "tmp");
	}

}
