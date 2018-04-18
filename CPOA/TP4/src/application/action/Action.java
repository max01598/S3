package application.action;
import banque.AgenceBancaire;
/**
 * An Action is an object that implements some action of a user's menu.<BR>
 * It is defined by a message, an execute method to "do" the action.
 * TODO: redefine equals()
 */
public interface Action  {
	/**
	 * Message of the action (to show on screen).
	 *
	 * @return the message of the action
	 */
	public String actionMessage ();

	/**
	 * The method to call in order to "execute" the action on <code>ag</code>.
	 *
	 * @param ag the AgenceBancaire on which the action may act on
	 * @throws Exception when an uncaught exception occurs during execution
	*/
	public void execute(AgenceBancaire ag) throws Exception;
}
