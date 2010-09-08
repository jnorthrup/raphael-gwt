package org.raphael.ui;

import com.google.gwt.event.dom.client.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.ComplexPanel;
import org.raphael.jsni.*;

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
     * @param x      coordinate of the centre
     * @param y      coordinate of the centre
     * @param radius
     * @return
     */
    public Raphael circle(double x, double y, double radius) {
        return attach(r.circle(x, y, radius));
    }

    /**
     * Draws a rectangle.
     *
     * @param x      coordinate of top left corner
     * @param y      coordinate of top left corner
     * @param width
     * @param height
     * @param radius
     * @return
     */
    public Raphael rect(double x, double y, double width, double height, double radius) {
        return attach(r.rect(x, y, width, height, radius));
    }

    public Raphael rect(double x, double y, double width, double height) {
        return rect(x, y, width, height, 0);
    }

    /**
     * Draws an ellipse.
     *
     * @param x  coordinate of the centre
     * @param y  coordinate of the centre
     * @param rx horizontal radius
     * @param ry vertical radius
     * @return
     */
    public Raphael ellipse(double x, double y, double rx, double ry) {
        return attach(r.ellipse(x, y, rx, ry));
    }

    /**
     * Embeds an image into the SVG/VML canvas.
     *
     * @param src    URI of the source image
     * @param x      coordinate position
     * @param y      coordinate position
     * @param width
     * @param height
     * @return
     */
    public Raphael image(String src, double x, double y, double width, double height) {
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
     * @param x    coordinate position
     * @param y    coordinate position
     * @param text
     * @return
     */
    public Raphael text(double x, double y, String text) {
        return attach(r.text(x, y, text));
    }

    /**
     * Creates a path element by given path data string.
     *
     * @param pathStringOrJsArray Path data in SVG path string format.
     * @return
     */
    public <T> RaphaelPath path(T pathStringOrJsArray) {
        return (RaphaelPath) attach(r.path(pathStringOrJsArray));
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

    public Raphael print(double x, double y, String text, Font font, double fontSize) {
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
