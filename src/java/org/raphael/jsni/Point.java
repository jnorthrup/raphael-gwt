package org.raphael.jsni;

import com.google.gwt.core.client.JavaScriptObject;

public class Point extends JavaScriptObject {
	
	protected Point(){}
	
	public final native float getX() /*-{
		return this.x;
	}-*/;
	public final native float getY() /*-{
		return this.y;
	}-*/;

}
