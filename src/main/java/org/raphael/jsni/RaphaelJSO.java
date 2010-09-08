package org.raphael.jsni;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

public class RaphaelJSO extends JavaScriptObject {
	
	public static class BBox extends JavaScriptObject {
		
		protected BBox(){}
		
		public final native float getWidth() /*-{
			return this.width;
		}-*/;
		public final native float getHeight() /*-{
			return this.height;
	}-*/;
		
	}

	protected RaphaelJSO(){}
	
	public final native String attr(String name, String value) /*-{
		return this.attr(name, value).toString();
	}-*/;

	public final native Element node() /*-{
		return this.node;
	}-*/;
	
	public final native void remove() /*-{
		this.remove();
	}-*/;

	public final native void hide() /*-{
		this.hide();
	}-*/;
	
	public final native void show() /*-{
		this.show();
	}-*/;

	public final native void rotate(float degree, boolean isAbsolute) /*-{
		this.rotate(degree, isAbsolute);
	}-*/;

	public final native void rotate(float degree, float cx, float cy) /*-{
		this.rotate(degree, cx, cy);
	}-*/;

	public final native void translate(float dx, float dy) /*-{
		this.translate(dx, dy);
	}-*/;

	public final native void scale(float rx, float ry) /*-{
		this.scale(rx, ry);
	}-*/;

	public final native void scale(float rx, float ry, float cx, float cy) /*-{
		this.scale(rx, ry, cx, cy);
	}-*/;

	public final native void animate(JavaScriptObject obj, 
			float ms, String easing, Runnable callback) /*-{
		this.animate(obj, ms, easing, callback == null ? null : function() {
			callback.@java.lang.Runnable::run()();
		});
	}-*/;

	public final native BBox getBBox() /*-{
		return this.getBBox();
	}-*/;

	public final native void toFront() /*-{
		this.toFront();
	}-*/;

	public final native void toBack() /*-{
		this.toBack();
	}-*/;
	
	public final native void insertBefore(RaphaelJSO r) /*-{
		this.insertBefore(r);
	}-*/;

	public final native void insertAfter(RaphaelJSO r) /*-{
		this.insertAfter(r);
	}-*/;
	
	public final native RaphaelJSO clone() /*-{
		return this.clone();
	}-*/;
	
	/* --- Set methods --- */
	
	public final native void push(RaphaelJSO child) /*-{
		this.push(child);
	}-*/;
	
	/* --- Path specific --- */

	public final native float getTotalLength() /*-{
		return this.getTotalLength();
	}-*/;
	
	public final native Point getPointAtLength(float length) /*-{
		return this.getPointAtLength(length);
	}-*/;

	public final native String getSubpath(float from, float to) /*-{
		return this.getSubpath(from, to);
	}-*/;

}
