package tddmicroexercises.turnticketdispenser;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class TicketDispenserTest {
	@Test
	public void getTurnTicketWithTurnNumber() {

		ITurnNumberSequence turnNumberSequence = mock(ITurnNumberSequence.class);
		when(turnNumberSequence.getNextTurnNumber()).thenReturn(5);

		TicketDispenser ticketDispenser = new TicketDispenser(turnNumberSequence);
		assertEquals(5, ticketDispenser.getTurnTicket().getTurnNumber());
	}

}
