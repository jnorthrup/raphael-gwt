package org.raphael.jsni;

public class RaphaelSet extends Raphael {

	RaphaelSet(RaphaelJSO jsoPeer) {
		super(jsoPeer);
	}
	
	public void push(Raphael... children) {
		for (Raphael r: children) {
			jso.push(r.jso);
		}
	}

}
