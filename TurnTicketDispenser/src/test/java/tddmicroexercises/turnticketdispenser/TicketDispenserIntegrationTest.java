package tddmicroexercises.turnticketdispenser;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import tddmicroexercises.turnticketdispenser.impl.TurnNumberSequence;

public class TicketDispenserIntegrationTest {
	@Test
	public void newTicketTurnNumberIsGreaterThanPreviousTicketTurnNumber() {

		ITurnNumberSequence turnNumberSequence = new TurnNumberSequence();

		TicketDispenser ticketDispenser = new TicketDispenser(turnNumberSequence);

		TurnTicket previousTicket = ticketDispenser.getTurnTicket();
		TurnTicket newTicket = ticketDispenser.getTurnTicket();

		assertTrue(previousTicket.getTurnNumber() < newTicket.getTurnNumber());
	}

	@Test
	public void newTicketTurnNumberIsGreaterThanPreviousTicketTurnNumberUsingTwoDispensers() {

		ITurnNumberSequence turnNumberSequence = new TurnNumberSequence();

		TicketDispenser ticketDispenser1 = new TicketDispenser(turnNumberSequence);
		TicketDispenser ticketDispenser2 = new TicketDispenser(turnNumberSequence);

		TurnTicket previousTicket = ticketDispenser1.getTurnTicket();
		TurnTicket newTicket = ticketDispenser2.getTurnTicket();

		assertTrue(previousTicket.getTurnNumber() < newTicket.getTurnNumber());
	}

}
