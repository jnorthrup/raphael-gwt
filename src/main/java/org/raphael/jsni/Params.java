package org.raphael.jsni;

import com.google.gwt.core.client.JavaScriptObject;

public class Params {

    private final JavaScriptObject jso;

    @Override
    public String toString() {
        return "Params{" +
                "jso=" + jso +
                '}';
    }

    public Params() {
        this.jso = JavaScriptObject.createObject();
    }

    public Params attr(Raphael.Param param, JavaScriptObject value) {
        _attr(jso, makeParam(param), value);
        return this;
    }

    public Params attr(Raphael.Param param, String value) {
        _attr(jso, makeParam(param), value);
        return this;
    }

    public Params attr(Raphael.Param param, Double value) {
        _attr(jso, makeParam(param), value);
        return this;
    } 

    protected native void _attr(JavaScriptObject obj,
                                String param, JavaScriptObject value) /*-{
		obj[param] = value;
	}-*/;

    protected native void _attr(JavaScriptObject obj,
                                String param, String value) /*-{
		obj[param] = value;
	}-*/;

    protected native void _attr(JavaScriptObject obj,
                                String param, double value) /*-{
		obj[param] = value;
	}-*/;

    static String makeParam(Raphael.Param param) {
        return param.toString().replaceAll("_", "-");
    }

    JavaScriptObject asJSO() {
        return jso;
    }

}
