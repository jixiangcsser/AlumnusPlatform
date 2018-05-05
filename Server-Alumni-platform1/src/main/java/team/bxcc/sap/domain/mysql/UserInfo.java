package team.bxcc.sap.domain.mysql;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 用户基本信息实体类
 *
 * @author FengTao
 * @date 2018/2/1.
 */
public class UserInfo implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * 用户编号(为User表的id外键约束)
     */
    private String id;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 用户性别
     */
    private int sex;

    /**
     * 用户民族
     */
    private int nation;

    /**
     * 用户籍贯
     */
    private String home;

    /**
     * 用户政治面貌
     */
    private int political;

    /**
     * 用户工作单位
     */
    private String workstation;

    /**
     * 用户职务
     */
    private String job;

    /**
     * 用户本科学校
     */
    private String undergraduate;

    /**
     * 用户本科专业
     */
    private String speciality;

    /**
     * 用户本科毕业时间
     */
    private Timestamp date1;

    /**
     * 用户研究生毕业时间
     */
    private Timestamp date2;

    public UserInfo() {
        this.id = null;
        this.name = null;
        this.sex = 0;
        this.nation = 0;
        this.home = null;
        this.political = 0;
        this.workstation = null;
        this.job = null;
        this.undergraduate = null;
        this.speciality = null;
        this.date1 = null;
        this.date2 = null;
    }

    public UserInfo(String id, String name, int sex, int nation, String home, int political, String workstation, String job, String undergraduate, String speciality, Timestamp date1, Timestamp date2) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.nation = nation;
        this.home = home;
        this.political = political;
        this.workstation = workstation;
        this.job = job;
        this.undergraduate = undergraduate;
        this.speciality = speciality;
        this.date1 = date1;
        this.date2 = date2;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getNation() {
        return nation;
    }

    public void setNation(int nation) {
        this.nation = nation;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public int getPolitical() {
        return political;
    }

    public void setPolitical(int political) {
        this.political = political;
    }

    public String getWorkstation() {
        return workstation;
    }

    public void setWorkstation(String workstation) {
        this.workstation = workstation;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getUndergraduate() {
        return undergraduate;
    }

    public void setUndergraduate(String undergraduate) {
        this.undergraduate = undergraduate;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public Timestamp getDate1() {
        return date1;
    }

    public void setDate1(Timestamp date1) {
        this.date1 = date1;
    }

    public Timestamp getDate2() {
        return date2;
    }

    public void setDate2(Timestamp date2) {
        this.date2 = date2;
    }
}
