package org.raphael.jsni;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

public class RaphaelPaperJSO extends JavaScriptObject {
	
	protected RaphaelPaperJSO(){}

	public static final native RaphaelPaperJSO create(Element el) /*-{
		return $wnd.Raphael(el);
	}-*/;

	/**
	 * Draws a circle.
	 * 
	 * @param x coordinate of the centre
	 * @param y coordinate of the centre
	 * @param r radius
	 */
	public final Raphael circle(float x, float y, float r) {
		return new Raphael(_circle(x,y,r));
	}
	protected final native RaphaelJSO _circle(float x, float y, float r) /*-{
		return this.circle(x,y,r);
	}-*/;
	
	/**
	 * Draws a rectangle.
	 * 
	 * @param x coordinate of top left corner
	 * @param y coordinate of top left corner
	 * @param width 
	 * @param height
	 * @param r radius for rounded corners
	 */
	public final Raphael rect(float x, float y, float width, float height, float r) {
		return new Raphael(_rect(x,y,width,height,r));
	}
	protected final native RaphaelJSO _rect(float x, float y, float width, float height, float r) /*-{
		return this.rect(x,y,width,height,r);
	}-*/;
	
	/**
	 * Draws an ellipse.
	 * 
	 * @param x coordinate of the centre
	 * @param y coordinate of the centre
	 * @param rx horizontal radius
	 * @param ry vertical radius
	 * @return
	 */
	public final Raphael ellipse(float x, float y, float rx, float ry) {
		return new Raphael(_ellipse(x,y,rx,ry));
	}
	protected final native RaphaelJSO _ellipse(float x, float y, float rx, float ry) /*-{
		return this.ellipse(x,y,rx,ry);
	}-*/;

	/**
	 * Embeds an image into the SVG/VML canvas.
	 * 
	 * @param src URI of the source image
	 * @param x coordinate position
	 * @param y coordinate position
	 * @param width
	 * @param height
	 * @return
	 */
	public final Raphael image(String src, float x, float y, float width, float height) {
		return new Raphael(_image(src,x,y,width,height));
	}
	protected final native RaphaelJSO _image(String src, float x, float y, float width, float height) /*-{
		return this.image(src, x, y, width, height);
	}-*/;
	
	/**
	 * Creates array-like object to keep and operate couple of elements
	 * at once. Warning: it doesn’t create any elements for itself in the page.
	 * 
	 * @return
	 */
	public final RaphaelSet set() {
		return new RaphaelSet(_set());
	}
	protected final native RaphaelJSO _set() /*-{
		return this.set();
	}-*/;
	
	/**
	 * Draws a text string. If you need line breaks, put “\n” in the string.
	 * 
	 * @param x coordinate position
	 * @param y coordinate position
	 * @param text
	 * @return
	 */
	public final Raphael text(float x, float y, String text) {
		return new Raphael(_text(x,y,text));
	}
	protected final native RaphaelJSO _text(float x, float y, String text) /*-{
		return this.text(x, y, text);
	}-*/;


	/**
	 * Creates a path element by given path data string.
	 * 
	 * @param pathString path data in SVG path string format.
	 * @return
	 */
	public final RaphaelPath path(String pathString) {
		return new RaphaelPath(_path(pathString));
	}
	protected final native RaphaelJSO _path(String pathString) /*-{
		return this.path(pathString);
	}-*/;

	/**
	 * Clears the canvas, i.e. removes all the elements
	 */
	public final native void clear() /*-{
		this.clear();
	}-*/;

	/**
	 * If you need to change dimensions of the canvas call this method.
	 * 
	 * @param width
	 * @param height
	 */
	public final native void setSize(int width, int height) /*-{
		this.setSize(width, height);
	}-*/;

	public final native Font getFont(String family, String weight, String style, String stretch) /*-{
		this.getFont(family, weight, style, stretch);
	}-*/;

	/**
	 * Creates set of shapes to represent given font at given position
	 * with given size. Result of the method is set object (see set) which
	 * contains each letter as separate path object
	 * 
	 * @param x position of the text
	 * @param y position of the text
	 * @param text
	 * @param font font object
	 * @param fontSize 
	 * @return
	 */
	public final Raphael print(float x, float y, String text, Font font,
			float fontSize) {
		return new Raphael(_print(x, y, text, font, fontSize));
	}
	protected final native RaphaelJSO _print(float x, float y, String text,
			Font font, float fontSize) /*-{
		return this.print(x, y, text, font, fontSize);
	}-*/;

}
