package helen.com.we.model;

public class ItemSiderModel {

    private int titleSilder;
    private int contentSider;

    public ItemSiderModel() {
    }

    public ItemSiderModel(int titleSilder, int contentSider) {
        this.titleSilder = titleSilder;
        this.contentSider = contentSider;
    }

    public int getTitleSilder() {
        return titleSilder;
    }

    public void setTitleSilder(int titleSilder) {
        this.titleSilder = titleSilder;
    }

    public int getContentSider() {
        return contentSider;
    }

    public void setContentSider(int contentSider) {
        this.contentSider = contentSider;
    }
}
