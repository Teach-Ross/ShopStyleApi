package com.test.model;

public class JeanEntity {
    private String templateId;
    private JeanStyle style;
    private Boolean distressed;
    private Boolean cropped;
    private int waistSize;
    private int inseamSize;
    private String htmlColor;

    public JeanEntity() {
    }

    public JeanEntity(JeanStyle style, Boolean distressed, Boolean cropped, int waistSize, int inseamSize, String htmlColor) {
        this.style = style;
        this.distressed = distressed;
        this.cropped = cropped;
        this.waistSize = waistSize;
        this.inseamSize = inseamSize;
        this.htmlColor = htmlColor;
    }

    public JeanStyle getStyle() {
        return style;
    }

    public void setStyle(JeanStyle style) {
        this.style = style;
    }

    public Boolean getDistressed() {
        return distressed;
    }

    public void setDistressed(Boolean distressed) {
        this.distressed = distressed;
    }

    public Boolean getCropped() {
        return cropped;
    }

    public void setCropped(Boolean cropped) {
        this.cropped = cropped;
    }

    public int getWaistSize() {
        return waistSize;
    }

    public void setWaistSize(int waistSize) {
        this.waistSize = waistSize;
    }

    public int getInseamSize() {
        return inseamSize;
    }

    public void setInseamSize(int inseamSize) {
        this.inseamSize = inseamSize;
    }

    public String getHtmlColor() {
        return htmlColor;
    }

    public void setHtmlColor(String htmlColor) {
        this.htmlColor = htmlColor;
    }
}
