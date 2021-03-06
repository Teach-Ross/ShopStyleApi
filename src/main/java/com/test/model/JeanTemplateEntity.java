package com.test.model;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Kirstie34 on 3/14/17.
 */
@Entity
@Table(name = "JeanTemplate", schema = "Denim_Store_DB", catalog = "")
public class JeanTemplateEntity {
    private int templateId;
    private String jeanStyle;
    private String color;
    private String templateName;
    private byte distressed;
    private byte cropped;
    private int waistSize;
    private int inseamLength;
    private float price;

    @Id
    @Column(name = "TemplateID", nullable = false)
    public int getTemplateId() {
        return templateId;
    }

    public void setTemplateId(int templateId) {
        this.templateId = templateId;
    }

    @Basic
    @Column(name = "JeanStyle", nullable = false, length = 12)
    public String getJeanStyle() {
        return jeanStyle;
    }

    public void setJeanStyle(String jeanStyle) {
        this.jeanStyle = jeanStyle;
    }

    @Basic
    @Column(name = "Color", nullable = false, length = 7)
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Basic
    @Column(name = "TemplateName", nullable = false, length = 55)
    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    @Basic
    @Column(name = "Distressed", nullable = false)
    public byte getDistressed() {
        return distressed;
    }

    public void setDistressed(byte distressed) {
        this.distressed = distressed;
    }

    @Basic
    @Column(name = "Cropped", nullable = false)
    public byte getCropped() {
        return cropped;
    }

    public void setCropped(byte cropped) {
        this.cropped = cropped;
    }

    @Basic
    @Column(name = "WaistSize", nullable = false)
    public int getWaistSize() {
        return waistSize;
    }

    public void setWaistSize(int waistSize) {
        this.waistSize = waistSize;
    }

    @Basic
    @Column(name = "InseamLength", nullable = false)
    public int getInseamLength() {
        return inseamLength;
    }

    public void setInseamLength(int inseamLength) {
        this.inseamLength = inseamLength;
    }

    @Basic
    @Column(name = "Price", nullable = false, precision = 2)
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JeanTemplateEntity that = (JeanTemplateEntity) o;

        if (templateId != that.templateId) return false;
        if (distressed != that.distressed) return false;
        if (cropped != that.cropped) return false;
        if (waistSize != that.waistSize) return false;
        if (inseamLength != that.inseamLength) return false;
        if (jeanStyle != null ? !jeanStyle.equals(that.jeanStyle) : that.jeanStyle != null) return false;
        if (color != null ? !color.equals(that.color) : that.color != null) return false;
        if (templateName != null ? !templateName.equals(that.templateName) : that.templateName != null) return false;
        if (price != that.price) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = templateId;
        result = 31 * result + (jeanStyle != null ? jeanStyle.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (templateName != null ? templateName.hashCode() : 0);
        result = 31 * result + (int) distressed;
        result = 31 * result + (int) cropped;
        result = 31 * result + waistSize;
        result = 31 * result + inseamLength;
        result = 31 * result + (int) price;
        return result;
    }
}
