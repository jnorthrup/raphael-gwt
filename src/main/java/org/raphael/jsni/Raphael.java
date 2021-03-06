package org.raphael.jsni;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Widget;
import org.raphael.jsni.RaphaelJSO.BBox;

import java.util.ArrayList;
import java.util.List;

public class Raphael extends Widget
        implements HasAllMouseHandlers, HasClickHandlers {


    public enum Param {
        clip_rect,          // string comma or space separated values: x, y, width and height
        cx,                 // number
        cy,                 // number
        fill,               // colour or gradient
        fill_opacity,       // number
        font,               // string
        font_family,        // string
        font_size,          // number
        font_weight,        // string
        height,             // number
        opacity,            // number
        path,               // pathString
        r,                  // number
        rotation,           // number
        rx,                 // number
        ry,                 // number
        scale,              // string see scale()
        src,                // string (URL)
        stroke,             // colour
        stroke_dasharray,   // string [“”, “-”, “.”, “-.”, “-..”, “. ”, “- ”, “--”, “- .”, “--.”, “--..”]
        stroke_linecap,     // string [“butt”, “square”, “round”]
        stroke_linejoin,    // string [“bevel”, “round”, “miter”]
        stroke_miterlimit,  // number
        stroke_opacity,     // number
        stroke_width,       // number
        translation,        // string comma or space separated values: x and y
        width,              // number
        x,                  // number
        y                   // number
    }

    public final RaphaelJSO jso;
    private boolean chainAnim;
    private List<Runnable> animStack;
    private int animPos = 1;

    Raphael(RaphaelJSO jsoPeer) {
        setElement(jsoPeer.node());
        this.jso = jsoPeer;
    }

    public String attr(Param name) {
        String attr = Params.makeParam(name);
        return jso.attr(attr, null);
    }

    public <T extends Raphael>T attr(Param name, String value) {
        String attr = Params.makeParam(name);
        jso.attr(attr, value);
        return (T) this;
    }

    public <T extends Raphael>T attr(Param name, double value) {
          String attr = Params.makeParam(name);
        jso.attr(attr, value);
        return (T) this;
    }


    /**
     * Gives you a reference to the DOM object.
     *
     * @return
     */
    public Element node() {
        return jso.node();
    }

    /**
     * Removes element from the DOM. You can’t use it after this method call.
     */
    public void remove() {
        jso.remove();
    }

    /**
     * Makes element invisible.
     *
     * @return
     */
    public Raphael hide() {
        jso.hide();
        return this;
    }

    /**
     * Makes element visible.
     *
     * @return
     */
    public Raphael show() {
        jso.show();
        return this;
    }

    /**
     * Rotates the element by the given degree from its center point.
     *
     * @param degree Degree of rotation (0 – 360°)
     * @return
     */
    public Raphael rotate(double degree) {
        return rotate(degree, false);
    }

    /**
     * Rotates the element by the given degree from its center point.
     *
     * @param degree     Degree of rotation (0 – 360°)
     * @param isAbsolute
     * @return
     */
    public Raphael rotate(double degree, boolean isAbsolute) {
        jso.rotate(degree, isAbsolute);
        return this;
    }

    /**
     * Rotates the element by the given degree from given point.
     *
     * @param degree Degree of rotation (0 – 360°)
     * @param cx     center X coordinate
     * @param cy     center Y coordinate
     */
    public Raphael rotate(double degree, double cx, double cy) {
        jso.rotate(degree, cx, cy);
        return this;
    }

    /**
     * Moves the element around the canvas by the given distances.
     *
     * @param dx
     * @param dy
     */
    public Raphael translate(double dx, double dy) {
        jso.translate(dx, dy);
        return this;
    }

    /**
     * Resizes the element by the given multiplier.
     *
     * @param rx Amount to scale horizontally
     * @param ry Amount to scale vertically
     * @return
     */
    public Raphael scale(double rx, double ry) {
        jso.scale(rx, ry);
        return this;
    }

    /**
     * Resizes the element by the given multiplier.
     *
     * @param rx Amount to scale horizontally
     * @param ry Amount to scale vertically
     * @param cx X of the center of scaling
     * @param cy Y of the center of scaling
     * @return
     */
    public Raphael scale(double rx, double ry, double cx, double cy) {
        jso.scale(rx, ry, cx, cy);
        return this;
    }

    public void setChainAnimate(boolean chain) {
        this.chainAnim = chain;
        if (animStack == null) this.animStack = new ArrayList<Runnable>();
    }

    /**
     * Changes an attribute from its current value to its specified value
     * in the given amount of milliseconds.
     *
     * @param obj
     * @param ms
     * @return
     */
    public Raphael animate(Params obj, double ms) {
        return animate(obj, ms, null, null);
    }

    /**
     * Changes an attribute from its current value to its specified value
     * in the given amount of milliseconds.
     *
     * @param obj
     * @param ms
     * @param callback
     * @return
     */
    public Raphael animate(Params obj, double ms, Runnable callback) {
        return animate(obj, ms, null, callback);
    }

    /**
     * Changes an attribute from its current value to its specified value
     * in the given amount of milliseconds.
     *
     * @param obj
     * @param ms
     * @param easing
     * @return
     */
    public Raphael animate(Params obj, double ms, String easing) {
        return animate(obj, ms, easing, null);
    }

    /**
     * Changes an attribute from its current value to its specified value
     * in the given amount of milliseconds.
     *
     * @param obj
     * @param ms
     * @param easing
     * @param callback
     * @return
     */
    public Raphael animate(final Params obj, final double ms,
                           String easing, final Runnable callback) {

        final String eas = easing == null ? ">" : easing;
        if (chainAnim && callback == null) {
            assert animStack != null;
            animStack.add(new Runnable() {
                @Override
                public void run() {
                    int i = animStack.indexOf(this);
                    jso.animate(obj.asJSO(), ms, eas, next(i));
                    animPos++;
                }
            });
            if (animStack.size() == animPos)
                animStack.get(0).run();
        } else {
            jso.animate(obj.asJSO(), ms, eas, callback);
        }
        return this;
    }


    /**
     * Changes an attribute from its current value to its specified value
     * in the given amount of milliseconds.
     *
     * @param ms
     * @param callback
     * @return
     */
    public Raphael animateAlongBack(JavaScriptObject path, final double ms,
                                    Boolean rotate, final Runnable callback) {

        jso.animateAlongBack(path, ms, rotate, callback);

        return this;
    }

    /**
     * Changes an attribute from its current value to its specified value
     * in the given amount of milliseconds.
     *
     * @param ms
     * @param callback
     * @return
     */
    public Raphael animateAlong(JavaScriptObject path, final double ms,
                                Boolean rotate, final Runnable callback) {

        jso.animateAlong(path, ms, rotate, callback);

        return this;
    }


    /**
     * Changes an attribute from its current value to its specified value
     * in the given amount of milliseconds.
     *
     * @param obj
     * @param ms
     * @param easing
     * @param callback
     * @return
     */
    public Raphael animateWith(final JavaScriptObject with_, final Params obj, final double ms,
                               String easing, final Runnable callback) {

        jso.animateWith(with_, obj.asJSO(), ms, easing, callback);

        return this;
    }

    private Runnable next(final int index) {
        return new Runnable() {
            @Override
            public void run() {
                try {
                    animStack.get(index + 1).run();
                } catch (IndexOutOfBoundsException e) {
                    animStack.clear();
                }
            }
        };
    }

    /**
     * Returns the dimensions of an element.
     *
     * @return
     */
    public BBox getBBox() {
        return jso.getBBox();
    }

    /**
     * Moves the element so it is the closest to the viewer’s eyes,
     * on top of other elements.
     *
     * @return
     */
    public Raphael toFront() {
        jso.toFront();
        return this;
    }

    /**
     * Moves the element so it is the furthest from the viewer’s eyes,
     * behind other elements.
     *
     * @return
     */
    public Raphael toBack() {
        jso.toBack();
        return this;
    }

    /**
     * Inserts current object before the given one.
     *
     * @param r
     */
    public void insertBefore(Raphael r) {
        jso.insertBefore(r.jso);
    }

    /**
     * Inserts current object after the given one.
     *
     * @param r
     */
    public void insertAfter(Raphael r) {
        jso.insertAfter(r.jso);
    }

    /**
     * Returns a clone of the current element.
     */
    public Raphael clone() {
        return new Raphael(jso.clone());
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

}
