package game.Player;

import static org.junit.Assert.fail;
import game.CardCollection.BattlePile;
import game.CardCollection.DistancePile;
import game.CardCollection.SafetyPile;
import game.CardCollection.SpeedPile;
import game.Cards.Card;
import game.Cards.Distance;
import game.Cards.EmptyCard;
import game.Cards.OutOfGas;
import game.Cards.Priority;
import game.Cards.SpeedLimit;
import game.master.Deck;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

	private Player p;
	@Before
	public void setUp() throws Exception {
		Deck d = new Deck("test1", "test2");
		this.p = d.getP1();
	}

	@Test
	public final void testPlayer() {
		Player pp = new Player("pp");
		Assert.assertEquals(pp.getName(), "pp");
		Assert.assertEquals( pp.canMove(), true);
		Assert.assertEquals(pp.canDiscardCard(), false);
		Assert.assertEquals(pp.getBattle().cards.size() , 0);
	}
	
	
	@Test
	public final void testCanThrowMileCard() {
		this.p.setHasStarted(true);
		this.p.sethasDrawnCard(true);
		Assert.assertEquals(this.p.canThrowMileCard(new Distance(50) ), true);
		
		//Test speed Limit
		this.p.getSpeed().cards.add(new SpeedLimit());
		Assert.assertEquals(this.p.canThrowMileCard(new Distance(50) ), true);
		Assert.assertEquals(this.p.canThrowMileCard(new Distance(100) ), false);
		
		
		//Test 2 X 200 Miles card rule
		this.p.getDistance().cards.add(new Distance(200));
		this.p.getDistance().cards.add(new Distance(200));
		Assert.assertEquals(this.p.canThrowMileCard(new Distance(200) ), false);
		
		
	}

	@Test
	public final void testHasPriorityCard() {
		Assert.assertEquals(this.p.hasPriorityCard(), false);
		this.p.getSafety().cards.add(new Priority());
		Assert.assertEquals(this.p.hasPriorityCard(), true);
	}

	@Test
	public final void testTopMileCounter() {
		this.p = new Player("test");
		Assert.assertEquals(this.p.getMilesRun(),0);
	}
	
	@Test
	public final void testGetName() {
		Assert.assertEquals(this.p.getName(), "test1");
	}

	@Test
	public final void testGetPlayersHand() {
		Assert.assertEquals(this.p.getHand().size(), 6);
	}

	@Test
	public final void testAddHandCard() {
		this.p.getHand().add(new EmptyCard());
		Assert.assertEquals(this.p.getHand().size(),7);
	}

	@Test
	public final void testIsWinner() {
		this.p.addMilesRun(1000);
		Assert.assertEquals(this.p.isWinner(new EmptyCard()) , true);
	}


	@Test
	public final void testCanDiscardCard() {
		this.p = new Player("test");
		Assert.assertEquals(this.p.canDiscardCard(), false);
		this.p.sethasDrawnCard(true);
		Assert.assertEquals(this.p.canDiscardCard(), true);

	}

	@Test
	public final void testIsAbleToMove() {
		Assert.assertEquals(this.p.isAbleToMove(), true);
		this.p.getBattle().cards.add(new OutOfGas());
		Assert.assertEquals(this.p.isAbleToMove(), false);
	}

	@Test
	public final void testSetName() {
		this.p.setName("new");
		Assert.assertEquals(this.p.getName(),"new");
	}

	@Test
	public final void testGetMilesRun() {
		this.p = new Player("test");
		Assert.assertEquals(this.p.getMilesRun(),0);
		this.p.addMilesRun(100);
		Assert.assertEquals(this.p.getMilesRun(),100);
	}

	@Test
	public final void testAddMilesRun() {
		this.p.addMilesRun(100);
		Assert.assertEquals(this.p.getMilesRun(),100);

	}

	@Test
	public final void testGetHand() {
		Assert.assertEquals(this.p.getHand().size(),6);

	}

	@Test
	public final void testSetHand() {
		this.p.setHand(new ArrayList<Card>());
		Assert.assertEquals(this.p.getHand().size(),0);
	}

	@Test
	public final void testGetBattle() {
		Assert.assertEquals(this.p.getBattle().cards.size(),0);
	}

	@Test
	public final void testSetBattle() {
		this.p.setBattle(new BattlePile());
		Assert.assertEquals(this.p.getBattle().cards.size(),0);
	}

	@Test
	public final void testGetSpeed() {
		Assert.assertEquals(this.p.getSpeed().cards.size(),0);
	}

	@Test
	public final void testSetSpeed() {
		this.p.setSpeed(new SpeedPile());
		Assert.assertEquals(this.p.getSpeed().cards.size(),0);
	}

	@Test
	public final void testGetDistance() {
		Assert.assertEquals(this.p.getDistance().cards.size(),0);
	}

	@Test
	public final void testSetDistance() {
		this.p.setDistance(new DistancePile());
		Assert.assertEquals(this.p.getDistance().cards.size(),0);
	}

	@Test
	public final void testGetSatefy() {
		Assert.assertEquals(this.p.getSafety().cards.size(),0);
	}

	@Test
	public final void testSetSatefy() {
		this.p.setSafety(new SafetyPile());
		Assert.assertEquals(this.p.getSafety().cards.size(),0);
	}

	@Test
	public final void testHasStarted() {
		this.p.setHasStarted(true);
		Assert.assertEquals(this.p.hasStarted(),true);
	}

	@Test
	public final void testCanMove() {
		this.p.setCanMove(false);
		Assert.assertEquals(this.p.canMove(),false);
	}


	@Test
	public final void testHasDrawnCard() {
		Assert.assertEquals(this.p.hasDrawnCard(),false);
	}


}
