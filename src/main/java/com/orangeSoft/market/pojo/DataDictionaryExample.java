package com.orangeSoft.market.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataDictionaryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DataDictionaryExample() {
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

        public Criteria andRecordIdIsNull() {
            addCriterion("record_id is null");
            return (Criteria) this;
        }

        public Criteria andRecordIdIsNotNull() {
            addCriterion("record_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecordIdEqualTo(Long value) {
            addCriterion("record_id =", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotEqualTo(Long value) {
            addCriterion("record_id <>", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdGreaterThan(Long value) {
            addCriterion("record_id >", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdGreaterThanOrEqualTo(Long value) {
            addCriterion("record_id >=", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdLessThan(Long value) {
            addCriterion("record_id <", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdLessThanOrEqualTo(Long value) {
            addCriterion("record_id <=", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdIn(List<Long> values) {
            addCriterion("record_id in", values, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotIn(List<Long> values) {
            addCriterion("record_id not in", values, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdBetween(Long value1, Long value2) {
            addCriterion("record_id between", value1, value2, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotBetween(Long value1, Long value2) {
            addCriterion("record_id not between", value1, value2, "recordId");
            return (Criteria) this;
        }

        public Criteria andTIndexIsNull() {
            addCriterion("t_index is null");
            return (Criteria) this;
        }

        public Criteria andTIndexIsNotNull() {
            addCriterion("t_index is not null");
            return (Criteria) this;
        }

        public Criteria andTIndexEqualTo(String value) {
            addCriterion("t_index =", value, "tIndex");
            return (Criteria) this;
        }

        public Criteria andTIndexNotEqualTo(String value) {
            addCriterion("t_index <>", value, "tIndex");
            return (Criteria) this;
        }

        public Criteria andTIndexGreaterThan(String value) {
            addCriterion("t_index >", value, "tIndex");
            return (Criteria) this;
        }

        public Criteria andTIndexGreaterThanOrEqualTo(String value) {
            addCriterion("t_index >=", value, "tIndex");
            return (Criteria) this;
        }

        public Criteria andTIndexLessThan(String value) {
            addCriterion("t_index <", value, "tIndex");
            return (Criteria) this;
        }

        public Criteria andTIndexLessThanOrEqualTo(String value) {
            addCriterion("t_index <=", value, "tIndex");
            return (Criteria) this;
        }

        public Criteria andTIndexLike(String value) {
            addCriterion("t_index like", value, "tIndex");
            return (Criteria) this;
        }

        public Criteria andTIndexNotLike(String value) {
            addCriterion("t_index not like", value, "tIndex");
            return (Criteria) this;
        }

        public Criteria andTIndexIn(List<String> values) {
            addCriterion("t_index in", values, "tIndex");
            return (Criteria) this;
        }

        public Criteria andTIndexNotIn(List<String> values) {
            addCriterion("t_index not in", values, "tIndex");
            return (Criteria) this;
        }

        public Criteria andTIndexBetween(String value1, String value2) {
            addCriterion("t_index between", value1, value2, "tIndex");
            return (Criteria) this;
        }

        public Criteria andTIndexNotBetween(String value1, String value2) {
            addCriterion("t_index not between", value1, value2, "tIndex");
            return (Criteria) this;
        }

        public Criteria andItemNameIsNull() {
            addCriterion("item_name is null");
            return (Criteria) this;
        }

        public Criteria andItemNameIsNotNull() {
            addCriterion("item_name is not null");
            return (Criteria) this;
        }

        public Criteria andItemNameEqualTo(String value) {
            addCriterion("item_name =", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotEqualTo(String value) {
            addCriterion("item_name <>", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThan(String value) {
            addCriterion("item_name >", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThanOrEqualTo(String value) {
            addCriterion("item_name >=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThan(String value) {
            addCriterion("item_name <", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThanOrEqualTo(String value) {
            addCriterion("item_name <=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLike(String value) {
            addCriterion("item_name like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotLike(String value) {
            addCriterion("item_name not like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameIn(List<String> values) {
            addCriterion("item_name in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotIn(List<String> values) {
            addCriterion("item_name not in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameBetween(String value1, String value2) {
            addCriterion("item_name between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotBetween(String value1, String value2) {
            addCriterion("item_name not between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andRecordCreateIsNull() {
            addCriterion("record_create is null");
            return (Criteria) this;
        }

        public Criteria andRecordCreateIsNotNull() {
            addCriterion("record_create is not null");
            return (Criteria) this;
        }

        public Criteria andRecordCreateEqualTo(Date value) {
            addCriterion("record_create =", value, "recordCreate");
            return (Criteria) this;
        }

        public Criteria andRecordCreateNotEqualTo(Date value) {
            addCriterion("record_create <>", value, "recordCreate");
            return (Criteria) this;
        }

        public Criteria andRecordCreateGreaterThan(Date value) {
            addCriterion("record_create >", value, "recordCreate");
            return (Criteria) this;
        }

        public Criteria andRecordCreateGreaterThanOrEqualTo(Date value) {
            addCriterion("record_create >=", value, "recordCreate");
            return (Criteria) this;
        }

        public Criteria andRecordCreateLessThan(Date value) {
            addCriterion("record_create <", value, "recordCreate");
            return (Criteria) this;
        }

        public Criteria andRecordCreateLessThanOrEqualTo(Date value) {
            addCriterion("record_create <=", value, "recordCreate");
            return (Criteria) this;
        }

        public Criteria andRecordCreateIn(List<Date> values) {
            addCriterion("record_create in", values, "recordCreate");
            return (Criteria) this;
        }

        public Criteria andRecordCreateNotIn(List<Date> values) {
            addCriterion("record_create not in", values, "recordCreate");
            return (Criteria) this;
        }

        public Criteria andRecordCreateBetween(Date value1, Date value2) {
            addCriterion("record_create between", value1, value2, "recordCreate");
            return (Criteria) this;
        }

        public Criteria andRecordCreateNotBetween(Date value1, Date value2) {
            addCriterion("record_create not between", value1, value2, "recordCreate");
            return (Criteria) this;
        }

        public Criteria andRecordDescriptionIsNull() {
            addCriterion("record_description is null");
            return (Criteria) this;
        }

        public Criteria andRecordDescriptionIsNotNull() {
            addCriterion("record_description is not null");
            return (Criteria) this;
        }

        public Criteria andRecordDescriptionEqualTo(String value) {
            addCriterion("record_description =", value, "recordDescription");
            return (Criteria) this;
        }

        public Criteria andRecordDescriptionNotEqualTo(String value) {
            addCriterion("record_description <>", value, "recordDescription");
            return (Criteria) this;
        }

        public Criteria andRecordDescriptionGreaterThan(String value) {
            addCriterion("record_description >", value, "recordDescription");
            return (Criteria) this;
        }

        public Criteria andRecordDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("record_description >=", value, "recordDescription");
            return (Criteria) this;
        }

        public Criteria andRecordDescriptionLessThan(String value) {
            addCriterion("record_description <", value, "recordDescription");
            return (Criteria) this;
        }

        public Criteria andRecordDescriptionLessThanOrEqualTo(String value) {
            addCriterion("record_description <=", value, "recordDescription");
            return (Criteria) this;
        }

        public Criteria andRecordDescriptionLike(String value) {
            addCriterion("record_description like", value, "recordDescription");
            return (Criteria) this;
        }

        public Criteria andRecordDescriptionNotLike(String value) {
            addCriterion("record_description not like", value, "recordDescription");
            return (Criteria) this;
        }

        public Criteria andRecordDescriptionIn(List<String> values) {
            addCriterion("record_description in", values, "recordDescription");
            return (Criteria) this;
        }

        public Criteria andRecordDescriptionNotIn(List<String> values) {
            addCriterion("record_description not in", values, "recordDescription");
            return (Criteria) this;
        }

        public Criteria andRecordDescriptionBetween(String value1, String value2) {
            addCriterion("record_description between", value1, value2, "recordDescription");
            return (Criteria) this;
        }

        public Criteria andRecordDescriptionNotBetween(String value1, String value2) {
            addCriterion("record_description not between", value1, value2, "recordDescription");
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