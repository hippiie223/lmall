package com.lmall.domain.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticleAuthorExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ArticleAuthorExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAuthorNameIsNull() {
            addCriterion("author_name is null");
            return (Criteria) this;
        }

        public Criteria andAuthorNameIsNotNull() {
            addCriterion("author_name is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorNameEqualTo(String value) {
            addCriterion("author_name =", value, "authorName");
            return (Criteria) this;
        }

        public Criteria andAuthorNameNotEqualTo(String value) {
            addCriterion("author_name <>", value, "authorName");
            return (Criteria) this;
        }

        public Criteria andAuthorNameGreaterThan(String value) {
            addCriterion("author_name >", value, "authorName");
            return (Criteria) this;
        }

        public Criteria andAuthorNameGreaterThanOrEqualTo(String value) {
            addCriterion("author_name >=", value, "authorName");
            return (Criteria) this;
        }

        public Criteria andAuthorNameLessThan(String value) {
            addCriterion("author_name <", value, "authorName");
            return (Criteria) this;
        }

        public Criteria andAuthorNameLessThanOrEqualTo(String value) {
            addCriterion("author_name <=", value, "authorName");
            return (Criteria) this;
        }

        public Criteria andAuthorNameLike(String value) {
            addCriterion("author_name like", value, "authorName");
            return (Criteria) this;
        }

        public Criteria andAuthorNameNotLike(String value) {
            addCriterion("author_name not like", value, "authorName");
            return (Criteria) this;
        }

        public Criteria andAuthorNameIn(List<String> values) {
            addCriterion("author_name in", values, "authorName");
            return (Criteria) this;
        }

        public Criteria andAuthorNameNotIn(List<String> values) {
            addCriterion("author_name not in", values, "authorName");
            return (Criteria) this;
        }

        public Criteria andAuthorNameBetween(String value1, String value2) {
            addCriterion("author_name between", value1, value2, "authorName");
            return (Criteria) this;
        }

        public Criteria andAuthorNameNotBetween(String value1, String value2) {
            addCriterion("author_name not between", value1, value2, "authorName");
            return (Criteria) this;
        }

        public Criteria andArticleNumIsNull() {
            addCriterion("article_num is null");
            return (Criteria) this;
        }

        public Criteria andArticleNumIsNotNull() {
            addCriterion("article_num is not null");
            return (Criteria) this;
        }

        public Criteria andArticleNumEqualTo(Integer value) {
            addCriterion("article_num =", value, "articleNum");
            return (Criteria) this;
        }

        public Criteria andArticleNumNotEqualTo(Integer value) {
            addCriterion("article_num <>", value, "articleNum");
            return (Criteria) this;
        }

        public Criteria andArticleNumGreaterThan(Integer value) {
            addCriterion("article_num >", value, "articleNum");
            return (Criteria) this;
        }

        public Criteria andArticleNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_num >=", value, "articleNum");
            return (Criteria) this;
        }

        public Criteria andArticleNumLessThan(Integer value) {
            addCriterion("article_num <", value, "articleNum");
            return (Criteria) this;
        }

        public Criteria andArticleNumLessThanOrEqualTo(Integer value) {
            addCriterion("article_num <=", value, "articleNum");
            return (Criteria) this;
        }

        public Criteria andArticleNumIn(List<Integer> values) {
            addCriterion("article_num in", values, "articleNum");
            return (Criteria) this;
        }

        public Criteria andArticleNumNotIn(List<Integer> values) {
            addCriterion("article_num not in", values, "articleNum");
            return (Criteria) this;
        }

        public Criteria andArticleNumBetween(Integer value1, Integer value2) {
            addCriterion("article_num between", value1, value2, "articleNum");
            return (Criteria) this;
        }

        public Criteria andArticleNumNotBetween(Integer value1, Integer value2) {
            addCriterion("article_num not between", value1, value2, "articleNum");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andTopicNumIsNull() {
            addCriterion("topic_num is null");
            return (Criteria) this;
        }

        public Criteria andTopicNumIsNotNull() {
            addCriterion("topic_num is not null");
            return (Criteria) this;
        }

        public Criteria andTopicNumEqualTo(Integer value) {
            addCriterion("topic_num =", value, "topicNum");
            return (Criteria) this;
        }

        public Criteria andTopicNumNotEqualTo(Integer value) {
            addCriterion("topic_num <>", value, "topicNum");
            return (Criteria) this;
        }

        public Criteria andTopicNumGreaterThan(Integer value) {
            addCriterion("topic_num >", value, "topicNum");
            return (Criteria) this;
        }

        public Criteria andTopicNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("topic_num >=", value, "topicNum");
            return (Criteria) this;
        }

        public Criteria andTopicNumLessThan(Integer value) {
            addCriterion("topic_num <", value, "topicNum");
            return (Criteria) this;
        }

        public Criteria andTopicNumLessThanOrEqualTo(Integer value) {
            addCriterion("topic_num <=", value, "topicNum");
            return (Criteria) this;
        }

        public Criteria andTopicNumIn(List<Integer> values) {
            addCriterion("topic_num in", values, "topicNum");
            return (Criteria) this;
        }

        public Criteria andTopicNumNotIn(List<Integer> values) {
            addCriterion("topic_num not in", values, "topicNum");
            return (Criteria) this;
        }

        public Criteria andTopicNumBetween(Integer value1, Integer value2) {
            addCriterion("topic_num between", value1, value2, "topicNum");
            return (Criteria) this;
        }

        public Criteria andTopicNumNotBetween(Integer value1, Integer value2) {
            addCriterion("topic_num not between", value1, value2, "topicNum");
            return (Criteria) this;
        }

        public Criteria andQaNumIsNull() {
            addCriterion("qa_num is null");
            return (Criteria) this;
        }

        public Criteria andQaNumIsNotNull() {
            addCriterion("qa_num is not null");
            return (Criteria) this;
        }

        public Criteria andQaNumEqualTo(Integer value) {
            addCriterion("qa_num =", value, "qaNum");
            return (Criteria) this;
        }

        public Criteria andQaNumNotEqualTo(Integer value) {
            addCriterion("qa_num <>", value, "qaNum");
            return (Criteria) this;
        }

        public Criteria andQaNumGreaterThan(Integer value) {
            addCriterion("qa_num >", value, "qaNum");
            return (Criteria) this;
        }

        public Criteria andQaNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("qa_num >=", value, "qaNum");
            return (Criteria) this;
        }

        public Criteria andQaNumLessThan(Integer value) {
            addCriterion("qa_num <", value, "qaNum");
            return (Criteria) this;
        }

        public Criteria andQaNumLessThanOrEqualTo(Integer value) {
            addCriterion("qa_num <=", value, "qaNum");
            return (Criteria) this;
        }

        public Criteria andQaNumIn(List<Integer> values) {
            addCriterion("qa_num in", values, "qaNum");
            return (Criteria) this;
        }

        public Criteria andQaNumNotIn(List<Integer> values) {
            addCriterion("qa_num not in", values, "qaNum");
            return (Criteria) this;
        }

        public Criteria andQaNumBetween(Integer value1, Integer value2) {
            addCriterion("qa_num between", value1, value2, "qaNum");
            return (Criteria) this;
        }

        public Criteria andQaNumNotBetween(Integer value1, Integer value2) {
            addCriterion("qa_num not between", value1, value2, "qaNum");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}