package com.orangeSoft.market.pojo;

import java.util.ArrayList;
import java.util.List;

public class ChatDetailsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ChatDetailsExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andChatContentIdIsNull() {
            addCriterion("chat_content_id is null");
            return (Criteria) this;
        }

        public Criteria andChatContentIdIsNotNull() {
            addCriterion("chat_content_id is not null");
            return (Criteria) this;
        }

        public Criteria andChatContentIdEqualTo(Long value) {
            addCriterion("chat_content_id =", value, "chatContentId");
            return (Criteria) this;
        }

        public Criteria andChatContentIdNotEqualTo(Long value) {
            addCriterion("chat_content_id <>", value, "chatContentId");
            return (Criteria) this;
        }

        public Criteria andChatContentIdGreaterThan(Long value) {
            addCriterion("chat_content_id >", value, "chatContentId");
            return (Criteria) this;
        }

        public Criteria andChatContentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("chat_content_id >=", value, "chatContentId");
            return (Criteria) this;
        }

        public Criteria andChatContentIdLessThan(Long value) {
            addCriterion("chat_content_id <", value, "chatContentId");
            return (Criteria) this;
        }

        public Criteria andChatContentIdLessThanOrEqualTo(Long value) {
            addCriterion("chat_content_id <=", value, "chatContentId");
            return (Criteria) this;
        }

        public Criteria andChatContentIdIn(List<Long> values) {
            addCriterion("chat_content_id in", values, "chatContentId");
            return (Criteria) this;
        }

        public Criteria andChatContentIdNotIn(List<Long> values) {
            addCriterion("chat_content_id not in", values, "chatContentId");
            return (Criteria) this;
        }

        public Criteria andChatContentIdBetween(Long value1, Long value2) {
            addCriterion("chat_content_id between", value1, value2, "chatContentId");
            return (Criteria) this;
        }

        public Criteria andChatContentIdNotBetween(Long value1, Long value2) {
            addCriterion("chat_content_id not between", value1, value2, "chatContentId");
            return (Criteria) this;
        }

        public Criteria andChatContentIsNull() {
            addCriterion("chat_content is null");
            return (Criteria) this;
        }

        public Criteria andChatContentIsNotNull() {
            addCriterion("chat_content is not null");
            return (Criteria) this;
        }

        public Criteria andChatContentEqualTo(String value) {
            addCriterion("chat_content =", value, "chatContent");
            return (Criteria) this;
        }

        public Criteria andChatContentNotEqualTo(String value) {
            addCriterion("chat_content <>", value, "chatContent");
            return (Criteria) this;
        }

        public Criteria andChatContentGreaterThan(String value) {
            addCriterion("chat_content >", value, "chatContent");
            return (Criteria) this;
        }

        public Criteria andChatContentGreaterThanOrEqualTo(String value) {
            addCriterion("chat_content >=", value, "chatContent");
            return (Criteria) this;
        }

        public Criteria andChatContentLessThan(String value) {
            addCriterion("chat_content <", value, "chatContent");
            return (Criteria) this;
        }

        public Criteria andChatContentLessThanOrEqualTo(String value) {
            addCriterion("chat_content <=", value, "chatContent");
            return (Criteria) this;
        }

        public Criteria andChatContentLike(String value) {
            addCriterion("chat_content like", value, "chatContent");
            return (Criteria) this;
        }

        public Criteria andChatContentNotLike(String value) {
            addCriterion("chat_content not like", value, "chatContent");
            return (Criteria) this;
        }

        public Criteria andChatContentIn(List<String> values) {
            addCriterion("chat_content in", values, "chatContent");
            return (Criteria) this;
        }

        public Criteria andChatContentNotIn(List<String> values) {
            addCriterion("chat_content not in", values, "chatContent");
            return (Criteria) this;
        }

        public Criteria andChatContentBetween(String value1, String value2) {
            addCriterion("chat_content between", value1, value2, "chatContent");
            return (Criteria) this;
        }

        public Criteria andChatContentNotBetween(String value1, String value2) {
            addCriterion("chat_content not between", value1, value2, "chatContent");
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