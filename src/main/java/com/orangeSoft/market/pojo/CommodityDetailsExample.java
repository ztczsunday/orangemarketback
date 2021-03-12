package com.orangeSoft.market.pojo;

import java.util.ArrayList;
import java.util.List;

public class CommodityDetailsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommodityDetailsExample() {
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

        public Criteria andDetailsIdIsNull() {
            addCriterion("details_id is null");
            return (Criteria) this;
        }

        public Criteria andDetailsIdIsNotNull() {
            addCriterion("details_id is not null");
            return (Criteria) this;
        }

        public Criteria andDetailsIdEqualTo(Long value) {
            addCriterion("details_id =", value, "detailsId");
            return (Criteria) this;
        }

        public Criteria andDetailsIdNotEqualTo(Long value) {
            addCriterion("details_id <>", value, "detailsId");
            return (Criteria) this;
        }

        public Criteria andDetailsIdGreaterThan(Long value) {
            addCriterion("details_id >", value, "detailsId");
            return (Criteria) this;
        }

        public Criteria andDetailsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("details_id >=", value, "detailsId");
            return (Criteria) this;
        }

        public Criteria andDetailsIdLessThan(Long value) {
            addCriterion("details_id <", value, "detailsId");
            return (Criteria) this;
        }

        public Criteria andDetailsIdLessThanOrEqualTo(Long value) {
            addCriterion("details_id <=", value, "detailsId");
            return (Criteria) this;
        }

        public Criteria andDetailsIdIn(List<Long> values) {
            addCriterion("details_id in", values, "detailsId");
            return (Criteria) this;
        }

        public Criteria andDetailsIdNotIn(List<Long> values) {
            addCriterion("details_id not in", values, "detailsId");
            return (Criteria) this;
        }

        public Criteria andDetailsIdBetween(Long value1, Long value2) {
            addCriterion("details_id between", value1, value2, "detailsId");
            return (Criteria) this;
        }

        public Criteria andDetailsIdNotBetween(Long value1, Long value2) {
            addCriterion("details_id not between", value1, value2, "detailsId");
            return (Criteria) this;
        }

        public Criteria andCidIsNull() {
            addCriterion("cid is null");
            return (Criteria) this;
        }

        public Criteria andCidIsNotNull() {
            addCriterion("cid is not null");
            return (Criteria) this;
        }

        public Criteria andCidEqualTo(Long value) {
            addCriterion("cid =", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotEqualTo(Long value) {
            addCriterion("cid <>", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThan(Long value) {
            addCriterion("cid >", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThanOrEqualTo(Long value) {
            addCriterion("cid >=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThan(Long value) {
            addCriterion("cid <", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThanOrEqualTo(Long value) {
            addCriterion("cid <=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidIn(List<Long> values) {
            addCriterion("cid in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotIn(List<Long> values) {
            addCriterion("cid not in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidBetween(Long value1, Long value2) {
            addCriterion("cid between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotBetween(Long value1, Long value2) {
            addCriterion("cid not between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andDetailsUrlIsNull() {
            addCriterion("details_url is null");
            return (Criteria) this;
        }

        public Criteria andDetailsUrlIsNotNull() {
            addCriterion("details_url is not null");
            return (Criteria) this;
        }

        public Criteria andDetailsUrlEqualTo(String value) {
            addCriterion("details_url =", value, "detailsUrl");
            return (Criteria) this;
        }

        public Criteria andDetailsUrlNotEqualTo(String value) {
            addCriterion("details_url <>", value, "detailsUrl");
            return (Criteria) this;
        }

        public Criteria andDetailsUrlGreaterThan(String value) {
            addCriterion("details_url >", value, "detailsUrl");
            return (Criteria) this;
        }

        public Criteria andDetailsUrlGreaterThanOrEqualTo(String value) {
            addCriterion("details_url >=", value, "detailsUrl");
            return (Criteria) this;
        }

        public Criteria andDetailsUrlLessThan(String value) {
            addCriterion("details_url <", value, "detailsUrl");
            return (Criteria) this;
        }

        public Criteria andDetailsUrlLessThanOrEqualTo(String value) {
            addCriterion("details_url <=", value, "detailsUrl");
            return (Criteria) this;
        }

        public Criteria andDetailsUrlLike(String value) {
            addCriterion("details_url like", value, "detailsUrl");
            return (Criteria) this;
        }

        public Criteria andDetailsUrlNotLike(String value) {
            addCriterion("details_url not like", value, "detailsUrl");
            return (Criteria) this;
        }

        public Criteria andDetailsUrlIn(List<String> values) {
            addCriterion("details_url in", values, "detailsUrl");
            return (Criteria) this;
        }

        public Criteria andDetailsUrlNotIn(List<String> values) {
            addCriterion("details_url not in", values, "detailsUrl");
            return (Criteria) this;
        }

        public Criteria andDetailsUrlBetween(String value1, String value2) {
            addCriterion("details_url between", value1, value2, "detailsUrl");
            return (Criteria) this;
        }

        public Criteria andDetailsUrlNotBetween(String value1, String value2) {
            addCriterion("details_url not between", value1, value2, "detailsUrl");
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