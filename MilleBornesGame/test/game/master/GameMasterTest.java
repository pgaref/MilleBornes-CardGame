package game.master;

import static org.junit.Assert.fail;
import game.CardCollection.NotSupportedOperationException;
import game.Cards.Card;
import game.Cards.Distance;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GameMasterTest {

	private GameMaster m;
	@Before
	public void setUp() throws Exception {
		this.m = new GameMaster(null, "test1", "test2");
	}

	@Test
	public void testGameMaster() {
		Assert.assertNotEquals(this.m, null);
	}

	@Test
	public void testPlayerSelectsToPass() {
		Card tmp = new Distance(50);
		this.m.getCurrentPlayer().addHandCard(tmp);
		Assert.assertEquals(this.m.playerSelectsToPass(), false);
		
		this.m.getCurrentPlayer().getHand().remove(tmp);
		this.m.getCurrentPlayer().sethasDrawnCard(true);
		Assert.assertEquals(this.m.playerSelectsToPass(), true);
	}

	@Test
	public void testPlayerDiscardsCard() {
		Card tmp = new Distance(50);
		this.m.getCurrentPlayer().addHandCard(tmp);
		this.m.getCurrentPlayer().sethasDrawnCard(true);
		Assert.assertEquals(this.m.playerDiscardsCard(null),false);
	}

	@Test
	public void testPlayerSubmitsCard() {
		Card tmp = new Distance(50);
		try {
			Assert.assertEquals(this.m.playerSubmitsCard(tmp), false);
		} catch (NotSupportedOperationException e) {
			e.printStackTrace();
		}
		
		
	}

	@Test
	public void testPlayerDrawCard() {
		this.m.playerDrawCard();
		Assert.assertEquals(this.m.getCurrentPlayer().getHand().size(),7);
	}

	@Test
	public void testGetFirstPlayer() {
		Assert.assertEquals(this.m.getFirstPlayer().getName(), "test1");
	}

	@Test
	public void testGetSecondPlayer() {
		Assert.assertEquals(this.m.getSecondPlayer().getName(), "test2");
	}

	@Test
	public void testGetCurrentPlayer() {

		Assert.assertEquals(this.m.getCurrentPlayer().getName(), "test1");
	}

	@Test
	public void testGetNextPlayer() {
		Assert.assertEquals(this.m.getNextPlayer().getName(), "test2");
	}

	@Test
	public void testGetWinner() {
		
		this.m.setWinner(this.m.getFirstPlayer());
		Assert.assertEquals(this.m.getWinner().getName(), "test1");
	}

	@Test
	public void testSetWinner() {
		this.m.setWinner(this.m.getFirstPlayer());
		Assert.assertEquals(this.m.getWinner().getName(), "test1");
	}


	@Test
	public void testGetDeck() {
		Assert.assertEquals(this.m.getDeck().getDiscardCards().cards.size(), 0);
		Assert.assertEquals(this.m.getDeck().getDrawCards().cards.size(), 94);
	}

	@Test
	public void testSetDeck() {
		this.m.setDeck(new Deck("t1", "t2"));
		Assert.assertEquals(this.m.getDeck().getP1().getName(), "t1");
		Assert.assertEquals(this.m.getDeck().getP2().getName(), "t2");
		Assert.assertEquals(this.m.getDeck().getDiscardCards().cards.size(), 0);
		Assert.assertEquals(this.m.getDeck().getDrawCards().cards.size(), 94);
	}


}
