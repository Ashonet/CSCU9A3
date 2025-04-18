import java.util.LinkedList;
import java.util.Queue;

/**
 * A basic model of a shop, consisting of 1 queue of customers.
 *
 * @author cma
 * @date 11/2011
 *
 */
public class Shop
{
	/**
	 * A queue of all customers currently in the shop.
	 */
	private Queue<Customer> queue;

	/**
	 * Construct a new shop. This should initialise an empty queue.
	 */
	@SuppressWarnings("unchecked")
	public Shop()
	{
		// Java supports multiple types of queues so we cannot simply ask for a new Queue...
		// One type of queue is a LinkedList, which is what we are using here.
		// For more information check the Javadocs.
		queue = new LinkedList<Customer>();
	}

	/**
	 * Gets the queue of customers currently in the shop.
	 *
	 * @return the queue of customers currently in the shop.
	 */
	public Queue<Customer> getQueue()
	{
		return queue;
	}
	
	/**
	 * Add a new customer to the back of the queue.
	 *
	 * @param customer the customer to enqueue.
	 */
	public void addCustomer(Customer customer)
	{
		// TODO: add a customer to the queue
	}

	/**
	 * Get the next customer from the front of the queue.
	 *
	 * @return the next customer in the queue.
	 */
	public Customer getNextCustomer()
	{
		// TODO: return (and remove) the next customer from the queue
		return null;
	}
}
