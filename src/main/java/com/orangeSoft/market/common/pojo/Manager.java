package com.orangeSoft.market.common.pojo;

public class Manager {
    private String managerAccount;

    private String managerPassword;

    public String getManagerAccount() {
        return managerAccount;
    }

    public void setManagerAccount(String managerAccount) {
        this.managerAccount = managerAccount == null ? null : managerAccount.trim();
    }

    public String getManagerPassword() {
        return managerPassword;
    }

    public void setManagerPassword(String managerPassword) {
        this.managerPassword = managerPassword == null ? null : managerPassword.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", managerAccount=").append(managerAccount);
        sb.append(", managerPassword=").append(managerPassword);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Manager other = (Manager) that;
        return (this.getManagerAccount() == null ? other.getManagerAccount() == null : this.getManagerAccount().equals(other.getManagerAccount()))
                && (this.getManagerPassword() == null ? other.getManagerPassword() == null : this.getManagerPassword().equals(other.getManagerPassword()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getManagerAccount() == null) ? 0 : getManagerAccount().hashCode());
        result = prime * result + ((getManagerPassword() == null) ? 0 : getManagerPassword().hashCode());
        return result;
    }
}