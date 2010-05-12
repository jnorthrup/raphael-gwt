package org.raphael.jsni;

import com.google.gwt.core.client.JavaScriptObject;

public class Params {
	
	private final JavaScriptObject jso;

	public Params() {
		this.jso = JavaScriptObject.createObject();
	}
	
	public void attr(Raphael.Param param, String value) {
		_attr(jso, makeParam(param), value);
	}
	public void attr(Raphael.Param param, Float value) {
		_attr(jso, makeParam(param), value);
	}
	protected native void _attr(JavaScriptObject obj, 
			String param, String value) /*-{
		obj[param] = value;
	}-*/;
	protected native void _attr(JavaScriptObject obj, 
			String param, float value) /*-{
		obj[param] = value;
	}-*/;
	
	static String makeParam(Raphael.Param param) {
		return param.toString().replaceAll("_", "-");
	}
	
	JavaScriptObject asJSO() {
		return jso;
	}

}
