package net.maple3142.umleditor.misc;

public record Vector2(double x, double y) implements IntPointXY {
    @Override
    public int getX() {
        return (int) x;
    }

    @Override
    public int getY() {
        return (int) y;
    }

    public Vector2 add(Vector2 v) {
        return new Vector2(x + v.x, y + v.y);
    }

    public Vector2 subtract(Vector2 v) {
        return new Vector2(x - v.x, y - v.y);
    }

    public Vector2 scale(double c) {
        return new Vector2((int) (c * x), (int) (c * y));
    }

    public Vector2 rotate(double angle) {
        // rotate by origin, counterclockwise
        // (x+i*y)(cos+i*sin)=(x*cos-y*sin)+i*(x*sin+y*cos)
        double c = Math.cos(angle);
        double s = Math.sin(angle);
        return new Vector2((int) (x * c - y * s), (int) (x * s + y * c));
    }

    public Vector2 rotateAround(Vector2 origin, double angle) {
        return subtract(origin).rotate(angle).add(origin);
    }

    public Vector2 rotateAndScaleAround(Vector2 origin, double angle, double c) {
        return subtract(origin).rotate(angle).scale(c).add(origin);
    }
}
