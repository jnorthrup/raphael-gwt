package org.raphael.jsni;

public class RaphaelPath extends Raphael {

    RaphaelPath(RaphaelJSO jsoPeer) {
        super(jsoPeer);
    }

    /**
     * Returns length of the path in pixels.
     *
     * @return
     */
    public double getTotalLength() {
        return jso.getTotalLength();
    }

    /**
     * Returns point description at given length.
     *
     * @param length in pixels from the beginning of the path to the point
     * @return
     */
    public Point getPointAtLength(double length) {
        return jso.getPointAtLength(length);
    }

    /**
     * Returns the subpath string of a given path.
     *
     * @param from length in pixels from the beginining of the path to the beginining of the subpath
     * @param to   length in pixels from the beginining of the path to the end of the subpath
     * @return
     */
    public String getSubpath(double from, double to) {
        return jso.getSubpath(from, to);
    }

    public <T> T asJso() {
        return (T) jso;

    }
}
