package org.raphael.jsni;

import com.google.gwt.core.client.JavaScriptObject;

public class Color extends JavaScriptObject {

    protected Color() {
    }

    public final native int getRed() /*-{
		return this.r;
	}-*/;

    public final native int getBlue() /*-{
		return this.b;
	}-*/;

    public final native int getGreen() /*-{
		return this.g;
	}-*/;

    public final native String getHEX() /*-{
		return this.hex;
	}-*/;

}
