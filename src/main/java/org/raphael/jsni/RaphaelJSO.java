package org.raphael.jsni;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

public class RaphaelJSO extends JavaScriptObject {

    public static class BBox extends JavaScriptObject {

        protected BBox() {
        }

        public final native double getWidth() /*-{
			return this.width;
		}-*/;

        public final native double getHeight() /*-{
			return this.height;
	}-*/;

    }

    protected RaphaelJSO() {
    }

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

    public final native void rotate(double degree, boolean isAbsolute) /*-{
		this.rotate(degree, isAbsolute);
	}-*/;

    public final native void rotate(double degree, double cx, double cy) /*-{
		this.rotate(degree, cx, cy);
	}-*/;

    public final native void translate(double dx, double dy) /*-{
		this.translate(dx, dy);
	}-*/;

    public final native void scale(double rx, double ry) /*-{
		this.scale(rx, ry);
	}-*/;

    public final native void scale(double rx, double ry, double cx, double cy) /*-{
		this.scale(rx, ry, cx, cy);
	}-*/;

    public final native void animateAlong(JavaScriptObject path,
                                          double ms, Boolean rotate, Runnable callback) /*-{
		this.animateAlong (path,  ms, rotate, callback == null ? null : function() {
			callback.@java.lang.Runnable::run()();
		});
	}-*/;

    public final native void animateAlongBack(JavaScriptObject path,
                                              double ms, Boolean rotate, Runnable callback) /*-{
		this.animateAlongBack(path,  ms, rotate, callback == null ? null : function() {
			callback.@java.lang.Runnable::run()();
		});
	}-*/;

    public final native void animate(JavaScriptObject obj,
                                     double ms, String easing, Runnable callback) /*-{
		this.animate(obj, ms, easing, callback == null ? null : function() {
			callback.@java.lang.Runnable::run()();
		});
	}-*/;

    public final native <T> void animateWith(T with_, JavaScriptObject obj,
                                             double ms, String easing, Runnable callback) /*-{
		this.animateWith( with_, obj, ms, easing, callback == null ? null : function() {
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

    public final native <T> void push(T child) /*-{
		this.push(child);
	}-*/;

    /* --- Path specific --- */

    public final native double getTotalLength() /*-{
		return this.getTotalLength();
	}-*/;

    public final native Point getPointAtLength(double length) /*-{
		return this.getPointAtLength(length);
	}-*/;

    public final native String getSubpath(double from, double to) /*-{
		return this.getSubpath(from, to);
	}-*/;

}
