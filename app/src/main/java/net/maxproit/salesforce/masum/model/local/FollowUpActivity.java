package net.maxproit.salesforce.masum.model.local;

public class FollowUpActivity {
    int id,visiPlanI;
    String followUpdate,remark;

    public FollowUpActivity(int id, int visiPlanI, String followUpdate, String remark) {
        this.id = id;
        this.visiPlanI = visiPlanI;
        this.followUpdate = followUpdate;
        this.remark = remark;
    }

    public FollowUpActivity(int visiPlanI, String followUpdate, String remark) {
        this.visiPlanI = visiPlanI;
        this.followUpdate = followUpdate;
        this.remark = remark;
    }

    public int getId() {
        return id;
    }

    public int getVisiPlanI() {
        return visiPlanI;
    }

    public String getFollowUpdate() {
        return followUpdate;
    }

    public String getRemark() {
        return remark;
    }
}
