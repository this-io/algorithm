package datastructure.queue;

public class Node {
	private Integer data;
	private Node forwardLink;
	private Node backwardLink;

	public Integer getData() {
		return data;
	}

	public void setData(Integer data) {
		this.data = data;
	}

	public Node getForwardLink() {
		return forwardLink;
	}

	public void setForwardLink(Node forwardLink) {
		this.forwardLink = forwardLink;
	}

	public void setBackwardLink(Node backwardLink) {
		this.backwardLink = backwardLink;
	}

	public Node getBackwardLink() {
		return backwardLink;
	}
}
