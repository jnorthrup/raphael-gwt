package org.raphael.ui;

import org.raphael.jsni.Color;
import org.raphael.jsni.Font;
import org.raphael.jsni.Raphael;
import org.raphael.jsni.RaphaelPaperJSO;
import org.raphael.jsni.RaphaelPath;
import org.raphael.jsni.RaphaelSet;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasAllMouseHandlers;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseMoveHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.google.gwt.event.dom.client.MouseWheelEvent;
import com.google.gwt.event.dom.client.MouseWheelHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.ComplexPanel;

public class RaphaelPaper extends ComplexPanel 
		implements HasClickHandlers, HasAllMouseHandlers {
	
	protected final RaphaelPaperJSO r;
	
	public RaphaelPaper() {
		setElement(DOM.createDiv());
		this.r = RaphaelPaperJSO.create(getElement());
	}
	
	/**
	 * Draws a circle.
	 * 
	 * @param x coordinate of the centre
	 * @param y coordinate of the centre
	 * @param r radius
	 */
	public Raphael circle(float x, float y, float radius) {
		return attach(r.circle(x, y, radius));
	}

	/**
	 * Draws a rectangle.
	 * 
	 * @param x coordinate of top left corner
	 * @param y coordinate of top left corner
	 * @param width 
	 * @param height
	 * @param r radius for rounded corners
	 */
	public Raphael rect(float x, float y, float width, float height, float radius) {
		return attach(r.rect(x, y, width, height, radius));
	}
	
	public Raphael rect(float x, float y, float width, float height) {
		return rect(x, y, width, height, 0);
	}
	
	/**
	 * Draws an ellipse.
	 * 
	 * @param x coordinate of the centre
	 * @param y coordinate of the centre
	 * @param rx horizontal radius
	 * @param ry vertical radius
	 * @return
	 */
	public Raphael ellipse(float x, float y, float rx, float ry) {
		return attach(r.ellipse(x, y, rx, ry));
	}
	
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
	public Raphael image(String src, float x, float y, float width, float height) {
		return attach(r.image(src, x, y, width, height));
	}
	
	/**
	 * Creates array-like object to keep and operate couple of elements
	 * at once. Warning: it doesn’t create any elements for itself in the page.
	 * 
	 * @return
	 */
	public RaphaelSet set() {
		return r.set();
	}
	
	/**
	 * Draws a text string. If you need line breaks, put “\n” in the string.
	 * 
	 * @param x coordinate position
	 * @param y coordinate position
	 * @param text
	 * @return
	 */
	public Raphael text(float x, float y, String text) {
		return attach(r.text(x, y, text));
	}
	
	/**
	 * Creates a path element by given path data string.
	 * 
	 * @param pathString Path data in SVG path string format.
	 * @return
	 */
	public RaphaelPath path(String pathString) {
		return (RaphaelPath) attach(r.path(pathString));
	}
	
	/**
	 * Clears the canvas, i.e. removes all the elements
	 */
	public void clear() {
		r.clear();
	}
	
	/**
	 * If you need to change dimensions of the canvas call this method.
	 * 
	 * @param width
	 * @param height
	 */
	public void setSize(int width, int height) {
		r.setSize(width, height);
	}
	
	/**
	 * Parses passes string and returns an color object.
	 * 
	 * @param color
	 * @return
	 */
	public static final native Color getRGB(String color) /*-{
		return $wnd.Raphael.getRGB(color);
	}-*/;
	
	/**
	 * Finds font object in the registered fonts by given parameters.
	 * You could specify only one word from the font name, like “Myriad”
	 * for “Myriad Pro”.
	 * 
	 * @param family
	 * @param weight
	 * @param style
	 * @param stretch
	 * @return
	 */
	public Font getFont(String family, String weight, String style, String stretch) {
		return r.getFont(family, weight, style, stretch);
	}
	
	public Font getFont(String family) {
		return getFont(family, null, null, null);
	}
	
	public Raphael print(float x, float y, String text, Font font, float fontSize) {
		return r.print(x, y, text, font, fontSize);
	}
	
	@Override
	public HandlerRegistration addClickHandler(ClickHandler handler) {
		return addDomHandler(handler, ClickEvent.getType());
	}
	
	@Override
	public HandlerRegistration addMouseDownHandler(MouseDownHandler handler) {
		return addDomHandler(handler, MouseDownEvent.getType());
	}

	@Override
	public HandlerRegistration addMouseUpHandler(MouseUpHandler handler) {
		return addDomHandler(handler, MouseUpEvent.getType());
	}

	@Override
	public HandlerRegistration addMouseOutHandler(MouseOutHandler handler) {
		return addDomHandler(handler, MouseOutEvent.getType());
	}

	@Override
	public HandlerRegistration addMouseOverHandler(MouseOverHandler handler) {
		return addDomHandler(handler, MouseOverEvent.getType());
	}

	@Override
	public HandlerRegistration addMouseMoveHandler(MouseMoveHandler handler) {
		return addDomHandler(handler, MouseMoveEvent.getType());
	}

	@Override
	public HandlerRegistration addMouseWheelHandler(MouseWheelHandler handler) {
		return addDomHandler(handler, MouseWheelEvent.getType());
	}

	/* --- */

	private Raphael attach(Raphael widget) {
		add(widget, (Element) widget.node().getParentElement());
		return widget;
	}

}
