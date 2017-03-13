package com.test.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class TemplatecollectionentityPK implements Serializable {
    private String templateId;
    private String userId;

    @Column(name = "TemplateId", nullable = false, length = 10)
    @Id
    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    @Column(name = "UserId", nullable = false, length = 10)
    @Id
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TemplatecollectionentityPK that = (TemplatecollectionentityPK) o;

        if (templateId != null ? !templateId.equals(that.templateId) : that.templateId != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = templateId != null ? templateId.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }
}
