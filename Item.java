public interface Item {
    public char getToken();
    public String getName();
    public int getX();
    public int getY();
    public void updateXRight();
    public void updateXLeft();
    public void updateYUp();
    public void updateYDown();
}