package com.orangeSoft.market.pojo;

import java.util.ArrayList;
import java.util.List;

public class UserInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserInfoExample() {
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

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Integer value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Integer value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Integer value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Integer value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Integer value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Integer> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Integer> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Integer value1, Integer value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Integer value1, Integer value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIsNull() {
            addCriterion("user_password is null");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIsNotNull() {
            addCriterion("user_password is not null");
            return (Criteria) this;
        }

        public Criteria andUserPasswordEqualTo(String value) {
            addCriterion("user_password =", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotEqualTo(String value) {
            addCriterion("user_password <>", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordGreaterThan(String value) {
            addCriterion("user_password >", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("user_password >=", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLessThan(String value) {
            addCriterion("user_password <", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLessThanOrEqualTo(String value) {
            addCriterion("user_password <=", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLike(String value) {
            addCriterion("user_password like", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotLike(String value) {
            addCriterion("user_password not like", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIn(List<String> values) {
            addCriterion("user_password in", values, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotIn(List<String> values) {
            addCriterion("user_password not in", values, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordBetween(String value1, String value2) {
            addCriterion("user_password between", value1, value2, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotBetween(String value1, String value2) {
            addCriterion("user_password not between", value1, value2, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserAlipayAccountIsNull() {
            addCriterion("user_alipay_account is null");
            return (Criteria) this;
        }

        public Criteria andUserAlipayAccountIsNotNull() {
            addCriterion("user_alipay_account is not null");
            return (Criteria) this;
        }

        public Criteria andUserAlipayAccountEqualTo(String value) {
            addCriterion("user_alipay_account =", value, "userAlipayAccount");
            return (Criteria) this;
        }

        public Criteria andUserAlipayAccountNotEqualTo(String value) {
            addCriterion("user_alipay_account <>", value, "userAlipayAccount");
            return (Criteria) this;
        }

        public Criteria andUserAlipayAccountGreaterThan(String value) {
            addCriterion("user_alipay_account >", value, "userAlipayAccount");
            return (Criteria) this;
        }

        public Criteria andUserAlipayAccountGreaterThanOrEqualTo(String value) {
            addCriterion("user_alipay_account >=", value, "userAlipayAccount");
            return (Criteria) this;
        }

        public Criteria andUserAlipayAccountLessThan(String value) {
            addCriterion("user_alipay_account <", value, "userAlipayAccount");
            return (Criteria) this;
        }

        public Criteria andUserAlipayAccountLessThanOrEqualTo(String value) {
            addCriterion("user_alipay_account <=", value, "userAlipayAccount");
            return (Criteria) this;
        }

        public Criteria andUserAlipayAccountLike(String value) {
            addCriterion("user_alipay_account like", value, "userAlipayAccount");
            return (Criteria) this;
        }

        public Criteria andUserAlipayAccountNotLike(String value) {
            addCriterion("user_alipay_account not like", value, "userAlipayAccount");
            return (Criteria) this;
        }

        public Criteria andUserAlipayAccountIn(List<String> values) {
            addCriterion("user_alipay_account in", values, "userAlipayAccount");
            return (Criteria) this;
        }

        public Criteria andUserAlipayAccountNotIn(List<String> values) {
            addCriterion("user_alipay_account not in", values, "userAlipayAccount");
            return (Criteria) this;
        }

        public Criteria andUserAlipayAccountBetween(String value1, String value2) {
            addCriterion("user_alipay_account between", value1, value2, "userAlipayAccount");
            return (Criteria) this;
        }

        public Criteria andUserAlipayAccountNotBetween(String value1, String value2) {
            addCriterion("user_alipay_account not between", value1, value2, "userAlipayAccount");
            return (Criteria) this;
        }

        public Criteria andUerTelephoneIsNull() {
            addCriterion("uer_telephone is null");
            return (Criteria) this;
        }

        public Criteria andUerTelephoneIsNotNull() {
            addCriterion("uer_telephone is not null");
            return (Criteria) this;
        }

        public Criteria andUerTelephoneEqualTo(String value) {
            addCriterion("uer_telephone =", value, "uerTelephone");
            return (Criteria) this;
        }

        public Criteria andUerTelephoneNotEqualTo(String value) {
            addCriterion("uer_telephone <>", value, "uerTelephone");
            return (Criteria) this;
        }

        public Criteria andUerTelephoneGreaterThan(String value) {
            addCriterion("uer_telephone >", value, "uerTelephone");
            return (Criteria) this;
        }

        public Criteria andUerTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("uer_telephone >=", value, "uerTelephone");
            return (Criteria) this;
        }

        public Criteria andUerTelephoneLessThan(String value) {
            addCriterion("uer_telephone <", value, "uerTelephone");
            return (Criteria) this;
        }

        public Criteria andUerTelephoneLessThanOrEqualTo(String value) {
            addCriterion("uer_telephone <=", value, "uerTelephone");
            return (Criteria) this;
        }

        public Criteria andUerTelephoneLike(String value) {
            addCriterion("uer_telephone like", value, "uerTelephone");
            return (Criteria) this;
        }

        public Criteria andUerTelephoneNotLike(String value) {
            addCriterion("uer_telephone not like", value, "uerTelephone");
            return (Criteria) this;
        }

        public Criteria andUerTelephoneIn(List<String> values) {
            addCriterion("uer_telephone in", values, "uerTelephone");
            return (Criteria) this;
        }

        public Criteria andUerTelephoneNotIn(List<String> values) {
            addCriterion("uer_telephone not in", values, "uerTelephone");
            return (Criteria) this;
        }

        public Criteria andUerTelephoneBetween(String value1, String value2) {
            addCriterion("uer_telephone between", value1, value2, "uerTelephone");
            return (Criteria) this;
        }

        public Criteria andUerTelephoneNotBetween(String value1, String value2) {
            addCriterion("uer_telephone not between", value1, value2, "uerTelephone");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserGenderIsNull() {
            addCriterion("user_gender is null");
            return (Criteria) this;
        }

        public Criteria andUserGenderIsNotNull() {
            addCriterion("user_gender is not null");
            return (Criteria) this;
        }

        public Criteria andUserGenderEqualTo(String value) {
            addCriterion("user_gender =", value, "userGender");
            return (Criteria) this;
        }

        public Criteria andUserGenderNotEqualTo(String value) {
            addCriterion("user_gender <>", value, "userGender");
            return (Criteria) this;
        }

        public Criteria andUserGenderGreaterThan(String value) {
            addCriterion("user_gender >", value, "userGender");
            return (Criteria) this;
        }

        public Criteria andUserGenderGreaterThanOrEqualTo(String value) {
            addCriterion("user_gender >=", value, "userGender");
            return (Criteria) this;
        }

        public Criteria andUserGenderLessThan(String value) {
            addCriterion("user_gender <", value, "userGender");
            return (Criteria) this;
        }

        public Criteria andUserGenderLessThanOrEqualTo(String value) {
            addCriterion("user_gender <=", value, "userGender");
            return (Criteria) this;
        }

        public Criteria andUserGenderLike(String value) {
            addCriterion("user_gender like", value, "userGender");
            return (Criteria) this;
        }

        public Criteria andUserGenderNotLike(String value) {
            addCriterion("user_gender not like", value, "userGender");
            return (Criteria) this;
        }

        public Criteria andUserGenderIn(List<String> values) {
            addCriterion("user_gender in", values, "userGender");
            return (Criteria) this;
        }

        public Criteria andUserGenderNotIn(List<String> values) {
            addCriterion("user_gender not in", values, "userGender");
            return (Criteria) this;
        }

        public Criteria andUserGenderBetween(String value1, String value2) {
            addCriterion("user_gender between", value1, value2, "userGender");
            return (Criteria) this;
        }

        public Criteria andUserGenderNotBetween(String value1, String value2) {
            addCriterion("user_gender not between", value1, value2, "userGender");
            return (Criteria) this;
        }

        public Criteria andUserSelfieIsNull() {
            addCriterion("user_selfie is null");
            return (Criteria) this;
        }

        public Criteria andUserSelfieIsNotNull() {
            addCriterion("user_selfie is not null");
            return (Criteria) this;
        }

        public Criteria andUserSelfieEqualTo(String value) {
            addCriterion("user_selfie =", value, "userSelfie");
            return (Criteria) this;
        }

        public Criteria andUserSelfieNotEqualTo(String value) {
            addCriterion("user_selfie <>", value, "userSelfie");
            return (Criteria) this;
        }

        public Criteria andUserSelfieGreaterThan(String value) {
            addCriterion("user_selfie >", value, "userSelfie");
            return (Criteria) this;
        }

        public Criteria andUserSelfieGreaterThanOrEqualTo(String value) {
            addCriterion("user_selfie >=", value, "userSelfie");
            return (Criteria) this;
        }

        public Criteria andUserSelfieLessThan(String value) {
            addCriterion("user_selfie <", value, "userSelfie");
            return (Criteria) this;
        }

        public Criteria andUserSelfieLessThanOrEqualTo(String value) {
            addCriterion("user_selfie <=", value, "userSelfie");
            return (Criteria) this;
        }

        public Criteria andUserSelfieLike(String value) {
            addCriterion("user_selfie like", value, "userSelfie");
            return (Criteria) this;
        }

        public Criteria andUserSelfieNotLike(String value) {
            addCriterion("user_selfie not like", value, "userSelfie");
            return (Criteria) this;
        }

        public Criteria andUserSelfieIn(List<String> values) {
            addCriterion("user_selfie in", values, "userSelfie");
            return (Criteria) this;
        }

        public Criteria andUserSelfieNotIn(List<String> values) {
            addCriterion("user_selfie not in", values, "userSelfie");
            return (Criteria) this;
        }

        public Criteria andUserSelfieBetween(String value1, String value2) {
            addCriterion("user_selfie between", value1, value2, "userSelfie");
            return (Criteria) this;
        }

        public Criteria andUserSelfieNotBetween(String value1, String value2) {
            addCriterion("user_selfie not between", value1, value2, "userSelfie");
            return (Criteria) this;
        }

        public Criteria andUserSignatureIsNull() {
            addCriterion("user_signature is null");
            return (Criteria) this;
        }

        public Criteria andUserSignatureIsNotNull() {
            addCriterion("user_signature is not null");
            return (Criteria) this;
        }

        public Criteria andUserSignatureEqualTo(String value) {
            addCriterion("user_signature =", value, "userSignature");
            return (Criteria) this;
        }

        public Criteria andUserSignatureNotEqualTo(String value) {
            addCriterion("user_signature <>", value, "userSignature");
            return (Criteria) this;
        }

        public Criteria andUserSignatureGreaterThan(String value) {
            addCriterion("user_signature >", value, "userSignature");
            return (Criteria) this;
        }

        public Criteria andUserSignatureGreaterThanOrEqualTo(String value) {
            addCriterion("user_signature >=", value, "userSignature");
            return (Criteria) this;
        }

        public Criteria andUserSignatureLessThan(String value) {
            addCriterion("user_signature <", value, "userSignature");
            return (Criteria) this;
        }

        public Criteria andUserSignatureLessThanOrEqualTo(String value) {
            addCriterion("user_signature <=", value, "userSignature");
            return (Criteria) this;
        }

        public Criteria andUserSignatureLike(String value) {
            addCriterion("user_signature like", value, "userSignature");
            return (Criteria) this;
        }

        public Criteria andUserSignatureNotLike(String value) {
            addCriterion("user_signature not like", value, "userSignature");
            return (Criteria) this;
        }

        public Criteria andUserSignatureIn(List<String> values) {
            addCriterion("user_signature in", values, "userSignature");
            return (Criteria) this;
        }

        public Criteria andUserSignatureNotIn(List<String> values) {
            addCriterion("user_signature not in", values, "userSignature");
            return (Criteria) this;
        }

        public Criteria andUserSignatureBetween(String value1, String value2) {
            addCriterion("user_signature between", value1, value2, "userSignature");
            return (Criteria) this;
        }

        public Criteria andUserSignatureNotBetween(String value1, String value2) {
            addCriterion("user_signature not between", value1, value2, "userSignature");
            return (Criteria) this;
        }

        public Criteria andUserEmailIsNull() {
            addCriterion("user_email is null");
            return (Criteria) this;
        }

        public Criteria andUserEmailIsNotNull() {
            addCriterion("user_email is not null");
            return (Criteria) this;
        }

        public Criteria andUserEmailEqualTo(String value) {
            addCriterion("user_email =", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotEqualTo(String value) {
            addCriterion("user_email <>", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailGreaterThan(String value) {
            addCriterion("user_email >", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailGreaterThanOrEqualTo(String value) {
            addCriterion("user_email >=", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLessThan(String value) {
            addCriterion("user_email <", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLessThanOrEqualTo(String value) {
            addCriterion("user_email <=", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLike(String value) {
            addCriterion("user_email like", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotLike(String value) {
            addCriterion("user_email not like", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailIn(List<String> values) {
            addCriterion("user_email in", values, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotIn(List<String> values) {
            addCriterion("user_email not in", values, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailBetween(String value1, String value2) {
            addCriterion("user_email between", value1, value2, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotBetween(String value1, String value2) {
            addCriterion("user_email not between", value1, value2, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserLicenseIsNull() {
            addCriterion("user_license is null");
            return (Criteria) this;
        }

        public Criteria andUserLicenseIsNotNull() {
            addCriterion("user_license is not null");
            return (Criteria) this;
        }

        public Criteria andUserLicenseEqualTo(String value) {
            addCriterion("user_license =", value, "userLicense");
            return (Criteria) this;
        }

        public Criteria andUserLicenseNotEqualTo(String value) {
            addCriterion("user_license <>", value, "userLicense");
            return (Criteria) this;
        }

        public Criteria andUserLicenseGreaterThan(String value) {
            addCriterion("user_license >", value, "userLicense");
            return (Criteria) this;
        }

        public Criteria andUserLicenseGreaterThanOrEqualTo(String value) {
            addCriterion("user_license >=", value, "userLicense");
            return (Criteria) this;
        }

        public Criteria andUserLicenseLessThan(String value) {
            addCriterion("user_license <", value, "userLicense");
            return (Criteria) this;
        }

        public Criteria andUserLicenseLessThanOrEqualTo(String value) {
            addCriterion("user_license <=", value, "userLicense");
            return (Criteria) this;
        }

        public Criteria andUserLicenseLike(String value) {
            addCriterion("user_license like", value, "userLicense");
            return (Criteria) this;
        }

        public Criteria andUserLicenseNotLike(String value) {
            addCriterion("user_license not like", value, "userLicense");
            return (Criteria) this;
        }

        public Criteria andUserLicenseIn(List<String> values) {
            addCriterion("user_license in", values, "userLicense");
            return (Criteria) this;
        }

        public Criteria andUserLicenseNotIn(List<String> values) {
            addCriterion("user_license not in", values, "userLicense");
            return (Criteria) this;
        }

        public Criteria andUserLicenseBetween(String value1, String value2) {
            addCriterion("user_license between", value1, value2, "userLicense");
            return (Criteria) this;
        }

        public Criteria andUserLicenseNotBetween(String value1, String value2) {
            addCriterion("user_license not between", value1, value2, "userLicense");
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