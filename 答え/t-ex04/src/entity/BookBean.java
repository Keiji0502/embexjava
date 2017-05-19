/*
 * 総合４ 解答例  BookBean.java
 *
 * Copyright(C) 2016 emBex Education Inc. All Rights Reserved.
 */
package entity;

import javax.servlet.http.HttpServletRequest;

/**
 * 書籍情報クラス.
 *
 * @author emBex
 * @version 1.00
 */
public class BookBean {

    private int id; // ID
    private String bookTitle; // 書籍名
    private String authorName; // 著者名
    private String publisherName; // 出版社
    private int publisherYear = -1; // 出版年
    private String isbnCode; // ISBNコード

    /**
     * IDを取得する.
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * IDを設定する.
     *
     * @param id
     *            セットする id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 書籍名を取得する.
     *
     * @return bookTitle
     */
    public String getBookTitle() {
        return bookTitle;
    }

    /**
     * 書籍名を設定する.
     *
     * @param bookTitle
     *            セットする bookTitle
     */
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    /**
     * 著者名を取得する.
     *
     * @return authorName
     */
    public String getAuthorName() {
        return authorName;
    }

    /**
     * 著者名を設定する.
     *
     * @param authorName
     *            セットする authorName
     */
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    /**
     * 出版社を取得する.
     *
     * @return publisherName
     */
    public String getPublisherName() {
        return publisherName;
    }

    /**
     * 出版社を設定する.
     *
     * @param publisherName
     *            セットする publisherName
     */
    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    /**
     * 出版年を取得する.
     *
     * @return publisherYear
     */
    public int getPublisherYear() {
        return publisherYear;
    }

    /**
     * 出版年を設定する.
     *
     * @param publisherYear
     *            セットする publisherYear
     */
    public void setPublisherYear(int publisherYear) {
        this.publisherYear = publisherYear;
    }

    /**
     * ISBNコードを取得する.
     *
     * @return isbnCode
     */
    public String getIsbnCode() {
        return isbnCode;
    }

    /**
     * ISBNコードを設定する.
     *
     * @param isbnCode
     *            セットする isbnCode
     */
    public void setIsbnCode(String isbnCode) {
        this.isbnCode = isbnCode;
    }

    /**
     * リクエスト情報から書籍情報を生成.
     *
     * @param request
     *            リクエスト
     * @return 書籍情報
     */
    public static BookBean createBookBean(HttpServletRequest request) {

        BookBean bookBean = new BookBean();
        bookBean.setBookTitle(request.getParameter("bookTitle"));
        bookBean.setAuthorName(request.getParameter("authorName"));
        bookBean.setPublisherName(request.getParameter("publisherName"));

        try {
            bookBean.setPublisherYear(Integer.parseInt(request
                    .getParameter("publisherYear")));
        } catch (Exception e) {
            bookBean.setPublisherYear(-1);
        }

        bookBean.setIsbnCode(request.getParameter("isbnCode"));

        return bookBean;
    }
}
