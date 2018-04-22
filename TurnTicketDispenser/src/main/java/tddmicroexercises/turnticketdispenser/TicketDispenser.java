package tddmicroexercises.turnticketdispenser;

public class TicketDispenser {

	private ITurnNumberSequence turnNumberSequence;

	public TurnTicket getTurnTicket() {
		int newTurnNumber = turnNumberSequence.getNextTurnNumber();
		TurnTicket newTurnTicket = new TurnTicket(newTurnNumber);

		return newTurnTicket;
	}

	public void setTurnNumberSequence(ITurnNumberSequence turnNumberSequence) {
		this.turnNumberSequence = turnNumberSequence;
	}

}
