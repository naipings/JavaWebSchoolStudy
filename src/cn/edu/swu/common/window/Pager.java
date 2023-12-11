package cn.edu.swu.common.window;

public class Pager {

    private String url;
    private int total; // 总页数
    private int currentPage; // 当前页码
    private int pageSize; // 每页显示的记录数

    public Pager() {

    }

    public String toHtml() {
        StringBuilder sb = new StringBuilder();
        sb.append("<div class='pager'>");
        sb.append(String.format(("第%d页 / 共%d页 &nbsp;&nbsp;"), this.getCurrentPage(), this.totalPage()));

        sb.append(this.getCurrentPage() <= 1 ? "" :
                String.format("<a href='%s?page=%d'>前一页</a>&nbsp;&nbsp;", this.getUrl(), this.getCurrentPage() - 1));
        for ( int i=1, tp = this.totalPage(); i <= tp; i++ ) {
            sb.append(String.format("<a href='%s?page=%d'>%d</a>&nbsp;&nbsp;", this.getUrl(), i, i));
        }

        sb.append(this.getCurrentPage() >= this.totalPage() ? "" :
                String.format("&nbsp;&nbsp;<a href='%s?page=%d'>后一页</a>", this.getUrl(), this.getCurrentPage() + 1));
        sb.append("</div>");

        return sb.toString();
    }

    public int totalPage() {
        return Double.valueOf(Math.ceil(this.getTotal()*1.0 / this.getPageSize())).intValue();
    }

    public Pager(String url, int total, int currentPage, int pageSize) {
        this.url = url;
        this.total = total;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }

    public int offset() {
        return (this.getCurrentPage() - 1) * this.getPageSize();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }


}
